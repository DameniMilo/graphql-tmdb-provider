package org.jahia.modules.tmdbprovider.api.impl;

import com.uwetrottmann.tmdb2.Tmdb;
import com.uwetrottmann.tmdb2.entities.*;
import com.uwetrottmann.tmdb2.enumerations.AppendToResponseItem;
import com.uwetrottmann.tmdb2.services.MoviesService;
import org.jahia.modules.tmdbprovider.api.TMDBService;
import org.osgi.service.component.annotations.Component;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component(immediate = true)
public class TMDBServiceImpl implements TMDBService {

    private Tmdb tmdb = null;

    @Override
    public void init() {
        if (tmdb == null) {
            tmdb = new Tmdb(System.getProperty("com.jahia.tmdb.apiKeyValue"));
        }
    }

    @Override
    public Movie getMovie(int id) throws IOException {
        MoviesService moviesService = tmdb.moviesService();
        Response<Movie> response = moviesService.summary(id, null, new AppendToResponse(AppendToResponseItem.CREDITS)).execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        return null;
    }

    @Override
    public List<BaseMovie> getMovies(int year) throws IOException {
        Response<MovieResultsPage> response = tmdb.discoverMovie().year(year).build().execute();
        if (response.isSuccessful()) {
            return response.body().results;
        }
        return Collections.emptyList();
    }
}

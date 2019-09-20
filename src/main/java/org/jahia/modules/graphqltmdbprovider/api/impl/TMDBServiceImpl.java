package org.jahia.modules.graphqltmdbprovider.api.impl;

import com.uwetrottmann.tmdb2.Tmdb;
import com.uwetrottmann.tmdb2.entities.Movie;
import com.uwetrottmann.tmdb2.services.MoviesService;
import org.jahia.modules.graphqltmdbprovider.api.TMDBService;
import org.osgi.service.component.annotations.Component;
import retrofit2.Response;

import java.io.IOException;

@Component(immediate = true)
public class TMDBServiceImpl implements TMDBService {

    private String apiKey;

    @Override
    public Movie getMovie(int id) throws IOException {
        Tmdb tmdb = new Tmdb(apiKey);
        MoviesService moviesService = tmdb.moviesService();
        Response<Movie> response = moviesService.summary(id, null).execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        return null;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}

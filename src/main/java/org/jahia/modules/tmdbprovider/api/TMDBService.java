package org.jahia.modules.tmdbprovider.api;

import com.uwetrottmann.tmdb2.entities.BaseMovie;
import com.uwetrottmann.tmdb2.entities.Movie;

import java.io.IOException;
import java.util.List;

public interface TMDBService {

    void init();

    Movie getMovie(int id) throws IOException;

    List<BaseMovie> getMovies(int year) throws IOException;
}

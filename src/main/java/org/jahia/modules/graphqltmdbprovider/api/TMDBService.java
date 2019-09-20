package org.jahia.modules.graphqltmdbprovider.api;

import com.uwetrottmann.tmdb2.entities.Movie;

import java.io.IOException;

public interface TMDBService {

    Movie getMovie(int id) throws IOException;
}

package org.jahia.modules.graphqltmdbprovider.graphql.api;

import graphql.annotations.annotationTypes.*;
import org.jahia.modules.graphql.provider.dxm.DataFetchingException;
import org.jahia.modules.graphqltmdbprovider.api.Movie;
import org.jahia.modules.graphqltmdbprovider.api.TMDBService;
import org.jahia.osgi.BundleUtils;

import java.io.IOException;

/**
 * The root class for the GraphQL TMDB API
 */
public class GqlTMDB {

    private TMDBService tmdbService = null;

    public GqlTMDB() {
        this.tmdbService = BundleUtils.getOsgiService(TMDBService.class, null);
    }

    @GraphQLField
    @GraphQLName("movie")
    @GraphQLDescription("Get a movie")
    public Movie getMovie(
        @GraphQLName("id")
        @GraphQLNonNull
        @GraphQLDescription("The primary identifier of the movie we want to retrieve")
                int id) {
        try {
            com.uwetrottmann.tmdb2.entities.Movie movie = tmdbService.getMovie(id);
            return new Movie(id, movie.title);
        } catch (IOException e) {
            throw new DataFetchingException(e);
        }
    }
}

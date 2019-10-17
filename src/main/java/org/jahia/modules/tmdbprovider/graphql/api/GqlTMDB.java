package org.jahia.modules.tmdbprovider.graphql.api;

import com.uwetrottmann.tmdb2.entities.BaseMovie;
import com.uwetrottmann.tmdb2.entities.Movie;
import graphql.annotations.annotationTypes.*;
import org.jahia.modules.graphql.provider.dxm.DataFetchingException;
import org.jahia.modules.tmdbprovider.api.TMDBService;
import org.jahia.osgi.BundleUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The root class for the GraphQL TMDB API
 */
public class GqlTMDB {

    private TMDBService tmdbService = null;

    public GqlTMDB() {
        this.tmdbService = BundleUtils.getOsgiService(TMDBService.class, null);
        tmdbService.init();
    }

    @GraphQLField
    @GraphQLName("movie")
    @GraphQLDescription("Get a movie")
    public GqlMovie getMovie (
        @GraphQLName("id")
        @GraphQLNonNull
        @GraphQLDescription("The primary identifier of the movie we want to retrieve")
                int id) {
        try {
            Movie movie = tmdbService.getMovie(id);
            if (movie != null) {
                return new GqlMovie(movie);
            }
            return null;
        } catch (IOException e) {
            throw new DataFetchingException(e);
        }
    }

    @GraphQLField
    @GraphQLName("movies")
    @GraphQLDescription("Return a list of movies")
    public Collection<GqlMovie> getMovies (
        @GraphQLName("year")
        @GraphQLNonNull
        @GraphQLDescription("The year of the movies we want to retrieve")
            int year) {
        try {
            List<BaseMovie> baseMovies = tmdbService.getMovies(year);
            ArrayList<GqlMovie> gqlBaseMovies = new ArrayList<>();
            if (!baseMovies.isEmpty()) {
                for (BaseMovie baseMovie : baseMovies) {
                    gqlBaseMovies.add(new GqlMovie(baseMovie));
                }
            }
            return gqlBaseMovies;
        } catch (IOException e) {
            throw new DataFetchingException(e);
        }
    }
}

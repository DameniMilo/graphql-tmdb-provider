package org.jahia.modules.tmdbprovider.graphql.api;

import com.uwetrottmann.tmdb2.entities.Movie;
import graphql.annotations.annotationTypes.GraphQLDescription;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;

/**
 * The Movie representation for the GraphQL API
 */
@GraphQLName("Movie")
public class GqlMovie {
    private Movie tmdbMovie;

    public GqlMovie(Movie tmdbMovie) {
        this.tmdbMovie = tmdbMovie;
    }

    public Movie getTmdbMovie() {
        return tmdbMovie;
    }

    @GraphQLField
    @GraphQLDescription("Retrieve the name of the Movie")
    public String getTitle() {
        return tmdbMovie.title;
    }

    @GraphQLField
    @GraphQLDescription("Retrieve the overview of the movie")
    public String getOverview() {
        return tmdbMovie.overview;
    }
}

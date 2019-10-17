package org.jahia.modules.tmdbprovider.graphql.api;

import com.uwetrottmann.tmdb2.entities.BaseMovie;
import graphql.annotations.annotationTypes.GraphQLDescription;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;

/**
 * The Movie representation for the GraphQL API
 */
@GraphQLName("Movie")
public class GqlMovie {
    private BaseMovie tmdbMovie;

    public GqlMovie(BaseMovie tmdbMovie) {
        this.tmdbMovie = tmdbMovie;
    }

    public BaseMovie getTmdbMovie() {
        return tmdbMovie;
    }

    @GraphQLField
    @GraphQLDescription("Retrieve the TMDB id of the Movie")
    public Integer getId() {
        return tmdbMovie.id;
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

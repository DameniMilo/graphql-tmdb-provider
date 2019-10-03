package org.jahia.modules.tmdbprovider.graphql.api;

import com.uwetrottmann.tmdb2.entities.BaseMovie;
import graphql.annotations.annotationTypes.GraphQLDescription;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;

@GraphQLName("BaseMovie")
public class GqlBaseMovie {
    private BaseMovie tmdbBaseMovie;

    public GqlBaseMovie(BaseMovie tmdbBaseMovie) {
        this.tmdbBaseMovie = tmdbBaseMovie;
    }

    @GraphQLField
    @GraphQLDescription("Retrieve the TMDB id of the Movie")
    public Integer getId() {
        return tmdbBaseMovie.id;
    }

    @GraphQLField
    @GraphQLDescription("Retrieve the name of the Movie")
    public String getTitle() {
        return tmdbBaseMovie.title;
    }

    @GraphQLField
    @GraphQLDescription("Retrieve the overview of the movie")
    public String getOverview() {
        return tmdbBaseMovie.overview;
    }
}

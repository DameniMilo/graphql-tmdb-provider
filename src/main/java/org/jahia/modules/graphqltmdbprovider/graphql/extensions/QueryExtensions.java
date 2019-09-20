package org.jahia.modules.graphqltmdbprovider.graphql.extensions;

import graphql.annotations.annotationTypes.GraphQLDescription;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import graphql.annotations.annotationTypes.GraphQLTypeExtension;
import org.jahia.modules.graphql.provider.dxm.DXGraphQLProvider;
import org.jahia.modules.graphqltmdbprovider.graphql.api.GqlTMDB;

/**
 * This extension to the Query is where the TMDB GraphQL API is made available
 */
@GraphQLTypeExtension(DXGraphQLProvider.Query.class)
public class QueryExtensions {

    @GraphQLField
    @GraphQLName("tmdb")
    @GraphQLDescription("Main access field to the Jahia GraphQL TMDB API")
    public static GqlTMDB getTmdb() {
        return new GqlTMDB();
    }

}

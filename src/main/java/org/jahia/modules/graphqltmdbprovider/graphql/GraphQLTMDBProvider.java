package org.jahia.modules.graphqltmdbprovider.graphql;

import org.jahia.modules.graphql.provider.dxm.DXGraphQLExtensionsProvider;
import org.jahia.modules.graphqltmdbprovider.graphql.extensions.QueryExtensions;
import org.osgi.service.component.annotations.Component;

import java.util.Arrays;
import java.util.Collection;

/**
 * Main GraphQL extension provider for TMDB
 */
@Component(immediate = true, service = DXGraphQLExtensionsProvider.class)
public class GraphQLTMDBProvider implements DXGraphQLExtensionsProvider {
    @Override
    public Collection<Class<?>> getExtensions() {
        return Arrays.<Class<?>>asList(QueryExtensions.class);
    }
}

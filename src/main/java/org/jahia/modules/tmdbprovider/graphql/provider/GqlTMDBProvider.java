package org.jahia.modules.tmdbprovider.graphql.provider;

import org.jahia.modules.graphql.provider.dxm.DXGraphQLExtensionsProvider;
import org.jahia.modules.tmdbprovider.graphql.extensions.GqlTMDBExtension;
import org.osgi.service.component.annotations.Component;

import java.util.Arrays;
import java.util.Collection;

/**
 * Main GraphQL extension provider for TMDB
 */
@Component(immediate = true, service = DXGraphQLExtensionsProvider.class)
public class GqlTMDBProvider implements DXGraphQLExtensionsProvider {
    @Override
    public Collection<Class<?>> getExtensions() {
        return Arrays.<Class<?>>asList(GqlTMDBExtension.class);
    }
}

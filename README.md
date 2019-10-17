# graphql-tmdb-provider

This is an example implementation of a Jahia GraphQL provider that exposes GraphQL fields that integrate with the TMDB 
service to provide information about movies.

Steps to install : 

1. Signup for an account at https://www.themoviedb.org/account/signup
2. Activate your account by clicking on the link sent by email
3. Login and go to the API link in your profile settings : https://www.themoviedb.org/settings/api
4. Click on "Request a new API key"
5. Request a developer key
6. Accept the terms of use if acceptable
7. Retrieve the API key v3
5. mvn clean install
6. Modify Jahia's setenv.sh file to include:
   `CATALINA_OPTS="$CATALINA_OPTS -Dcom.jahia.tmdb.apiKeyValue=cda35e0d70796f6c9ef4aba6d450f579"`
6. Upload generated JAR into Jahia Module Administration and make sure it is started
7. Go into tools at http://localhost:8080/tools and use the GraphiQL tool to test out some requests on the tmdb namespace

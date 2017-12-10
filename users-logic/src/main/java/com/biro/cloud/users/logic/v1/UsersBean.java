package com.biro.cloud.users.logic.v1;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// project
import com.biro.cloud.users.persistence.v1.AccountOptions;
import com.biro.cloud.users.persistence.v1.Users;
import com.biro.cloud.users.logic.v1.configuration.RestProperties;

// javax persistence
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

// kumuluzee
import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;

// other
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.UriInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

// apache
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


@RequestScoped
public class UsersBean {

    private ObjectMapper objectMapper;
    private HttpClient httpClient;
    private String basePath;

    @Inject
    private RestProperties restProperties;

    @Inject
    private UsersBean usersBean;


    @PostConstruct
    private void init() {
        httpClient = HttpClientBuilder.create().build();
        objectMapper = new ObjectMapper();
        basePath = "http://docker.for.mac.localhost:8080/v1/";
    }

    @PersistenceContext(unitName = "users-jpa")
    private EntityManager em;

    /////////// API

    public List<Users> getUsers(){

        Query query = em.createNamedQuery("Users.getAll", Users.class);

        List<Users> users = query.getResultList();
        if (restProperties.isAccountOptionsServiceEnabled()) {
            users.get(0).setUsername("Fukach svoje matere!");
        }

        return users;

        // return addAccountOptionsToUsersList(users);
    }

    public List<Users> getUsersFilter(UriInfo uriInfo) {

        QueryParameters queryParameters = QueryParameters.query(uriInfo.getRequestUri().getQuery()).defaultOffset(0)
                .build();

        List<Users> users = JPAUtils.queryEntities(em, Users.class, queryParameters);

        return addAccountOptionsToUsersList(users);
    }


    ///////////// Auxiliary

    private List<Users> addAccountOptionsToUsersList(List<Users> users) {
        for (int i = 0; i < users.size(); i++) {
            Users u = users.get(i);
            u = getUser(u.getId());
            users.set(i, u);
        }
        return users;
    }

    public Users getUser(String userId) {
        Users user = em.find(Users.class, userId);

        if (user == null) {
            throw new NotFoundException();
        }

        List<AccountOptions> userAccountOptions = usersBean.getAccountOptions(userId);
        user.setAccountOptionsList(userAccountOptions);

        return user;

    }


    public List<AccountOptions> getAccountOptions(String userId) {
        try {
            HttpGet request = new HttpGet(basePath + "accountoptions/filtered?filter=userId:EQ:" + userId);
            HttpResponse response = httpClient.execute(request);

            int status = response.getStatusLine().getStatusCode();

            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();

                if (entity != null)
                    return getObjects(EntityUtils.toString(entity));
            } else {
                String msg = "Remote server '" + basePath + "' is responded with status " + status + ".";
                // todo logging
                throw new InternalServerErrorException(msg);
            }

        } catch (IOException e) {
            String msg = e.getClass().getName() + " occured: " + e.getMessage();
            // todo logging
            throw new InternalServerErrorException(msg);
        }
        return new ArrayList<>();

    }

    private List<AccountOptions> getObjects(String json) throws IOException {
        return json == null ? new ArrayList<>() : objectMapper.readValue(json,
                objectMapper.getTypeFactory().constructCollectionType(List.class, AccountOptions.class));
    }

}
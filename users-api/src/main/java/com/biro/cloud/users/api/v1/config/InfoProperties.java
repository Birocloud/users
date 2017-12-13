package com.biro.cloud.users.api.v1.config;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ConfigBundle("kubernetes")
public class InfoProperties {

    @ConfigValue(value = "users-service.address", watch = true)
    private String usersMicroserviceAddress;

    @ConfigValue(value = "accountoptions-service.address", watch = true)
    private String accountOptionsMicroserviceAddress;

    public String getUsersMicroserviceAddress() {
        return usersMicroserviceAddress;
    }

    public String getAccountOptionsMicroserviceAddress() {
        return accountOptionsMicroserviceAddress;
    }

    public void setUsersMicroserviceAddress(String address) {
        usersMicroserviceAddress = address;
    }

    public void setAccountOptionsMicroserviceAddress(String address) {
        accountOptionsMicroserviceAddress = address;
    }

}

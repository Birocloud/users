package com.biro.cloud.users.logic.v1.configuration;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ConfigBundle("rest-properties")
public class RestProperties {

    @ConfigValue(value = "external-dependencies.accountoptions-service.enabled", watch = true)
    private boolean accountOptionsServiceEnabled;

    public boolean isAccountOptionsServiceEnabled() {
        return accountOptionsServiceEnabled;
    }

    public void setAccountOptionsServiceEnabled(boolean accountOptionsServiceEnabled) {
        this.accountOptionsServiceEnabled = accountOptionsServiceEnabled;
    }
}

package com.biro.cloud.users.persistence.v1;

/**
 * Created by km on 09/12/2017.
 */

public class AccountOptions {

    private String id;
    private String userId;
    private String key;
    private String value;

    // getter and setter methods
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getKey() {
        return this.key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getValue() {
        return this.value;
    }
    public void setValue(String value) {
        this.value = value;
    }

}
package com.biro.cloud.users.persistence.v1;

import java.util.List;

import com.biro.cloud.users.persistence.v1.AccountOptions;

import java.util.*;
import org.eclipse.persistence.annotations.UuidGenerator;
import javax.persistence.*;


@Entity(name = "users")
@NamedQueries(value =
        {
                @NamedQuery(name = "Users.getAll", query = "SELECT u FROM users u")
        })
@UuidGenerator(name = "idGenerator")
public class Users {

    @Id
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    private List<AccountOptions> accountOptionsList;

    // getter and setter methods
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<AccountOptions> getAccountOptionsList() { return this.accountOptionsList; }
    public void setAccountOptionsList(List<AccountOptions> opts) { this.accountOptionsList = opts; }

}
package com.biro.cloud.users.api.v1.resources;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by km on 13/12/2017.
 */
public class Info {
    public List<String> clani;
    public String opis_projekta;
    public List<String> mikrostoritve;
    public List<String> github;
    public List<String> travis;
    public List<String> dockerhub;

    public Info() {
        clani = new ArrayList<String>();
        clani.add("km4699");
        opis_projekta = "Trenutno nas projekt implementira uporabnika, ki mu pripadajo neke nastavitve.";
        mikrostoritve = new ArrayList<String>();
        mikrostoritve.add("http://169.51.26.156:30519/v1/users");
        mikrostoritve.add("http://169.51.26.156:30840/v1/accountoptions");
        github = new ArrayList<String>();
        github.add("https://github.com/Birocloud/users");
        github.add("https://github.com/Birocloud/accountoptions");
        travis = new ArrayList<String>();
        travis.add("https://travis-ci.org/Birocloud/users");
        travis.add("https://travis-ci.org/Birocloud/accountoptions");
        dockerhub = new ArrayList<String>();
        dockerhub.add("https://hub.docker.com/r/kristijanmirceta/birocloud-users/");
        dockerhub.add("https://hub.docker.com/r/kristijanmirceta/birocloud-accountoptions/");
    }
}

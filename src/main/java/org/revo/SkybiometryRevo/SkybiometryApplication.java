package org.revo.SkybiometryRevo;

import org.revo.SkybiometryRevo.model.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class SkybiometryApplication {
    private String url = "http://api.skybiometry.com/fc/";
    private final RestTemplate restTemplate = new RestTemplate();
    private login login;


    public SkybiometryApplication(login login) {
        this.login = login;
    }

    public train train(String uids) {
        try {
            return restTemplate.getForObject(url + "faces/" + "train.json?" + login.toString() + "&uids=" + uids, train.class);
        } catch (HttpClientErrorException e) {
        }
        return new train(status.fail);
    }

    public recognize recognize(String uids, String OnlineUrl) {
        try {
            return restTemplate.getForObject(url + "faces/" + "recognize.json?" + login.toString() + "&uids=" + uids + "&urls=" + OnlineUrl, recognize.class);
        } catch (HttpClientErrorException e) {
        }
        return new recognize(status.fail);
    }

    public get get(String uids) {
        try {
            return restTemplate.getForObject(url + "tags/" + "get.json?" + login.toString() + "&uids=" + uids, get.class);
        } catch (HttpClientErrorException e) {
        }
        return new get(status.fail);
    }

    public detect detect(String urls, String attributes) {
        try {
            return restTemplate.getForObject(url + "faces/" + "detect.json?" + login.toString() + "&urls=" + urls + "&attributes=" + attributes, detect.class);
        } catch (HttpClientErrorException e) {
        }
        return new detect(status.fail);
    }

    public save save(String uid, String tids) {
        try {
            return restTemplate.getForObject(url + "tags/" + "save.json?" + login.toString() + "&uid=" + uid + "&tids=" + tids, save.class);
        } catch (HttpClientErrorException e) {
        }
        return new save(status.fail);
    }

    public user users(String namespace) {
        try {
            return restTemplate.getForObject(url + "account/" + "users.json?" + login.toString() + "&namespaces=" + namespace, user.class);
        } catch (HttpClientErrorException e) {
        }
        return new user(status.fail);
    }

    public limits limits() {
        try {
            return restTemplate.getForObject(url + "account/" + "limits.json?" + login.toString(), limits.class);
        } catch (HttpClientErrorException e) {
        }
        return new limits().setStatus(status.fail);
    }

    public authenticate authenticate() {
        try {
            return restTemplate.getForObject(url + "account/" + "authenticate.json?" + login.toString(), authenticate.class);
        } catch (HttpClientErrorException e) {
        }
        return new authenticate(status.fail, false);
    }
}


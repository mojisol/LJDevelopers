package com.ljd.android.ljdevelopers;

/**
 * Created by MOJISOLA on 19/08/2017.
 */

public class Ljdevelopers {
    private String login;
    private String avatar_url;
    private String html_url;

    public Ljdevelopers(String login, String gitUrl, String avatar_url) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.html_url = gitUrl;}

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }


    }

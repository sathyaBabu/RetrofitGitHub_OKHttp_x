package com.sathya.retrofitgithub_okhttp_x.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GitHubUser {
/*
"  name": "Sathya Babu ",
  "company": "Edureka",
  "blog": "www.edureka.co",
  "location": "Bangalore",

 "bio": "Been in IT for over two decades, Consulting, Development, and corporate training.",
 */
    private String name;
    private String company;
    private String blog;

    private String bio;

    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;




     public String getAvatarUrl() {
        return avatarUrl;
    }



    public String getName() {
        return name;
    }

    public String getBlog() {
        return blog;
    }

    public String getCompany() {
        return company;
    }

    public String getBio() {
        return bio;
    }
}

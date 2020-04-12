package com.sid.architecture.component.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class MovieDetails {
    @SerializedName("name")
    public String name;
    @SerializedName("realname")
    public String realname;
    @SerializedName("team")
    public String team;
}

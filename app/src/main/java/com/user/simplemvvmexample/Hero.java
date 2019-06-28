package com.user.simplemvvmexample;

import com.google.gson.annotations.SerializedName;

public class Hero {
    @SerializedName("createdby")
    private String createdby;

    @SerializedName("firstappearance")
    private String firstappearance;

    @SerializedName("imageurl")
    private String imageurl;

    @SerializedName("name")
    private String name;

    @SerializedName("publisher")
    private String publisher;

    @SerializedName("bio")
    private String bio;

    @SerializedName("team")
    private String team;

    @SerializedName("realname")
    private String realname;

    public void setCreatedby(String createdby){
        this.createdby = createdby;
    }

    public String getCreatedby(){
        return createdby;
    }

    public void setFirstappearance(String firstappearance){
        this.firstappearance = firstappearance;
    }

    public String getFirstappearance(){
        return firstappearance;
    }

    public void setImageurl(String imageurl){
        this.imageurl = imageurl;
    }

    public String getImageurl(){
        return imageurl;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public String getPublisher(){
        return publisher;
    }

    public void setBio(String bio){
        this.bio = bio;
    }

    public String getBio(){
        return bio;
    }

    public void setTeam(String team){
        this.team = team;
    }

    public String getTeam(){
        return team;
    }

    public void setRealname(String realname){
        this.realname = realname;
    }

    public String getRealname(){
        return realname;
    }

    @Override
    public String toString(){
        return
                "Response{" +
                        "createdby = '" + createdby + '\'' +
                        ",firstappearance = '" + firstappearance + '\'' +
                        ",imageurl = '" + imageurl + '\'' +
                        ",name = '" + name + '\'' +
                        ",publisher = '" + publisher + '\'' +
                        ",bio = '" + bio + '\'' +
                        ",team = '" + team + '\'' +
                        ",realname = '" + realname + '\'' +
                        "}";
    }
}
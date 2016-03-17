package com.myapps.mkain.dccharacters.model;

public class Character {

    private String name;
    private String realName;
    private String title;
    private String description;
    private int imageID;

    public Character() {

    }

    public Character(String name, String realName, String title, String description, int type) {
        this.name = name;
        this.realName = realName;
        this.title = title;
        this.description = description;
        this.imageID = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}

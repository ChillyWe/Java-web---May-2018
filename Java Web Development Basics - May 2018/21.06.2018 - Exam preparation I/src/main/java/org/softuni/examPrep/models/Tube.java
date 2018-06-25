package org.softuni.examPrep.models;

public class Tube {
    private String title;

    private String description;

    private Integer views;

    private String uploader;

    public Tube(String title, String description, Integer views, String uploader) {
        this.title = title;
        this.description = description;
        this.views = views;
        this.uploader = uploader;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getViews() {
        return this.views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getUploader() {
        return this.uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}

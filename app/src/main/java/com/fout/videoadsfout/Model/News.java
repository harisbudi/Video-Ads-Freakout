package com.fout.videoadsfout.Model;

public class News {
    public String title,date, Image,rubrik;

    public News(String title, String date, String image, String rubrik) {
        this.title = title;
        this.date = date;
        Image = image;
        this.rubrik = rubrik;
    }

    public String getRubrik() {
        return rubrik;
    }

    public void setRubrik(String rubrik) {
        this.rubrik = rubrik;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}

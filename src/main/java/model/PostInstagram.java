package model;

import service.Service;

import java.util.Base64;

public class PostInstagram{

    String id;
    String id_usuari;
    String title;
    //String url;
    String message;
    byte[] image;
    String likes;
    String dat;

  /*  public PostInstagram(String likes,String id,String id_usuari, String title, String url, String message, String dat) {
        this.id = id;
        this.id_usuari = id_usuari;
        this.title = title;
        this.url = url;
        this.message = message;
        this.dat = dat;
        this.likes = likes;
    }

    public PostInstagram(String id_usuari, String title, String url, String message, String dat) {
        this.id_usuari = id_usuari;
        this.title = title;
        this.url = url;
        this.message = message;
        this.dat = dat;
    }*/

    public PostInstagram(String likes,String id,String id_usuari, String title, byte[] image, String message, String dat) {
        this.id = id;
        this.id_usuari = id_usuari;
        this.title = title;
        this.image = image;
        this.message = message;
        this.dat = dat;
        this.likes = likes;
    }



    public PostInstagram(String id_usuari, String title, byte[] image, String message, String dat) {
        this.id_usuari = id_usuari;
        this.title = title;
        this.image = image;
        this.message = message;
        this.dat = dat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_usuari() {
        return id_usuari;
    }

    public void setId_usuari(String id_usuari) {
        this.id_usuari = id_usuari;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

   /* public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }*/

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDat() {
        return dat;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }

    public User getUsuari(){
        return Service.getInstance().getUser(id_usuari);
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public byte[] getImage() {
        return image;
    }

    public String getImageString(){
        return Base64.getEncoder().encodeToString(this.image);
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

package model;

public class User {
    String id;
    String usuari;
    String email;
    String linkedin;
    String gitlab;

    public User(String id, String usuari, String email, String linkedin, String gitlab) {
        this.id = id;
        this.usuari = usuari;
        this.email = email;
        this.linkedin = linkedin;
        this.gitlab = gitlab;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGitlab() {
        return gitlab;
    }

    public void setGitlab(String gitlab) {
        this.gitlab = gitlab;
    }
}

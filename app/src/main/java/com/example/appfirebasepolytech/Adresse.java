package com.example.appfirebasepolytech;

public class Adresse {
    private String codeP;
    private String ville;
    private String rue;

    public Adresse() {
    }

    public Adresse(String codeP, String ville, String rue) {
        this.codeP = codeP;
        this.ville = ville;
        this.rue = rue;
    }

    public String getCodeP() {
        return codeP;
    }

    public String getVille() {
        return ville;
    }

    public String getRue() {
        return rue;
    }

    public void setCodeP(String codeP) {
        this.codeP = codeP;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }
}

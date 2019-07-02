package model.entretien;

import common.sharedKernel.ValueObject;

class Candidat implements ValueObject {

    private String nom;

    private String prenom;

    private Profil profil;

    Candidat(String nom, String prenom, Profil profil) {
        this.nom = nom;
        this.prenom = prenom;
        this.profil = profil;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Profil getProfil() {
        return profil;
    }
}

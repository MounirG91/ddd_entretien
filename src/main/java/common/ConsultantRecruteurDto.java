package common;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ConsultantRecruteurDto {
    private String nom;

    private String prenom;

    private List<String> competences;

    private int nombreAnneeExperience;

    private List<String> softSkills;

    private Map<Date, Date> creneauDisponibles;

    public ConsultantRecruteurDto() {
    }

    public ConsultantRecruteurDto(String nom, String prenom, List<String> competences, int nombreAnneeExperience, List<String> softSkills, Map<Date, Date> creneauDisponibles) {
        this.nom = nom;
        this.prenom = prenom;
        this.competences = competences;
        this.nombreAnneeExperience = nombreAnneeExperience;
        this.softSkills = softSkills;
        this.creneauDisponibles = creneauDisponibles;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public List<String> getCompetences() {
        return competences;
    }

    public int getNombreAnneeExperience() {
        return nombreAnneeExperience;
    }

    public List<String> getSoftSkills() {
        return softSkills;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCompetences(List<String> competences) {
        this.competences = competences;
    }

    public void setNombreAnneeExperience(int nombreAnneeExperience) {
        this.nombreAnneeExperience = nombreAnneeExperience;
    }

    public void setSoftSkills(List<String> softSkills) {
        this.softSkills = softSkills;
    }

    public Map<Date, Date> getCreneauDisponibles() {
        return creneauDisponibles;
    }

    public void setCreneauDisponibles(Map<Date, Date> creneauDisponibles) {
        this.creneauDisponibles = creneauDisponibles;
    }
}

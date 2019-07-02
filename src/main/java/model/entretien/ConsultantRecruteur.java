package model.entretien;

import common.sharedKernel.ValueObject;

import java.util.Date;
import java.util.Map;

class ConsultantRecruteur implements ValueObject {

    private String nom;

    private String prenom;

    private Profil profil;

    private Map<Date, Date> creneauDisponibles;

    ConsultantRecruteur(String nom, String prenom, Profil profil, Map<Date, Date> creneauDisponibles) {
        this.nom = nom;
        this.prenom = prenom;
        this.profil = profil;
        this.creneauDisponibles = creneauDisponibles;
    }

    String getNom() {
        return nom;
    }

    String getPrenom() {
        return prenom;
    }

    Profil getProfil() {
        return profil;
    }

    boolean peutTesterCandidat(Candidat candidat){
        boolean peutTester = false ;
        if (this.getProfil().getNombreAnneeExperience()<=candidat.getProfil().getNombreAnneeExperience()) {
            return false;
        }
        else {
            for (String competenceCandidat : candidat.getProfil().getCompetences()) {
                if (this.getProfil().getCompetences().contains(competenceCandidat)) {
                    peutTester = true;
                    break;
                }
            }
        }
        return peutTester;
    }

    boolean estDisponible(Date dateDebut, Date dateFin) {
        for (Map.Entry<Date, Date> entry : creneauDisponibles.entrySet()) {
            Date dateDebutCreneau = entry.getKey();
            Date dateFinCreneau = entry.getValue();

            if (dateDebut.after(dateDebutCreneau) && dateFin.before(dateFinCreneau)) {
                return true;
            }
        }
        return false;
    }


}

package use_cases.entretien;

import common.CandidatDto;
import common.ConsultantRecruteurDto;
import common.EntretienDto;
import common.SalleDto;
import model.entretien.ConsultantRecruteurNonDisponibleException;
import model.entretien.Entretien;
import model.salle.Salle;

import java.util.Date;
import java.util.List;

public class PlanifierEntretien {


    private Salles salles;
    private ConsultantRecruteurs consultantRecruteurs;
    private Entretien entretien;
    private Salle salle;
    private Entretiens entretiens;

    public PlanifierEntretien(Salles salles, ConsultantRecruteurs consultantRecruteurs, Entretien entretien, Salle salle, Entretiens entretiens) {
        this.salles = salles;
        this.consultantRecruteurs = consultantRecruteurs;
        this.entretien = entretien;
        this.salle = salle;
        this.entretiens = entretiens;
    }

    public EntretienDto planifierEntretien (CandidatDto candidat, Date dateDebut, Date dateFin) throws ConsultantRecruteurNonDisponibleException {

        List<SalleDto> sallesDisponibles = salles.sallesDisponibles(dateDebut);
        List<ConsultantRecruteurDto> consultantsDisponibles = consultantRecruteurs.consultantsDisponibles(dateDebut);

        EntretienDto entretienDto = null;

        entretienDto = entretien.planifier(candidat, sallesDisponibles, consultantsDisponibles, dateDebut, dateFin);

        salle.reserver(sallesDisponibles, dateDebut);

        entretiens.sauvegarderEntretien(entretienDto);

        return entretienDto;
    }
}

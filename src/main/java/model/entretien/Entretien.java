package model.entretien;

import common.CandidatDto;
import common.ConsultantRecruteurDto;
import common.EntretienDto;
import common.SalleDto;
import common.sharedKernel.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Entretien implements Entity {

    private EntretienID  idEntretien;

    private Candidat candidat;

    private ConsultantRecruteur consultantRecruteurChoisi;

    private List<ConsultantRecruteur> consultantsPouvantTesterLeCandiant;

    private String status;

    public EntretienDto planifier(CandidatDto candidatDto, List<SalleDto> sallesDto, List<ConsultantRecruteurDto> consultantRecruteursDto, Date dateDebut, Date dateFin) throws ConsultantRecruteurNonDisponibleException {
        idEntretien = new EntretienID();

        this.rechercherConsultantRecruteurPouvantTesterLeCandidat(candidatDto, consultantRecruteursDto);

        this.rechercherConsultantDisponible(dateDebut, dateFin);

        this.statusPlanifie();

        CandidatDto candidatDtoRetour = new CandidatDto(
                candidat.getNom(),
                candidat.getPrenom(),
                candidat.getProfil().getCompetences(),
                candidat.getProfil().getNombreAnneeExperience(),
                candidat.getProfil().getSoftSkills());

        ConsultantRecruteurDto consultantRecruteurDtoRetour = new ConsultantRecruteurDto(
                consultantRecruteurChoisi.getNom(),
                consultantRecruteurChoisi.getPrenom(),
                consultantRecruteurChoisi.getProfil().getCompetences(),
                consultantRecruteurChoisi.getProfil().getNombreAnneeExperience(),
                consultantRecruteurChoisi.getProfil().getSoftSkills(), null);

        return new EntretienDto(candidatDtoRetour, consultantRecruteurDtoRetour, status);
    }


    void rechercherConsultantRecruteurPouvantTesterLeCandidat(CandidatDto candidatDto, List<ConsultantRecruteurDto> consultantRecruteursDto) throws ConsultantRecruteurNonDisponibleException {
        Candidat candidat = new Candidat(
                candidatDto.getNom(),
                candidatDto.getPrenom(),
                new Profil(
                        candidatDto.getCompetences(),
                        candidatDto.getNombreAnneeExperience(),
                        candidatDto.getSoftSkills()
                )
        );

        consultantsPouvantTesterLeCandiant = new ArrayList<ConsultantRecruteur>();
        for (ConsultantRecruteurDto consultantRecruteurDto : consultantRecruteursDto){
            ConsultantRecruteur consultantRecruteur = new ConsultantRecruteur(
                    consultantRecruteurDto.getNom(),
                    consultantRecruteurDto.getPrenom(),
                    new Profil(
                            consultantRecruteurDto.getCompetences(),
                            consultantRecruteurDto.getNombreAnneeExperience(),
                            consultantRecruteurDto.getSoftSkills()
                    ),
                    consultantRecruteurDto.getCreneauDisponibles());
             if (consultantRecruteur.peutTesterCandidat(candidat)) {
                 consultantsPouvantTesterLeCandiant.add(consultantRecruteur);
             }
        }

        if (consultantsPouvantTesterLeCandiant.size() == 0) {
            throw new ConsultantRecruteurNonDisponibleException();
        }
    }


    void rechercherConsultantDisponible(Date dateDebut, Date dateFin) throws ConsultantRecruteurNonDisponibleException {

        for (ConsultantRecruteur consultantRecruteur : consultantsPouvantTesterLeCandiant) {
            if (consultantRecruteur.estDisponible(dateDebut, dateFin)) {
                this.consultantRecruteurChoisi = consultantRecruteur;
                return;
            }
        }

        if (this.consultantRecruteurChoisi == null) {
            throw new ConsultantRecruteurNonDisponibleException();
        }

    }

    void statusPlanifie() {
        this.status = "PLANIFIE";
    }


}

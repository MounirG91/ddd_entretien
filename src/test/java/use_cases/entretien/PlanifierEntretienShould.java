package use_cases.entretien;


import common.CandidatDto;
import common.ConsultantRecruteurDto;
import common.EntretienDto;
import common.SalleDto;
import model.entretien.ConsultantRecruteurNonDisponibleException;
import model.entretien.Entretien;
import model.salle.Salle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
public class PlanifierEntretienShould {

    @InjectMocks
    PlanifierEntretien planifierEntretien;

    @Mock
    Salles salles;

    @Mock
    ConsultantRecruteurs consultantRecruteurs;

    @Mock
    Entretien entretien;

    @Mock
    Salle salle;

    @Mock
    Entretiens entretiens;

    @Test
    public void recuperer_la_liste_des_salles_disponibles_pour_un_jour_donne() throws ConsultantRecruteurNonDisponibleException {
        // given
        Date dateJourDonne = new Date();
        Date dateFin = new Date(dateJourDonne.getTime() + 3600);
        CandidatDto candidat = new CandidatDto();

        //when
        planifierEntretien.planifierEntretien(candidat, dateJourDonne, dateFin);

        //then
        Mockito.verify(salles).sallesDisponibles(dateJourDonne);
    }

    @Test
    public void recuperer_la_liste_des_consultants_disponibles_pour_un_jour_donne() throws ConsultantRecruteurNonDisponibleException {
        // given
        Date dateJourDonne = new Date();
        Date dateFin = new Date(dateJourDonne.getTime() + 3600);

        CandidatDto candidat = new CandidatDto();
        //when
        planifierEntretien.planifierEntretien(candidat, dateJourDonne, dateFin);

        //then
        Mockito.verify(consultantRecruteurs).consultantsDisponibles(dateJourDonne);
    }

    @Test
    public void planifier_un_entretien_pour_un_jour_donne() throws ConsultantRecruteurNonDisponibleException {
        // given
        Date dateJourDonne = new Date();
        Date dateFin = new Date(dateJourDonne.getTime() + 3600);
        CandidatDto candidat = new CandidatDto();

        List<SalleDto> sallesMock = Arrays.asList(new SalleDto(), new SalleDto());
        List<ConsultantRecruteurDto> consultantRecruteursMock = Arrays.asList(new ConsultantRecruteurDto(), new ConsultantRecruteurDto());

        Mockito.when(salles.sallesDisponibles(dateJourDonne)).thenReturn(sallesMock);
        Mockito.when(consultantRecruteurs.consultantsDisponibles(dateJourDonne)).thenReturn(consultantRecruteursMock);

        // when
        planifierEntretien.planifierEntretien(candidat, dateJourDonne, dateFin);

        // then
        Mockito.verify(entretien).planifier(candidat, sallesMock, consultantRecruteursMock, dateJourDonne, dateFin);
    }

    @Test
    public void reserver_une_salle() throws ConsultantRecruteurNonDisponibleException {
        // given
        Date dateJourDonne = new Date();
        Date dateFin = new Date(dateJourDonne.getTime() + 3600);
        CandidatDto candidat = new CandidatDto();

        List<SalleDto> sallesMock = Arrays.asList(new SalleDto(), new SalleDto());
        Mockito.when(salles.sallesDisponibles(dateJourDonne)).thenReturn(sallesMock);


        // when
        planifierEntretien.planifierEntretien(candidat, dateJourDonne, dateFin);

        // then
        Mockito.verify(salle).reserver(sallesMock, dateJourDonne);
    }

    @Test
    public void sauvegarder_l_entretien_planifie() throws ConsultantRecruteurNonDisponibleException {
        // given
        Date dateJourDonne = new Date();
        Date dateFin = new Date(dateJourDonne.getTime() + 3600);
        CandidatDto candidat = new CandidatDto();

        // when
        planifierEntretien.planifierEntretien(candidat, dateJourDonne, dateFin);

        // then
        Mockito.verify(entretiens).sauvegarderEntretien((EntretienDto) any());
    }

    @Test
    public void retourner_un_entretien() throws ConsultantRecruteurNonDisponibleException {
        // given
        Date dateJourDonne = new Date();
        Date dateFin = new Date(dateJourDonne.getTime() + 3600);
        CandidatDto candidat = new CandidatDto();

        Mockito.when(entretien.planifier(any(CandidatDto.class), any(List.class), any(List.class), any(Date.class), any(Date.class)))
                .thenReturn(new EntretienDto());

        // when
        EntretienDto entretienDto = planifierEntretien.planifierEntretien(candidat, dateJourDonne, dateFin);

        // then
        Assert.assertNotNull(entretienDto);
    }


}

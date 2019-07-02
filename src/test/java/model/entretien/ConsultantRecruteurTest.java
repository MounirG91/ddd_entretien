package model.entretien;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class ConsultantRecruteurTest {


    @Test
    public void ne_peut_pas_tester_un_candidat_il_a_moins_d_experience() {
        // given
        Candidat candidat = new Candidat(
                "toto",
                "tata",
                new Profil(
                        Arrays.asList("Java", "JavaScript", "PHP"),
                        5,
                        Arrays.asList("Cool")
                ));
        ConsultantRecruteur consultantRecruteur = new ConsultantRecruteur(
                "toto",
                "tata",
                new Profil(
                        Arrays.asList("Java", "JavaScript", "PHP"),
                        3,
                        Arrays.asList("Cool")
                ),
                null);

        // when
        boolean peutTester = consultantRecruteur.peutTesterCandidat(candidat);

        // then
        Assert.assertEquals(peutTester,false);

    }



    @Test
    public void ne_peut_pas_tester_un_candidat_il_n_a_pas_les_memes_competences() {
        // given
        Candidat candidat = new Candidat(
                "toto",
                "tata",
                new Profil(
                        Arrays.asList("Java", "JavaScript", "NodeJS"),
                        5,
                        Arrays.asList("Cool")
                ));
        ConsultantRecruteur consultantRecruteur = new ConsultantRecruteur(
                "toto",
                "tata",
                new Profil(
                        Arrays.asList("SQL", "Python", "PHP"),
                        8,
                        Arrays.asList("Cool")
                ),
                null);

        // when
        boolean peutTester = consultantRecruteur.peutTesterCandidat(candidat);

        // then
        Assert.assertEquals(peutTester,false);

    }



    @Test
    public void peut_tester_un_candidat() {
        // given
        Candidat candidat = new Candidat(
                "toto",
                "tata",
                new Profil(
                        Arrays.asList("Java", "JavaScript", "PHP"),
                        5,
                        Arrays.asList("Cool")
                ));
        ConsultantRecruteur consultantRecruteur = new ConsultantRecruteur(
                "toto",
                "tata",
                new Profil(
                        Arrays.asList("Java", "JavaScript", "PHP"),
                        8,
                        Arrays.asList("Cool")
                ),
                null);

        // when
        boolean peutTester = consultantRecruteur.peutTesterCandidat(candidat);

        // then
        Assert.assertEquals(peutTester,true);

    }





}

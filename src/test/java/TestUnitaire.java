/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emma
 */
import FFSSM.Club;
import FFSSM.Embauche;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.util.Calendar;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TestUnitaire {
    
    Moniteur moniteur;
    Club club;
    Site site;
    Plongee plongee;
    Embauche embauche;
    Plongeur plongeur;
    Licence licence;
    Plongeur plongeur2;
    Licence licence2;

    @Before
    public void setUp() {
        Calendar dateMax = Calendar.getInstance();
        dateMax.add(Calendar.YEAR, -3);
        moniteur = new Moniteur("4812", "Duplomb", "Cerise", "Castres", "12345678", Calendar.getInstance(), 4);
        club = new Club(moniteur, "clubBlanc", "1178439");
        site = new Site("Villeneuve", "rien");
        plongee = new Plongee(site, moniteur, Calendar.getInstance(), 20, 10);
        embauche = new Embauche(Calendar.getInstance(), moniteur, club);
        plongeur = new Plongeur("33", "Poireau", "Pierre", "Castres", "6987622", Calendar.getInstance(), 6, 5);
        plongeur2 = new Plongeur("34", "Barral", "Yasmine", "Castres", "39658552", Calendar.getInstance(), 7, 8);
        licence = new Licence(plongeur, "13", Calendar.getInstance(), 25, club);
        licence2 = new Licence(moniteur, "13", dateMax, 25, club);
    }

    @Test
    public void testClub() {
        club.organisePlongee(plongee);
        plongeur.ajouteLicence(licence);
        plongee.ajouteParticipant(plongeur);
        club.plongeesNonConformes().size();
        assertEquals(0, club.plongeesNonConformes().size());

    }

    @Test
    public void testNonConforme() {
        club.organisePlongee(plongee);
        plongeur2.ajouteLicence(licence2);
        plongee.ajouteParticipant(plongeur2);
        club.plongeesNonConformes().size();
        assertEquals(1, club.plongeesNonConformes().size());

    }

    @Test
    public void testEmployeur() {
        moniteur.nouvelleEmbauche(club, Calendar.getInstance());
        moniteur.employeurActuel().getNom();
        assertEquals("clubBleu", moniteur.employeurActuel().getNom());
        moniteur.TerminerEmbauche(Calendar.getInstance());
        assertTrue(moniteur.emplois().get(0).estTerminee());

    }
    
}

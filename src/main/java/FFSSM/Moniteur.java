/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Personne {

    public int numeroDiplome;
    private List<Embauche> mesEmplois;

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.numeroDiplome = numeroDiplome;
        mesEmplois = new ArrayList<>();
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur, ou null
     */
    public Club employeurActuel() {
         return mesEmplois.get(mesEmplois.size()-1).getEmployeur();   
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {   
         mesEmplois.add(new Embauche(debutNouvelle, this, employeur));	    
    }
    
     public void TerminerEmbauche(Calendar dateFin) {   
        mesEmplois.get(mesEmplois.size()-1).terminer(dateFin);	    
    }

    public List<Embauche> emplois() {
         return mesEmplois;
    }

}

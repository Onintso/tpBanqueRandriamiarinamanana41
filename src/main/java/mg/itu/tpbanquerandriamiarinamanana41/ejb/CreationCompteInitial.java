/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpbanquerandriamiarinamanana41.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import mg.itu.tpbanquerandriamiarinamanana41.entities.CompteBancaire;

/**
 *
 * @author randr
 */
@Singleton
@Startup
public class CreationCompteInitial {
    @EJB
    GestionnaireCompte gestionnaireCompte;
    
    @PostConstruct
        public void init() {
            long nb = gestionnaireCompte.nbComptes();
            if(nb==0){
                CompteBancaire[] listeCompte = new CompteBancaire[4];
                listeCompte[0]=new CompteBancaire("John Lennon", 150000);
                listeCompte[1]=new CompteBancaire("Paul McCartney", 950000);
                listeCompte[2]=new CompteBancaire("Ringo Starr", 20000);
                listeCompte[3]=new CompteBancaire("Georges Harrisson", 100000);
                for(int i=0; i<4; i++)
                    gestionnaireCompte.creerCompte(listeCompte[i]);
            }
            
        }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpbanquerandriamiarinamanana41.ejb;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import mg.itu.tpbanquerandriamiarinamanana41.entities.CompteBancaire;

/**
 *
 * @author randr
 */
@DataSourceDefinition(
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        name = "java:app/jdbc/banque",
        serverName = "localhost",
        portNumber = 3306,
        user = "payara", // nom et
        password = "P1a1y1a1r1a1!", // mot de passe que vous avez donnés lors de la création de la base de données
        databaseName = "banque",
        properties = {
            "useSSL=false",
            "allowPublicKeyRetrieval=true"
        }
)
@Stateless
public class GestionnaireCompte {

    @PersistenceContext(unitName = "banquePU")
    private EntityManager em;
    
    public void creerCompte(CompteBancaire c){
        em.persist(c);
    }
    
    public List<CompteBancaire> getAllComptes() {  
        String request = "select c from CompteBancaire c";
        TypedQuery<CompteBancaire> query = em.createQuery(request, CompteBancaire.class);
       return query.getResultList();
    } 
    
    public long nbComptes(){
        String request = "select count(c) from CompteBancaire c";
        Query query = em.createQuery(request);
        long nb = (long) query.getSingleResult();
        return nb;
    }
}

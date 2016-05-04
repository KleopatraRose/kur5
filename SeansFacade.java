/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r.mavenproject2;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kleopatra
 */
@Stateless
public class SeansFacade extends AbstractFacade<Seans> implements SeansFacadeLocal {

    @PersistenceContext(unitName = "r_mavenproject2_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeansFacade() {
        super(Seans.class);
    }
    
}

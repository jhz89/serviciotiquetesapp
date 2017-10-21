/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Harold
 */
@Stateless
public class TiqueteFacade extends AbstractFacade<Tiquete> {

    @PersistenceContext(unitName = "tiquetesappPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiqueteFacade() {
        super(Tiquete.class);
    }
    
}

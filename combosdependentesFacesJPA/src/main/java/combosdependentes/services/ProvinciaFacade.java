/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package combosdependentes.services;

import combosdependentes.entidades.Provincia;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


/**
 *
 * @author desenvolvimento
 */
@Stateless
public class ProvinciaFacade extends AbstractFacade<Provincia> {
    @PersistenceContext(unitName = "appgeografiaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProvinciaFacade() {
        super(Provincia.class);
    }
    
}

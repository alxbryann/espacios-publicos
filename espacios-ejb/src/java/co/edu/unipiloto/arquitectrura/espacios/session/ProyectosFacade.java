/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectrura.espacios.session;

import co.edu.unipiloto.arquitectrura.espacios.entity.Proyectos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author barr2
 */
@Stateless
public class ProyectosFacade extends AbstractFacade<Proyectos> implements ProyectosFacadeLocal {

    @PersistenceContext(unitName = "espacios-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectosFacade() {
        super(Proyectos.class);
    }
    
}

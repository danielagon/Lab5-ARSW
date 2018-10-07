/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.filters.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.filters.Filter;
import org.springframework.stereotype.Service;

/**
 *
 * @author danielagonzalez
 */
//@Service
public class SubsamplingFilter implements Filter{

    @Override
    public void removePoints(Blueprint bp) throws BlueprintPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

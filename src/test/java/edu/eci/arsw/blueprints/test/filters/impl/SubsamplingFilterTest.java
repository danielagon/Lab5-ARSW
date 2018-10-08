/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.test.filters.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author danielagonzalez
 */
public class SubsamplingFilterTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    
    /**
     * The injection must be modified to perform the test.
     */
    @Test
    public void removePointsTest() throws BlueprintPersistenceException, BlueprintNotFoundException{
        BlueprintsServices bps = context.getBean(BlueprintsServices.class);
        
        Point[] points = new Point[] {new Point(13,45), new Point(46,77), new Point(15,22), new Point(33,11), new Point(19,34)};
        Blueprint bp = new Blueprint("Alex", "Test", points);
        bps.addNewBlueprint(bp);
        
        List<Point> newPoints = new ArrayList<>();
        newPoints.add(new Point(13,45));
        newPoints.add(new Point(15,22));
        newPoints.add(new Point(19,34));
        
        List<Point> returnedPoints = bps.getBlueprint("Alex", "Test").getPoints();
        
        for (int i=0;i<returnedPoints.size();i++){
            assertEquals(returnedPoints.get(i).getX(), newPoints.get(i).getX());
            assertEquals(returnedPoints.get(i).getY(), newPoints.get(i).getY());
        }
    }
}

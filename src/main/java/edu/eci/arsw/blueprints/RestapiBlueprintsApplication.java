package edu.eci.arsw.blueprints;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import java.util.Set;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author danielagonzalez
 */
@SpringBootApplication
public class RestapiBlueprintsApplication {
    
    private static BlueprintsServices bluePrints;
    
    public static void main(String[] args) throws BlueprintNotFoundException, BlueprintPersistenceException{
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        bluePrints = context.getBean(BlueprintsServices.class);
        SpringApplication.run(RestapiBlueprintsApplication.class, args);
        registerBlueprints();
        consultBlueprints();
        consultBlueprintsByAuthor();
    }
    
    public static void registerBlueprints() throws BlueprintPersistenceException{
        Point [] pts1 = new Point [] {new Point(23,45), new Point(40,56)};
        Blueprint bp1 = new  Blueprint("Jhon","Blueprint",pts1);
        bluePrints.addNewBlueprint(bp1);
        
        Point[] pts2 = new Point[] {new Point(13,10), new Point(67,98)};
        Blueprint bp2 = new Blueprint("Mark","Home",pts2);
        bluePrints.addNewBlueprint(bp2);
    }
    
    public static void consultBlueprints() throws BlueprintNotFoundException,BlueprintPersistenceException{
        Blueprint bp1 = bluePrints.getBlueprint("Jhon", "Blueprint");
        System.out.println(bp1.toString());
        Blueprint bp2 = bluePrints.getBlueprint("Mark", "Home");
        System.out.println(bp2.toString());
    }
    
    public static void consultBlueprintsByAuthor() throws BlueprintNotFoundException,BlueprintPersistenceException{
        Point[] pts3 = new Point[] {new Point(33,67), new Point(10,34)};
        Blueprint bp3 = new Blueprint("Mark","Car",pts3);
        bluePrints.addNewBlueprint(bp3);
        
        Set<Blueprint> blueprintsByAuthor = bluePrints.getBlueprintsByAuthor("Mark");
        System.out.println(blueprintsByAuthor);
    }
}

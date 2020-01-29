/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventech;



import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.geojson.Polygon;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.java.html.leaflet.*;
import org.bson.Document;

/**
 *
 * @author info
 */
public class Preventech {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        Tupla x = new Tupla("Ciao",5.10,10.2,"Via pepp");
        
        
        System.out.println("Doc inserito");     
        
        
        /*for (Document o : foundDocument) {
            List<Document> list = (List<Document>) o.get("pos");
            String list2 = (String) o.get("str");
            System.out.println(list2);
            System.out.println(list.get(0));
            System.out.println(list.get(1));
        }*/
        
    }
    
}

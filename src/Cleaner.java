
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class Cleaner {

	private static final Logger log = Logger.getAnonymousLogger();

	public static void dropMongoDB() {
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 ); 
		MongoDatabase db  = mongoClient.getDatabase("mongodbPU"); 
		db.drop();
		

	}
	public static void run() {

	
		
		String[] TYPES = new String[]{
				"JaxSimpleEvent",
				"OgmSimpleEvent",
				"OgmSimpleEventBody",
				"JaxListEvent",
				"OgmListEvent",
				"OgmListEventBody",
				"OgmHopListEvent",
				"OgmBigSimpleEvent",
				"OgmBigSimpleEventBody",
				"OgmBigListEvent",
				"OgmBigListEventBody"
				};

		long startTime = System.nanoTime();    

		try {

			/* JPQL bulk delete */
			String s = Arrays.stream(TYPES)
		             .map(e -> "e.type = '"+e+"'")
		             .collect( Collectors.joining( " OR " ));
			EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();
			EntityTransaction txx = em.getTransaction();
			txx.begin();
			Query query = em.createQuery("DELETE FROM Event e WHERE "+s);
	        query.executeUpdate();
			txx.commit();
			
			/*native delete (dropping collections)*/
			MongoClient mongoClient = new MongoClient( "localhost" , 27017 ); 
			MongoDatabase db  = mongoClient.getDatabase("mongodbPU"); 
			for (String type : TYPES) {
				MongoCollection collection  = db.getCollection(type);
				collection.drop();
			}
			
            
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		long estimatedTime = System.nanoTime() - startTime;

		System.out.println("Datasources cleared:" + TimeUnit.NANOSECONDS.toMillis(estimatedTime) + "ms " + Arrays.toString(TYPES) );

	}

}

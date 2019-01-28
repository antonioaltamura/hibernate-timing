import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
public class Test {

	private static final Logger log = Logger.getAnonymousLogger();

	public static void main(String[] args) {

	
		Random rnd = new Random();
		//rnd.setSeed(1109232111);

		int SIZE =  10;
		int TABLESIZE = 500;

		if(args.length == 2) {
	    	SIZE = Integer.parseInt(args[0]);
	    	TABLESIZE = Integer.parseInt(args[1]);
	    }
		
		long startTime = System.nanoTime();    
		long elsaved;
		try {
			CSVReader elems = new CSVReader("CSV/OPT.csv",";");
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			

			for(int i=0;i<SIZE;i++) {

				OgmListEvent event= new OgmListEvent();
				event.setTitle("title");
				EventPK id = new EventPK(1);
				Long eventid = rnd.nextLong();
				
				id.setId(eventid);
				event.setId(id);
				OgmListEventBody body = new OgmListEventBody();
				body.setName("name");
				body.setId(eventid);
				ArrayList<RowElementEmbeddable> list = new ArrayList<RowElementEmbeddable>();
				
				//rewind the buffer
				elems.rewind();
						
				for(int x=0;x<TABLESIZE;x++) {
					String[] l = elems.readLine();
					RowElementEmbeddable el = RowElementEmbeddable.fromStringArray(l);
					list.add(el);
					
				}
				body.setElements(list);
				event.setOgmListEventBody(body);
				elsaved = System.nanoTime();    
				tx.begin();
				em.persist(event);
				tx.commit();
				System.out.println("OgmListInsert - element "+i+" saved:" + TimeUnit.NANOSECONDS.toMillis(System.nanoTime()-elsaved));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		long estimatedTime = System.nanoTime() - startTime;

		System.out.println("Test - SIZE:" + SIZE + " TABLESIZE:" + TABLESIZE + ":" + TimeUnit.NANOSECONDS.toMillis(estimatedTime));

	}
}

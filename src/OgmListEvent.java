

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PostLoad;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Query;
import javax.persistence.Transient;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/** This Class persistent the Event in Mysql and its body in Mongodb
 * 
 */
@Entity
@DiscriminatorValue("OgmListEvent")
public class OgmListEvent extends Event {

	@Transient
	private static EntityManager em = Persistence.createEntityManagerFactory("mongodbPU").createEntityManager();

	/**
	 * 
	 */
	@Transient
	@EventBody("OgmListEventBody")
	private OgmListEventBody body;
	/**
	 * 
	 */
	@Transient
	private final String workingTable = ("MyWorkingCopy");
	/**
	 * 
	 */
	@Transient
	private final String instance = ("MyInstance");



	/**
	 * 
	 */
	public OgmListEvent() {
	}


	/**
	 * 
	 * @return
	 */
	public OgmListEventBody getDCStorageBody() {
		return this.body;
	}

	/**
	 * 
	 */
	@PostLoad
	public void postload() {

		if (body == null) {
			try {
				Field field = this.getClass().getDeclaredField("body");
				Annotation annotation = field.getAnnotation(EventBody.class);
				if(annotation instanceof EventBody){
					EventBody ann = (EventBody) annotation;
					EntityTransaction tx = em.getTransaction();
					tx.begin();
					Query query = em.createQuery("FROM " +ann.value()+ " e WHERE e.id=:id");
					query.setParameter("id",this.getId().getId());
					OgmListEventBody r = (OgmListEventBody) query.getSingleResult();
					tx.commit();
					setOgmListEventBody(r);
				}
			}
			catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 */
	@PrePersist
	@PreUpdate
	public void prepersist() {
		if (body != null)  {
			try {
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				em.persist(this.body);
				tx.commit();
				super.setBody(Long.toString(this.getId().getId()));
			} catch (Exception e) {
				System.out.println("@PrePersist exception");
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 */
	@PreRemove
	public void remove() {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(this.body);
		tx.commit();
	}
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return this.body.getName();
	}


	/**
	 * 
	 * @return
	 */
	public String getWorkingTable() {
		return workingTable;
	}

	/**
	 * 
	 * @return
	 */
	public String getInstance() {
		return instance;
	}


	public OgmListEventBody getOgmEventBody() {
		return this.body;
	}


	public void setOgmListEventBody(OgmListEventBody b) {
		this.body = b;
	}

}

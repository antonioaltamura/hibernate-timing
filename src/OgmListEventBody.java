


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Type;

/**
 * 
 */
//@Embeddable
@Entity
@Table(name="OgmListEventBody")
public class OgmListEventBody implements Serializable{

	private static final long serialVersionUID = 1L;

	//@Type(type = "objectid")
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/**
	 * 
	 */
	private String name;
	

	/**
	 * 
	 */
	public OgmListEventBody() {
	}

    @ElementCollection
    private List<RowElementEmbeddable> elements = new ArrayList<RowElementEmbeddable>();


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the elements
	 */
	public List<RowElementEmbeddable> getElements() {
		return elements;
	}

	/**
	 * @param elements the elements to set
	 */
	public void setElements(List<RowElementEmbeddable> elements) {
		this.elements = elements;
	}

	

	

}

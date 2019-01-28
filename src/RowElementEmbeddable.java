

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Embeddable
public class RowElementEmbeddable implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
    
    private Long id;
    private String itemCode;
    private String itemDescription;
    private double packageLenght;
    private double packageWidth;
    private double packageHeight;
    private double packageWeight;
    private int breakingDegree;
    private String fragilityDegree;
    private String packagingType;
    private double palletHeight;
    private String category;
    private String similarityCode;
    private String rotationClassLink;
    private String attributeLink;
    private Long owner_ev_activity;
    private Long owner_ev_id;
    private String owner_ev_link;
   

    
    public RowElementEmbeddable() {}
  
    
	public RowElementEmbeddable(String name, String itemCode, String itemDescription, double packageLenght,
			double packageWidth, double packageHeight, double packageWeight, int breakingDegree, String fragilityDegree,
			String packagingType, double palletHeight, String category, String similarityCode, String rotationClassLink,
			String attributeLink, Long owner_ev_activity, Long owner_ev_id, String owner_ev_link) {
		super();
		this.name = name;
		this.itemCode = itemCode;
		this.itemDescription = itemDescription;
		this.packageLenght = packageLenght;
		this.packageWidth = packageWidth;
		this.packageHeight = packageHeight;
		this.packageWeight = packageWeight;
		this.breakingDegree = breakingDegree;
		this.fragilityDegree = fragilityDegree;
		this.packagingType = packagingType;
		this.palletHeight = palletHeight;
		this.category = category;
		this.similarityCode = similarityCode;
		this.rotationClassLink = rotationClassLink;
		this.attributeLink = attributeLink;
		this.owner_ev_activity = owner_ev_activity;
		this.owner_ev_id = owner_ev_id;
		this.owner_ev_link = owner_ev_link;
	}

	@Transient
	 public static RowElementEmbeddable fromStringArray(String[] l) {
	    	return new RowElementEmbeddable(l[1],l[1],l[2],Double.parseDouble(l[3]),
	    			Double.parseDouble(l[4]),Double.parseDouble(l[5]),Double.parseDouble(l[6]),Integer.parseInt(l[7]),l[8],
	    			l[9],Double.parseDouble(l[10]),l[11],l[12],l[13],
	    			l[14],Long.parseLong(l[15]),Long.parseLong(l[16]),l[17]);
		
	    }
	public String getName() {
		return name;
	}

	public RowElementEmbeddable setName(String name) {
		this.name = name;
		return this;
	}

	public Long getId() {
		return id;
	}

	public RowElementEmbeddable setId(Long id) {
		this.id = id;
		return this;
	}

	public String getItemCode() {
		return itemCode;
	}

	public RowElementEmbeddable setItemCode(String itemCode) {
		this.itemCode = itemCode;
		return this;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public RowElementEmbeddable setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
		return this;
	}

	public double getPackageLenght() {
		return packageLenght;
	}

	public RowElementEmbeddable setPackageLenght(double packageLenght) {
		this.packageLenght = packageLenght;
		return this;
	}

	public double getPackageWidth() {
		return packageWidth;
	}

	public RowElementEmbeddable setPackageWidth(double packageWidth) {
		this.packageWidth = packageWidth;
		return this;
	}

	public double getPackageWeight() {
		return packageWeight;
	}

	public RowElementEmbeddable setPackageWeight(double packageWeight) {
		this.packageWeight = packageWeight;
		return this;
	}
	
	public double getPackageHeight() {
		return packageHeight;
	}

	public RowElementEmbeddable setPackageHeight(double packageHeight) {
		this.packageHeight = packageHeight;
		return this;
	}

	public int getBreakingDegree() {
		return breakingDegree;
	}

	public RowElementEmbeddable setBreakingDegree(int breakingDegree) {
		this.breakingDegree = breakingDegree;
		return this;
	}

	public String getFragilityDegree() {
		return fragilityDegree;
	}

	public RowElementEmbeddable setFragilityDegree(String fragilityDegree) {
		this.fragilityDegree = fragilityDegree;
		return this;
	}

	public String getPackagingType() {
		return packagingType;
	}

	public RowElementEmbeddable setPackagingType(String packagingType) {
		this.packagingType = packagingType;
		return this;
	}

	public double getPalletHeight() {
		return palletHeight;
	}

	public RowElementEmbeddable setPalletHeight(double palletHeight) {
		this.palletHeight = palletHeight;
		return this;
	}

	public String getCategory() {
		return category;
	}

	public RowElementEmbeddable setCategory(String category) {
		this.category = category;
		return this;
	}

	public String getSimilarityCode() {
		return similarityCode;
	}

	public RowElementEmbeddable setSimilarityCode(String similarityCode) {
		this.similarityCode = similarityCode;
		return this;
	}

	public String getRotationClassLink() {
		return rotationClassLink;
	}

	public RowElementEmbeddable setRotationClassLink(String rotationClassLink) {
		this.rotationClassLink = rotationClassLink;
		return this;
	}

	public String getAttributeLink() {
		return attributeLink;
	}

	public RowElementEmbeddable setAttributeLink(String attributeLink) {
		this.attributeLink = attributeLink;
		return this;
	}

	public Long getOwner_ev_activity() {
		return owner_ev_activity;
	}

	public RowElementEmbeddable setOwner_ev_activity(Long owner_ev_activity) {
		this.owner_ev_activity = owner_ev_activity;
		return this;
	}

	public Long getOwner_ev_id() {
		return owner_ev_id;
	}

	public RowElementEmbeddable setOwner_ev_id(Long owner_ev_id) {
		this.owner_ev_id = owner_ev_id;
		return this;
	}

	public String getOwner_ev_link() {
		return owner_ev_link;
	}

	public RowElementEmbeddable setOwner_ev_link(String owner_ev_link) {
		this.owner_ev_link = owner_ev_link;
		return this;
	}


	
}
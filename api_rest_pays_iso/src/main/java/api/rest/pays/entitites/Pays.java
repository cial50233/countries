package api.rest.pays.entitites;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Pays extends AbstractEntity {
	
	@Column(length = 2, nullable = false)
	private String alpha2Code;

    @Column(length = 200, nullable = false)
    private String name;
    
    @Column(length = 200, nullable = false)
    private String region;
    
    @Column(length = 200, nullable = false)
    private String flag;
    
    public Pays() {
    }
    

    public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAlpha2Code() {
		return alpha2Code;
	}


	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}


    

}
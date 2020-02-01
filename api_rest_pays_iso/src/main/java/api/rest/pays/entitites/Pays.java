package api.rest.pays.entitites;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
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

	public Pays(String alpha2Code, String name, String region, String flag) {
		this.alpha2Code = alpha2Code;
		this.name = name;
		this.region = region;
		this.flag = flag;
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

	@Override
	public String toString() {

		return "Country: [Name: " + name + ", alpha2Code: "

				+ alpha2Code + " region: " + region + " flag: " + flag + "]";

	}

}

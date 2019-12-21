package api.rest.pays.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PaysDto {
	@NotEmpty
	@Size(max = 2)
	private String alpha2Code;

	@NotEmpty
	@Size(max = 200)
	private String name;
	
	@NotEmpty
	@Size(max = 200)
	private String region;
	
	@NotEmpty
	@Size(max = 200)
	private String flag;


	public PaysDto() {
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

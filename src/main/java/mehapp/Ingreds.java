package mehapp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Ingreds {
	@NotNull
	@Size(min=2, max=5000 )
	private String textIngreds;

	public String getTextIngreds() {
		return textIngreds;
	}

	public void setTextIngreds(String textIngreds) {
		this.textIngreds = textIngreds;
	}

	
	

}

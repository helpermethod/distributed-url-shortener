package de.predic8.cloud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@Entity
public class Url {
	@Id
	@GeneratedValue
	private Long id;
	private String url;

	public Url(String url) {
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
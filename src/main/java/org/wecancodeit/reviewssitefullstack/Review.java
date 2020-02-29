package org.wecancodeit.reviewssitefullstack;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String title;
	private String image;
	@Lob
	private String content;
	
	@ManyToMany
	private Collection<Category> categories;


	public long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	
	public String getImage() {
		return image;
	}
	
	public String getContent() {
		return content;
	}
	
	public Collection <Category> getCategories() {
		
		return categories;
	}
	
	public Review() {
		
	}
	
	public Review(String title, String image, String content, Category...categories) {
		this.title = title;
		this.image = image;
		this.content = content;
		this.categories = new HashSet<>(Arrays.asList(categories));
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

}

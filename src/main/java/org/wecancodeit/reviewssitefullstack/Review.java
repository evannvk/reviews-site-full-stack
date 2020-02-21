package org.wecancodeit.reviewssitefullstack;

public class Review {
	
	private long id;
	private String title;
	private String category;
	private String image;
	private String content;


	public long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getImage() {
		return image;
	}
	
	public String getContent() {
		return content;
	}
	
	public Review(long id, String title, String category, String image, String content) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.image = image;
		this.content = content;
		
	}
	

}

package models;

public class Product {
	private long id;
	public static long idCounter = 1;
	private String name;
	private long price;
	private String provider;
	private String imgPath;
	public Product(String name, long price, String provider, String imgPath) {
		this.id = idCounter++;
		this.name = name;
		this.price = price;
		this.provider = provider;
		this.imgPath = imgPath;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public long getPrice() {
		return price;
	}
	public String getProvider() {
		return provider;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}

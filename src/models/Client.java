package models;

public class Client {
	private int id; 
	private static int idCounter = 1;
	private String name;
	
	public Client(int id, String name) {
		this.id = idCounter++;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}

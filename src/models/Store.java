package models;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import persistence.FileManager;

public class Store {
	private static final String ERROR_PRODUCT_NOT_FOUND = "Product not found!";
	private static final String ERROR_CLIENT_NOT_FOUND = "client not found!";
	private ArrayList<Product> productList;
	private ArrayList<Client> clientList;
	private ArrayList<Order> orderList;
	
	public Store() {
		writeProducts();
		productList = new ArrayList<Product>();
		readProducts();
//		for (Product client : productList) {
//			System.out.println(client.getId());
//		}
		
		clientList = new ArrayList<Client>();
		clientList.add(new Client(1, "Carlos"));
		clientList.add(new Client(2, "Felipe"));
		clientList.add(new Client(3, "Andres"));
		clientList.add(new Client(4, "Jhon"));
		clientList.add(new Client(5, "Hugo"));
		
		orderList = new ArrayList<Order>();
		orderList.add(new Order(1, productList.get(0),
				clientList.get(0)));
	}
	
	public void setProduct(Product product,int index) {
		Product.idCounter = Product.idCounter-1;
		productList.set(index, product);		
	}
	
	public static Product updateProduct(String name,int price,String provider , String file,int id) throws IOException, URISyntaxException {
		String path = "./db/img/" + id
				+ file.substring(file.lastIndexOf("."), file.length());
		Files.copy(Paths.get(file), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
		return new Product(name, price, provider, path);
	}

	private void readProducts() {
		Product.idCounter=1;
		for (Product product : FileManager.read()) {
			productList.add(product);			
		}
	}
	
	public void addProduct(Product product) {
		productList.add(product);
	}
	
	public static Product createProduct(String name,int price,String provider , String file) throws IOException, URISyntaxException {
		String path = "./db/img/" + Product.idCounter+1
				+ file.substring(file.lastIndexOf("."), file.length());
		Files.copy(Paths.get(file), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
		return new Product(name, price, provider, path);
	}
	private void writeProducts() {
		ArrayList<Product> list;
		list = new ArrayList<Product>();
		list.add(new Product("xiaomi mi note 10", 425000,"CompuServicios", 
				"./db/img/xiaomi mi note 10.jpeg"));
		list.add(new Product("xiaomi redmi 8",770000,"CompuServicios",
				"./db/img/xiaomi redmi 8.jpeg"));
		list.add(new Product("xiaomi redmi note 7", 719900,"CompuServicios",
				"./db/img/xiaomi redmi note 7.jpeg"));
		list.add(new Product("xiaomi redmi note 8", 2500000,"CompuServicios",
				"./db/img/xiaomi redmi note 8.jpeg"));
		list.add(new Product("Anna",100000,"TecnoServicios",
				"./db/img/gato.jpeg"));
		list.add(new Product("xiaomi mi note 10", 425000,"CompuServicios", 
				"./db/img/xiaomi mi note 10.jpeg"));
		list.add(new Product("xiaomi redmi 8",770000,"CompuServicios",
				"./db/img/xiaomi redmi 8.jpeg"));
		list.add(new Product("xiaomi redmi note 7", 719900,"CompuServicios",
				"./db/img/xiaomi redmi note 7.jpeg"));
		list.add(new Product("xiaomi redmi note 8", 2500000,"CompuServicios",
				"./db/img/xiaomi redmi note 8.jpeg"));
		list.add(new Product("Anna",100000,"TecnoServicios",
				"./db/img/gato.jpeg"));
		FileManager.write(list);
	}
	public void addOrder(Order order) {
		orderList.add(order);
	}
	
	public Product searchProduct(int id) throws Exception{
		for (Product product : productList) {
			if (product.getId() == id) {
				return product;
			}
		}
		throw new Exception(ERROR_PRODUCT_NOT_FOUND);
	}
	public Client searchClient(String name) throws Exception{
		for (Client client : clientList) {
			if (client.getName().equals(name)) {
				return client;
			}
		}
		throw new Exception(ERROR_CLIENT_NOT_FOUND);
	}
	
	public ArrayList<Order> getOrderList() {
		return orderList;
	}
	public ArrayList<Product> getProductList() {
		return productList;
	}
	public ArrayList<Client> getClientList() {
		return clientList;
	}
}
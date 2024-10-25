package persistence;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import models.Product;

///agregar db con list.json

public class FileManager {/////agregar libreria json-simple-1.1.1.jar
	///////cambiar los tags

	private static final String TAG_LIST = "list";//dejar taglist
	private static final String TAG_ID = "id";
	private static final String TAG_NAME = "name";
	private static final String TAG_PRICE = "price";
	private static final String TAG_IMG = "img";
	private static final String TAG_PROVIDER = "provider";
	private static final String DB_PATH = "./db/list.json";//dejar la ruta del archivo

	@SuppressWarnings("unchecked")//cambiar los datos e importar la libreria
	public static void write(ArrayList<Product> products) {
		JSONObject jsonfile = new JSONObject();
		JSONArray list = new JSONArray();
		for (Product product : products) {
			JSONObject jsonProfile = new JSONObject();
			jsonProfile.put(TAG_ID, product.getId());
			jsonProfile.put(TAG_NAME, product.getName());
			jsonProfile.put(TAG_PRICE, product.getPrice());
			jsonProfile.put(TAG_PROVIDER, product.getProvider());
			jsonProfile.put(TAG_IMG, product.getImgPath());
			list.add(jsonProfile);
		}
		jsonfile.put(TAG_LIST, list);
		try (FileWriter file = new FileWriter(DB_PATH, false)) {
			file.write(jsonfile.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Product> read() {
		ArrayList<Product> list = new ArrayList<Product>();
		JSONParser parser = new JSONParser();
		try (Reader reader = new FileReader(DB_PATH)) {
			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			JSONArray products = (JSONArray) jsonObject.get(TAG_LIST);
			Iterator<JSONObject> iterator = products.iterator();
			while (iterator.hasNext()) {
				JSONObject Product = (JSONObject) iterator.next();
				list.add(new Product((String)Product.get(TAG_NAME),
						(Long)Product.get(TAG_PRICE),
						(String)Product.get(TAG_PROVIDER),
						(String)Product.get(TAG_IMG)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

//	public static void main(String[] args) {
//		for (Product object : read()) {
//			System.out.println(object.getId());			
//		}
//	}
//	
	///Agregar metodos al modelo
	private void writeData() {////escribir
		ArrayList<Object> list;
		list = new ArrayList<Object>();
		list.add(new Object());
//		FileManager.write(list);
	}
	private void readProducts() {//leer
		for (Product product : FileManager.read()) {
//			listadestino.add(product);			
		}
	}
	
	
}
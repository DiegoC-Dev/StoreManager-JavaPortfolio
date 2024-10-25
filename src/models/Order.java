package models;

public class Order {
		private int id;
		private static int idCounter = 1;
		private Product product;
		private Client client;
		
		public Order(int id, Product product, Client client) {
			super();
			this.id = idCounter++;
			this.product = product;
			this.client = client;
		}

		public int getId() {
			return id;
		}

		public Product getProduct() {
			return product;
		}

		public Client getClient() {
			return client;
		}

		public String[] toStringVector() {
			String[] order= {""+id,""+product.getProvider(),""+product.getName(),
					""+client.getName()};
			return order;
		}
}
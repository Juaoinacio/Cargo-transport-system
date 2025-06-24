package travelSystem;

public class Product {
	private static int counterIds = 1;
	private int id;
	private String name;
	
	Product(String name){
		this.id = counterIds++;
		this.name = name;
		
		System.out.println("\nProduto cadastrado com sucesso!!!");
	}
	
	//Gets
	public int getId(){
		return id;
	}
	public String getName() {
		return name;
	}
	
	//Sets
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + " |Produto: " + this.name;
	}
}

package travelSystem;

import java.util.ArrayList;
import java.util.List;

public class ManageProduct {
	
	List<Product> products;
	
	//Costrutor
	ManageProduct(){
		products = new ArrayList<>();
	}
	
	//Retorna lista de Produtos
	public List<Product> getListProducts() {
		return this.products;
	}
	
	//Cria produto
	public void createProduct(String name) {
		products.add(new Product(name));
	}
	
	//Mostra produtos
	public void showAllProducts() {
		for(Product product : products) {
			System.out.println(product);
		}
	}
	
	//Editar produto
	public void editProduct(int id, String newName) {
		Product product = searchProductById(id);
		if (product != null) {
			product.setName(newName);
		} else {
			System.out.print("Produto não existe");
		}
	}
	
	//Deleta produto
	public void deleteProduct(int id) {
		products.removeIf(product -> product.getId() == id);
	}
	
	//Busca produto por id
	public Product searchProductById(int id) {
		return products.stream()
				.filter(product -> product.getId() == id)
				.findFirst()
				.orElse(null);
	}
	//Busca produto por nome
	public Product searchProductByName(String name) {
		return products.stream()
				.filter(product -> product.getName().equalsIgnoreCase(name))
				.findFirst()
				.orElse(null);
	}
	
}

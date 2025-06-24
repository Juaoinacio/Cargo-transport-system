package travelSystem;

import java.util.ArrayList;
import java.util.List;

public class ManageCustomer {

	private List<Customer> customers;
	
	//Costrutor 
	ManageCustomer(){
		customers = new ArrayList<>();		
	}
	
	// Retorna lista de Clientes
	public List<Customer> getListCustomers() {
		return this.customers;
	}
	
	//Cria um Cliente
	public void createCustomer(String name,int cpf,String city) {
		customers.add(new Customer(name, cpf, city));
	}
	
	//Mostrar clientes
	public void showAllCustomers() {
		for(Customer customer : customers) {
			System.out.println(customer);
		}
	}
	
	//Editar clientes
	public void editCustomer(int id, String newName,int newCpf,String newCity) {
		Customer customer = searchCustomerById(id);
		if (customer != null) {
			customer.setName(newName);
			customer.setCpf(newCpf);
			customer.setCity(newCity);
		} else {
			System.out.print("Cliente não existe");
		}
	}
	
	//Deletar Cliente
	public void deleteCustomer(int id) {
		customers.removeIf(customer -> customer.getId() == id);
	}
	
	//Busca Cliente por id
	public Customer searchCustomerById(int id) {
		return customers.stream()
				.filter(customer -> customer.getId() == id)
				.findFirst()
				.orElse(null);
	}
	
	//Buscar CLiente por Name
	public Customer searchCustomerByName(String name) {
		return customers.stream()
				.filter(customer -> customer.getName().equalsIgnoreCase(name))
				.findFirst()
				.orElse(null);
	}
	
	//Buscar CLiente por CPF
	public Customer searchCustomerByCpf(int cpf) {
		return customers.stream()
				.filter(customer -> customer.getCpf()== cpf)
				.findFirst()
				.orElse(null);
	}
}


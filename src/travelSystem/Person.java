package travelSystem;

public class Person {
	
	ManageCustomer manageCustomer = new ManageCustomer();
	ManageChauffeur manageChauffeur = new ManageChauffeur();
	
	private String name;
	private int cpf;
	private String city;
	
	Person(){};
	
	Person(String name, int cpf, String city){
		
		this.name = name;
		this.cpf = cpf;
		this.city = city;
	}
	
	//Gets
	public String getName() {
		return this.name;
	}
	public int getCpf() {
		return this.cpf;
	}
	public String getCity() {
		return this.city;
	}
	
	//Sets
	public void setName(String name) {
		this.name = name;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	// Customers
	public void createCustomer(String name,int cpf,String city){
		manageCustomer.createCustomer(name, cpf, city);
	}
	public void showAllCustomers() {
		manageCustomer.showAllCustomers();
	}
	public void editCustomer(int id,String name,int cpf,String city) {
		manageCustomer.editCustomer(id,name,cpf,city);
	}
	public void deleteCustomer(int id) {
		manageCustomer.deleteCustomer(id);
	}
	public Customer searchCustomerById(int id) {
		return manageCustomer.searchCustomerById(id);
	}
	public Customer searchCustomerByName(String name) {
		return manageCustomer.searchCustomerByName(name);
	}
	public Customer searchCustomerByCpf(int cpf) {
		return manageCustomer.searchCustomerByCpf(cpf);
	}
	public boolean searchCustumers() {
		return manageCustomer.getListCustomers().isEmpty(); 
	}
	
	
	// Chauffeur
	public void createChauffeur(String city, int cpf, String name, int cnh){
		manageChauffeur.createChauffeur(city, cpf, name, cnh);
	}
	public void showAllChauffeurs() {
		manageChauffeur.showAllChauffeurs();
	}
	public void editChauffeur(int id, String name, int cpf, String city, int cnh) {
		manageCustomer.editCustomer(id,name,cpf,city);
	}
	public void deleteChauffeur(int id) {
		manageCustomer.deleteCustomer(id);
	}
	public Chauffeur searchChauffeurById(int id) {
		return manageChauffeur.searchChauffeurById(id);
	}
	public Chauffeur searchChauffeurByName(String name) {
		return manageChauffeur.searchChauffeurByName(name);
	}
	public Chauffeur searchChauffeurByCpf(int cpf) {
		return manageChauffeur.searchChauffeurByCpf(cpf);
	}
	public boolean searchChauffeur() {
		return manageChauffeur.getListChauffeurs().isEmpty(); 
	}
	
}


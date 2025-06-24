package travelSystem;

public class Customer extends Person{
	private static int counterIds = 1; 
	private int id;
	
	Customer(String city, int cpf, String name){
		
		super(city, cpf, name);
		
		this.id = counterIds;
		counterIds++;
		
		System.out.println("\nCliente Cadastrado com sucesso!!! ");
		
	}
	public int getId() {
		return id;
	}
	public String getCity() {
		return super.getCity();
	}
	public int getCpf() {
		return super.getCpf();
	}
	public String getName() {
		return super.getName();
	}

	@Override
	public String toString() {
	    return "ID: " + id + " | Nome: " + getName() + " | CPF: " + getCpf() + " | Cidade: " + getCity();
	    
	}
	
}

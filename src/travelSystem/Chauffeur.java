package travelSystem;

public class Chauffeur extends Person {
	private static int counterIds = 1; 
	private int id;
	private int cnh;
	private boolean inTravel;
	
	Chauffeur(String city, int cpf, String name, int cnh){
		
		super(city, cpf, name);
		
		this.id = counterIds++;
		this.cnh = cnh;	
		this.inTravel = false;
		
		System.out.println("\nMotorista Cadastrado com sucesso!!!");
	}

	public int getId() {
		return this.id;
	}
	public int getCnh() {
		return this.cnh;
	}
	public int setCnh(int cnh) {
		return this.cnh = cnh;
	}
	public String getCity() {
		return super.getCity();
	}
	public void setCity(String city) {
		super.setCity(city);
	}
	public int getCpf() {
		return super.getCpf();
	}
	public String getName() {
		return super.getName();
	}
	public void setInTravel(boolean inTravel) {
		this.inTravel = inTravel;
	}
	
	@Override
	public String toString() {
	    return "ID: " + id + " | Nome: " + getName() + " | CPF: " + getCpf() +" | CNH: " + cnh +
	    		"| Cidade: " + getCity() + (inTravel ? " | O motorista esta em viagem!" : " | O motorista não esta em viagem!") ;
	}
}

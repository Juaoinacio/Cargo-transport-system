package travelSystem;

import java.util.ArrayList;
import java.util.List;

public class ManageChauffeur{
	
	private List <Chauffeur> chauffeurs;
	
	//Costrutor
	ManageChauffeur(){
		chauffeurs = new ArrayList<>();
	}
	
	// Retorna a lista de Motorista
	public List<Chauffeur> getListChauffeurs() {
		return this.chauffeurs;
	}
	
	// Cria um motorista
	public void createChauffeur(String city, int cpf, String name, int cnh) {
		chauffeurs.add(new Chauffeur(city, cpf, name, cnh));
	}
	
	//Mostra a lista de motorista
	public void showAllChauffeurs() {
		if (chauffeurs.isEmpty()) {
			System.out.println("\n Nem um motorista cadastrado");
		}else {
			for (Chauffeur chauffeur: chauffeurs ) {
				System.out.println(chauffeur);
			}
		}
	}
	
	//Edita um motorista
	public void editChauffeur(int id, String newName,int newCpf,String newCity, int newCnh) {
		Chauffeur chauffeur = searchChauffeurById(id);
		if (chauffeur != null) {
			chauffeur.setName(newName);
			chauffeur.setCpf(newCpf);
			chauffeur.setCity(newCity);
			chauffeur.setCnh(newCnh);
		} else {
			System.out.print("Motorista não existe");
		}
	}
	
	//Deleta um motorista
	public void deleteChauffeur(int id) {
		chauffeurs.removeIf(customer -> customer.getId() == id);
	}
		
	//Busca usuario pelo id
	public Chauffeur searchChauffeurById(int id) {
		return chauffeurs.stream()
				.filter(chauffeur -> chauffeur.getId() == id)
				.findFirst()
				.orElse(null);
	}
	
	//Busca usuario pelo nome
	public Chauffeur searchChauffeurByName(String name) {
		return chauffeurs.stream()
				.filter(chauffeur -> chauffeur.getName().equalsIgnoreCase(name))
				.findFirst()
				.orElse(null);
	}
	
	//Busca usuario pelo CPF
	public Chauffeur searchChauffeurByCpf(int cpf) {
		return chauffeurs.stream()
				.filter(chauffeur -> chauffeur.getCpf() == cpf)
				.findFirst()
				.orElse(null);
	}
}


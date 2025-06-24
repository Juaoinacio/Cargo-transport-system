package travelSystem;

import java.util.ArrayList;
import java.util.List;

public class ManageTravel {

	private List<Travel> travelsInitialized;
	private List<Travel> travelsFinalized;
	
	//Costrutor
	ManageTravel(){
		travelsInitialized = new ArrayList<>();
		travelsFinalized = new ArrayList<>();
	}
	
	//Retorna as lista
	public List<Travel> getListTravelInicialized() {
		return this.travelsInitialized;
	}
	public List<Travel> getListTravelFinalized() {
		return this.travelsFinalized;
	}
	
	//Cria viagem
	public void createTravel(String description, String cityOrigin, String cityDestination, Chauffeur chauffeur,
            List<Customer> customers, List<Product> products) {
		travelsInitialized.add(new Travel(description, cityOrigin, cityDestination, chauffeur, customers, products));
	}
	
	//Mostra viagem
	public void showAllTravels() {
		for (Travel travel: travelsInitialized) {
			if (travel != null) {
				System.out.println(travel);
			}else {
				System.out.println("Não a viagens cadastradas");
			}
			
		}
	}
	
	//Edita viagem
	public void editTravel(int id,String description, String cityOrigin, String cityDestination, Chauffeur chauffeur,
            List<Customer> customers, List<Product> products){
		Travel travel = searchTravelById(id);
		if (travel != null) {
			travel.setDescription(description);
			travel.setCityOrigin(cityOrigin);
			travel.setCityDestination(cityDestination);
			travel.setChauffeur(chauffeur);
			travel.setCustomers(customers);
		} else {
			System.out.print("Produto não existe");
		}
	}
	
	//Deleta viagem
	public void deleteTravel(int id) {
		travelsInitialized.removeIf(travel -> travel.getId() == id);
	}
	
	//Busca viagem pelo id
	public Travel searchTravelById(int id) {
		return travelsInitialized.stream()
				.filter(travel -> travel.getId() == id)
				.findFirst()
				.orElse(null);
	}
	//Finaliza viagem
	public void travelCompleted(int id) {
		Travel travel = searchTravelById(id);
		travel.setStatus(StatusTravel.FINALIZED);
		travelsFinalized.add(travel);
	}
}

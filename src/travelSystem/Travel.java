package travelSystem;

import java.util.List;

public class Travel {
    private int id;
    private static int counterIds = 1;
    private String description;
    private String cityOrigin;
    private String cityDestination;
    private Chauffeur chauffeur;
    private StatusTravel status;
    private List<Customer> customers;
    private List<Product> products;

    public Travel(String description, String cityOrigin, String cityDestination, Chauffeur chauffeur,
                  List<Customer> customers, List<Product> products) {
        this.description = description;
        this.cityOrigin = cityOrigin;
        this.cityDestination = cityDestination;
        this.chauffeur = chauffeur;
        this.chauffeur.setInTravel(true); 
        this.status = StatusTravel.INITIALIZED;
        this.customers = customers;
        this.products = products;
        this.id = counterIds++;
        
        System.out.println("\nViagem cadastrada com sucesso!!!");
    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCityOrigin() {
        return this.cityOrigin;
    }

    public void setCityOrigin(String cityOrigin) {
        this.cityOrigin = cityOrigin;
    }

    public String getCityDestination() {
        return this.cityDestination;
    }

    public void setCityDestination(String cityDestination) {
        this.cityDestination = cityDestination;
    }

    public Chauffeur getChauffeur() {
        return this.chauffeur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    public StatusTravel getStatus() {
        return this.status;
    }

    public void setStatus(StatusTravel status) {
        this.status = status;
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    @Override
    public String toString() {
    	String istatus; 
    	if(status == StatusTravel.INITIALIZED) {
    		istatus = "Viagem iniciada";
    	} else {
    		istatus = "Viagem finalizada";
    	}
        String info = "\n Informações da Viagem \n" +
                      "ID: " + id + "\n" +
                      "Descrição: " + description + "\n" +
                      "Origem: " + cityOrigin + "\n" +
                      "Destino: " + cityDestination + "\n" +
                      "Status: " + istatus + "\n";

        info += "\n--- Motorista ---\n";
         	info += chauffeur.toString();

        info += "\n\n--- Clientes ---\n";
        
            for (Customer customer : customers) {
                info += customer.toString() + "\n";
            }
            
        info += "\n--- Produtos ---\n";
            for (Product product : products) {
                info += product.toString() + "\n";
            }
        return info;
    }

}
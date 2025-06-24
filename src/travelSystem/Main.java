package travelSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Person person = new Person();
	private static Scanner scanner = new Scanner(System.in);
	private static ManageProduct product = new ManageProduct();
	private static ManageTravel travel = new ManageTravel();

	public static void main(String[] args) {
		int option;
		
		do {
			System.out.println("\n              Menu Sistema de Viagem     ");
			System.out.println("1 - Cadastrar / Exibir / Editar / Deletar uma Pessoa");
			System.out.println("2 - Cadastrar / Exibir / Editar / Deletar uma Viagem");
			System.out.println("3 - Cadastrar / Exibir / Editar / Deletar Produto");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");
			option = scanner.nextInt();
			scanner.nextLine();
			
			switch (option) {
				case 1:
					crudPerson();
					break;
				case 2:
					if (person.searchCustumers()) {
						System.out.println("Precisa haver um motorista cadastrado");
					}else if(person.searchChauffeur()){
						System.out.println("Precisa haver um clientes cadastrados");
					}else if(product.getListProducts().isEmpty()){
						System.out.println("Precisa haver um produtos cadastrados");
					} else {
						crudTravel();
					}
					break;
				case 3:
					crudProduct();
					break;
				case 0:
					System.out.println("\nSaindo do sistema...");
					break;
				default:
					System.out.println("\nOpção inválida!");
			}
		} while (option != 0);

	}
	
	public static void crudPerson() {
		int numberPerson;
		
		do {
			System.out.println("\n       Menu Sistema de Viagem     ");
			System.out.println("1 - Cadastrar uma Cliente");
			System.out.println("2 - Cadastrar uma Motorista");
			System.out.println("3 - Exibir os Clientes");
			System.out.println("4 - Exibir os Motoristas");
			System.out.println("5 - Editar um Cliente");
			System.out.println("6 - Editar um Motorista");
			System.out.println("7 - Deletar um Cliente");
			System.out.println("8 - Deletar um Motorista");
			System.out.println("0 - Voltar ");
			System.out.print("Escolha uma opção: ");
			numberPerson = scanner.nextInt();
			scanner.nextLine();
				
			switch (numberPerson) {
				case 1:{
					
					System.out.print("\nNome do cliente: ");
					String name = scanner.nextLine();
					
					Customer customer = person.searchCustomerByName(name);
					if (customer != null){
						System.out.print("O nome não pode ser igual ja cadastrado, adicione um sobrenome.\n");
						System.out.print("\nCliente cadastrados: ");
						person.showAllCustomers();
						break;
					}
					
					System.out.print("Seu cpf: ");
					int cpf = scanner.nextInt();
					Customer customerCpf = person.searchCustomerByCpf(cpf);
					
					if (customerCpf != null){
						System.out.print("O nome não pode ser igual ja cadastrado, adicione um sobrenome.\n");
						System.out.print("\nCliente cadastrados: ");
						person.showAllCustomers();
						break;
					}

					scanner.nextLine();
					
					System.out.print("Cidade onde mora: ");
					String city = scanner.nextLine();
					
					person.createCustomer(name, cpf, city);
					break;
				}
				case 2: {
					System.out.print("\nNome do Motorista: ");
					String name = scanner.nextLine();
					
					Chauffeur verifyNameChauffeur = person.searchChauffeurByName(name);
					if (verifyNameChauffeur != null){
						System.out.print("O nome não pode ser igual ja cadastrado, adicione um sobrenome.\n");
						System.out.print("\nMotorista cadastrados: ");
						person.showAllChauffeurs();
						break;
					}
					
					System.out.print("Novo cpf: ");
					int cpf = scanner.nextInt();
					
					Chauffeur verifyCpfChauffeur = person.searchChauffeurByCpf(cpf);
					if (verifyCpfChauffeur != null){
						System.out.print("O nome não pode ser igual ja cadastrado, adicione um sobrenome.\n");
						System.out.print("\nMotorista cadastrados: ");
						person.showAllChauffeurs();
						break;
					}
					
					System.out.print("Sua cnh: ");
					int cnh = scanner.nextInt();

					scanner.nextLine();
					
					System.out.print("Cidade onde mora: ");
					String city = scanner.nextLine();
					
					person.createChauffeur(name, cpf, city, cnh);
					break;
				}
				case 3:{
					if (person.searchCustumers()){
						System.out.println("Voce precisa ter Clientes cadastrados");
					} else {
						person.showAllCustomers();
					}
					break;
				}
				case 4:{
					if (person.searchChauffeur()){
						System.out.println("Voce precisa ter Clientes cadastrados");
					} else {
						person.showAllChauffeurs();
					}
					break;
				}
				case 5:{
					System.out.println("\n          Clientes:    ");
					person.showAllCustomers(); 
					
					System.out.print("\nDigite o id do cliente: ");
					int searchId = scanner.nextInt();
					scanner.nextLine();
					
					Customer findCustomer = person.searchCustomerById(searchId);
					if (findCustomer != null) {
						System.out.print("\nNovo nome: ");
						String name = scanner.nextLine();
						
						Customer verifyNameCustomer = person.searchCustomerByName(name);
						if (verifyNameCustomer != null){
							System.out.print("O nome não pode ser igual ja cadastrado, adicione um sobrenome.\n");
							System.out.print("\nCliete cadastrados: ");
							person.showAllCustomers();
							break;
						}
						
						System.out.print("Novo cpf:: ");
						int cpf = scanner.nextInt();

						Customer verifyCpfCustomer = person.searchCustomerByCpf(cpf);
						if (verifyCpfCustomer != null){
							System.out.print("O nome não pode ser igual ja cadastrado, adicione um sobrenome.\n");
							System.out.print("\nCliente cadastrados: ");
							person.showAllCustomers();
							break;
						}
						
						scanner.nextLine();
						
						System.out.print("Nova cidade: ");
						String city = scanner.nextLine();
						
						person.editCustomer(findCustomer.getId() ,name, cpf, city);
						break;
					} else {
						System.out.println("\nCliente não existe, informe outro ID");
						break;
					}
				}
				case 6:{
					System.out.println("\n          Motoristas:    ");
					person.showAllChauffeurs(); 
					
					System.out.println("\nDigite o id do motorista");
					int searchId = scanner.nextInt();
					scanner.nextLine();	
					
					Chauffeur findChauffeur = person.searchChauffeurById(searchId);
					
					System.out.print("\nNovo nome: ");
					String name = scanner.nextLine();
					
					Chauffeur verifyNameChauffeur = person.searchChauffeurByName(name);
					if (verifyNameChauffeur != null){
						System.out.print("O nome não pode ser igual ja cadastrado, adicione um sobrenome.\n");
						System.out.println("\nMotoristas cadastrados: ");
						person.showAllChauffeurs();
						break;
					}
					
					System.out.print("Novo cpf:: ");
					int cpf = scanner.nextInt();
					
					Chauffeur verifyCpfChauffeur = person.searchChauffeurByCpf(cpf);
					if (verifyCpfChauffeur != null){
						System.out.print("O nome não pode ser igual ja cadastrado, adicione um sobrenome.\n");
						System.out.print("\nMotorista cadastrados: ");
						person.showAllChauffeurs();
						break;
					}
					
					System.out.print("Novo cnh: ");
					int cnh = scanner.nextInt();

					scanner.nextLine();
					
					System.out.print("Nova cidade: ");
					String city = scanner.nextLine();
					
					person.editChauffeur(findChauffeur.getId() ,name, cpf, city, cnh);
					break;
				}
				case 7:{
					System.out.println("\n          Clientes:    ");
					person.showAllCustomers(); 
					
					System.out.print("\nDigite o id do cliente: ");
					int searchId = scanner.nextInt();
					scanner.nextLine();	
					
					person.deleteCustomer(searchId);
					break;
				}
				case 8:{
					System.out.println("\n          Motorista:    ");
					person.showAllChauffeurs(); 
					
					System.out.print("\nDigite o id do motorista: ");
					int searchId = scanner.nextInt();
					scanner.nextLine();	
					
					person.deleteChauffeur(searchId);
					break;
				}
				
				case 0:{
					System.out.println("\nVoltando para o menu inicial");
					break;
				}
				
				default:{
					System.out.println("Opção inválida!");
				}
			}
		} while(numberPerson != 0);
	}

	public static void crudTravel() {
		int numberTravel;
		
		do {
			System.out.println("\n      Menu Sistema de Viagem     ");
			System.out.println("1 - Iniciar uma viagem");
			System.out.println("2 - Exibir Viagens inicia");
			System.out.println("3 - Editar uma Viagem");
			System.out.println("4 - Finalizar uma Viagens");
			System.out.println("5 - Deletar uma Viagem");
			System.out.println("0 - Voltar");
			System.out.print("Escolha uma opção: ");
			numberTravel = scanner.nextInt();
			scanner.nextLine();
			
			switch (numberTravel) {
				case 1:{
					System.out.print("\nDescrição da viagem: ");
					String description = scanner.nextLine();
					
					System.out.print("Cidade de origem: ");
					String cityOrigin = scanner.nextLine();
					
					System.out.print("Cidade de destino: ");
					String cityDestination = scanner.nextLine();
					
					System.out.println("\n          Motrorista:   ");
					person.showAllChauffeurs();
					System.out.print("Selecione um motorista pelo id: ");
					int idChauffeur = scanner.nextInt();
					Chauffeur chauffeur = person.searchChauffeurById(idChauffeur);
					
					List<Customer> customersList = new ArrayList<>();
					int numberCustomer;
					do {
						System.out.println("\n          Clientes:   ");
						person.showAllCustomers();
						System.out.print("Selecione o cliente pelo id: ");
						int idCustomers = scanner.nextInt();
						Customer customer = person.searchCustomerById(idCustomers);
						
						if (customersList.contains(customer)){
							System.out.println("\nCliente ja cadastrado");
							System.out.print("Deseja adicionar mais um cliente? (1 - Sim | 0 - Não): ");
							numberCustomer = scanner.nextInt();
						    scanner.nextLine();
						} else {
							customersList.add(customer);
							System.out.print("Deseja adicionar mais um cliente? (1 - Sim | 0 - Não): ");
							numberCustomer = scanner.nextInt();
						    scanner.nextLine();
						}
						
					}while(numberCustomer == 1);
					
					List<Product> productsList = new ArrayList<>();
					int numberProduct;
					do {
						System.out.println("\n          Produtos:   ");
						product.showAllProducts();
						System.out.print("Selecione o produto pelo id: ");
						int idProduct = scanner.nextInt();
						Product pruduct  = product.searchProductById(idProduct);
						
						if (productsList.contains(pruduct)){
							System.out.println("\nProduto ja cadastrado");
							System.out.print("Deseja adicionar mais um produto? (1 - Sim | 0 - Não): ");
							numberProduct = scanner.nextInt();
						    scanner.nextLine();
						}else {
							productsList.add(pruduct);
							System.out.print("Deseja adicionar mais um produto? (1 - Sim | 0 - Não): ");
							numberProduct = scanner.nextInt();
						    scanner.nextLine();
						}
						
					}while(numberProduct == 1);
					travel.createTravel(description, cityOrigin, cityDestination, chauffeur, customersList, productsList);
					break;
				}
				case 2:{
					if (travel.getListTravelInicialized().isEmpty()){
						System.out.println("Voce precisa ter viagem cadastrados");
					} else {
						travel.showAllTravels();
					}
					break;
				}
				case 3:{
					System.out.println("\n          Viagens:");
					travel.showAllTravels();
					int searchId = scanner.nextInt();
					scanner.nextLine();	
					
					Travel findTravel = travel.searchTravelById(searchId);
					
					System.out.print("Descrição da viagem: ");
					String description = scanner.nextLine();
					
					System.out.print("Cidade de origem: ");
					String cityOrigin = scanner.nextLine();
					
					System.out.print("Cidade de destino: ");
					String cityDestination = scanner.nextLine();
					System.out.println("\n         Motoristas:");
					person.showAllChauffeurs();
					System.out.print("Selecione o id do novo motorista: ");
					int idChauffeur = scanner.nextInt();
					Chauffeur chauffeur = person.searchChauffeurById(idChauffeur);
				
					List<Customer> customersList = new ArrayList<>();
					int numberCustomer;
					
					do {
						System.out.println("\n          Clientes:   ");
						person.showAllCustomers();
						System.out.print("Selecione o id do novo cliente: ");
						int idCustomers = scanner.nextInt();
						Customer customer = person.searchCustomerById(idCustomers);
						
						if (customersList.contains(customer)){
							System.out.println("\nCliente ja cadastrado");
							System.out.print("Deseja adicionar mais um cliente? (1 - Sim | 0 - Não): ");
							numberCustomer = scanner.nextInt();
						    scanner.nextLine();
						} else {
							customersList.add(customer);
							System.out.print("Deseja adicionar mais um cliente? (1 - Sim | 0 - Não): ");
							numberCustomer = scanner.nextInt();
						    scanner.nextLine();
						}
						
					}while(numberCustomer == 1);
					    
					List<Product> productsList = new ArrayList<>();
					int numberProduct;
					
					do {
						System.out.println("\n          Produtos:   ");
						product.showAllProducts();
						System.out.print("Selecione o id do novo produto: ");
						int idProduct = scanner.nextInt();
						Product pruduct  = product.searchProductById(idProduct);
						
						if (productsList.contains(pruduct)){
							System.out.println("\nProduto ja cadastrado");
							System.out.print("Deseja adicionar mais um produto? (1 - Sim | 0 - Não): ");
							numberProduct = scanner.nextInt();
						    scanner.nextLine();
						}else {
							productsList.add(pruduct);
							System.out.print("Deseja adicionar mais um produto? (1 - Sim | 0 - Não): ");
							numberProduct = scanner.nextInt();
						    scanner.nextLine();
						}
						
					}while(numberProduct == 1);
				
					travel.editTravel(findTravel.getId(), description,  cityOrigin, cityDestination, chauffeur,
							customersList, productsList);
				}
					break;
				case 4:{
					System.out.println("\n          Viagens:");
					travel.showAllTravels();
					int searchId = scanner.nextInt();
					scanner.nextLine();	
					
					Travel findTravel = travel.searchTravelById(searchId);
					
					if (findTravel != null) {
						travel.travelCompleted(searchId);
					} else {
						System.out.println("ID não encontrado");
					}
					break;
				}
					
				case 0:
					System.out.println("Voltando para o menu inicial");
					break;
				default:
					System.out.println("Opção inválida!");
			}
		} while(numberTravel != 0);
	}
	public static void crudProduct() {
		int option;
		
		do {
			System.out.println("\n      Menu do produto   ");
			System.out.println("1 - Criar um produto");
			System.out.println("2 - Exibir um produto");
			System.out.println("3 - Editar um produto");
			System.out.println("4 - Deletar um produto");
			System.out.println("0 - Voltar");
			System.out.print("Escolha uma opção: ");
			option = scanner.nextInt();
			scanner.nextLine();
			
			switch (option) {
				case 1:{
					System.out.print("\nNome do produto: ");
					String name = scanner.nextLine();
					Product prd = product.searchProductByName(name);
					if (prd != null){
						System.out.print("Produto ja cadastrado\n");
						System.out.print("\nProdutos: ");
						product.showAllProducts();
					}else{
						product.createProduct(name);
					}	
					break;
				}
				case 2:{
					if (product.getListProducts().isEmpty()) {
						System.out.print("Voce precisa cadastrar um produto");
					}else {
						product.showAllProducts();
					}
					break;
				}
				case 3:{
					System.out.println("\n          Produtos:      ");
					product.showAllProducts(); 
					
					System.out.println("\nDigite o id do produto");
					int searchId = scanner.nextInt();
					scanner.nextLine();	
					
					Product findProduct = product.searchProductById(searchId);
					
					System.out.println("Novo nome do produto: ");
					String name = scanner.nextLine();
					
					Product prd = product.searchProductByName(name);
					if (prd != null){
						System.out.print("Produto ja cadastrado\n");
						System.out.print("\nProdutos: ");
						product.showAllProducts();
					}else{
						product.editProduct(findProduct.getId() ,name);
					}	
					break;
				}
				case 4:{
					System.out.println("\n          Produtos:    ");
					product.showAllProducts(); 
					
					System.out.print("\nDigite o id do produto: ");
					int searchId = scanner.nextInt();
					scanner.nextLine();	
					
					product.deleteProduct(searchId);
					break;
				}
				case 0:{
					System.out.println("\nVoltando para o menu inicial");
					break;
				}
				default:{
					System.out.println("Opção inválida!");
				}
			}
		}while(option != 0);
	}
}
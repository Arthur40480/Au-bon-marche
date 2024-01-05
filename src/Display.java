import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Display {
	
	// Méthode affichant le menu principale et retourne la saisie de l'utilisateur :
	public static void mainMenu(Scanner scanner, ArrayList<HashMap<String, Object>> merchandiseList, ArrayList<HashMap<String, Object>> customerList) {
		// On déclare un tableau de String qui contiendra chaque option :
		String[] mainMenu = {
				"1 - Traiter l'arrivée d'un nouveau client",
				"2 - Editer le bilan de la journée",
				"3 - Quitter l'application"
		};
		System.out.println("************ Menu Principale ************");
		System.out.println();
		for(int i = 0; i < mainMenu.length; i++) {
			System.out.println(mainMenu[i]);
		}
		System.out.println();
		System.out.println("*****************************************");
		System.out.print("Veuillez saisir votre choix (1 - " + mainMenu.length + ") : ");
		// On apelle la méthode checkMenu pour vérifier la saisie utilisateur :
		int userChoice = Check.checkMenu(scanner, mainMenu);  
		// Suivant le choix utilisateur, on éxecute :
		switch(userChoice) {
			case 1:
				Customer.newCustomer(scanner, merchandiseList, customerList);
				break;
			case 2:
				displayReviewOfTheDay(scanner, customerList, merchandiseList);
				break;
			case 3:
				System.out.println();
				System.out.println("*************** A bientôt ***************");
				System.exit(0);
		}
	}
	// Méthode affichant la liste de produit restant :
	public static void displayMerchandiseList(ArrayList<HashMap<String, Object>> merchandiseList) {
		System.out.println();
		System.out.println("********************** PRODUIT **********************");
		System.out.println();
		for(HashMap<String, Object> merchandise : merchandiseList) {
			System.out.print("ID: " + merchandise.get("Id") + " - PRODUIT: " + merchandise.get("Nom"));
			
			// Casting explicites -> pour convertir les objets de ma HashMap en type spécifique lors de l'estraction de données de la HashMap :
			// Normalement besoin d'une verification pour éviter des erreurs :
			// Mais je le fait pas car je suis certains du type de données que je stock (Localement) :
			Object stockObject = merchandise.get("Stock");
			// (Number) -> opération de casting explicite, nécessaire car stockObject est déclaré comme "Object" alors qu'il contient un nombre :
			// .doubleValue() -> Méthode définie par la classe "Number", utilisée pour convertir la valeur numérique encapsulée dans l'objet
			// Number en un type "Double" :
			double stockDouble = ((Number) stockObject).doubleValue();
			Object kgPriceObject = merchandise.get("PrixAuKg");
			boolean kgPriceBool = (Boolean) kgPriceObject;
			
			System.out.print(" - STOCK: ");
			// Opération ternaire, si return true -> première option, sinon deuxième :
			System.out.print(stockDouble == 0 ? "Indisponible" : merchandise.get("Stock"));
			if(stockDouble != 0) {
				System.out.print(kgPriceBool ? "Kg" : "Pièces");
			}
			System.out.print(" - PRIX: " + merchandise.get("Prix"));
			System.out.println(kgPriceBool ? "€/Kg" : "€/U");
		}
		System.out.println();
	}
	// Méthode qui permet d'afficher le ticket de caisse du client :
	public static void displayReceipt(Scanner scanner, HashMap<String, Object> customerInfos, ArrayList<HashMap<String, Object>> merchandiseList, ArrayList<HashMap<String, Object>> customerList) {	
		// On viens récupérer la liste qui fait office de panier :
		Object cartObject = customerInfos.get("Cart");
		@SuppressWarnings("unchecked")
		ArrayList<HashMap<String, Object>> cart = (ArrayList<HashMap<String, Object>>) cartObject;
		
		System.out.println();
		System.out.println("****************** TICKET DE CAISSE ******************");
		System.out.println();
		System.out.println("Client : " + customerInfos.get("LastName") + " " + customerInfos.get("Name"));
		System.out.println();
		for(HashMap<String, Object> item : cart) {
			System.out.print("- " + item.get("NameItem") + "  - " + item.get("QuantityItem"));
			Object pricePerKgObject = item.get("PricePerKg");
			boolean pricePerKgBool = (boolean) pricePerKgObject;
			System.out.println( pricePerKgBool ? " Kg" + "  - " + item.get("QuantityPrice") + "€" : " unité(s)" + "  - " + item.get("QuantityPrice") + "€" );
		}
		System.out.println();
		System.out.println("Prix total : " + customerInfos.get("TotalPrice") + "€");
		System.out.println();
		Display.mainMenu(scanner, merchandiseList, customerList);
	}
	// Méthode permettant d'afficher le bilan de la journée, ainsi que le stock actuel :
	public static void displayReviewOfTheDay(Scanner scanner, ArrayList<HashMap<String, Object>> customerList, ArrayList<HashMap<String, Object>> merchandiseList) {
		int customerNumber = 1;
		double total = 0;
		System.out.println();
		System.out.println("***************** BILAN DE LA JOURNEE *****************");
		System.out.println();
		System.out.println("Nombre de client : " + customerList.size() );
		System.out.println();
		for(HashMap<String, Object> customer : customerList) {
			Object totalPricePerCustomerObject = customer.get("TotalPrice");
			double totalPricePerCustomerDouble = ((Number) totalPricePerCustomerObject).doubleValue();
			System.out.println("Client numéro " + customerNumber +": " + customer.get("LastName") + " " + customer.get("Name") + " - Total : " + customer.get("TotalPrice") + "€");
			customerNumber++;
			total = total + totalPricePerCustomerDouble;
		}
		System.out.println();
		System.out.println("Total : " + total + "€");
		displayMerchandiseList(merchandiseList);
		mainMenu(scanner, merchandiseList, customerList);
	}
}

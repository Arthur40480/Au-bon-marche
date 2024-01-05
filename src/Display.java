import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Display {
	
	// Méthode affichant le menu principale et retourne la saisie de l'utilisateur :
	public static int mainMenu(Scanner scanner) {
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
		int userChoice = Check.checkMenu(scanner, mainMenu); // On apelle la méthode checkMenu pour vérifier la saisie utilisateur 
		return userChoice;
	}
	
	// Méthode affichant le menu client et retourne la saisie de l'utilisateur :
	public static int customerMenu(Scanner scanner) {
		// On déclare un tableau de String qui contiendra chaque option :
		String[] customerMenu = {
				"1 - Remplir votre panier",
				"2 - Voir votre Panier",
				"3 - Finaliser vos achats"
		};
		System.out.println("************ Menu Client ************");
		System.out.println();
		for(int i = 0; i < customerMenu.length; i++) {
			System.out.println(customerMenu[i]);
		}
		System.out.println();
		System.out.println("*****************************************");
		System.out.print("Veuillez saisir votre choix (1 - " + customerMenu.length + ") : ");
		int userChoice = Check.checkMenu(scanner, customerMenu); // On apelle la méthode checkMenu pour vérifier la saisie utilisateur 
		return userChoice;
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
			System.out.print(kgPriceBool ? "Kg" : "Pièces");
			System.out.print(" - PRIX: " + merchandise.get("Prix"));
			System.out.println(kgPriceBool ? "€/Kg" : "€/U");
		}
	}
}

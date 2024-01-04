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
}

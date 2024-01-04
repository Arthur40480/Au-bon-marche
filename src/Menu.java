import java.util.Scanner;

public class Menu {
	// Méthode affichant le menu principale et retourne la saisie de l'utilisateur :
	public static int mainMenu(Scanner scanner) {
		System.out.println("************ Menu Principale ************");
		System.out.println();
		System.out.println("1 - Traiter l'arrivée d'un nouveau client");
		System.out.println("2 - Editer le bilan de la journée");
		System.out.println();
		System.out.println("*****************************************");
		System.out.print("Veuillez saisir votre choix (1 - 2) : ");
		int userChoice = scanner.nextInt();
		return userChoice;
	}
}

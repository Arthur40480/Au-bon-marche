import java.util.Scanner;

public class Menu {
	// Méthode affichant le menu principale et retourne la saisie de l'utilisateur :
	public static int mainMenu(Scanner scanner) {
		String[] mainMenu = {
				"1 - Traiter l'arrivée d'un nouveau client",
				"2 - Editer le bilan de la journée"
		};
		System.out.println("************ Menu Principale ************");
		System.out.println();
		for(int i = 0; i < mainMenu.length; i++) {
			System.out.println(mainMenu[i]);
		}
		System.out.println();
		System.out.println("*****************************************");
		System.out.print("Veuillez saisir votre choix (1 - 2) : ");
		int userChoice = Check.checkMenu(scanner, mainMenu);
		return userChoice;
	}
}

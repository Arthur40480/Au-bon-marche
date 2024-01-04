import java.util.Scanner;

public class Check {
	// Méthode qui viens vérifier la saisie utilisateur suivant le nombre d'option dans le menu passer :
	public static int checkMenu(Scanner scanner, String[] optionMenu) {
		int userChoice;
		
		while(true) {
			// Si c'est un nombre entier alors :
			if(scanner.hasNextInt()) {
				userChoice = scanner.nextInt();
				// Si la saisie de l'utilisateur est supérieur à 1 et inférieur à la longueur du menu :
				if(userChoice < 1 || userChoice > optionMenu.length) {
					System.out.print("Veuillez saisir un choix correct (1 - " + optionMenu.length + ") : ");
				// Sinon :
				} else {
					break; // On sort de la boucle
				}
			// Sinon :
			} else {
				System.out.print("Veuillez saisir un choix correct (1 - " + optionMenu.length + ") : ");
				scanner.next();
			}
		}
		return userChoice;
	}
}

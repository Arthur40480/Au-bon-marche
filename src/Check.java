import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Check {
	// Méthode qui viens vérifier la saisie utilisateur suivant le nombre d'option dans le menu passer :
	public static int checkMenu(Scanner scanner, String[] optionMenu) {
		int userChoice;
		
		while(true) {
			// Si c'est un nombre entier alors :
			if(scanner.hasNextInt()) {
				userChoice = scanner.nextInt();
				// Si la saisie de l'utilisateur est inferieur à 1 et superieur à la longueur du menu :
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
	// Méthode qui viens vérifier la saisie utilisateur suivant l'id du produit sélectionner :
	public static int checkMerchandiseId(Scanner scanner, ArrayList<HashMap<String, Object>> merchandiseList) {
		int userChoice;
		
		while(true) {
			// Si c'est un nombre entier alors :
			if(scanner.hasNextInt()) {
				userChoice = scanner.nextInt();
				// Si la saisie de l'utilisateur est inferieur à 1 et superieur à la longueur de la liste :
				if(userChoice < 1 || userChoice > merchandiseList.size()) {
					System.out.print("Veuillez saisir un choix correct (1 - " + merchandiseList.size() + ") : ");
				// Sinon :
				} else {
					// On viens récupérer la HashMap de la marchandise sélectionner :
					HashMap<String, Object> merchandiseToCheck = merchandiseList.get(userChoice - 1);
					// Opération de casting explicite pour convertir notre valeur numérique encapsuler dans l'objet :
					Object stockToCheckObject = merchandiseToCheck.get("Stock");
					double stockToCheckDouble = ((Number) stockToCheckObject).doubleValue();
					// Si le stock égale à 0 alors :
					if( stockToCheckDouble == 0) {
						System.out.println("Ce produit est momentanément indisponible, veuillez nous excuser.");
						System.out.println("Veuillez saisir un autre choix (1 - " + merchandiseList.size() + ") : ");
					// Sinon :
					} else {
						break; // On sort de la boucle
					}
				}
			// Sinon :
			} else {
				System.out.print("Veuillez saisir un choix correct (1 - " + merchandiseList.size() + ") : ");
				scanner.next();
			}
		}
		return userChoice;
	}
	// Méthode qui permet de vérifier la saisie utilisateur concernant la quantité voulue, par rapport au stock restant :
	public static double checkMerchandiseQuantity(Scanner scanner, ArrayList<HashMap<String, Object>> merchandiseList, int merchandiseId) {
		double userChoiceQuantity;
		
		// On viens récupérer la HashMap de la marchandise sélectionner :
		HashMap<String, Object> merchandiseToCheck = merchandiseList.get(merchandiseId - 1);
		
		// Opération de casting explicite pour convertir notre valeur numérique encapsuler dans l'objet :
		Object stockToCheckObject = merchandiseToCheck.get("Stock");
		double stockToCheckDouble = ((Number) stockToCheckObject).doubleValue();
		
		// Opération de casting explicite pour convertir notre valeur boolean encapsuler dans l'objet :
		Object pricePerKgObject = merchandiseToCheck.get("PrixAuKg");
		boolean pricePerKgBool = (boolean) pricePerKgObject;
		
		while(true) {
			// Si le produit se vend à l'unité, alors :
			if(pricePerKgBool == false) {
				if(scanner.hasNextInt()) {
					userChoiceQuantity = scanner.nextInt();
					// Si la quantité choisie est égale à 0 ou supérieur au stock du produit sélectionner :
					if(userChoiceQuantity <= 0 || userChoiceQuantity > stockToCheckDouble) {
						System.out.println("Nous n'avons pas cette quantité en stock pour ce produit !"); 
						System.out.print("Veuillez choisir une quantité correcte (Stock restant :" + stockToCheckDouble + " pièce(s)" + ") :");
					// Sinon :
					} else {
						break;
					}
				// Sinon :
				} else {
					System.out.print("Ce produit se vend à l'unité, veuillez choisir une quantité correcte :");
					scanner.next();
				}
			// Sinon, si c'est un produit qui se vend au kg, alors :
			} else {
				if(scanner.hasNextDouble()) {
					userChoiceQuantity = scanner.nextDouble();
					// Si la quantité choisie est égale à 0 ou supérieur au stock du produit sélectionner :
					if(userChoiceQuantity <= 0 || userChoiceQuantity > stockToCheckDouble) {
						System.out.println("Nous n'avons pas cette quantité en stock pour ce produit !"); 
						System.out.print("Veuillez choisir une quantité correcte (Stock restant :" + stockToCheckDouble + " Kg" + ") :");
					// Sinon :
					} else {
						break;
					}
				// Sinon :
				} else {
					System.out.print("Ce produit se vend au kg, veuillez choisir une quantité correcte :");
					scanner.next();
				}
			}
			
		}
		return userChoiceQuantity;
	}	
	
}


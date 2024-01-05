import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Purchase {
	// Méthode qui permet au client d'ajouter une quantité de produit à sont panier :
	// Elle met à jour la liste des produits et du panier :
	// Et boucle si jamais le client n'à pas finis ces achats :
	public static void purchaseMerchandise(Scanner scanner, ArrayList<HashMap<String, Object>> merchandiseList, HashMap<String, Object> customerInfos) {
		while(true) {
			// On affiche la liste des produits au client :
			Display.displayMerchandiseList(merchandiseList);
			
			// On récupère l'id du produit ainsi que sa quantité :
			System.out.println();
			System.out.print("Veuillez saisir l'ID du produit que vous souhaitez ajouter au panier : ");
			
			// On apelle la méthode checkMerchandiseId pour tester la saisie utilisateur :
			int userChoiceId = Check.checkMerchandiseId(scanner, merchandiseList);
			System.out.print("Veuillez saisir la quantité du produit que vous souhaitez ajouter au panier : ");
			
			// On apelle la méthode checkMerchandiseQuantity pour tester la saisie utilisateur :
			double userChoiceQuantity = Check.checkMerchandiseQuantity(scanner, merchandiseList, userChoiceId);
			
			// On assigne à merchadiseList la liste mise à jour retourner par notre méthode updateMerchandiseList :
			merchandiseList = Update.updateMerchandiseList(merchandiseList, userChoiceId, userChoiceQuantity);
			
			// On met à jour le panier du client :
			customerInfos = Update.updateCart(merchandiseList, customerInfos, userChoiceId, userChoiceQuantity);
			
			System.out.print("Avez-vous terminé vos achats ? (Oui/Non) : ");
			String userChoice = scanner.next();
			if(userChoice.toLowerCase().equals("oui")) {
				Display.displayReceipt(scanner, customerInfos, merchandiseList);
				break;
			}
		}
	}
}

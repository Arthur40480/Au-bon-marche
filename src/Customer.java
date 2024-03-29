import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Customer {
	// Méthode permettant de créer de nouveau client en enregistrant leurs informations :
	public static void newCustomer(Scanner scanner, ArrayList<HashMap<String, Object>> merchandiseList, ArrayList<HashMap<String, Object>> customerList) {
		// Déclaration d'une HashMap qui contiendras les informations du client, ainsi que sont panier :
		HashMap<String, Object> customerInfos = new HashMap<>();
		// Déclaration d'une HashMap qui sera le panier du client :
		ArrayList<HashMap<String, Object>> cart = new ArrayList<>();
		
		System.out.println();
		System.out.println("*************** Bienvenue ***************");
		System.out.println();
		System.out.print("Veuillez remplir votre nom : ");
		String lastName = scanner.next();
		System.out.print("Veuillez remplir votre prénom : ");
		String name = scanner.next();
		
		// On assigne les informations du client à notre HashMap :
		customerInfos.put("LastName", lastName);
		customerInfos.put("Name", name);
		customerInfos.put("TotalPrice", 0);
		customerInfos.put("Cart", cart);
		
		Purchase.purchaseMerchandise(scanner, merchandiseList, customerInfos, customerList);
	}
}

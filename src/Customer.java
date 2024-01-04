import java.util.HashMap;
import java.util.Scanner;

public class Customer {
	// Méthode permettant de créer de nouveau client en enregistrant leurs informations :
	public static void newCustomer(Scanner scanner) {
		// Déclaration d'une HashMap qui contiendras les informations du client, ainsi que sont panier :
		HashMap<String, Object> customerInfos = new HashMap<>();
		
		System.out.println();
		System.out.println("*************** Bienvenue ***************");
		System.out.print("Veuillez remplir votre nom : ");
		String lastName = scanner.next();
		System.out.print("Veuillez remplir votre prénom : ");
		String name = scanner.next();
		
		// On assigne les informations du client à notre HashMap :
		customerInfos.put("LastName", lastName);
		customerInfos.put("Name", name);
		
		System.out.println(customerInfos);
	}
}

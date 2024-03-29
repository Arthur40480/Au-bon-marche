import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Marche {

	public static void main(String[] args) {
		// Déclaration de notre Scanner pour récupérer les saisies utilisateurs :
		Scanner scanner = new Scanner(System.in);
		
		// Déclaration d'une liste, une qui contiendra les fruits et légumes :
		ArrayList<HashMap<String, Object>> merchandiseList = new ArrayList<>();
		
		// Déclaration d'une liste, une qui contiendra les clients et leurs informations :
		ArrayList<HashMap<String, Object>> customerList = new ArrayList<>();
		
		// Déclaration de tableau d'objet à multiple dimension contenant toute les informations des fruits et légumes à vendre :
		Object[][] informationBoard = {
				{"Clémentine", "Datte", "Grenade", "Kaki", "Kiwi", "Mandarine", "Orange", "Pamplemousse", "Poire","Pomme", 		//  <- Noms
				"Carrote", "Choux de Bruxelles", "Chou vert", "Courge butternut", "Endive", "Epinard", "Poireau", "Potiron", "Radis noir", "Salsifis"},	
				{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20},	// <- Id
				{6, 4, 3, 3, 5, 6, 8, 8, 5, 8, 7, 4, 12, 6, 5, 4, 5, 6, 10, 3},		//  <- Stock
				{2.90, 7, 3.50, 4.50, 3.50, 2.80, 1.50, 2, 2.50, 1.50, 1.30, 4, 2.50, 2.50, 2.50, 2.60, 1.20, 2.50, 5, 2.50},	//  <- Prix
				{true, true, true, true, true, true, true, false, true, true, true, true, false, false, true, true, true, false, false, true},	//  <- Prix au kg ?
		};
		
		// Boucle pour créer les HashMap qui contiendront les fruits/légumes et leurs informations :
		for(int i = 0; i < 20; i++) {
			HashMap<String, Object> merchandise = new HashMap<>();
			merchandise.put("Nom", informationBoard[0][i]);
			merchandise.put("Id", informationBoard[1][i]);
			merchandise.put("Stock", informationBoard[2][i]);
			merchandise.put("Prix", informationBoard[3][i]);
			merchandise.put("PrixAuKg", informationBoard[4][i]);
			
			// On ajoute la HashMap à la ArrayList :
			merchandiseList.add(merchandise);
		}
		
		Display.mainMenu(scanner, merchandiseList, customerList);
		scanner.close();
	}

}
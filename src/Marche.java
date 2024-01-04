import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Marche {

	public static void main(String[] args) {
		// Déclaration de notre Scanner pour récupérer les saisies utilisateurs :
		Scanner scanner = new Scanner(System.in);
		
		// Déclaration de deux listes, une qui contiendra les fruits et l'autre les légumes :
		ArrayList<HashMap<String, Object>> fruitList = new ArrayList<>();
		ArrayList<HashMap<String, Object>> vegetableList = new ArrayList<>();
		
		// Déclaration de tableau d'objet à multiple dimension contenant toute les informations des fruits et légumes à vendre :
		Object[][] informationBoard = {
				{"Clémentine", "Datte", "Grenade", "Kaki", "Kiwi", "Mandarine", "Orange", "Pamplemousse", "Poire","Pomme"},	//  <- Noms
				{6, 4, 3, 3, 5, 6, 8, 8, 5, 8},																				//  <- Stock
				{2.90, 7, 3.50, 4.50, 3.50, 2.80, 1.50, 2, 2.50, 1.50},														//  <- Prix
				{true, true, true, true, true, true, true, false, true, true},												//  <- Prix au kg ?
				{"Carrote", "Choux de Bruxelles", "Chou vert", "Courge butternut", "Endive", "Epinard", "Poireau", "Potiron", "Radis noir", "Salsifis"},
				{7, 4, 12, 6, 5, 4, 5, 6, 10, 3},
				{1.30, 4, 2.50, 2.50, 2.50, 2.60, 1.20, 2.50, 5, 2.50},
				{true, true, false, false, true, true, true, false, false, true}
		};
		
		// Boucle pour créer les HashMap qui contiendront les fruits et leurs informations :
		for(int i = 0; i < 10; i++) {
			HashMap<String, Object> fruit = new HashMap<>();
			fruit.put("Nom", informationBoard[0][i]);
			fruit.put("Stock", informationBoard[1][i]);
			fruit.put("Prix", informationBoard[2][i]);
			fruit.put("PrixAuKg", informationBoard[3][i]);
			
			fruitList.add(fruit);
		}
		
		// Boucle pour créer les HashMap qui contiendront les fruits et leurs informations :
		for(int j = 0; j < 10; j++) {
			HashMap<String, Object> vegetable = new HashMap<>();
			vegetable.put("Nom", informationBoard[4][j]);
			vegetable.put("Stock", informationBoard[5][j]);
			vegetable.put("Prix", informationBoard[6][j]);
			vegetable.put("PrixAuKg", informationBoard[7][j]);
			
			vegetableList.add(vegetable);
		}
		
		System.out.println(fruitList);
		System.out.println(vegetableList);
		scanner.close();

	}

}

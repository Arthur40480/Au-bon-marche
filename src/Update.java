import java.util.ArrayList;
import java.util.HashMap;

public class Update {
	// Méthode pour mettre à jour le stock des produits :
	public static ArrayList<HashMap<String, Object>> updateMerchandiseList(ArrayList<HashMap<String, Object>> merchandiseList, int merchandiseId, double merchandiseQuantity) {
		// On viens récupérer la HashMap de la marchandise à mettre à jour :
		HashMap<String, Object> merchandiseToUpdate = merchandiseList.get(merchandiseId - 1);
		// Opération de casting explicite pour convertir notre valeur numérique encapsuler dans l'objet :
		Object stockToUpdateObject = merchandiseToUpdate.get("Stock");
		double stockToUpdateDouble = ((Number) stockToUpdateObject).doubleValue();
		
		// On calcule le nouveau stock du produit :
		double newStockUpdated = stockToUpdateDouble - merchandiseQuantity;
		
		// On assigne le nouveau stock à notre HashMap :
		merchandiseToUpdate.put("Stock", newStockUpdated);
		
		return merchandiseList;
	}
}

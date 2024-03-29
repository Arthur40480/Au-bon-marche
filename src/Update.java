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
	// Méthode qui permet de mettre à jour le panier du client :
	public static HashMap<String, Object> updateCart(ArrayList<HashMap<String, Object>> merchandiseList, HashMap<String, Object> customerInfos, int merchandiseId, double merchandiseQuantity) {
		// On viens récupérer la HashMap de la marchandise à ajouter dans le panier :
		HashMap<String, Object> merchandiseToAdd = merchandiseList.get(merchandiseId - 1);
		// On viens récupérer la liste qui fait office de panier :
		Object cartObject = customerInfos.get("Cart");
		@SuppressWarnings("unchecked")
		ArrayList<HashMap<String, Object>> cart = (ArrayList<HashMap<String, Object>>) cartObject;
		// On viens créer une Hashmap pour chaques item que l'on assignera à la HashMap cart :
		HashMap<String, Object> item = new HashMap<>();
		
		// Opération de casting explicite pour convertir notre valeur string encapsuler dans l'objet :
		Object nameMerchandiseToAddObject = merchandiseToAdd.get("Nom");
		String nameMerchandiseToAddString = (String) nameMerchandiseToAddObject;
		
		// Opération de casting explicite pour convertir notre valeur boolean encapsuler dans l'objet :
		Object pricePerKgObject = merchandiseToAdd.get("PrixAuKg");
		boolean pricePerKgBool = (boolean) pricePerKgObject;
		
		// Opération de casting explicite pour convertir notre valeur numérique encapsuler dans l'objet :
		Object priceMerchandiseToAddObject = merchandiseToAdd.get("Prix");
		double priceMerchandiseToAddDouble = ((Number) priceMerchandiseToAddObject).doubleValue();

		// On calcule le prix de la marchandise sélectionner x sa quantité :
		double quantityPriceToAdd = priceMerchandiseToAddDouble * merchandiseQuantity;
		
		// On calcule le prix total du panier :
		Object totalPriceCartObject = customerInfos.get("TotalPrice");
		double totalPriceCartDouble = ((Number) totalPriceCartObject).doubleValue();
		double totalPriceCartUpdated = totalPriceCartDouble + quantityPriceToAdd;
		
		// On met à jour les informations du client :
		// Le prix total :
		customerInfos.put("TotalPrice", totalPriceCartUpdated);
		// Le panier :
		item.put("NameItem", nameMerchandiseToAddString);
		item.put("QuantityItem", merchandiseQuantity);
		item.put("QuantityPrice", quantityPriceToAdd);
		item.put("PricePerKg", pricePerKgBool);
		cart.add(item);
		customerInfos.put("Cart", cart);
		
		return customerInfos;
	}
}

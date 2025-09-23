package rest.warehouse;

import org.springframework.stereotype.Service;
import rest.model.ProductData;
import rest.model.WarehouseData;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * Service-Klasse für die Verarbeitung von Lagerdaten.
 * Stellt Methoden zum Abrufen von Lagerinformationen und zum Filtern von Produkten bereit.
 *
 * @author Ramis Ekici
 * @version 23-09-2025
 */
@Service
public class WarehouseService {

    /**
     * Liefert einen Begrüßungstext für ein gegebenes Modul.
     *
     * @param inModule Name des Moduls
     * @return Begrüßungstext als String
     */
	public String getGreetings( String inModule ) {
        return "Greetings from " + inModule;
    }

    /**
     * Liefert die Lagerdaten für ein bestimmtes Lager anhand der Lager-ID.
     *
     * @param inID ID des Lagers
     * @return Lagerdaten als WarehouseData-Objekt
     */
    public WarehouseData getWarehouseData( String inID ) {
    	WarehouseSimulation simulation = new WarehouseSimulation();
        return simulation.getData( inID );
    }

    /**
     * Liefert gefilterte Lagerdaten anhand von Produktkategorie und Produktname.
     * Es werden nur Produkte zurückgegeben, die den Filterkriterien entsprechen.
     *
     * @param productCategorie Kategorie des Produkts (null oder leer für keine Filterung)
     * @param productName Name des Produkts (null oder leer für keine Filterung)
     * @return Gefilterte Lagerdaten als WarehouseData-Objekt
     */
    public WarehouseData getWarehouseDataFiltered(String productCategorie, String productName) {
        WarehouseData data = getWarehouseData("001"); // oder anhand Location dynamisch abrufen

        if (data.getProducts() != null) {
            Set<ProductData> filtered = data.getProducts().stream()
                    .filter(p -> productCategorie == null || productCategorie.isEmpty()
                            || p.getProductCategory().toLowerCase().contains(productCategorie.toLowerCase()))
                    .filter(p -> productName == null || productName.isEmpty()
                            || p.getProductName().toLowerCase().contains(productName.toLowerCase()))
                    .collect(Collectors.toCollection(HashSet::new));
            data.setProducts(filtered);
        }

        return data;
    }
}
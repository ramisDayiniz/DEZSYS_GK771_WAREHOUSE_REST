package rest.warehouse;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;

import rest.model.WarehouseData;

/**
 * REST-Controller für die Verwaltung von Lagerdaten.
 * Stellt Endpunkte zur Verfügung, um Lagerinformationen im JSON- oder XML-Format abzurufen.
 *
 * @author Ramis Ekici
 * @version 23-09-2025
 */
@RestController
public class WarehouseController {

    @Autowired
    private WarehouseService service;

    /**
     * Hauptseite der Anwendung. Gibt eine einfache HTML-Übersicht mit Links zu Beispiel-Lagerdaten zurück.
     *
     * @return HTML-String mit Hinweisen auf verfügbare Lagerdaten-Endpunkte
     */
    @RequestMapping("/")
    public String warehouseMain() {
    	String mainPage = "This is the warehouse application! (DEZSYS_WAREHOUSE_REST) <br/><br/>" +
                          "<a href='http://localhost:8080/warehouse/001/json'>Link to warehouse/001/json</a><br/>" +
                          "<a href='http://localhost:8080/warehouse/001/xml'>Link to warehouse/001/xml</a><br/>" 
                          ;
        return mainPage;
    }

    /**
     * Liefert Lagerdaten im JSON-Format für ein gegebenes Lager.
     *
     * @param inID ID des Lagers, dessen Daten abgerufen werden sollen
     * @return Lagerdaten als WarehouseData-Objekt
     */
    @RequestMapping(value="/warehouse/{inID}/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public WarehouseData warehouseData( @PathVariable String inID ) {
        return service.getWarehouseData( inID );
    }

    /**
     * Liefert Lagerdaten im XML-Format für ein gegebenes Lager.
     *
     * @param inID ID des Lagers, dessen Daten abgerufen werden sollen
     * @return Lagerdaten als WarehouseData-Objekt
     */
    @RequestMapping(value="/warehouse/{inID}/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public WarehouseData warehouseDataXML( @PathVariable String inID ) {
        return service.getWarehouseData( inID );
    }



}
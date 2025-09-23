package rest.warehouse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import rest.model.WarehouseData;

/**
 * Controller für die Anzeige von Lagerdaten über Thymeleaf.
 * Stellt Endpunkte bereit, um Lagerinformationen und Produktlisten im Browser darzustellen.
 *
 * @author Ramis Ekici
 * @version 23-09-2025
 */
@Controller
public class WarehouseViewController {
    /** Service zur Verwaltung und Bereitstellung von Lagerdaten */
    private final WarehouseService service;

    /**
     * Konstruktor für den Controller
     *
     * @param service WarehouseService zur Abfrage von Lagerdaten
     */
    public WarehouseViewController(WarehouseService service) {
        this.service = service;
    }

    /**
     * Zeigt die Detailansicht eines Lagers anhand der Lager-ID an.
     *
     * @param id Lager-ID aus dem Pfad
     * @param model Model zur Übergabe der Daten an die View
     * @return Name der Thymeleaf-Template-Datei
     */
    @GetMapping("/warehouse/view/{id}")
    public String showWarehouse(@PathVariable String id, Model model) {
        WarehouseData data = service.getWarehouseData(id); // direkt
        model.addAttribute("warehouse", data);
        return "warehouse-view";
    }

    /**
     * Zeigt die Lageransicht mit optionalen Filterkriterien an.
     * Filterbar nach Produktkategorie und Produktname.
     *
     * @param location Optional: Kategorie des Produkts (früher "Standort")
     * @param productName Optional: Name des Produkts
     * @param model Model zur Übergabe der Daten an die View
     * @return Name der Thymeleaf-Template-Datei
     */
    @GetMapping("/warehouse/view")
    public String showWarehouse(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String productName,
            Model model) {

        WarehouseData data = service.getWarehouseDataFiltered(location, productName);
        model.addAttribute("warehouse", data);
        return "warehouse-view";
    }

}




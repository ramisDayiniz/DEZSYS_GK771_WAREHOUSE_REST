package rest.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import rest.model.WarehouseData;

@Controller
public class WarehouseViewController {

    private final WarehouseService service;

    public WarehouseViewController(WarehouseService service) {
        this.service = service;
    }

    @GetMapping("/warehouse/view/{id}")
    public String showWarehouse(@PathVariable String id, Model model) {
        WarehouseData data = service.getWarehouseData(id); // direkt
        model.addAttribute("warehouse", data);
        return "warehouse-view";
    }

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




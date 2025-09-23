package rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductData {
    public ProductData(){

    }


    private String productID;
    private String productName;
    private String productCategory;
    private String productUnit;
    private int productQuantity;

    public ProductData(String productID, String productName, String productCategory, String productUnit, int productQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productUnit = productUnit;
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "ProductData{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", productCategory=" + productCategory +
                ", productUnit='" + productUnit + '\'' +
                '}';
    }
}


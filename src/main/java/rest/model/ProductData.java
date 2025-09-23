package rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductData {
    public ProductData(){

    }


    private String productID;
    private String productName;
    private int productCategory;
    private String productUnit;


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


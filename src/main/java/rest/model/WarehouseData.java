package rest.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WarehouseData {
	
	private String warehouseID;
	private String warehouseName;
	private String timestamp;
	private String warehouseAddress;
	private String warehousePostalCode;
	private String warehouseCity;
	private String warehouseCountry;
	private HashSet<ProductData> products;

	/**
	 * Constructor
	 */
	public WarehouseData() {
		
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());

	}


	public ProductData getProduct(String productID) {
		if (products == null) {
			return null;
		}
		Iterator<ProductData> iterator = products.iterator();
		while (iterator.hasNext()) {
			ProductData product = iterator.next();
			if (product.getProductID().equals(productID)) {
				return product;
			}
		}
		return null;
	}


	public HashSet<ProductData> getAllProducts() {
		if (products == null) {
			return null;
		}

		return products;
	}


	public boolean addProduct(ProductData product) {
		if (this.products == null) {
			return false;
		}

		if (this.products.contains(product)) {
			return false;
		}

		return this.products.add(product);
	}

	public HashSet<ProductData> getProducts() {
		return products;
	}

	public void setProducts(HashSet<ProductData> products) {
		this.products = products;
	}

	public String getWarehouseAddress() {
		return warehouseAddress;
	}

	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	public String getWarehousePostalCode() {
		return warehousePostalCode;
	}

	public void setWarehousePostalCode(String warehousePostalCode) {
		this.warehousePostalCode = warehousePostalCode;
	}

	public String getWarehouseCity() {
		return warehouseCity;
	}

	public void setWarehouseCity(String warehouseCity) {
		this.warehouseCity = warehouseCity;
	}

	public String getWarehouseCountry() {
		return warehouseCountry;
	}

	public void setWarehouseCountry(String warehouseCountry) {
		this.warehouseCountry = warehouseCountry;
	}

	/**
	 * Setter and Getter Methods
	 */


	public String getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(String warehouseID) {
		this.warehouseID = warehouseID;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Methods
	 */
	@Override
	public String toString() {
		return "WarehouseData{" +
				"warehouseID='" + warehouseID + '\'' +
				", warehouseName='" + warehouseName + '\'' +
				", timestamp='" + timestamp + '\'' +
				", warehouseAddress='" + warehouseAddress + '\'' +
				", warehousePostalCode='" + warehousePostalCode + '\'' +
				", warehouseCity='" + warehouseCity + '\'' +
				", warehouseCountry='" + warehouseCountry + '\'' +
				'}';
	}



}

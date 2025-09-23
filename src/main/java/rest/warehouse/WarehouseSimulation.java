package rest.warehouse;

import rest.model.ProductData;
import rest.model.WarehouseData;

import java.util.HashSet;

public class WarehouseSimulation {

	private double getRandomDouble( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum;
		double rounded = Math.round(number * 100.0) / 100.0;
		return rounded;

	}

	private int getRandomInt( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum;
		Long rounded = Math.round(number);
		return rounded.intValue();

	}

	public WarehouseData getData( String inID ) {
		WarehouseData data = new WarehouseData();
		data.setWarehouseID( inID );
		data.setWarehouseName( "Linz Bahnhof" );
		data.setWarehouseAddress("Bahnhofsstrasse 27/9");
		data.setWarehousePostalCode("Linz");
		data.setWarehouseCity("Linz");
		data.setWarehouseCountry("Austria");

		HashSet<ProductData> products = new HashSet<>();

		products.add(new ProductData("00-443175", "Bio Orangensaft Sonne", "Getraenk", "Packung 1L", 2500));
		products.add(new ProductData("00-871895", "Bio Apfelsaft Gold",    "Getraenk", "Packung 1L", 3420));
		products.add(new ProductData("01-926885", "Ariel Waschmittel Color","Waschmittel", "Packung 3KG", 478));
		products.add(new ProductData("00-316253", "Persil Discs Color",     "Waschmittel", "Packung 700G", 1430));

		data.setProducts(products);

		return data;
	}
}

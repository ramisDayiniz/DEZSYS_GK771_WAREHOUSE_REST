package rest.warehouse;

import rest.model.ProductData;
import rest.model.WarehouseData;

import java.util.HashSet;

/**
 * Simulation von Lagerdaten für Demonstrations- und Testzwecke.
 * Erzeugt Beispiel-Lagerdaten einschließlich Produkte mit zufälligen oder festen Werten.
 *
 * @author Ramis Ekici
 * @version 23-09-2025
 */
public class WarehouseSimulation {


	/**
	 * Generiert eine zufällige Gleitkommazahl zwischen Minimum und Maximum.
	 * Das Ergebnis wird auf 2 Nachkommastellen gerundet.
	 *
	 * @param inMinimum Untergrenze
	 * @param inMaximum Obergrenze
	 * @return Zufällige Zahl als double
	 */
	private double getRandomDouble( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum;
		double rounded = Math.round(number * 100.0) / 100.0;
		return rounded;

	}

	/**
	 * Generiert eine zufällige ganze Zahl zwischen Minimum und Maximum.
	 *
	 * @param inMinimum Untergrenze
	 * @param inMaximum Obergrenze
	 * @return Zufällige Zahl als int
	 */
	private int getRandomInt( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum;
		Long rounded = Math.round(number);
		return rounded.intValue();

	}

	/**
	 * Liefert Beispiel-Lagerdaten für ein gegebenes Lager anhand der Lager-ID.
	 * Enthält feste Produkte mit Beispielwerten.
	 *
	 * @param inID ID des Lagers
	 * @return Lagerdaten als WarehouseData-Objekt
	 */
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

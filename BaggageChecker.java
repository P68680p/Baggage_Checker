/*
 * Author: Polina Debchuk
 * Date: July 15, 2024
 * Due date: July 26, 2024
 * Description:A simple program for checking dimensions of the baggage and compare them,
 * and calculate total weight if valid baggage and calculate extra charge for the overweight
 * Lab Professor: James Mwangi PhD
 */

public class BaggageChecker {
	//********** PROPERTIES / CONSTANTS *************************************************************************************************
	public static final double SURCHARGE_PER_KG = 3;	//$ per kg
	public static final double MAX_REGULAR_WEIGHT = 22; //in kg
	public static final double MAX_CARRYON_DIMENSION = 36; //in cm
	public static final int MAX_SUM_DIMENSIONS = 192;	//in cm
	
	/************************************************************************************************************************************
	 * The first method, allowedWeightIsMoreThanMax(), returns true if the baggage object passed has a weight
	 * greater than the maximum permissible regular weight of 22.0 kg, and false otherwise.
	 */

	public static boolean allowedWeightIsMoreThanMax(Baggage bag) {
		if(bag.getWeight() > MAX_REGULAR_WEIGHT) {
			return true;
		}
		return false;
	}
	
	/*************************************************************************************************************************************
	 * The second method, calculateWeightSurcharge(), should use the baggage object’s weight to return
	 * a SURCHARGE_PER_KG of $3.00 for each kg above the MAX_REGULAR_WEIGHT just mentioned
	 * (which should both be set as constants in this class).
	 */

	public static double calculateWeightSurcharge (Baggage bag) {
		double surcharge = 0;
		if (allowedWeightIsMoreThanMax(bag)) {
			surcharge = (bag.getWeight() - MAX_REGULAR_WEIGHT) * SURCHARGE_PER_KG;
		}
		return surcharge;
	}
	
/******************************************************************************************************************************************
 * 	A third method, canBeUsedAsACarryOn(), returns true if the length, width, and height
 *  are each less than 36 cm (the value of MAX_CARRYON_DIMENSION), and false otherwise.
 */
	public static boolean canBeUsedAsCarryOn(Baggage bag) {
		if(bag.getLength() < MAX_CARRYON_DIMENSION && bag.getWidth() < MAX_CARRYON_DIMENSION && bag.getHeight() < MAX_CARRYON_DIMENSION) {
			return true;
		}
		return false;
	}
	
/*******************************************************************************************************************************************
 * Finally, the sumDimensionsExceedsMax() method tests to see is the sum of the baggage object’s length, width, and height
 * exceed 192 cm—again, this number, MAX_SUM_DIMENSIONS needs to be set as a constant of the class.
 * This method returns true if the sum of the object’s dimensions is greater than this value—implying the baggage
 * will not fit in the plane’s baggage compartment—and false otherwise.
 */
	public static boolean sumDimensionsExceedsMax(Baggage bag) {
		if(bag.getLength() + bag.getWidth() + bag.getHeight() > MAX_SUM_DIMENSIONS) {
			return true;
		}
		return false;
	}
}

/*
 * Author: Polina Debchuk
 * Date: July 15, 2024
 * Due date: July 26, 2024
 * Description:A simple program for dimensions of the baggage and for work with them
 * Lab Professor: James Mwangi PhD
 */


public class Baggage {
	
//**********PROPERTIES***************	
	//custom's baggage dimensions (Baggage class' properties)
	private int lenght; //(in cm, as ints)
	private int width;	//(in cm, as ints)
	private int height;	//(in cm, as ints)
	private double weight;	//(in kgs, as a double)
	
	//dimensions for comparing (constants for default values as a standard)
	public final static int DEFAULT_LENGTH = 65;
	public final static int DEFAULT_WIDTH = 25;
	public final static int DEFAULT_HEIGHT = 50;
	public final static double DEFAULT_WEIGHT = 10.0;
	
	
//**********CONSTRUCTORS***************	
	//no-args constructor which is chained to the 4-args constructor using default values of 65 cm (the length),
	//25 cm (the width), 50 cm (the height), and a weight of 10.0 kg.
	public Baggage(){
		this(DEFAULT_LENGTH, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_WEIGHT);
	}
	
	//4-args constructor for creating a Baggage instance
	public Baggage(int length, int width, int height,double weight) {
		this.lenght = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
	}
	
	
//************GETTERS AND SETTERS*************
	public int getLength() {
		return lenght;
	}
	public void setLength(int length) {
		this.lenght = length;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}	
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
//***************toString()*****************
	public String toString() {
		String result="";
		
		//*************check if the baggage is oversized or not********************
		if(BaggageChecker.sumDimensionsExceedsMax(this)) {				
			result = "This is oversized; it is not acceptable.";
		}
		else {
			result = String.format("This bag has length %d cm, width %d cm, height %d cm, and weight %.2f kg.", lenght, width, height, weight);
			
			//*************check if the baggage can be used as a carry on********************
			if(BaggageChecker.canBeUsedAsCarryOn(this)) {	
				result += "\nThis bag can be used as a carry on.";
			}
			
			//*************check if it's need to pay for extra weight********************
			if(BaggageChecker.allowedWeightIsMoreThanMax(this)){				
				result += String.format("\nThis bag is overweight; it exceeds the allowed weight of 22.00 kg. A surcharge of $%.2f applies.", BaggageChecker.calculateWeightSurcharge(this));
			}
		}
		return result;
	}
}

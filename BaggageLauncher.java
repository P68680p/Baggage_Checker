/*
 * Author: Polina Debchuk
 * Date: July 15, 2024
 * Due date: July 26, 2024
 * Description:A simple program for checking dimensions of the baggage
 * Lab Professor: James Mwangi PhD
 */

public class BaggageLauncher {

	public static void main(String[] args) {
		//*********total number of valid bags and total weight entered*********
		int totalNumberOfValidBags = 0;
		double totalWeight=0;
		
		// *********greeting ****************************************************
		System.out.println("Welcome to the Baggage Handler Software Program\n");

		do {		
			//*********create custom's baggage instance*********
			int length = InputData.validateInt("Enter the length of the baggage (in cm):");		
			int width = InputData.validateInt("Enter the width (in cm):");
			int height = InputData.validateInt("Enter the height (in cm):");
			double weight = InputData.validateDouble("Enter the weight (in kg):");
			Baggage customBaggage = new Baggage(length, width, height, weight);
			
			//*********check if the baggage is oversized and not acceptable*********	
			if(BaggageChecker.sumDimensionsExceedsMax(customBaggage)) {				
				System.out.println(customBaggage.toString());
			}
			else {
				System.out.println(customBaggage.toString());
				totalNumberOfValidBags++;
				totalWeight=totalWeight + customBaggage.getWeight();
			}
			
			//*********check if user wants to exit*********					
			String choice = InputData.validateString("\nDo you wish to continue? Enter 'No' to quit, anything else to continue:");
			if(choice.equalsIgnoreCase("No")) {
				System.out.println("The total number of valid bags entered was: " + totalNumberOfValidBags);
				System.out.println("The total weight entered was: "+ totalWeight + " kg.");
				System.out.println("\nThe program has terminated.");
				System.out.println("Program by Polina Debchuk");
				break;
			}
		}
		while(true);	
	}

}


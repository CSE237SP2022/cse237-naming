package naming;

public class Dice {

	
    public static void main(String[] args) {
        int dice = 4;
        int throwss = 7;
 
        int[] rollFrequencyTable = throwManyTimes(dice, throwss);
        printFrequencies(rollFrequencyTable);

    }

    /**
     * Prints out the contents of the frequency table
     * @param rollFrequencyTable 
     */
	public static void printFrequencies(int[] rollFrequencyTable) {
		for(int i = 0; i < rollFrequencyTable.length; i++) {
            System.out.println("Sum: " + i + " times: " + rollFrequencyTable[i]);
        }
	}

	/**
	 * Rolls the given number of dice, throws number of times
	 * @param dice number of dice
	 * @param throwss number of throws
	 * @return a table of how often each sum was rolled
	 */
	public static int[] throwManyTimes(int dice, int throwss) {
		int[] rollFrequencyTable = new int[dice * 6];
		int[][] rollTracker = new int[throwss][dice];
        int sumOfThrow = 0;
        int yahtzees = 0;
        for(int i = 0; i < throwss; i++) {
        	sumOfThrow = computeAndPrintSum(dice, rollTracker, i);

            if(checkForYahtzees(dice, rollTracker, i)) {
            	yahtzees++;
            }
            rollFrequencyTable[sumOfThrow]++;
        }
        System.out.println("There were " + yahtzees + " yahtzees");
		return rollFrequencyTable;
	}

	private static int computeAndPrintSum(int dice, int[][] rollTracker, int i) {
		int sumOfThrow;
		sumOfThrow = rollDice(dice, rollTracker, i);
		System.out.println(" Sum: " + sumOfThrow);
		return sumOfThrow;
	}

	private static int rollDice(int dice, int[][] rollTracker, int throwNumber) {
		int sumOfThrow = 0;
		System.out.print("Roll: "); 
		for(int j = 0; j < dice; j++) { 
		    int dieRoll = (int)(Math.random() * 6 + 1); 
		    rollTracker[throwNumber][j] = dieRoll; 
		    sumOfThrow += dieRoll;
		    System.out.print(dieRoll + " ");
		}
		return sumOfThrow;
	}
    
    public static boolean checkForYahtzees(int dice, int[][] rollTracker, int throwNumber) {
    	for(int j = 0; j < dice - 1; j++) {
            if(rollTracker[throwNumber][j] != rollTracker[throwNumber][j+1]) {
                return false;
            }
        }
    	return true;
    }

}

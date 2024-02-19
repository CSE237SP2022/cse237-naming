package naming;

public class Dice {

    public static void main(String[] args) {
        int dice = 4;
        int throwss = 7;

        int[][] rollTracker = new int[throwss][dice];
        int[] rollFrequencyTable = new int[dice * 6];

        int sumOfThrow = 0;
        int yahtzees = 0;
        for(int i = 0; i < throwss; i++) {
        	sumOfThrow = 0;
            System.out.print("Roll: ");
            for(int j = 0; j < dice; j++) {
                int dieRoll = (int)(Math.random() * 6 + 1);
                rollTracker[i][j] = dieRoll;
                sumOfThrow += dieRoll;
                System.out.print(dieRoll + " ");
            }
            System.out.println(" Sum: " + sumOfThrow);

            for(int j = 0; j < dice - 1; j++) {
                if(rollTracker[i][j] == rollTracker[i][j+1]) {
                    yahtzees++;
                }
            }
            rollFrequencyTable[sumOfThrow]++;
        }
        System.out.println("There were " + yahtzees + " yahtzees");

        for(int i = 0; i < rollFrequencyTable.length; i++) {
            System.out.println("Sum: " + i + " times: " + rollFrequencyTable[i]);
        }

    }

}

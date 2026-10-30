
import java.util.Random;  // Import the Scanner class
import java.util.Scanner;

public class HeadsOrTails {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        String[] options = {"Heads", "Tails"};
        int[] amount = {0, 0};

        System.out.print("How many attempts would you like to run ");
        int runs = input.nextInt();

        for (int i = 0; i < runs; i++) {
            int rnd = rand.nextInt(options.length);
            if (amount[0] < 10 || amount[1] < 10) {
                amount[rnd]++;
                // System.out.printf("Heads: " + ((amount[0]*100)/(amount[0]+amount[1])) + "%\r");
                System.out.printf("\rHeads: %.1f%%\tTails: %.1f%%\t\tRun: %.1f", amount[0] * 100.0 / (i + 1), amount[1] * 100.0 / (i + 1), i*1.0);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // System.out.printf("\rHeads: + %d Tails: %d", amount[0], amount[1]);
            } else if (amount[0] < 50 || amount[1] < 50) {
                amount[rnd]++;
                // System.out.printf("Heads: " + ((amount[0]*100)/(amount[0]+amount[1])) + "%\r");
                System.out.printf("\rHeads: %.1f%%\tTails: %.1f%%\t\tRun: %.1f", amount[0] * 100.0 / (i + 1), amount[1] * 100.0 / (i + 1), i*1.0);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (amount[0] < 1000 || amount[1] < 1000) {
                amount[rnd]++;
                // System.out.printf("Heads: " + ((amount[0]*100)/(amount[0]+amount[1])) + "%\r");
                System.out.printf("\rHeads: %.1f%%\tTails: %.1f%%\t\tRun: %.1f", amount[0] * 100.0 / (i + 1), amount[1] * 100.0 / (i + 1), i*1.0);
                
            } else if (amount[0] < 50000 || amount[1] < 50000) {
                amount[rnd]++;
                // System.out.printf("Heads: " + ((amount[0]*100)/(amount[0]+amount[1])) + "%\r");
                System.out.printf("\rHeads: %.1f%%\tTails: %.1f%%\t\tRun: %.1f", amount[0] * 100.0 / (i + 1), amount[1] * 100.0 / (i + 1), i*1.0);
                
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                amount[rnd]++;
                // System.out.printf("Heads: " + ((amount[0]*100)/(amount[0]+amount[1])) + "%\r");
                System.out.printf("\rHeads: %.1f%%\tTails: %.1f%%\t\tRun: %.1f", amount[0] * 100.0 / (i + 1), amount[1] * 100.0 / (i + 1), i*1.0);
                
            }
        }
        System.out.println("\nHeads: " + amount[0] + "\nTails: " + amount[1]);

        input.close();
    }
}

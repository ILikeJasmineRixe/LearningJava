import java.util.Scanner;

public class reverseString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What word would you like to reverse?\t");
        String word = input.nextLine();


        int length = word.length();
        String reversed = "";

        for (int i = (length -1); i>=0;i--) {
            reversed += word.charAt(i);
        }

        System.out.println("Reversed:\t" + reversed);
        input.close();
    }
}
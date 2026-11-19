import java.util.Scanner;

public class countVowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // word.charAt(i);

        System.out.print("Input a word: ");

        String word = scanner.nextLine();

        int length = word.length();
        int vowelCount = 0;
        int consCount = 0;

        for (int i=0;i<length;i++) {
            char ch = (word.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            } else {
                consCount++;
            }
        }

        System.out.println("Vowels: " + vowelCount + "\nConsonants: " + consCount);
    }
}


public class countWords {
    public static void main(String[] args) {
        
        String sentence = "I Like java!";
        int length = sentence.length();
        int endOfLine = length - 1;

        
        int wordCount = 0;

        for (int i = 0; i < length; i++) {
            if ((sentence.charAt(i) == ' ') || (i == endOfLine)) {
                wordCount++;
            }
        }

        System.out.println(wordCount);
    }
}
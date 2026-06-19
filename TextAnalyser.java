import java.util.*;

public class TextAnalyser{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        // Calling our reusable methods
        int words = countWords(text);
        int vowels = countVowels(text);

        System.out.print("Enter a word to search for: ");
        String searchWord = scanner.nextLine();
        int occurrences = countWordOccurrences(text, searchWord);

        // Print results
        System.out.println("\n--- Text Analysis ---");
        System.out.println("Word count: " + words);
        System.out.println("Vowel count: " + vowels);
        System.out.println("'" + searchWord + "' occurs " + occurrences + " time(s)");

        scanner.close();
    }

    // ===== Method 1: Count words =====
    public static int countWords(String text) {
        String[] wordsArray = text.trim().split("\\s+"); // splits by spaces
        return wordsArray.length;
    }

    // ===== Method 2: Count vowels =====
    public static int countVowels(String text) {
        int count = 0;
        String lowerText = text.toLowerCase();

        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    // ===== Method 3: Count occurrences of a specific word =====
    public static int countWordOccurrences(String text, String target) {
        String[] wordsArray = text.toLowerCase().trim().split("\\s+");
        int count = 0;

        for (String word : wordsArray) {
            if (word.equals(target.toLowerCase())) {
                count++;
            }
        }
        return count;
    }
}
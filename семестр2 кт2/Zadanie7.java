import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Zadanie7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        String result = removeDuplicateWords(input);

        System.out.println("Строка без повторяющихся слов: " + result);

        scanner.close();
    }

    private static String removeDuplicateWords(String input) {
 
        String[] words = input.split("\\s+");
 
        Set<String> uniqueWords = new LinkedHashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }

        return String.join(" ", uniqueWords);
    }
}

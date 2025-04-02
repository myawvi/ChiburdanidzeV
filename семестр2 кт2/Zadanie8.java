import java.util.Scanner;

public class Zadanie8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        String result = convertCase(input);

        System.out.println("Результат: " + result);

        scanner.close();
    }

    private static String convertCase(String input) {
        int upperCaseCount = 0;
        int lowerCaseCount = 0;

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCaseCount++;
            } else if (Character.isLowerCase(c)) {
                lowerCaseCount++;
            }
        }

        if (upperCaseCount > lowerCaseCount) {
            return input.toUpperCase(); 
        } else if (lowerCaseCount > upperCaseCount) {
            return input.toLowerCase(); 
        } else {
            return input.toLowerCase(); 
        }
    }
}

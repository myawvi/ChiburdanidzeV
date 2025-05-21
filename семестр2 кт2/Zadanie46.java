import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Zadanie46 {

    private static final Map<Character, Integer> romanToArabicMap = new HashMap<>();

    static {
        romanToArabicMap.put('I', 1);
        romanToArabicMap.put('V', 5);
        romanToArabicMap.put('X', 10);
        romanToArabicMap.put('L', 50);
        romanToArabicMap.put('C', 100);
        romanToArabicMap.put('D', 500);
        romanToArabicMap.put('M', 1000);
    }

    public static int romanToArabic(String roman) {
        int total = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char currentChar = roman.charAt(i);
            int currentValue = romanToArabicMap.get(currentChar);

            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            prevValue = currentValue;
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите римское число : ");
        String roman = scanner.nextLine().toUpperCase();

        try {
            int arabic = romanToArabic(roman);
            if (arabic >= 1 && arabic < 10000) {
                System.out.println("Арабское число: " + arabic);
            } else {
                System.out.println("Неверный ввод");
            }
        } catch (Exception e) {
            System.out.println("Неверный формат");
        }

        scanner.close();
    }
}

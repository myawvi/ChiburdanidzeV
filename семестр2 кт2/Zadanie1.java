import java.util.Scanner;

public class Zadanie1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первую строку: ");
        String firstString = scanner.nextLine();

        System.out.print("Введите вторую строку: ");
        String secondString = scanner.nextLine();

        boolean isEnding = isEnding(firstString, secondString);
   
        System.out.println(isEnding);
        
        scanner.close();
    }

    public static boolean isEnding(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false; 
        }
        return str1.endsWith(str2);
    }
}
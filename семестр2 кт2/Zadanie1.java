import java.util.Scanner;

public class Zadanie1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первую строку: ");
        String a = scanner.nextLine();

        System.out.print("Введите вторую строку: ");
        String b = scanner.nextLine();

        boolean isEnding = isEnding(a, b);
   
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

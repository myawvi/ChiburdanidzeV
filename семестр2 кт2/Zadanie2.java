import java.util.Scanner;

public class Zadanie2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();

        String form = formatName(name);

        System.out.println("Привет, " + form + "!");
        
        scanner.close();
    }

    public static String formatName(String name) {
        if (name == null || name.isEmpty()) {
            return ""; 
        }
      
        return Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
    }
}

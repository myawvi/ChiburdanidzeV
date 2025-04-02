import java.util.Scanner;

public class Zadanie4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int firstNumber = scanner.nextInt();
        
        System.out.print("Введите второе число: ");
        int secondNumber = scanner.nextInt();

        int start = Math.min(firstNumber, secondNumber);
        int step = start; 

        System.out.println("Квадраты чисел:");

        int count = 5; 

        for (int i = 0; i < count; i++) {
            int currentNumber = start + i * step;
            int square = currentNumber * currentNumber;
            System.out.print(square + (i < count - 1 ? ", " : ""));
        }

        System.out.println();
        scanner.close();
    }
}

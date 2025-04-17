import java.util.Scanner;

public class Zadanie6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] memory = new Integer[3];

        while (true) {
            System.out.print("Введите число (или введите 'exit' для выхода): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {

                int number = Integer.parseInt(input);
                
 
                addToMemory(memory, number);
                
 
                System.out.println("Состояние памяти: ");
                for (Integer num : memory) {
                    System.out.print(num != null ? num : "EMPTY" + " ");
                }
                System.out.println(); 
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректное число.");
            }
        }

        scanner.close();
    }

    private static void addToMemory(Integer[] memory, int number) {
 
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == null) {
                memory[i] = number; 
                return;
            }
        }


        int minIndex = 0;
        for (int i = 1; i < memory.length; i++) {
            if (memory[i] < memory[minIndex]) {
                minIndex = i;
            }
        }
        memory[minIndex] = number;
    }
}

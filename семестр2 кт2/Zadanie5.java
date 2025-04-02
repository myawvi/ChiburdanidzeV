import java.util.Scanner;

public class Zadanie5 {

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.print("Введите начало ряда: ");
int start = scanner.nextInt();

System.out.print("Введите шаг: ");
int step = scanner.nextInt();

System.out.print("Введите количество шагов: ");
int count = scanner.nextInt();

System.out.println("Числа в полученном ряду:");
for (int i = 0; i < count; i++) {
int currentNumber = start + i * step;
System.out.print(currentNumber + (i < count - 1 ? ", " : ""));
}

scanner.close();
}
}

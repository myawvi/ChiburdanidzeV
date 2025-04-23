import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class КаждыйТретий {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество игроков: ");
        int a = scanner.nextInt();
        System.out.print("Введите номер игрока, с которого начинается игра: ");
        int b = scanner.nextInt();

        List<Integer> players = new ArrayList<>();
        for (int i = 1; i <= a; i++) {
            players.add(i);
        }

        List<Integer> eliminated = new ArrayList<>();
        int index = b - 1;
        while (players.size() > 1) {
            index = (index + 2) % players.size();
            eliminated.add(players.remove(index));
        }

        eliminated.add(players.get(0));

        System.out.println("Список выбывших игроков (включая победителя): " + eliminated);

        scanner.close();
    }
}

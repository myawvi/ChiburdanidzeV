import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Calculator {

    private static final String HISTORY_FILE = "история.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printHistory();

        System.out.println("Введите задачу или 'history' для просмотра истории, 'exit' для выхода:");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("history")) {
                printHistory();
                continue;
            } else if (input.isEmpty()) {
                continue;
            }

            try {
                Parser parser = new Parser(input);
                double result = parser.parseExpression();
                System.out.println("Результат: " + result);
                saveToHistory(input, result);
            } catch (Exception e) {
                System.out.println("Ошибка вычисления: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void saveToHistory(String expression, double result) {
        String line = expression + " = " + result;
        try (FileWriter fw = new FileWriter(HISTORY_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(line);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения истории: " + e.getMessage());
        }
    }

    private static void printHistory() {
        System.out.println("История вычислений:");
        if (!Files.exists(Paths.get(HISTORY_FILE))) {
            System.out.println("История пуста");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(HISTORY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения истории: " + e.getMessage());
        }
        System.out.println("=========================");
    }
}

class Parser {
    private String input;
    private int pos = -1, ch;

    public Parser(String input) {
        this.input = input.replaceAll("\\s+", "");
        nextChar();
    }

    private void nextChar() {
        ch = (++pos < input.length()) ? input.charAt(pos) : -1;
    }

    private boolean eat(int charToEat) {
        while (ch == ' ') nextChar();
        if (ch == charToEat) {
            nextChar();
            return true;
        }
        return false;
    }
    public double parseExpression() {
        double x = parseTerm();
        while (true) {
            if (eat('+')) {
                x += parseTerm(); 

            } else if (eat('-')) {
                x -= parseTerm(); 
            } else {
                return x;
            }
        }
    }

    private double parseTerm() {
        double x = parseFactor();
        while (true) {
            if (eat('*')) {
                x *= parseFactor(); 
            } else if (eat('/')) {
                x /= parseFactor(); 
            } else if (eat('%')) {
                x %= parseFactor(); 
            } else if (eat('/')) { 
                if(eat('/')) { 
                    double divisor = parseFactor();
                    if(divisor == 0) throw new ArithmeticException("Деление на ноль");
                    x = (int)(x / divisor);
                } else {
                    throw new RuntimeException("Неверный оператор");
                }
            } else {
                return x;
            }
        }
    }

    private double parseFactor() {
        double x = parsePower();
        return x;
    }

    private double parsePower() {
        double x = parseUnary();
        while (true) {
            if (eat('^')) {
                x = Math.pow(x, parseUnary());
            } else {
                return x;
            }
        }
    }

    private double parseUnary() {
        if (eat('+')) return parseUnary(); 
        if (eat('-')) return -parseUnary(); 

        if (eat('|')) {
            double val = parseExpression();
            if (!eat('|')) {
                throw new RuntimeException("Отсутствует закрывающий символ |");
            }
            return Math.abs(val);
        }

        return parsePrimary();
    }

    private double parsePrimary() {
        if (eat('(')) { 
            double x = parseExpression();
            if (!eat(')')) {
                throw new RuntimeException("Отсутствует закрывающая скобка ')'");
            }
            return x;
        }

        StringBuilder sb = new StringBuilder();
        if ((ch >= '0' && ch <= '9') || ch == '.') {
            while ((ch >= '0' && ch <= '9') || ch == '.') {
                sb.append((char) ch);
                nextChar();
            }
            return Double.parseDouble(sb.toString());
        }

        throw new RuntimeException("Неизвестный символ: " + (char) ch);
    }
}

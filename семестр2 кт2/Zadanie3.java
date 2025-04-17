import java.util.Scanner;

public class Zadanie3 {

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.print("Введите строку: ");
String input = scanner.nextLine();

String result = removeVowels(input);
 
System.out.println("Строка без гласных: " + result);
        
scanner.close();
}

public static String removeVowels(String str) {
if (str == null) {
return null; 
}
 
StringBuilder result = new StringBuilder();

for (char c : str.toCharArray()) {
if (!isVowel(c)) {
result.append(c);
}
}

return result.toString(); 
}

public static boolean isVowel(char c) {
  
char lowerCase = Character.toLowerCase(c);
return lowerCase == 'а' || lowerCase == 'е' || lowerCase == 'ё' || 
lowerCase == 'и' || lowerCase == 'о' || lowerCase == 'у' || 
lowerCase == 'ы' || lowerCase == 'э' || lowerCase == 'ю' || 
lowerCase == 'я' || lowerCase == 'a' || lowerCase == 'e' || 
lowerCase == 'i' || lowerCase == 'o' || lowerCase == 'u'; 
}
}

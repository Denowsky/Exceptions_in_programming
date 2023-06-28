import java.util.Scanner;

public class exception4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите что-нибудь: ");
        String userInput = scanner.nextLine();
        scanner.close();
        System.out.println("Вы ввели: " + userInput);
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("Ввод не может быть пустым!");
        }
    }
}
import java.util.Scanner;

public class exception1 {
    public static void main(String[] args) {
        float input = getFloatFromUser();
        System.out.println("Вы ввели число: " + input);
    }

    public static float getFloatFromUser() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите дробное число: ");
            String inputString = scanner.nextLine();

            try {
                float userInput = Float.parseFloat(inputString);
                scanner.close();
                return userInput;
            } catch (NumberFormatException e) {
                System.out.println("Введите допустимое дробное число (прим.: 2.75)");
            }
        }
    }
}
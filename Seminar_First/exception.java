import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class exception {
    
    public static double[] divideArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Размеры массивов должны быть одинаковыми");
        }

        double[] result = new double[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            result[i] = (double) arr1[i] / arr2[i];
        }

        return result;
    }
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
            int result = a / b;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль: " + e.getMessage());
        }

        int[] arr = { 1, 2, 3 };
        try {
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за границы массива: " + e.getMessage());
        }

        File file = new File("input.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }

        int[] arr1 = {4,5,6,4};
        int[] arr2 = {1,2,3};
        double[] arr3 = divideArrays(arr1, arr2);
    }

}
package Seminar_Third;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        try {
            System.out.print("Введите данные(Фамилия Имя Отчество ДатаРождения Телефон Пол): ");
            String input = scanner.nextLine();

            String[] data = input.split(" ");

            if (data.length != 6) {
                throw new IllegalArgumentException("Введено неверное количество данных");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String dateOfBirthStr = data[3];
            String phoneNumberStr = data[4];
            char gender = data[5].charAt(0);

            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            long phoneNumber = Long.parseLong(phoneNumberStr);

            if (gender != 'm' && gender != 'f') {
                throw new IllegalArgumentException("Введён некорректный пол");
            }

            String filename = lastName + ".txt";
            FileWriter fileWriter = new FileWriter(new File(filename), true);

            StringBuilder sb = new StringBuilder();
            sb.append('<' + lastName + '>').append('<' + firstName + '>').append('<' + middleName + '>');
            sb.append('<' + dateOfBirth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + '>');
            sb.append('<').append(phoneNumber).append('>');
            sb.append('<').append(gender).append('>');
            sb.append("\n");

            fileWriter.write(sb.toString());
            fileWriter.close();

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
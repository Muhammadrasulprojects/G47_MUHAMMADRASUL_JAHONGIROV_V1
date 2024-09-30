package exam.thirdTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PhoneNumberReader {
    public static void main(String[] args) {
        String folderPath = "file";
        String fileName = "PhoneNumbers.txt";
        String filePath = folderPath + File.separator + fileName;

        readPhoneNumbers(filePath);
    }

    public static void readPhoneNumbers(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Fayl topilmadi: " + filePath);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (isValidPhoneNumber(line)) {
                    System.out.println(line);
                } else {
                    System.out.println("Xato formatdagi raqam: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Faylni o'qishda xatolik: " + e.getMessage());
        }
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\+998\\d{2}\\d{7}");
    }
}


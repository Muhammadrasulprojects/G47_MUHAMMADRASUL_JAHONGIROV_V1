package exam.forthTask;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomFileLogger {
    private static final Logger logger = Logger.getLogger(CustomFileLogger.class.getName());

    public static void setup() throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String date = dateFormat.format(new Date());
        String fileName = date + ".log";

        FileHandler fileHandler = new FileHandler(fileName, true);
        fileHandler.setFormatter(new CustomFormatter());

        logger.addHandler(fileHandler);
        logger.setLevel(Level.ALL);
    }

    public static void main(String[] args) {
        try {
            setup();
            logger.info("Bu 'INFO' darajadagi log.");
            logger.warning("Bu 'WARNING' darajadagi log.");
            logger.severe("Bu 'SEVERE' darajadagi log.");

            try {
                throw new Exception("Test exception");
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Exception example", e);
            }

        } catch (IOException e) {
            System.err.println("Log faylini yaratishda xatolik: " + e.getMessage());
        }
    }
}
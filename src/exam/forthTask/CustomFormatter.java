package exam.forthTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder();
        sb.append(dateFormat.format(new Date(record.getMillis())))
                .append(" ")
                .append(record.getLevel().getName())
                .append(" [")
                .append(record.getSourceClassName())
                .append("] ")
                .append(record.getMessage());

        if (record.getThrown() != null) {
            sb.append("\n").append(formatThrowable(record.getThrown()));
        }

        sb.append("\n");
        return sb.toString();
    }

    private String formatThrowable(Throwable throwable) {
        StringBuilder sb = new StringBuilder();
        sb.append(throwable.toString()).append("\n");
        for (StackTraceElement element : throwable.getStackTrace()) {
            sb.append("\tat ").append(element).append("\n");
        }
        return sb.toString();
    }
}

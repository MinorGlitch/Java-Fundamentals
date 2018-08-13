package logger.appenders;

import logger.enums.ReportLevel;
import logger.interfaces.Appender;
import logger.interfaces.Layout;

public class ConsoleAppender implements Appender {
    private Layout layout;
    private ReportLevel threshold;
    private int messagesAppended;

    public ConsoleAppender(Layout layout) {
        this.layout = layout;
    }

    @Override
    public void append(String date, String message, ReportLevel reportLevel) {
        if (reportLevel.ordinal() >= this.threshold.ordinal()) {
            System.out.println(this.layout.format(date, message, reportLevel));
            this.messagesAppended++;
        }

    }

    @Override
    public int checkThreshold(ReportLevel reportLevel) {
        return this.threshold.compareTo(reportLevel);
    }

    @Override
    public void setThreshold(ReportLevel reportLevel) {
        this.threshold = reportLevel;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, " +
                "Layout type: %s, Report level: %s, " +
                "Messages appended: %d",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.threshold.name(),
                this.messagesAppended);
    }
}

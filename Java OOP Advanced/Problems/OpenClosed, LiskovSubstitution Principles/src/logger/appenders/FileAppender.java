package logger.appenders;

import logger.enums.ReportLevel;
import logger.files.LogFile;
import logger.interfaces.Appender;
import logger.interfaces.File;
import logger.interfaces.Layout;

public class FileAppender implements Appender {
    private File file;
    private Layout layout;
    private ReportLevel threshold;
    private int messagesAppended;

    public FileAppender(Layout layout) {
        this.layout = layout;
        this.file = new LogFile();
    }

    @Override
    public void append(String date, String message, ReportLevel reportLevel) {
        if (reportLevel.ordinal() >= this.threshold.ordinal()) {
            String res = this.layout.format(date, message, reportLevel);
            this.file.write(res);
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
                        "Messages appended: %d, File size: %d",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.threshold.name(),
                this.messagesAppended,
                this.file.getSize());
    }

}

package logger;

import logger.enums.ReportLevel;
import logger.interfaces.Appender;
import logger.interfaces.Logger;

import java.util.ArrayList;
import java.util.List;

public class MessageLogger implements Logger {
    private List<Appender> appenders;

    public MessageLogger(List<Appender> appenders) {
        this.appenders = new ArrayList<>(appenders);
    }

    public List<Appender> getAppenders() {
        return appenders;
    }

    private void log(String date, String message, ReportLevel reportLevel) {
        for (Appender appender : appenders) {
            appender.append(date, message, reportLevel);
        }
    }

    @Override
    public void logInfo(String date, String message) {

        this.log(date, message, ReportLevel.INFO);
    }

    @Override
    public void logWarning(String date, String message) {

        this.log(date, message, ReportLevel.WARNING);
    }

    @Override
    public void logError(String date, String message) {

        this.log(date, message, ReportLevel.ERROR);
    }

    @Override
    public void logCritical(String date, String message) {
        this.log(date, message, ReportLevel.CRITICAL);
    }

    @Override
    public void logFatal(String date, String message) {

        this.log(date, message, ReportLevel.FATAL);
    }
}

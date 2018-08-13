package logger.interfaces;

import logger.enums.ReportLevel;

public interface Appender {
    void append(String date, String message, ReportLevel reportLevel);
    int checkThreshold(ReportLevel reportLevel);
    void setThreshold(ReportLevel reportLevel);
}

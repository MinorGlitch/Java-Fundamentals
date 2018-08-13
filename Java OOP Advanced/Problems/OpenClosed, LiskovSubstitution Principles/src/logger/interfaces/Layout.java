package logger.interfaces;

import logger.enums.ReportLevel;

public interface Layout {
    String format(String date, String message, ReportLevel reportLevel);
}

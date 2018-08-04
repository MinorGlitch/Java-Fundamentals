package logger.layouts;

import logger.enums.ReportLevel;
import logger.interfaces.Layout;

public class SimpleLayout implements Layout {
    private String layout;

    public SimpleLayout() {
        this.layout = "%s - %s - %s";
    }

    @Override
    public String format(String date, String message, ReportLevel reportLevel) {
        return String.format(this.layout, date, reportLevel, message);
    }
}

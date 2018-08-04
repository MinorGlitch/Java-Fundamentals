package logger.layouts;

import logger.enums.ReportLevel;
import logger.interfaces.Layout;

public class XmlLayout implements Layout {
    private String format;

    public XmlLayout() {
        this.format = "<log>\n" +
                "\t<date>%s</date>\n" +
                "\t<level>%s</level>\n" +
                "\t<message>%s</message>\n" +
                "</log>";
    }

    @Override
    public String format(String date, String message, ReportLevel reportLevel) {
        return String.format(this.format, date, reportLevel, message);
    }
}

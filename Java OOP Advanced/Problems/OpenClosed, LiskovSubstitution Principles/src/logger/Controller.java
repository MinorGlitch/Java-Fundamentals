package logger;

import logger.enums.ReportLevel;
import logger.interfaces.Appender;
import logger.interfaces.Layout;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Controller {
    private static final String APPENDERS_PATH = "logger.appenders.";
    private static final String LAYOUTS_PATH = "logger.layouts.";
    private Repository repository;

    public Controller() {
    }

    public Repository getRepository() {
        return repository;
    }

    public void createRepository(List<Appender> appenders) {
        this.repository = new Repository(appenders);
    }

    public void readCommand(String line) throws IOException {

        String[] commandArgs = line.split("\\|");

        ReportLevel reportLevel = Enum.valueOf(ReportLevel.class, commandArgs[0]);
        String date = commandArgs[1];
        String message = commandArgs[2];

        switch (reportLevel) {
            case INFO:
                this.repository.getLogger().logInfo(date, message);
                break;
            case WARNING:
                this.repository.getLogger().logWarning(date, message);
                break;
            case ERROR:
                this.repository.getLogger().logError(date, message);
                break;
            case CRITICAL:
                this.repository.getLogger().logCritical(date, message);
                break;
            case FATAL:
                this.repository.getLogger().logFatal(date, message);
                break;
        }
    }

    public Appender parseAppender(String[] commandArgs) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        ReportLevel reportLevel = ReportLevel.INFO;

        if (commandArgs.length == 3) {
            reportLevel = Enum.valueOf(ReportLevel.class, commandArgs[2]);
        }

        Class<?> appender = Class.forName(APPENDERS_PATH + commandArgs[0]);
        Constructor<?> appenderConstructor = appender.getDeclaredConstructor(Layout.class);

        Class<?> layout = Class.forName(LAYOUTS_PATH + commandArgs[1]);
        Constructor layoutConstructor = layout.getDeclaredConstructor();

        Layout finalLayout = (Layout) layoutConstructor.newInstance();

        Appender finalAppender = (Appender) appenderConstructor.newInstance(finalLayout);
        finalAppender.setThreshold(reportLevel);

        return finalAppender;
    }
}

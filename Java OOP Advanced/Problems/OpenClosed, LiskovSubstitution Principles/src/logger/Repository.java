package logger;

import logger.MessageLogger;
import logger.interfaces.Appender;
import logger.interfaces.Logger;

import java.util.List;

public class Repository {
    private Logger logger;

    public Repository() { }

    public Repository(List<Appender> appenders) {
        this.logger = new MessageLogger(appenders);
    }

    public Logger getLogger() {
        return logger;
    }
}

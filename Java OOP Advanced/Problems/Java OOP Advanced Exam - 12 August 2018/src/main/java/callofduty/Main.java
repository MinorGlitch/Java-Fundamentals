package callofduty;

import callofduty.core.MissionControlImpl;
import callofduty.domain.enums.CommandType;
import callofduty.domain.io.InputReaderImpl;
import callofduty.domain.io.OutputWriterImpl;
import callofduty.domain.managers.MissionManagerImpl;
import callofduty.interfaces.InputReader;
import callofduty.interfaces.MissionManager;
import callofduty.interfaces.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new InputReaderImpl();
        OutputWriter writer = new OutputWriterImpl();

        MissionManager manager = new MissionManagerImpl(new MissionControlImpl());

        String line = reader.readLine();

        while (true) {
            List<String> commandArgs = Arrays.stream(line.split(" ")).collect(Collectors.toList());

            CommandType commandType = Enum.valueOf(CommandType.class, commandArgs.get(0).toUpperCase());

            switch (commandType) {
                case AGENT:
                    writer.println(manager.agent(commandArgs.stream().skip(1).collect(Collectors.toList())));
                    break;
                case REQUEST:
                    writer.println(manager.request(commandArgs.stream().skip(1).collect(Collectors.toList())));
                    break;
                case COMPLETE:
                    writer.println(manager.complete(commandArgs.stream().skip(1).collect(Collectors.toList())));
                    break;
                case STATUS:
                    writer.println(manager.status(commandArgs.stream().skip(1).collect(Collectors.toList())));
                    break;
                case OVER:
                    writer.println(manager.over(new ArrayList<>()));
                    return;
            }

            line = reader.readLine();
        }
    }
}





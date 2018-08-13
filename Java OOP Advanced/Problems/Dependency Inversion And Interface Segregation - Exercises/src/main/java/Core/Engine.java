package Core;

import contracts.ICommandHandler;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Engine {
    private ICommandHandler commandHandler;

    public Engine(ICommandHandler commandHandler)
    {
        this.commandHandler = commandHandler;
    }

    public void Run()
    {
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            //TODO

            String line = scanner.nextLine();

            if (line.equals("End")) {
                break;
            }

            List<String> tokens = Arrays.asList(line.split("\\\\"));
            String name = tokens.get(0);
            List<String> parameters = tokens.stream().skip(1).collect(Collectors.toList());

            try
            {
                String commandResult = this.commandHandler.ExecuteCommand(name, parameters);
                System.out.println(commandResult);
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }

}

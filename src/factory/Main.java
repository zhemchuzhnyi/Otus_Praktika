package factory;

import animals.Animal;
import data.CommandsData;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            List<String> namesStr = new ArrayList<>();
            for (CommandsData commandsData: CommandsData.values()) {
                namesStr.add(commandsData.name());
            }


            System.out.println(String.format("Введите клманду: %s", String.join("/", namesStr)));

            String userCommand = scanner.next().trim();
            String userCommandUpperCase = userCommand.toUpperCase();

            boolean isCommandExist = false;
            for (CommandsData commandsData: CommandsData.values()) {
                if(userCommand.equals(commandsData.name())) {
                    isCommandExist = true;
                    break;
                }
            }

            if (!isCommandExist) {
                System.out.printf("Комманда %s не поддерживается\n",userCommand);
                continue;
            }

            switch (CommandsData.valueOf(userCommandUpperCase)) {
                case ADD: {
                    break;
                }
                case LIST: {
                    for (Animal animal: animals) {
                        System.out.println(animal. toString());
                    }
                    break;
                }
                case EXIT: {
                  System.exit(0);
                }
            }
        }
    }
}

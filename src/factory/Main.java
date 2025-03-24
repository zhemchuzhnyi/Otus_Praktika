package factory;

import animals.Animal;
import animals.birds.IFlying;
import data.CommandsData;
import data.AnimalTypeData;
import data.ColorData;
import tools.ToolsValue;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        ToolsValue tools = new ToolsValue();

        while (true) {
            List<String> namesStr = new ArrayList<>();
            for (CommandsData commandsData : CommandsData.values()) {
                namesStr.add(commandsData.name());
            }

            System.out.println(String.format("Введите команду: %s", String.join("/", namesStr)));
            String userCommand = scanner.nextLine().trim();
            CommandsData command = CommandsData.fromString(userCommand);

            if (command == null) {
                System.out.printf("Команда %s не поддерживается\n", userCommand);
                continue;
            }

            switch (command) {
                case ADD: {
                    AnimalTypeData type = getAnimalType(scanner, tools);
                    if (type == null) continue;

                    String name = getName(scanner, tools);
                    if (name == null) continue;

                    int age = getAge(scanner, tools);
                    if (age == -1) continue;

                    int weight = getWeight(scanner, tools);
                    if (weight == -1) continue;

                    ColorData color = getColor(scanner, tools);
                    if (color == null) continue;

                    AnimalFactory factory = new AnimalFactory(name, age, weight, color);
                    Animal animal = factory.create(type);
                    animals.add(animal);
                    animal.say();
                    if (type == AnimalTypeData.DUCK) {
                        ((IFlying) animal).fly();
                    }
                    break;
                }
                case LIST: {
                    for (Animal animal : animals) {
                        System.out.println(animal.toString());
                    }
                    break;
                }
                case EXIT: {
                    System.exit(0);
                }
            }
        }
    }

    private static AnimalTypeData getAnimalType(Scanner scanner, ToolsValue tools) {
        while (true) {
            System.out.println("Какое животное? (cat/dog/duck):");
            String typeInput = scanner.nextLine().trim();
            if (!tools.isAnimalTypeValid(typeInput)) {
                System.out.println("Неверный тип");
                continue;
            }
            return AnimalTypeData.valueOf(typeInput.toUpperCase());
        }
    }

    private static String getName(Scanner scanner, ToolsValue tools) {
        while (true) {
            System.out.println("Введите имя (буквы):");
            String name = scanner.nextLine().trim();
            if (!tools.isNameValid(name)) {
                System.out.println("Имя должно содержать только буквы");
                continue;
            }
            return name;
        }
    }

    private static int getAge(Scanner scanner, ToolsValue tools) {
        while (true) {
            System.out.println("Введите возраст:");
            String ageInput = scanner.nextLine().trim();
            if (!tools.isAgeValid(ageInput)) {
                System.out.println("Возраст должен быть числом от 1 до 99");
                continue;
            }
            return Integer.parseInt(ageInput);
        }
    }

    private static int getWeight(Scanner scanner, ToolsValue tools) {
        while (true) {
            System.out.println("Введите вес:");
            String weightInput = scanner.nextLine().trim();
            if (!tools.isNumber(weightInput)) {
                System.out.println("Вес должен быть числом от 1 до 999");
                continue;
            }
            return Integer.parseInt(weightInput);
        }
    }

    private static ColorData getColor(Scanner scanner, ToolsValue tools) {
        while (true) {
            System.out.println("Введите цвет (Красный/Черный/Белый):");
            String colorInput = scanner.nextLine().trim();
            ColorData color = ColorData.fromString(colorInput);
            if (color == null) {
                System.out.println("Недопустимый цвет");
                continue;
            }
            return color;
        }
    }
}
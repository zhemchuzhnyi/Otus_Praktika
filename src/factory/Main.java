package factory;

import animals.Animal;
import animals.birds.IFlying;
import data.CommandsData;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
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
            for (CommandsData commandsData: CommandsData.values()) {
                namesStr.add(commandsData.name());
            }

            System.out.println(String.format("Введите команду: %s", String.join("/", namesStr)));
            String userCommand = scanner.next().trim();
            String userCommandUpperCase = userCommand.toUpperCase();

            CommandsData command;
            try {
                command = CommandsData.valueOf(userCommandUpperCase);
            } catch (IllegalArgumentException e) {
                System.out.printf("Команда %s не поддерживается\n", userCommand);
                continue;
            }

            switch (command) {
                case ADD: {
                    System.out.println("Какое животное? (cat/dog/duck):");
                    String typeInput = scanner.next().trim();
                    if (!tools.isAnimalTypeValid(typeInput)) {
                        System.out.println("Недопустимый тип");
                        break;
                    }
                    AnimalTypeData type = AnimalTypeData.valueOf(typeInput.toUpperCase());

                    System.out.println("Введите имя (буквы):");
                    String name = scanner.next().trim();
                    if (!tools.isNameValid(name)) {
                        System.out.println("Имя должно содержать только буквы");
                        break;
                    }

                    System.out.println("Введите возраст:");
                    String ageInput = scanner.next().trim();
                    if (!tools.isAgeValid(ageInput)) {
                        System.out.println("Возраст должен быть числом от 1 до 99");
                        break;
                    }
                    int age = Integer.parseInt(ageInput);

                    System.out.println("Введите вес:");
                    String weightInput = scanner.next().trim();
                    if (!tools.isNumber(weightInput)) {
                        System.out.println("Вес должен быть числом от 1 до 999");
                        break;
                    }
                    int weight = Integer.parseInt(weightInput);

                    System.out.println("Введите цвет (Красный/Черный/Белый):");
                    String colorInput = scanner.next().trim();
                    if (!tools.isColorValid(colorInput)) {
                        System.out.println("Недопустимый цвет");
                        break;
                    }
                    ColorData color = ColorData.fromString(colorInput);

                    Animal animal;
                    if (type == AnimalTypeData.CAT) {
                        animal = new Cat(name, age, weight, color);
                    } else if (type == AnimalTypeData.DOG) {
                        animal = new Dog(name, age, weight, color);
                    } else {
                        animal = new Duck(name, age, weight, color);
                        ((IFlying) animal).fly();
                    }
                    animals.add(animal);
                    animal.say();
                    break;
                }
                case LIST: {
                    for (Animal animal: animals) {
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
}
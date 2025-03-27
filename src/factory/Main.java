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

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList animals = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        ToolsValue tools = new ToolsValue();

        while (true) {
            String[] commandNames = new String[CommandsData.values().length];
            CommandsData[] commands = CommandsData.values();
            for (int i = 0; i < commands.length; i++) {
                commandNames[i] = commands[i].name();
            }
            CommandsData command = null;
            while (command == null) {
                System.out.println("Введите команду: " + String.join(" / ", commandNames));
                String userCommand = scanner.next().trim();
                String userCommandUpperCase = userCommand.toUpperCase();
                try {
                    command = CommandsData.valueOf(userCommandUpperCase);
                } catch (IllegalArgumentException e) {
                    System.out.println("Команда " + userCommand + " не поддерживается - выберите команду");
                }
            }

            if (command == CommandsData.ADD) {
                AnimalTypeData type = null;
                while (type == null) {
                    System.out.println("Какое животное? (cat / dog / duck):");
                    String typeInput = scanner.next().trim();
                    if (tools.isAnimalTypeValid(typeInput)) {
                        type = AnimalTypeData.valueOf(typeInput.toUpperCase());
                    } else {
                        System.out.println("Команда не поддерживается - выберите животное");
                    }
                }

                String name = null;
                while (name == null) {
                    System.out.println("Введите имя (буквы):");
                    String nameInput = scanner.next().trim();
                    if (tools.isNameValid(nameInput)) {
                        name = nameInput;
                    } else {
                        System.out.println("Имя должно содержать только буквы - введите имя");
                    }
                }

                int age = -1;
                while (age == -1) {
                    System.out.println("Введите возраст:");
                    String ageInput = scanner.next().trim();
                    if (tools.isAgeValid(ageInput)) {
                        age = Integer.parseInt(ageInput);
                    } else {
                        System.out.println("Возраст должен быть числом от 1 до 99 - введите возраст");
                    }
                }

                int weight = -1;
                while (weight == -1) {
                    System.out.println("Введите вес:");
                    String weightInput = scanner.next().trim();
                    if (tools.isNumber(weightInput)) {
                        weight = Integer.parseInt(weightInput);
                    } else {
                        System.out.println("Вес должен быть числом от 1 до 99 - введите вес");
                    }
                }

                ColorData color = null;
                while (color == null) {
                    System.out.println("Введите цвет (Красный / Черный / Белый):");
                    String colorInput = scanner.next().trim();
                    if (tools.isColorValid(colorInput)) {
                        color = ColorData.fromString(colorInput);
                    } else {
                        System.out.println("Недопустимый цвет - выберите цвет");
                    }
                }

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
                animal.go();
                animal.drink();
                animal.eat();
            } else if (command == CommandsData.LIST) {
                if (animals.isEmpty()) {
                    System.out.println("Список животных пуст");
                } else {
                    for (int i = 0; i < animals.size(); i++) {
                        Animal animal = (Animal) animals.get(i);
                        System.out.println("Имя: " + animal.getName());
                        System.out.println("Возраст: " + animal.getAge());
                        System.out.println("Вес: " + animal.getWeight());
                        System.out.println("Цвет: " + animal.getColor().getName());
                        animal.say();
                        animal.go();
                        animal.drink();
                        animal.eat();
                        if (animal instanceof IFlying) {
                            ((IFlying) animal).fly();
                        }
                        System.out.println(animal.toString());
                        System.out.println("-------------------");
                    }
                }
            } else if (command == CommandsData.EXIT) {
                System.out.println("Программа завершена");
                System.exit(0);
            }
        }
    }
}
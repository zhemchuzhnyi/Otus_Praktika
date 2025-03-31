package main;

import animals.Animal;
import animals.birds.IFlying;
import data.AnimalTypeData;
import data.CommandsData;
import data.ColorData;
import factory.AnimalFactory;
import tools.ToolsValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        ToolsValue tools = new ToolsValue();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду (add / list / exit):");
            String input = scanner.nextLine().trim().toUpperCase();
            CommandsData command = CommandsData.fromString(input);

            if (command == null) {
                System.out.println("Ошибка: Неверная команда.");
                continue;
            }

            switch (command) {
                case ADD:
                    AnimalTypeData type = null;
                    while (type == null) {
                        System.out.println("Какое животное? (cat / dog / duck):");
                        String typeInput = scanner.nextLine().trim();
                        if (tools.isAnimalTypeValid(typeInput)) {
                            type = AnimalTypeData.fromString(typeInput);
                        } else {
                            System.out.println("Неверный тип животного.");
                        }
                    }

                    String name = null;
                    while (name == null) {
                        System.out.println("Введите имя:");
                        String nameInput = scanner.nextLine().trim();
                        if (tools.isNameValid(nameInput)) {
                            name = nameInput;
                        } else {
                            System.out.println("Имя должно содержать только буквы.");
                        }
                    }

                    int age = -1;
                    while (age == -1) {
                        System.out.println("Введите возраст (1-99):");
                        String ageInput = scanner.nextLine().trim();
                        if (tools.isNumber(ageInput)) {
                            age = Integer.parseInt(ageInput);
                        } else {
                            System.out.println("Возраст должен быть числом от 1 до 99.");
                        }
                    }

                    int weight = -1;
                    while (weight == -1) {
                        System.out.println("Введите вес (1-99):");
                        String weightInput = scanner.nextLine().trim();
                        if (tools.isNumber(weightInput)) {
                            weight = Integer.parseInt(weightInput);
                        } else {
                            System.out.println("Вес должен быть числом от 1 до 99.");
                        }
                    }

                    ColorData color = null;
                    while (color == null) {
                        System.out.println("Введите цвет (красный / черный / белый):");
                        String colorInput = scanner.nextLine().trim();
                        if (tools.isColorValid(colorInput)) {
                            color = ColorData.fromString(colorInput.toLowerCase());
                        } else {
                            System.out.println("Недопустимый цвет.");
                        }
                    }

                    AnimalFactory factory = new AnimalFactory(name, age, weight, color);
                    Animal animal = factory.create(type);
                    animals.add(animal);

                    animal.say();
                    animal.go();
                    animal.drink();
                    animal.eat();

                    if (animal instanceof IFlying) {
                        ((IFlying) animal).fly();
                    }
                    break;

                case LIST:
                    if (animals.isEmpty()) {
                        System.out.println("Список животных пуст.");
                    } else {
                        for (Animal a : animals) {
                            System.out.println(a);
                        }
                    }
                    break;

                case EXIT:
                    System.out.println("Программа завершена.");
                    return
            }
        }
    }
}
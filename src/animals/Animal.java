package animals;

import data.ColorData;

public abstract class Animal {
    private String name;
    private int age;
    private int weight;
    private ColorData color;

    public Animal(String name, int age, int weight, ColorData color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public ColorData getColor() {
        return color;
    }

    public abstract void say();

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        return "Привет! Меня зовут " + getName() + ", мне " + getAge() + " " + getYearCase() +
                ", я вешу - " + getWeight() + " кг, мой цвет - " + getColor().getName();
    }

    private String getYearCase() {
        if (age >= 11 && age <= 14) return "лет";
        int remains = age % 10;
        if (remains == 1) return "год";
        if (remains >= 2 && remains <= 4) return "года";
        return "лет";
    }
}
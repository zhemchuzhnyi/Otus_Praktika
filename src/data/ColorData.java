package data;

public enum  ColorData {
    RED("Красный");

    private String name;

    ColorData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}

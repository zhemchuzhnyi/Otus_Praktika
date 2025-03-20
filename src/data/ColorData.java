package data;

public enum ColorData {
    RED("Красный"),
    BLACK("Черный"),
    WHITE("Белый");

    private String name;

    ColorData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ColorData fromString(String text) {
        if (text == null) {
            return null;
        }
        String trimmedText = text.trim();
        if (trimmedText.equalsIgnoreCase("Красный")) {
            return RED;
        }
        if (trimmedText.equalsIgnoreCase("Черный")) {
            return BLACK;
        }
        if (trimmedText.equalsIgnoreCase("Белый")) {
            return WHITE;
        }
        return null;
    }
}
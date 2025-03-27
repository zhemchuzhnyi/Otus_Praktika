package data;

public enum ColorData {
    RED("красный"), BLACK("черный"), WHITE("белый");

    private final String name;

    ColorData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ColorData fromString(String text) {
        if (text == null) return null;
        String trimmedText = text.trim().toLowerCase();
        for (ColorData color : values()) {
            if (trimmedText.equals(color.getName())) {
                return color;
            }
        }
        return null;
    }
}
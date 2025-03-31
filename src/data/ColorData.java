package data;

public enum ColorData {
    RED("красный"), BLACK("черный"), WHITE("белый");

    private final String value;

    ColorData(String name) {
        this.value = name;
    }

    public String getValue() {
        return value;
    }

    public static ColorData fromString(String text) {
        if (text == null) return null;
        String trimmedText = text.trim().toLowerCase();
        for (ColorData color : values()) {
            if (trimmedText.equals(color.getValue())) {
                return color;
            }
        }
        return null;
    }
}
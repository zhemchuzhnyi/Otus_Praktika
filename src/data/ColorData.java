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
        for (ColorData colorData : ColorData.values()) {
            if (trimmedText.equalsIgnoreCase(colorData.getName())) {
                return colorData;
            }
        }
        return null;
    }
}
package data;

public enum AnimalTypeData {
    CAT("cat"), DOG("dog"), DUCK("duck");

    private final String value;

    AnimalTypeData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AnimalTypeData fromString(String text) {
        if (text == null) return null;
        String trimmedText = text.trim().toLowerCase();
        for (AnimalTypeData type : values()) {
            if (trimmedText.equals(type.getValue())) {
                return type;
            }
        }
        return null;
    }
}
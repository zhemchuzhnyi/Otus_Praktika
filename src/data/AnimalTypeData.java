package data;

public enum AnimalTypeData {
    CAT("Cat"),
    DOG("Dog"),
    DUCK("Duck");

    private String value;

    AnimalTypeData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AnimalTypeData fromString(String text) {
        if (text == null) {
            return null;
        }
        String trimmedText = text.trim();
        if (trimmedText.equalsIgnoreCase(CAT.getValue())) {
            return CAT;
        }
        if (trimmedText.equalsIgnoreCase(DOG.getValue())) {
            return DOG;
        }
        if (trimmedText.equalsIgnoreCase(DUCK.getValue())) {
            return DUCK;
        }
        return null;
    }
}
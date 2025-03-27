package tools;

public class ToolsValue {
    // Проверка числа (1-99)
    public boolean isNumber(String numberStr) {
        if (numberStr == null) return false;
        try {
            int num = Integer.parseInt(numberStr.trim());
            return num >= 1 && num <= 99;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Проверка имени (только буквы)
    public boolean isNameValid(String nameStr) {
        if (nameStr == null) return false;
        String trimmedName = nameStr.trim();
        for (int i = 0; i < trimmedName.length(); i++) {
            char c = trimmedName.charAt(i);
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    // Проверка типа животного (cat/dog/duck)
    public boolean isAnimalTypeValid(String typeStr) {
        if (typeStr == null) return false;
        String trimmedText = typeStr.trim().toLowerCase();
        return trimmedText.equals("cat") || trimmedText.equals("dog") || trimmedText.equals("duck");
    }

    // Проверка цвета (красный/черный/белый)
    public boolean isColorValid(String colorStr) {
        if (colorStr == null) return false;
        String trimmedText = colorStr.trim().toLowerCase();
        return trimmedText.equals("красный") || trimmedText.equals("черный") || trimmedText.equals("белый");
    }
}
package tools;

public class ToolsValue {
    public boolean isNumber(String numberStr) {
        if (numberStr == null) return false;
        try {
            int num = Integer.parseInt(numberStr.trim());
            return num >= 1 && num <= 99;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isNameValid(String nameStr) {
        if (nameStr == null || nameStr.trim().isEmpty()) return false;
        String trimmedName = nameStr.trim();
        for (int i = 0; i < trimmedName.length(); i++) {
            char c = trimmedName.charAt(i);
            if (!Character.isLetter(c)) return false;
        }
        return true;
    }

    public boolean isAnimalTypeValid(String typeStr) {
        return data.AnimalTypeData.fromString(typeStr) != null;
    }

    public boolean isColorValid(String colorStr) {
        return data.ColorData.fromString(colorStr) != null;
    }
}
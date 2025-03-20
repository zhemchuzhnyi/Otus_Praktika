package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToolsValue {
    // Проверка на число (вес: 1-99)
    public boolean isNumber(String numberStr) {
        if (numberStr == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[1-9][0-9]\\d?$");
        Matcher matcher = pattern.matcher(numberStr.trim());
        return matcher.matches();
    }

    // Проверка возраста (1-99)
    public boolean isAgeValid(String ageStr) {
        if (ageStr == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[1-9][0-9]\\d?$");
        Matcher matcher = pattern.matcher(ageStr.trim());
        return matcher.matches();
    }

    // Проверка имени (только буквы)
    public boolean isNameValid(String nameStr) {
        if (nameStr == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]+$");
        Matcher matcher = pattern.matcher(nameStr.trim());
        return matcher.matches();
    }

    // Проверка типа животного (cat/dog/duck)
    public boolean isAnimalTypeValid(String typeStr) {
        if (typeStr == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(cat|dog|duck)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(typeStr.trim());
        return matcher.matches();
    }

    // Проверка цвета (Красный/Черный/Белый)
    public boolean isColorValid(String colorStr) {
        if (colorStr == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(Красный|Черный|Белый)$");
        Matcher matcher = pattern.matcher(colorStr.trim());
        return matcher.matches();
    }
}
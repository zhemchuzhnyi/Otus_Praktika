package data;

public enum CommandsData {
    ADD, LIST, EXIT;

    public static CommandsData fromString(String text) {
        if (text == null) {
            return null;
        }
        String trimmedText = text.trim().toUpperCase();
        if (trimmedText.equals("ADD")) {
            return ADD;
        }
        if (trimmedText.equals("LIST")) {
            return LIST;
        }
        if (trimmedText.equals("EXIT")) {
            return EXIT;
        }
        return null;
    }
}
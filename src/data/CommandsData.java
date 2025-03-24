package data;

public enum CommandsData {
    ADD, LIST, EXIT;

    public static CommandsData fromString(String text) {
        if (text == null) {
            return null;
        }
        String trimmedText = text.trim().toUpperCase();
        for (CommandsData command : CommandsData.values()) {
            if (trimmedText.equals(command.name())) {
                return command;
            }
        }
        return null;
    }
}
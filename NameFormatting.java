public class NameFormatting {
    public static String formatName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            return ""; 
        }

        String[] words = fullName.trim().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = capitalizeString(words[i]);
        }
        return String.join(" ", words);
    }

    public static String capitalizeString(String str) {
        if (str == null || str.isEmpty()) {
            return str; 
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}

package threads;

public enum TextColor {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m");

    private static final TextColor[] TEXT_COLORS = {
            RESET, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN
    };

    private final String ansii;

    TextColor(String ansii) {
        this.ansii = ansii;
    }

    public static String getColorString(int number) {
        int index = number % TEXT_COLORS.length;
        return TEXT_COLORS[index].getANSII();
    }

    public String getANSII() {
        return ansii;
    }
}

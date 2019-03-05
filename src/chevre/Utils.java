package chevre;

import java.util.*;

/**
 * A class that provides some useful utilities for implementing the Club
 * Chevre simulation.
 */
public class Utils {
    /**
     * A random number generator.
     */
    private static final Random RNG = new Random();

    /**
     * A collection of common goat first names.
     */
    private static final String[] FIRST_NAMES = {
            "Goaty", "Goat", "Brad", "Charlie", "Karen", "Bleaty", "Bleats",
            "Beauregard", "Joseph", "Harold", "Jessica", "Brynn", "Dave",
            "Rob", "Janet", "Allison", "Jim", "Randall", "Goatbert", "Tippy"
    };

    /**
     * A collection of common goat last names.
     */
    private static final String[] LAST_NAMES = {
        "McGoatface", "Bleaterson", "Bleater", "Bahramewe", "Johnson",
        "Sharma", "Goatson", "McGoat", "O'Goater", "Farmington", "Winthorpe",
        "Spiner", "Stewart", "McBleater", "Wilson", "Fisher", "Harrison",
        "Peterson", "Smith", "Reynolds"
    };

    /**
     * A collection of common goat suffixes.
     */
    private static final String[] SUFFIXES = {
            "Esq.", "Jr.", "Sr.", "III", "IV"
    };

    /**
     * Returns
     * @param min
     * @param max
     * @return
     */
    public static int getRandomNumber(int min, int max) {
        return RNG.nextInt(max - min) + min + 1;
    }

    /**
     * Makes and returns a random goat name.
     *
     * @return A randomly generated goat name.
     */
    public static String makeGoatName() {
        String name = FIRST_NAMES[RNG.nextInt(FIRST_NAMES.length)];
        String last = " " + LAST_NAMES[RNG.nextInt(LAST_NAMES.length)];

        double suffixChance = 0.10d;

        if(RNG.nextDouble() < 0.25d) {
            char middleInitial = (char)(RNG.nextInt(25) + 65);
            name += " " + middleInitial + ".";
            suffixChance = 0.75d;

        }

        name += " " + LAST_NAMES[RNG.nextInt(LAST_NAMES.length)];

        if(RNG.nextDouble() < suffixChance) {
            name += " " + SUFFIXES[RNG.nextInt(SUFFIXES.length)];
        }


        return name;
    }
}

/**
 * The Validation class provides methods for validating strings.
 *
 * @author Pei-Jiun Chuang
 * @version ver1.0.0
 */
public class Validation
{
    /**
     * Default constructor for the Validation class.
     */
    public Validation()
    {

    }

    /**
     * Check if a string contains spaces.
     *
     * @param input    The input string to check.
     * @return         True if the string contains spaces, false otherwise.
     */
    public static boolean hasSpace(String input)
    {
        input = input.trim();
        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) == ' ')
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if a string is blank (contains only whitespace).
     *
     * @param input    The input string to check.
     * @return         True if the string is blank, false otherwise.
     */
    public static boolean isBlank(String input)
    {
        input = input.trim();
        if (input.equals(""))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Check if the length of a string is within a specified range.
     *
     * @param input        The input string to check.
     * @param maxLength    The maximum allowed length.
     * @param minLength    The minimum allowed length.
     * @return             True if the string length is within the specified range, false otherwise.
     */
    public static boolean stringLengthInRange(String input, int maxLength, int minLength)
    {
        input = input.trim();
        if (input.length() <= maxLength && input.length() >= minLength)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Check if a string contains only alphabetic characters.
     *
     * @param input    The input string to check.
     * @return         True if the string contains only alphabetic characters, false otherwise.
     */
    public static boolean validateAlphabet(String input)
    {
        input = input.trim();
        for (char c : input.toCharArray())
        {
            if (!Character.isLetter(c))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Validate the format of an input string as a four-character ID starting with 'P' followed by three digits.
     *
     * @param input    A string to be validated as an ID.
     * @return         A boolean indicating whether the input string is a valid ID (true) or not (false).
     */
    public static boolean isValidID(String input)
    {
        input = input.trim();
        if (input.length() != 4)
        {
            return false;
        }
        char firstChar = input.charAt(0);
        if (firstChar != 'P')
        {
            return false;
        }
        for (int i = 1; i < 4; i++)
        {
            char currentChar = input.charAt(i);
            if (!Character.isDigit(currentChar))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Validate whether the input string can be parsed to an integer within the specified range.
     *
     * @param input     The string to be validated as an integer.
     * @param minInt    The minimum value the integer can take (inclusive).
     * @param maxInt    The maximum value the integer can take (inclusive).
     * @return          True if the input is a valid integer within the given range, false otherwise.
     */
    public static boolean validateIntegerInRange(String input, int minInt, int maxInt)
    {
        input = input.trim();
        for (int i = 0; i < input.length(); i++)
        {
            char currentChar = input.charAt(i);
            if (!Character.isDigit(currentChar))
            {
                return false;
            }
        }
        int validateInput = Integer.parseInt(input);
        if (validateInput < minInt || validateInput > maxInt)
        {
            return false;
        }
        return true;
    }
}
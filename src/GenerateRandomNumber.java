/**
 * The GenerateRandomNumber class provides methods to generate random integers within a specified range.
 *
 * @author Pei-Jiun Chuang
 * @version ver1.0.0
 */

public class GenerateRandomNumber
{
    /**
     * Default constructor for the GenerateRandomNumber class.
     */
    public GenerateRandomNumber()
    {

    }

    /**
     * Generate and return a random integer within the specified range.
     *
     * @param minimumNumber    The minimum value for the generated random number (inclusive).
     * @param maximumNumber    The maximum value for the generated random number (inclusive).
     * @return                 A random integer within the specified range.
     */
    public int generateRandomNumber(int minimumNumber, int maximumNumber)
    {
        double random1 = Math.random();
        double random2 = random1 * (maximumNumber - minimumNumber + 1);
        int random3 = (int)(random2);
        int random4 = random3 + minimumNumber;
        return random4;
    }
}

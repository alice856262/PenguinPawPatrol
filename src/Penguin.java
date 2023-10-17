/**
 * The Penguin class, which extends the Animal class, represents a penguin that has a gender attribute.
 *
 * @author Pei-Jiun Chuang
 * @version ver1.0.0
 */

import java.util.ArrayList;

public class Penguin extends Animal
{
    private char gender;

    /**
     * Default constructor for the Penguin class. Initialises a penguin instance with default values.
     */
    public Penguin()
    {
        super(true);
        this.gender = 'M';
    }

    /**
     * Non-default constructor for the Penguin class.
     *
     * @param alive     Indicates whether the penguin is alive.
     * @param gender    The gender of the penguin.
     */
    public Penguin(boolean alive, char gender)
    {
        super(alive);
        this.gender = gender;
    }

    /**
     * Implementation of the attack method in the Animal class. Penguins do not have attack behavior.
     *
     * @param dogNumber            The dog's number, affecting the attack probability.
     * @param penguinFamilyList    A list of penguin families in the simulation.
     * @param animalLists          Lists of animals used in the simulation.
     * @return                     An empty array since penguins do not have a meaningful attack behavior.
     */
    @Override
    public int[] attack(int dogNumber, ArrayList<PenguinFamily> penguinFamilyList, ArrayList<Animal>... animalLists)
    {
        // This method intentionally does nothing.
        return new int[0];
    }

    /**
     * Accessor method to get the gender of the penguin.
     *
     * @return    The gender of the penguin.
     */
    public char getGender()
    {
        return gender;
    }

    /**
     * Mutator method to set the gender of the penguin.
     *
     * @param gender    The new gender of the penguin.
     */
    public void setGender(char gender)
    {
        this.gender = gender;
    }

    /**
     * Generate a string representation of the penguin object, including its alive status and gender.
     *
     * @return    A string representation of the penguin object, indicating whether it is alive and its gender.
     */
    public String toString()
    {
        return "alive status: " + isAlive() + "; gender: " + gender;
    }
}


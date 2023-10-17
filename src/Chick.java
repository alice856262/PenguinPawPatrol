/**
 * The Chick class, which extends the Animal class, represents a chick that has an age attribute.
 *
 * @author Pei-Jiun Chuang
 * @version ver1.0.0
 */

import java.util.ArrayList;

public class Chick extends Animal
{
    private int age;

    /**
     * Default constructor for the Chick class. Initialises a chick instance with default values.
     */
    public Chick()
    {
        super(true);
        age = 0;
    }

    /**
     * Non-default constructor for the Chick class.
     *
     * @param alive    Indicates whether the chick is alive.
     * @param age      The age of the chick.
     */
    public Chick(boolean alive, int age)
    {
        super(alive);
        this.age = age;
    }

    /**
     * Implementation of the attack method in the Animal class. Chicks do not have attack behavior.
     *
     * @param dogNumber            The dog's number, affecting the attack probability.
     * @param penguinFamilyList    A list of penguin families in the simulation.
     * @param animalLists          Lists of animals used in the simulation.
     * @return                     An empty array since chicks do not have a meaningful attack behavior.
     */
    @Override
    public int[] attack(int dogNumber, ArrayList<PenguinFamily> penguinFamilyList, ArrayList<Animal>... animalLists)
    {
        // This method intentionally does nothing.
        return new int[0];
    }

    /**
     * Accessor method to get the age of the chick.
     *
     * @return    The age of the chick.
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Increases the age of the chick by 1.
     */
    public void increaseAge()
    {
        age += 1;
    }

    /**
     * Mutator method to set the age of the chick to a specified value.
     *
     * @param age    The new age of the chick.
     */
    public void setAge(int age)
    {
        this.age = age;
    }

    /**
     * Generate a string representation of the chick object, including its alive status and age.
     *
     * @return    A string representation of the chick object, indicating whether it is alive and its age.
     */
    public String toString()
    {
        return "alive status: " + isAlive() + "; age: " + age;
    }
}

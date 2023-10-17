/**
 * The Egg class, which extends the Animal class, represents an egg that has an age attribute and a status whether it has hatched or not.
 *
 * @author Pei-Jiun Chuang
 * @version ver1.0.0
 */

import java.util.ArrayList;

public class Egg extends Animal
{
    private int age;
    private boolean isHatched;

    /**
     * Default constructor for the Egg class. Initialises an egg instance with default values.
     */
    public Egg()
    {
        super(true);
        age = 0;
        isHatched = false;
    }

    /**
     * Non-default constructor for the Egg class.
     *
     * @param alive        Indicates whether the egg is alive.
     * @param age          The age of the egg.
     * @param isHatched    Indicates whether the egg has hatched or not.
     */
    public Egg(boolean alive, int age, boolean isHatched)
    {
        super(alive);
        this.age = age;
        this.isHatched = isHatched;
    }

    /**
     * Implementation of the attack method in the Animal class. Eggs do not have attack behavior.
     *
     * @param dogNumber            The dog's number, affecting the attack probability.
     * @param penguinFamilyList    A list of penguin families in the simulation.
     * @param animalLists          Lists of animals used in the simulation.
     * @return                     An empty array since eggs do not have a meaningful attack behavior.
     */
    @Override
    public int[] attack(int dogNumber, ArrayList<PenguinFamily> penguinFamilyList, ArrayList<Animal>... animalLists)
    {
        // This method intentionally does nothing.
        return new int[0];
    }

    /**
     * Accessor method to get the age of the egg.
     *
     * @return    The age of the egg.
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Attempt to hatch the egg based on age and probability.
     *
     * @return    Return true if the egg hatches, false if it remains unhatched.
     */
    public boolean hatch()
    {
        if ((!isHatched) && (age == 1))
        {
            GenerateRandomNumber randomNumber = new GenerateRandomNumber();
            int probability = randomNumber.generateRandomNumber(1, 10);
            if (probability <= 7)
            {
                isHatched = true;
                super.setAlive(false);
            }
            else
            {
                super.setAlive(false);
            }
        }
        return isHatched;
    }

    /**
     * Accessor method to get the status whether the egg has hatched or not.
     *
     * @return    Return true if the egg has hatched, false if it remains unhatched.
     */
    public boolean isHatched()
    {
        return isHatched;
    }

    /**
     * Increases the age of the egg by 1.
     */
    public void increaseAge()
    {
        age += 1;
    }

    /**
     * Mutator method to set the age of the egg to a specified value.
     *
     * @param age    The new age of the egg.
     */
    public void setAge(int age)
    {
        this.age = age;
    }

    /**
     * Mutator method to set the hatched status of the egg.
     *
     * @param isHatched    The hatched status to set.
     */
    public void setHatched(boolean isHatched)
    {
        this.isHatched = isHatched;
    }

    /**
     * Generate a string representation of the egg object, including its alive status, age, and hatched status.
     *
     * @return    A string representation of the egg object, indicating its alive status, age, and hatched status.
     */
    public String toString()
    {
        return "alive status: " + isAlive() + "; age: " + age + "; already hatched: " + isHatched();
    }
}

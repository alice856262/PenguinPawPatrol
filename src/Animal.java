/**
 * The abstract base class for animals, which represents basic properties and behaviors of animals.
 *
 * @author Pei-Jiun Chuang
 * @version ver1.0.0
 */

import java.util.ArrayList;

public abstract class Animal
{
    private boolean alive;

    /**
     * Default constructor for the Animal class, initializes the animal as alive.
     */
    public Animal()
    {
        alive = true;
    }

    /**
     * Non-default constructor for the Animal class that allows specifying the initial life status.
     *
     * @param alive    The initial life status of the animal.
     */
    public Animal(boolean alive)
    {
        this.alive = alive;
    }

    /**
     * Abstract method for performing an attack.
     *
     * @param dogNumber            The identification number of the attacking dog.
     * @param penguinFamilyList    A list of penguin families.
     * @param animalLists          An array of Animal lists.
     * @return An array of integers representing the result of the attack.
     */
    // Abstract methods are declared without an implementation in the abstract class. Subclasses of the abstract class must provide concrete implementations for these abstract methods.
    // However, it would be difficult to implement attack() here, so an abstract method is used.
    abstract public int[] attack(int dogNumber, ArrayList<PenguinFamily> penguinFamilyList, ArrayList<Animal>... animalLists);

    /**
     * Accessor method to get the current life status of the animal.
     *
     * @return    True if the animal is alive, false if it is not.
     */
    public boolean isAlive()
    {
        return alive;
    }

    /**
     * Mutator method to set the life status of the animal.
     *
     * @param alive    The new life status of the animal.
     */
    public void setAlive(boolean alive)
    {
        this.alive = alive;
    }

    /**
     * Generate a string representation of the animal, including its life status.
     *
     * @return    A string containing the animal's alive status.
     */
    public String toString()
    {
        return " alive status: " + alive;
    }
}

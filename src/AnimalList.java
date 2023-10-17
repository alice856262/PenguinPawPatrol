/**
 * The AnimalList class represents a collection of various animal lists, and can be initialized with specified numbers of each animal type.
 *
 * @author Pei-Jiun Chuang
 * @version ver1.0.0
 */

import java.util.ArrayList;

public class AnimalList
{
    private ArrayList<Animal> dogList;
    private ArrayList<PenguinFamily> penguinFamilyList;
    private ArrayList<Animal> foxList;
    private ArrayList<Animal> catList;
    private ArrayList<Animal> sharkList;

    /**
     * Default constructor that initializes empty lists for each animal type.
     */
    public AnimalList()
    {
        dogList = new ArrayList<>();
        penguinFamilyList = new ArrayList<>();
        foxList = new ArrayList<>();
        catList = new ArrayList<>();
        sharkList = new ArrayList<>();
    }

    /**
     * Non-default constructor that allows initializing the animal lists with custom ArrayLists.
     *
     * @param dogList              List of dogs.
     * @param penguinFamilyList    List of penguin families.
     * @param foxList              List of foxes.
     * @param catList              List of cats.
     * @param sharkList            List of sharks.
     */
    public AnimalList(ArrayList<Animal> dogList, ArrayList<PenguinFamily> penguinFamilyList, ArrayList<Animal> foxList, ArrayList<Animal> catList, ArrayList<Animal> sharkList)
    {
        this.dogList = dogList;
        this.penguinFamilyList = penguinFamilyList;
        this.foxList = foxList;
        this.catList = catList;
        this.sharkList = sharkList;
    }

    /**
     * Constructor that allows initializing the animal lists with specified numbers of each animal type.
     *
     * @param numberAnimal    An integer array containing the numbers of each animal type.
     * @param dogNumber       The number of dogs to create.
     */
    public AnimalList(int[] numberAnimal, int dogNumber)
    {
        dogList = new ArrayList<>();
        for (int i = 0; i < dogNumber; i++)
        {
            Dog dog = new Dog();
            dogList.add(dog);
        }
        penguinFamilyList = new ArrayList<>();
        for (int i = 0; i < numberAnimal[0]; i++)
        {
            PenguinFamily penguinFamily = new PenguinFamily();
            penguinFamily.setUniqueID("P" + String.format("%03d", penguinFamily.increaseID(i)));
            penguinFamilyList.add(penguinFamily);
        }
        foxList = new ArrayList<>();
        for (int i = 0; i < numberAnimal[1]; i++)
        {
            Fox fox = new Fox();
            foxList.add(fox);
        }
        catList = new ArrayList<>();
        for (int i = 0; i < numberAnimal[2]; i++)
        {
            Cat cat = new Cat();
            catList.add(cat);
        }
        sharkList = new ArrayList<>();
        for (int i = 0; i < numberAnimal[3]; i++)
        {
            Shark shark = new Shark();
            sharkList.add(shark);
        }
    }

    /**
     * Accessor method to get the list of dogs.
     *
     * @return    The list of dogs.
     */
    public ArrayList<Animal> getDogList()
    {
        return dogList;
    }

    /**
     * Accessor method to get the list of penguin families.
     *
     * @return    The list of penguin families.
     */
    public ArrayList<PenguinFamily> getPenguinFamilyList()
    {
        return penguinFamilyList;
    }

    /**
     * Accessor method to get the list of foxes.
     *
     * @return    The list of foxes.
     */
    public ArrayList<Animal> getFoxList()
    {
        return foxList;
    }

    /**
     * Accessor method to get the list of cats.
     *
     * @return    The list of cats.
     */
    public ArrayList<Animal> getCatList()
    {
        return catList;
    }

    /**
     * Accessor method to get the list of sharks.
     *
     * @return    The list of sharks.
     */
    public ArrayList<Animal> getSharkList()
    {
        return sharkList;
    }

    /**
     * Mutator method to set the list of dogs.
     *
     * @param dogList    The list of dogs to be set.
     */
    public void setDogList(ArrayList<Animal> dogList)
    {
        this.dogList = dogList;
    }

    /**
     * Mutator method to set the list of penguin families.
     *
     * @param penguinFamilyList    The list of penguin families to be set.
     */
    public void setPenguinFamilyList(ArrayList<PenguinFamily> penguinFamilyList)
    {
        this.penguinFamilyList = penguinFamilyList;
    }

    /**
     * Mutator method to set the list of foxes.
     *
     * @param foxList    The list of foxes to be set.
     */
    public void setFoxList(ArrayList<Animal> foxList)
    {
        this.foxList = foxList;
    }

    /**
     * Mutator method to set the list of cats.
     *
     * @param catList    The list of cats to be set.
     */
    public void setCatList(ArrayList<Animal> catList)
    {
        this.catList = catList;
    }

    /**
     * Mutator method to set the list of sharks.
     *
     * @param sharkList    The list of sharks to be set.
     */
    public void setSharkList(ArrayList<Animal> sharkList)
    {
        this.sharkList = sharkList;
    }

    /**
     * Generate a string representation of the `AnimalList` object.
     *
     * @return    A string containing information about the dog list, penguin family list, fox list, cat list, and shark list.
     */
    public String toString()
    {
        return "Dog list = " + dogList + "; penguin family list = " + penguinFamilyList + "; fox list = " + foxList +
                "; cat list = " + catList + "; shark list = " + sharkList;
    }
}

/**
 * The Dog class, which extends the Animal class, represents a dog that can attack foxes and cats. It also keeps track of the number of each type of animal killed.
 *
 * @author Pei-Jiun Chuang
 * @version ver1.0.0
 */

import java.util.ArrayList;

public class Dog extends Animal
{
    private int[] numberDogKilled;

    /**
     * Default constructor for the Dog class. Creates a dog instance with default values.
     */
    public Dog()
    {
        super(true);
        numberDogKilled = new int[2];    // [0]: fox, [1]: cat
    }

    /**
     * Non-default constructor for the Dog class.
     *
     * @param alive              Indicates whether the dog is alive.
     * @param numberDogKilled    An array representing the number of foxes and cats killed by the dog.
     */
    public Dog(boolean alive, int[] numberDogKilled)
    {
        super(alive);
        this.numberDogKilled = numberDogKilled;
    }

    /**
     * Overrides the attack method in the Animal class to simulate the dog's attack behavior.
     *
     * @param dogNumber            The dog's number, affecting the attack probability.
     * @param penguinFamilyList    A list of penguin families in the simulation.
     * @param animalLists          Lists of animals used in the simulation.
     * @return                     An array representing the number of each type of animal killed.
     */
    // Dog attack fox & cat
    @Override
    public int[] attack(int dogNumber, ArrayList<PenguinFamily> penguinFamilyList, ArrayList<Animal>... animalLists)
    {
        for (ArrayList<Animal> animalList : animalLists)
        {
            for (Animal animal : animalList)
            {
                GenerateRandomNumber randomNumber = new GenerateRandomNumber();
                int probability = randomNumber.generateRandomNumber(1, 100);
                if (animal instanceof Fox)
                {
                    if (animal.isAlive() && (dogNumber == 1) && (probability == 1))
                    {
                        animal.setAlive(false);
                        numberDogKilled[0] += 1;
                    }
                    else if (animal.isAlive() && (dogNumber == 2) && (probability <= 10))
                    {
                        animal.setAlive(false);
                        numberDogKilled[0] += 1;
                    }
                }
                else if (animal instanceof Cat)
                {
                    if (animal.isAlive() && (dogNumber == 1) && (probability == 1))
                    {
                        animal.setAlive(false);
                        numberDogKilled[1] += 1;
                    }
                    else if (animal.isAlive() && (dogNumber == 2) && (probability <= 10))
                    {
                        animal.setAlive(false);
                        numberDogKilled[1] += 1;
                    }
                }
            }
        }
        return numberDogKilled;
    }

    /**
     * Accessor method to get the number of each type of animal killed by the dog.
     *
     * @return    An array representing the number of each type of animal killed.
     */
    public int[] getNumberDogKilled()
    {
        return numberDogKilled;
    }

    /**
     * Mutator method to set the number of each type of animal killed by the dog.
     *
     * @param numberDogKilled    An array representing the number of each type of animal killed.
     */
    public void setNumberDogKilled(int[] numberDogKilled)
    {
        this.numberDogKilled = numberDogKilled;
    }

    /**
     * Generate a string representation of the dog object, including the number of each type of animal killed.
     *
     * @return    A string representation of the dog object.
     */
    public String toString()
    {
        return "Dog killed:" + numberDogKilled[0] + "fox," + numberDogKilled[1] + "cat";
    }
}

//                if (animal instanceof Shark) {
//                    continue;
//                }
//                if (!animal.isAlive()) {
//                    continue;
//                }
//                boolean attackSuccess = false;
//                if (attackSuccess) {
//                    animal.setAlive(false);
//                }



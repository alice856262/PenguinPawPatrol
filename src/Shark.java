/**
 * The Shark class, which extends the Animal class, represents a shark that can attack penguins. It also keeps track of the number of each type of animal killed.
 *
 * @author Pei-Jiun Chuang
 * @version ver1.0.0
 */

import java.util.ArrayList;

public class Shark extends Animal
{
    private int[] numberSharkKilled;

    /**
     * Default constructor for the Shark class. Creates a shark instance with default values.
     */
    public Shark()
    {
        super(true);
        numberSharkKilled = new int[2];    // [0]: malePenguin, [1]: femalePenguin
    }

    /**
     * Non-default constructor for the Shark class.
     *
     * @param alive                Indicates whether the shark is alive.
     * @param numberSharkKilled    An array representing the number of each type of animal killed.
     */
    public Shark(boolean alive, int[] numberSharkKilled)
    {
        super(alive);
        this.numberSharkKilled = numberSharkKilled;
    }

    /**
     * Overrides the attack method in the Animal class to simulate the shark's attack behavior.
     *
     * @param dogNumber            The dog's number, affecting the attack probability.
     * @param penguinFamilyList    A list of penguin families in the simulation.
     * @param animalLists          Lists of animals used in the simulation.
     * @return                     An array representing the number of each type of animal killed.
     */
    // Shark attack penguin
    @Override
    public int[] attack(int dogNumber, ArrayList<PenguinFamily> penguinFamilyList, ArrayList<Animal>... animalLists)
    {
        for (PenguinFamily penguinFamily : penguinFamilyList)
        {
            GenerateRandomNumber randomNumber = new GenerateRandomNumber();

            // Kill male penguin
            int probability = randomNumber.generateRandomNumber(1, 100 * 5);
            sharkKillAnimals(penguinFamily.getMalePenguin(), probability, 0);

            // Kill female penguin
            probability = randomNumber.generateRandomNumber(1, 100 * 5);
            sharkKillAnimals(penguinFamily.getFemalePenguin(), probability, 1);
        }
        return numberSharkKilled;
    }

    /**
     * Accessor method to get the number of each type of animal killed by the shark.
     *
     * @return    An array representing the number of each type of animal killed.
     */
    public int[] getNumberSharkKilled()
    {
        return numberSharkKilled;
    }

    /**
     * Mutator method to set the number of each type of animal killed by the shark.
     *
     * @param numberSharkKilled    An array representing the number of each type of animal killed.
     */
    public void setNumberSharkKilled(int[] numberSharkKilled)
    {
        this.numberSharkKilled = numberSharkKilled;
    }

    /**
     * Simulates the shark's attack on a specific animal and updates the number of animals killed.
     *
     * @param animal         The target animal to be attacked.
     * @param probability    The attack probability.
     * @param index          The index of the animal type in the numberSharkKilled array.
     */
    public void sharkKillAnimals(Animal animal, int probability, int index)
    {
        if ((animal.isAlive()) && (probability <= 2))
        {
            animal.setAlive(false);
            numberSharkKilled[index] += 1;
        }
    }

    /**
     * Generate a string representation of the shark object, including the number of each type of animal killed.
     *
     * @return    A string representation of the shark object.
     */
    public String toString()
    {
        return "Shark killed:" + numberSharkKilled[0] + "male penguin," + numberSharkKilled[1] + "female penguin";
    }
}


//        for (ArrayList<Animal> animalList : animalLists) {
//            for (Animal animal : animalList) {
//                GenerateRandomNumber randomNumber = new GenerateRandomNumber();
//                int probability = randomNumber.generateRandomNumber(1, 1000);
//
//                if ((animal instanceof Penguin) && animal.isAlive()) {
//                    if ((dogNumber == 0) && (probability <= 80)) {
//                        animal.setAlive(false);
//                        numberSharkKilled[0] += 1;
//                    }
//                    else if ((dogNumber == 1) && (probability <= 20)) {
//                        animal.setAlive(false);
//                        numberSharkKilled[0] += 1;
//                    }
//                    else if ((dogNumber == 2) && (probability <= 8)) {
//                        animal.setAlive(false);
//                        numberSharkKilled[0] += 1;
//                    }
//                }
//            }
//        }

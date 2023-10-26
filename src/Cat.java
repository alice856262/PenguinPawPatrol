/**
 * The Cat class, which extends the Animal class, represents a cat that can attack penguins and chicks. It also keeps track of the number of each type of animal killed.
 *
 * @author Pei-Jiun Chuang
 * @version ver1.0.0
 */

import java.util.ArrayList;

public class Cat extends Animal
{
    private int[] numberCatKilled;

    /**
     * Default constructor for the Cat class. Creates a cat instance with default values.
     */
    public Cat()
    {
        super(true);
        numberCatKilled = new int[3];    // numberCatKilled[0]: malePenguin, numberCatKilled[1]: femalePenguin, numberCatKilled[2]: chick
    }

    /**
     * Non-default constructor for the Cat class.
     *
     * @param alive              Indicates whether the cat is alive.
     * @param numberCatKilled    An array representing the number of each type of animal killed.
     */
    public Cat(boolean alive, int[] numberCatKilled)
    {
        super(alive);
        this.numberCatKilled = numberCatKilled;
    }

    /**
     * Overrides the attack method in the Animal class to simulate the cat's attack behavior.
     *
     * @param dogNumber            The dog's number, affecting the attack probability.
     * @param penguinFamilyList    A list of penguin families in the simulation.
     * @param animalLists          Lists of animals used in the simulation.
     * @return                     An array representing the number of each type of animal killed.
     */
    @Override
    public int[] attack(int dogNumber, ArrayList<PenguinFamily> penguinFamilyList, ArrayList<Animal>... animalLists)
    {
        for (PenguinFamily penguinFamily : penguinFamilyList)
        {
            GenerateRandomNumber randomNumber = new GenerateRandomNumber();

            // Kill male penguin: use collective probability
            int probability = randomNumber.generateRandomNumber(1, 1000 * 10);
            catKillAnimals(penguinFamily.getMalePenguin(), dogNumber, probability, 0);

            // Kill female penguin: use collective probability
            probability = randomNumber.generateRandomNumber(1, 1000 * 10);
            catKillAnimals(penguinFamily.getFemalePenguin(), dogNumber, probability, 1);

            // Kill chick: use collective probability
            for (Chick chick : penguinFamily.getChickList())
            {
                probability = randomNumber.generateRandomNumber(1, 1000 * 10);
                catKillAnimals(chick, dogNumber, probability, 2);
            }
        }
        return numberCatKilled;
    }

    /**
     * Simulates the cat's attack on a specific animal and updates the number of animals killed.
     *
     * @param animal         The target animal to be attacked.
     * @param dogNumber      The dog's number, affecting the attack probability.
     * @param probability    The attack probability.
     * @param index          The index of the animal type in the numberCatKilled array.
     */
    public void catKillAnimals(Animal animal, int dogNumber, int probability, int index)
    {
        if ((animal.isAlive()) && (dogNumber == 0) && (probability <= 40))
        {
            animal.setAlive(false);
            numberCatKilled[index] += 1;
        }
        else if ((animal.isAlive()) && (dogNumber == 1) && (probability <= 10))
        {
            animal.setAlive(false);
            numberCatKilled[index] += 1;
        }
        else if ((animal.isAlive()) && (dogNumber == 2) && (probability <= 4))
        {
            animal.setAlive(false);
            numberCatKilled[index] += 1;
        }
    }

    /**
     * Accessor method to get the number of each type of animal killed by the cat.
     *
     * @return    An array representing the number of each type of animal killed.
     */
    public int[] getNumberCatKilled()
    {
        return numberCatKilled;
    }

    /**
     * Mutator method to set the number of each type of animal killed by the cat.
     *
     * @param numberCatKilled    An array representing the number of each type of animal killed.
     */
    public void setNumberCatKilled(int[] numberCatKilled)
    {
        this.numberCatKilled = numberCatKilled;
    }

    /**
     * Generate a string representation of the cat object, including the number of each type of animal killed.
     *
     * @return    A string representation of the cat object.
     */
    public String toString()
    {
        return "Cat killed:" + numberCatKilled[0] + "male penguin," + numberCatKilled[1] + "female penguin," + numberCatKilled[2] + "chick";
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
//                        numberCatKilled[0] += 1;
//                    }
//                    else if ((dogNumber == 1) && (probability <= 20)) {
//                        animal.setAlive(false);
//                        numberCatKilled[0] += 1;
//                    }
//                    else if ((dogNumber == 2) && (probability <= 8)) {
//                        animal.setAlive(false);
//                        numberCatKilled[0] += 1;
//                    }
//                }
//                else if ((animal instanceof Chick) && animal.isAlive()) {
//                    if ((dogNumber == 0) && (probability <= 80)) {
//                        animal.setAlive(false);
//                        numberCatKilled[1] += 1;
//                    }
//                    else if ((dogNumber == 1) && (probability <= 20)) {
//                        animal.setAlive(false);
//                        numberCatKilled[1] += 1;
//                    }
//                    else if ((dogNumber == 2) && (probability <= 8)) {
//                        animal.setAlive(false);
//                        numberCatKilled[1] += 1;
//                    }
//                }
//            }
//        }
//    }

/**
 * The Fox class, which extends the Animal class, represents a fox that can attack penguins, chicks, and eggs. It also keeps track of the number of each type of animal killed.
 *
 * @author Pei-Jiun Chuang
 * @version ver1.0.0
 */

import java.util.ArrayList;

public class Fox extends Animal
{
    private int[] numberFoxKilled;

    /**
     * Default constructor for the Fox class. Creates a fox instance with default values.
     */
    public Fox()
    {
        super(true);
        numberFoxKilled = new int[4];    // [0]: malePenguin, [1]: femalePenguin, [2]: chick, [3]: egg
    }

    /**
     * Non-default constructor for the Fox class.
     *
     * @param alive              Indicates whether the fox is alive.
     * @param numberFoxKilled    An array representing the number of each type of animal killed.
     */
    public Fox(boolean alive, int[] numberFoxKilled)
    {
        super(alive);
        this.numberFoxKilled = numberFoxKilled;
    }

    /**
     * Overrides the attack method in the Animal class to simulate the fox's attack behavior.
     *
     * @param dogNumber            The dog's number, affecting the attack probability.
     * @param penguinFamilyList    A list of penguin families in the simulation.
     * @param animalLists          Lists of animals used in the simulation.
     * @return                     An array representing the number of each type of animal killed.
     */
    // Fox attack penguin & chick & egg
    @Override
    public int[] attack(int dogNumber, ArrayList<PenguinFamily> penguinFamilyList, ArrayList<Animal>... animalLists)
    {
        for (PenguinFamily penguinFamily : penguinFamilyList)
        {
            GenerateRandomNumber randomNumber = new GenerateRandomNumber();

            // Kill male penguin
            int probability = randomNumber.generateRandomNumber(1, 1000 * 20);
            foxKillAnimals(penguinFamily.getMalePenguin(), dogNumber, probability, 0);

            // Kill female penguin
            probability = randomNumber.generateRandomNumber(1, 1000 * 20);
            foxKillAnimals(penguinFamily.getFemalePenguin(), dogNumber, probability, 1);

            // Kill chick
            for (Chick chick : penguinFamily.getChickList())
            {
                probability = randomNumber.generateRandomNumber(1, 1000 * 20);
                foxKillAnimals(chick, dogNumber, probability, 2);
            }

            // Kill egg
            for (Egg egg : penguinFamily.getEggList())
            {
                probability = randomNumber.generateRandomNumber(1, 1000 * 20);
                foxKillAnimals(egg, dogNumber, probability, 3);
            }
        }
        return numberFoxKilled;
    }

    /**
     * Simulates the fox's attack on a specific animal and updates the number of animals killed.
     *
     * @param animal         The target animal to be attacked.
     * @param dogNumber      The dog's number, affecting the attack probability.
     * @param probability    The attack probability.
     * @param index          The index of the animal type in the numberFoxKilled array.
     */
    public void foxKillAnimals(Animal animal, int dogNumber, int probability, int index)
    {
        if ((animal.isAlive()) && (dogNumber == 0) && (probability <= 80))
        {
            animal.setAlive(false);
            numberFoxKilled[index] += 1;
        }
        else if ((animal.isAlive()) && (dogNumber == 1) && (probability <= 20))
        {
            animal.setAlive(false);
            numberFoxKilled[index] += 1;
        }
        else if ((animal.isAlive()) && (dogNumber == 2) && (probability <= 8))
        {
            animal.setAlive(false);
            numberFoxKilled[index] += 1;
        }
    }

    /**
     * Accessor method to get the number of each type of animal killed by the fox.
     *
     * @return    An array representing the number of each type of animal killed.
     */
    public int[] getNumberFoxKilled()
    {
        return numberFoxKilled;
    }

    /**
     * Mutator method to set the number of each type of animal killed by the fox.
     *
     * @param numberFoxKilled    An array representing the number of each type of animal killed.
     */
    public void setNumberFoxKilled(int[] numberFoxKilled)
    {
        this.numberFoxKilled = numberFoxKilled;
    }

    /**
     * Generate a string representation of the fox object, including the number of each type of animal killed.
     *
     * @return    A string representation of the fox object.
     */
    public String toString()
    {
        return "Fox killed:" + numberFoxKilled[0] + "male penguin," + numberFoxKilled[1] + "female penguin," + numberFoxKilled[2] + "chick," + numberFoxKilled[3] + "egg";
    }
}


//        for (ArrayList<Animal> animalList : animalLists) {
//            for (Animal animal : animalList) {
//                GenerateRandomNumber randomNumber = new GenerateRandomNumber();
//                int probability = randomNumber.generateRandomNumber(1, 1000);
////                if ((animal instanceof Penguin) && animal.isAlive()) {
////                    if ((dogNumber == 0) && (probability <= 80)) {
////                        animal.setAlive(false);
////                        numberFoxKilled[0] += 1;
////                    }
////                    else if ((dogNumber == 1) && (probability <= 20)) {
////                        animal.setAlive(false);
////                        numberFoxKilled[0] += 1;
////                    }
////                    else if ((dogNumber == 2) && (probability <= 8)) {
////                        animal.setAlive(false);
////                        numberFoxKilled[0] += 1;
////                    }
//                }
//                if ((animal instanceof Chick) && animal.isAlive()) {
//                    if ((dogNumber == 0) && (probability <= 80)) {
//                        animal.setAlive(false);
//                        numberFoxKilled[1] += 1;
//                    }
//                    else if ((dogNumber == 1) && (probability <= 20)) {
//                        animal.setAlive(false);
//                        numberFoxKilled[1] += 1;
//                    }
//                    else if ((dogNumber == 2) && (probability <= 8)) {
//                        animal.setAlive(false);
//                        numberFoxKilled[1] += 1;
//                    }
//                }
//                else if ((animal instanceof Egg) && animal.isAlive()) {
//                    if ((dogNumber == 0) && (probability <= 80)) {
//                        animal.setAlive(false);
//                        numberFoxKilled[2] += 1;
//                    }
//                    else if ((dogNumber == 1) && (probability <= 20)) {
//                        animal.setAlive(false);
//                        numberFoxKilled[2] += 1;
//                    }
//                    else if ((dogNumber == 2) && (probability <= 8)) {
//                        animal.setAlive(false);
//                        numberFoxKilled[2] += 1;
//                    }
//                }
//            }

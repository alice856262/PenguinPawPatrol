//import java.util.ArrayList;
//
//public class Cat extends Animal
//{
//    private int[] numberCatKilled;
//
//    public Cat()
//    {
//        super(true);
//        numberCatKilled = new int[3];    // [0]: malePenguin, [1]: femalePenguin, [2]: chick
//    }
//
//    public Cat(boolean alive, int[] numberCatKilled)
//    {
//        super(alive);
//        this.numberCatKilled = numberCatKilled;
//    }
//
//    // Cat attack penguin & chick
//    @Override
//    public int[] attack(int dogNumber, ArrayList<PenguinFamily> penguinFamilyList, ArrayList<Animal>... animalLists)
//    {
//        for (PenguinFamily penguinFamily : penguinFamilyList)
//        {
//            GenerateRandomNumber randomNumber = new GenerateRandomNumber();
//
//            // Kill male penguin
//            int probability = randomNumber.generateRandomNumber(1, 1000 * 10);
//            if ((penguinFamily.getMalePenguin().isAlive()) && (dogNumber == 0) && (probability <= 40))
//            {
//                penguinFamily.getMalePenguin().setAlive(false);
//                numberCatKilled[0] += 1;
//            }
//            else if ((penguinFamily.getMalePenguin().isAlive()) && (dogNumber == 1) && (probability <= 10))
//            {
//                penguinFamily.getMalePenguin().setAlive(false);
//                numberCatKilled[0] += 1;
//            }
//            else if ((penguinFamily.getMalePenguin().isAlive()) && (dogNumber == 2) && (probability <= 4))
//            {
//                penguinFamily.getMalePenguin().setAlive(false);
//                numberCatKilled[0] += 1;
//            }
//
//            // Kill female penguin
//            probability = randomNumber.generateRandomNumber(1, 1000 * 10);
//            if ((penguinFamily.getFemalePenguin().isAlive()) && (dogNumber == 0) && (probability <= 40))
//            {
//                penguinFamily.getFemalePenguin().setAlive(false);
//                numberCatKilled[1] += 1;
//            }
//            else if ((penguinFamily.getFemalePenguin().isAlive()) && (dogNumber == 1) && (probability <= 10))
//            {
//                penguinFamily.getFemalePenguin().setAlive(false);
//                numberCatKilled[1] += 1;
//            }
//            else if ((penguinFamily.getFemalePenguin().isAlive()) && (dogNumber == 2) && (probability <= 4))
//            {
//                penguinFamily.getFemalePenguin().setAlive(false);
//                numberCatKilled[1] += 1;
//            }
//
//            // Kill chick
//            for (Chick chick : penguinFamily.getChickList())
//            {
//                probability = randomNumber.generateRandomNumber(1, 1000 * 10);
//                if ((chick.isAlive()) && (dogNumber == 0) && (probability <= 40))
//                {
//                    chick.setAlive(false);
//                    numberCatKilled[2] += 1;
//                }
//                else if ((chick.isAlive()) && (dogNumber == 1) && (probability <= 10))
//                {
//                    chick.setAlive(false);
//                    numberCatKilled[2] += 1;
//                }
//                else if ((chick.isAlive()) && (dogNumber == 2) && (probability <= 4))
//                {
//                    chick.setAlive(false);
//                    numberCatKilled[2] += 1;
//                }
//            }
//        }
//        return numberCatKilled;
//    }
//
//    public int[] getNumberCatKilled()
//    {
//        return numberCatKilled;
//    }
//
//    public void setNumberCatKilled(int[] numberCatKilled)
//    {
//        this.numberCatKilled = numberCatKilled;
//    }
//
//    public String toString()
//    {
//        return "Cat killed:" + numberCatKilled[0] + "male penguin," + numberCatKilled[1] + "female penguin," + numberCatKilled[2] + "chick";
//    }
//}

//import java.util.ArrayList;
//
//public class Fox extends Animal
//{
//    private int[] numberFoxKilled;
//
//    public Fox()
//    {
//        super(true);
//        numberFoxKilled = new int[4];    // [0]: malePenguin, [1]: femalePenguin, [2]: chick, [3]: egg
//    }
//
//    public Fox(boolean alive, int[] numberFoxKilled)
//    {
//        super(alive);
//        this.numberFoxKilled = numberFoxKilled;
//    }
//
//    // Fox attack penguin & chick & egg
//    @Override
//    public int[] attack(int dogNumber, ArrayList<PenguinFamily> penguinFamilyList, ArrayList<Animal>... animalLists)
//    {
//        for (PenguinFamily penguinFamily : penguinFamilyList)
//        {
//            GenerateRandomNumber randomNumber = new GenerateRandomNumber();
//
//            // Kill male penguin
//            int probability = randomNumber.generateRandomNumber(1, 1000 * 20);
//            if ((penguinFamily.getMalePenguin().isAlive()) && (dogNumber == 0) && (probability <= 80))
//            {
//                penguinFamily.getMalePenguin().setAlive(false);
//                numberFoxKilled[0] += 1;
//            }
//            else if ((penguinFamily.getMalePenguin().isAlive()) && (dogNumber == 1) && (probability <= 20))
//            {
//                penguinFamily.getMalePenguin().setAlive(false);
//                numberFoxKilled[0] += 1;
//            }
//            else if ((penguinFamily.getMalePenguin().isAlive()) && (dogNumber == 2) && (probability <= 8))
//            {
//                penguinFamily.getMalePenguin().setAlive(false);
//                numberFoxKilled[0] += 1;
//            }
//
//            // Kill female penguin
//            probability = randomNumber.generateRandomNumber(1, 1000 * 20);
//            if ((penguinFamily.getFemalePenguin().isAlive()) && (dogNumber == 0) && (probability <= 80))
//            {
//                penguinFamily.getFemalePenguin().setAlive(false);
//                numberFoxKilled[1] += 1;
//            }
//            else if ((penguinFamily.getFemalePenguin().isAlive()) && (dogNumber == 1) && (probability <= 20))
//            {
//                penguinFamily.getFemalePenguin().setAlive(false);
//                numberFoxKilled[1] += 1;
//            }
//            else if ((penguinFamily.getFemalePenguin().isAlive()) && (dogNumber == 2) && (probability <= 8))
//            {
//                penguinFamily.getFemalePenguin().setAlive(false);
//                numberFoxKilled[1] += 1;
//            }
//
//            // Kill chick
//            for (Chick chick : penguinFamily.getChickList())
//            {
//                probability = randomNumber.generateRandomNumber(1, 1000 * 20);
//                if ((chick.isAlive()) && (dogNumber == 0) && (probability <= 80))
//                {
//                    chick.setAlive(false);
//                    numberFoxKilled[2] += 1;
//                }
//                else if ((chick.isAlive()) && (dogNumber == 1) && (probability <= 20))
//                {
//                    chick.setAlive(false);
//                    numberFoxKilled[2] += 1;
//                }
//                else if ((chick.isAlive()) && (dogNumber == 2) && (probability <= 8))
//                {
//                    chick.setAlive(false);
//                    numberFoxKilled[2] += 1;
//                }
//            }
//
//            // Kill egg
//            for (Egg egg : penguinFamily.getEggList())
//            {
//                probability = randomNumber.generateRandomNumber(1, 1000 * 20);
//                if ((egg.isAlive()) && (dogNumber == 0) && (probability <= 80))
//                {
//                    egg.setAlive(false);
//                    numberFoxKilled[3] += 1;
//                }
//                else if ((egg.isAlive()) && (dogNumber == 1) && (probability <= 20))
//                {
//                    egg.setAlive(false);
//                    numberFoxKilled[3] += 1;
//                }
//                else if ((egg.isAlive()) && (dogNumber == 2) && (probability <= 8))
//                {
//                    egg.setAlive(false);
//                    numberFoxKilled[3] += 1;
//                }
//            }
//        }
//        return numberFoxKilled;
//    }
//
//    public int[] getNumberFoxKilled()
//    {
//        return numberFoxKilled;
//    }
//
//    public void setNumberFoxKilled(int[] numberFoxKilled)
//    {
//        this.numberFoxKilled = numberFoxKilled;
//    }
//
//    public String toString()
//    {
//        return "Fox killed:" + numberFoxKilled[0] + "male penguin," + numberFoxKilled[1] + "female penguin," + numberFoxKilled[2] + "chick," + numberFoxKilled[3] + "egg";
//    }
//}

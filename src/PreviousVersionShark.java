//import java.util.ArrayList;
//
//public class Shark extends Animal
//{
//    private int[] numberSharkKilled;
//
//    public Shark()
//    {
//        super(true);
//        numberSharkKilled = new int[2];    // [0]: malePenguin, [1]: femalePenguin
//    }
//
//    public Shark(boolean alive, int[] numberSharkKilled)
//    {
//        super(alive);
//        this.numberSharkKilled = numberSharkKilled;
//    }
//
//    // Shark attack penguin
//    @Override
//    public int[] attack(int dogNumber, ArrayList<PenguinFamily> penguinFamilyList, ArrayList<Animal>... animalLists)
//    {
//        for (PenguinFamily penguinFamily : penguinFamilyList)
//        {
//            GenerateRandomNumber randomNumber = new GenerateRandomNumber();
//
//            // Kill male penguin
//            int probability = randomNumber.generateRandomNumber(1, 100 * 5);
//            if ((penguinFamily.getMalePenguin().isAlive()) && (probability <= 2))
//            {
//                penguinFamily.getMalePenguin().setAlive(false);
//                numberSharkKilled[0] += 1;
//            }
//            // Kill female penguin
//            probability = randomNumber.generateRandomNumber(1, 100 * 5);
//            if ((penguinFamily.getFemalePenguin().isAlive()) && (probability <= 2))
//            {
//                penguinFamily.getFemalePenguin().setAlive(false);
//                numberSharkKilled[1] += 1;
//            }
//        }
//        return numberSharkKilled;
//    }
//
//    public int[] getNumberSharkKilled()
//    {
//        return numberSharkKilled;
//    }
//
//    public void setNumberSharkKilled(int[] numberSharkKilled)
//    {
//        this.numberSharkKilled = numberSharkKilled;
//    }
//
//    public String toString()
//    {
//        return "Shark killed:" + numberSharkKilled[0] + "male penguin," + numberSharkKilled[1] + "female penguin";
//    }
//}

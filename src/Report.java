/**
 * The Report class provides methods to report the current status, summary statistics, and survival rates of a penguin colony simulation.
 *
 * @author Pei-Jiun Chuang
 * @version ver1.0.0
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Report
{
    /**
     * Default constructor for the Validation class.
     */
    public Report()
    {

    }

    /**
     * Report the current status of the penguin population and the presence of other animals.
     *
     * @param penguinFamilyList    A list of penguin families.
     * @param foxList              A list of foxes.
     * @param catList              A list of cats.
     * @param sharkList            A list of sharks.
     */
    public static void reportMonthStatus(ArrayList<PenguinFamily> penguinFamilyList, ArrayList<Animal> foxList, ArrayList<Animal> catList, ArrayList<Animal> sharkList)
    {
        System.out.println("End of month colony status:");
        // Number of complete family groups --> What does "complete" family groups mean?
        int numberCompleteFamily = 0;
        for (int i = 0; i < penguinFamilyList.size(); i++)
        {
            if (penguinFamilyList.get(i).isParentAlive())
            {
                numberCompleteFamily += 1;
            }
        }
        System.out.println("  complete family: " + numberCompleteFamily);

        // Number of live penguins
        int numberMalePenguin = 0;
        int numberFemalePenguin = 0;
        int numberPenguin = 0;
        for (int i = 0; i < penguinFamilyList.size(); i++)
        {
            if (penguinFamilyList.get(i).getMalePenguin().isAlive())
            {
                numberMalePenguin += 1;
            }
            if (penguinFamilyList.get(i).getFemalePenguin().isAlive())
            {
                numberFemalePenguin += 1;
            }
        }
        numberPenguin = numberMalePenguin + numberFemalePenguin;
        System.out.println("  live penguin count: " + numberPenguin + " (male: " + numberMalePenguin + ", female: " + numberFemalePenguin + ")");

        // Number of live chicks
        int numberChick = 0;
        for (int i = 0; i < penguinFamilyList.size(); i++)
        {
            for (Chick chick : (penguinFamilyList.get(i).getChickList()))
            {
                if (chick.isAlive())
                {
                    numberChick += 1;
                }
            }
        }
        System.out.println("  live chick count: " + numberChick);

        // Number of live (uneaten) eggs
        int numberEgg = 0;
        for (int i = 0; i < penguinFamilyList.size(); i++)
        {
            for (Egg egg : (penguinFamilyList.get(i).getEggList()))
            {
                if (egg.isAlive())
                {
                    numberEgg += 1;
                }
            }
        }
        System.out.println("  live egg count: " + numberEgg);

        // Number of fox
        int numberFox = 0;
        for (int i = 0; i < foxList.size(); i++)
        {
            if (foxList.get(i).isAlive())
            {
                numberFox += 1;
            }
        }
        System.out.println("  fox count: " + numberFox);

        // Number of cat
        int numberCat = 0;
        for (int i = 0; i < catList.size(); i++)
        {
            if (catList.get(i).isAlive())
            {
                numberCat += 1;
            }
        }
        System.out.println("  cat count: " + numberCat);

        // Number of shark
        int numberShark = 0;
        for (int i = 0; i < sharkList.size(); i++)
        {
            if (sharkList.get(i).isAlive())
            {
                numberShark += 1;
            }
        }
        System.out.println("  shark count: " + numberShark);

        System.out.println("Press ENTER to continue!");
        Scanner console = new Scanner(System.in);
        String enterToContinue = console.nextLine();
        while (!Validation.isBlank(enterToContinue))
        {
            System.out.println("Invalid input! Press ENTER to continue!");
            enterToContinue = console.nextLine();
        }
    }

    /**
     * Report the summary statistics of the penguin colony simulation.
     *
     * @param penguinFamilyList    The list of penguin families representing the colony.
     * @param endNumberList        An array to store the summary statistics.
     */
    public static void reportSimulationSummary(ArrayList<PenguinFamily> penguinFamilyList, int[] endNumberList)
    {
        System.out.println("End of simulation summary:");
        // Number of complete family groups --> What does "complete" family groups mean?
        for (int i = 0; i < penguinFamilyList.size(); i++)
        {
            if (penguinFamilyList.get(i).isParentAlive())
            {
                endNumberList[2] += 1;
            }
        }
        System.out.println("  complete family: " + endNumberList[2]);

        //  Number of live penguins
        for (int i = 0; i < penguinFamilyList.size(); i++)
        {
            if (penguinFamilyList.get(i).getMalePenguin().isAlive())
            {
                endNumberList[3] += 1;
            }
            if (penguinFamilyList.get(i).getFemalePenguin().isAlive())
            {
                endNumberList[4] += 1;
            }
        }
        endNumberList[5] = endNumberList[3] + endNumberList[4];
        System.out.println("  live penguin count: " + endNumberList[5] + " (male: " + endNumberList[3] + ", female: " + endNumberList[4] + ")");

        // Number of live chicks
        for (int i = 0; i < penguinFamilyList.size(); i++)
        {
            for (Chick chick : (penguinFamilyList.get(i).getChickList()))
            {
                if (chick.isAlive())
                {
                    endNumberList[6] += 1;
                }
            }
        }
        System.out.println("  live chick count: " + endNumberList[6]);

        System.out.println("\nSimulation is done.");
        System.out.println("Press ENTER to continue!");
        Scanner console = new Scanner(System.in);
        String enterToContinue = console.nextLine();
        while (!Validation.isBlank(enterToContinue))
        {
            System.out.println("Invalid input! Press ENTER to continue!");
            enterToContinue = console.nextLine();
        }
    }

    /**
     * Report the survival rates of the penguin colony. This method calculates and prints these rates.
     *
     * @param endNumberList        An array containing summary statistics.
     * @param penguinFamilyList    The list of penguin families representing the colony.
     * @param penguinPawPatrol     An instance of the PenguinPawPatrol class.
     */
    public static void reportSurvivalRates(int[] endNumberList, ArrayList<PenguinFamily> penguinFamilyList, PenguinPawPatrol penguinPawPatrol)
    {
        System.out.println("Colony survival rates:");
        try
        {
            // Family group survival rate: (total_penguin_families_with_two_parents / total_penguin_families_at_the_start) * 100
            double familySurvival = (endNumberList[2] * 100.0 / penguinFamilyList.size());
            penguinPawPatrol.getSurvivalList()[0] = "* family group survival rate: " + String.format("%.2f%%", familySurvival);
            System.out.println(penguinPawPatrol.getSurvivalList()[0]);

            // Penguin survival rate: (total_penguin_alive / total_penguins_at_the_start) * 100
            double penguinSurvival = (endNumberList[5] * 100.0 / (penguinFamilyList.size() * 2.0));
            penguinPawPatrol.getSurvivalList()[1] = "* penguin survival rate: " + String.format("%.2f%%", penguinSurvival);
            System.out.println(penguinPawPatrol.getSurvivalList()[1]);

            // Egg survival rate: (total_eggs_hatched / total_eggs_laid) * 100
            double eggSurvival = (endNumberList[1] * 100.0 / endNumberList[0]);
            penguinPawPatrol.getSurvivalList()[2] = "* egg survival rate: " + String.format("%.2f%%", eggSurvival);
            System.out.println(penguinPawPatrol.getSurvivalList()[2]);

            // Chick survival rate: (total_chicks_alive / total_chicks hatched) * 100
            double chickSurvival = (endNumberList[6] * 100.0 / endNumberList[1]);
            penguinPawPatrol.getSurvivalList()[3] = "* chick survival rate: " + String.format("%.2f%%", chickSurvival);
            System.out.println(penguinPawPatrol.getSurvivalList()[3]);

            // Overall colony survival: (total_penguins_alive + total_chicks_alive / total_penguins_at_the_start)
            double overallSurvival = (endNumberList[5] + endNumberList[6]) / (penguinFamilyList.size() * 2.0);
            penguinPawPatrol.getSurvivalList()[4] = "* overall colony survival: " + String.format("%.2f", overallSurvival);
            System.out.println(penguinPawPatrol.getSurvivalList()[4]);
        }
        catch (ArithmeticException e)
        {
            // Handle division by zero error
            System.out.println("Error: cannot divide by zero.");
        }
        catch (Exception e)
        {
            // Handle other exceptions
            System.out.println("Error: " + e.getMessage());
        }
    }
}

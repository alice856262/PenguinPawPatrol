/**
 * The PenguinPawPatrol class simulates the survival and interactions of penguin colonies with dogs, foxes, cats, and sharks over a year.
 * It manages penguin families, animal attacks, growth of chicks and eggs, and provides various reports and statistics.
 *
 * @author Pei-Jiun Chuang
 * @version ver1.0.0
 */

import java.util.*;

public class PenguinPawPatrol
{
    private String[] survivalList;

    /**
     * Default constructor for the PenguinPawPatrol class.
     */
    public PenguinPawPatrol()
    {
        survivalList = new String[5];    // [0]: family group, [1]: penguin, [2]: egg, [3]: chick, [4]: overall
    }

    /**
     * Non-default constructor for the PenguinPawPatrol class.
     *
     * @param survivalList    An array representing the survival status of penguin families.
     */
    public PenguinPawPatrol(String[] survivalList)
    {
        this.survivalList = survivalList;
    }

    /**
     * Ask the user for the number of patrol dogs and validate the input.
     *
     * @return    The number of patrol dogs (0, 1, or 2) as an integer.
     */
    public static int askDogNumber()
    {
        System.out.println("How many patrol dogs (0 or 1 or 2)? ");
        Scanner console = new Scanner(System.in);
        String dogNumberInput = console.nextLine();
        while (Validation.isBlank(dogNumberInput) || (!Validation.validateIntegerInRange(dogNumberInput, 0, 2)))
        {
            System.out.println("Invalid input!");
            System.out.println("How many patrol dogs (0 or 1 or 2)? ");
            dogNumberInput = console.nextLine();
        }
        int dogNumber = Integer.parseInt(dogNumberInput);
        return dogNumber;
    }

    /**
     * Simulate the attack of dogs on foxes and cats and report the number of each animal killed.
     *
     * @param dogList      A list of dogs participating in the attack.
     * @param dogNumber    The number of patrol dogs.
     * @param foxList      A list of foxes to be attacked.
     * @param catList      A list of cats to be attacked.
     */
    public static void attackFoxCat(ArrayList<Animal> dogList, int dogNumber, ArrayList<Animal> foxList, ArrayList<Animal> catList)
    {
        int numberKillFox = 0;
        int numberKillCat = 0;
        for (Animal dog : dogList)
        {
            int[] numberDogKilled = dog.attack(dogNumber, new ArrayList<>(), foxList, catList);
            numberKillFox += numberDogKilled[0];
            numberDogKilled[0] = 0;
            numberKillCat += numberDogKilled[1];
            numberDogKilled[1] = 0;
        }
        System.out.println("- fox killed: " + numberKillFox);
        System.out.println("- cat killed: " + numberKillCat);
    }

    /**
     * Simulate the attack of foxes, cats, and sharks on penguin families and report the number of each penguin, chick, and egg killed.
     *
     * @param foxList              A list of foxes participating in the attack.
     * @param dogNumber            The number of patrol dogs.
     * @param penguinFamilyList    A list of penguin families to be attacked.
     * @param catList              A list of cats participating in the attack.
     * @param sharkList            A list of sharks participating in the attack.
     */
    public static void attackPenguinFamily(ArrayList<Animal> foxList, int dogNumber, ArrayList<PenguinFamily> penguinFamilyList, ArrayList<Animal> catList, ArrayList<Animal> sharkList)
    {
        int numberKillMalePenguin = 0;
        int numberKillFemalePenguin = 0;
        int numberKillPenguin = 0;
        int numberKillChick = 0;
        int numberKillEgg = 0;
        for (Animal fox : foxList)
        {
            if (fox.isAlive())
            {
                int[] numberFoxKilled = fox.attack(dogNumber, penguinFamilyList);
                numberKillMalePenguin += numberFoxKilled[0];
                numberFoxKilled[0] = 0;
                numberKillFemalePenguin += numberFoxKilled[1];
                numberFoxKilled[1] = 0;
                numberKillChick += numberFoxKilled[2];
                numberFoxKilled[2] = 0;
                numberKillEgg += numberFoxKilled[3];
                numberFoxKilled[3] = 0;
            }
        }
        for (Animal cat : catList)
        {
            if (cat.isAlive())
            {
                int[] numberCatKilled = cat.attack(dogNumber, penguinFamilyList);
                numberKillMalePenguin += numberCatKilled[0];
                numberCatKilled[0] = 0;
                numberKillFemalePenguin += numberCatKilled[1];
                numberCatKilled[1] = 0;
                numberKillChick += numberCatKilled[2];
                numberCatKilled[2] = 0;
            }
        }
        for (Animal shark : sharkList)
        {
            if (shark.isAlive())
            {
                int[] numberSharkKilled = shark.attack(dogNumber, penguinFamilyList);
                numberKillMalePenguin += numberSharkKilled[0];
                numberSharkKilled[0] = 0;
                numberKillFemalePenguin += numberSharkKilled[1];
                numberSharkKilled[1] = 0;
            }
        }
        numberKillPenguin = numberKillMalePenguin + numberKillFemalePenguin;
        System.out.println("- penguin killed: " + numberKillPenguin + " (male: " + numberKillMalePenguin + ", female: " + numberKillFemalePenguin + ")");
        System.out.println("- chick killed: " + numberKillChick);
        System.out.println("- egg killed: " + numberKillEgg);
    }

    /**
     * Display welcome message at the beginning of the simulation.
     */
    public static void displayWelcomeMessage()
    {
        System.out.println("Welcome to Paw Patrol");
        System.out.println("=====================");
        System.out.println("\nRunning simulation from month July to June.");
    }

    /**
     * Accessor method to get the survival list.
     *
     * @return    The survival list.
     */
    public String[] getSurvivalList()
    {
        return survivalList;
    }

    /**
     * Simulate the growth of penguin families for a specific month.
     *
     * @param month                The month of the simulation.
     * @param penguinFamilyList    A list of penguin families.
     * @param endNumberList        An array to store the count of new chicks and eggs.
     */
    public static void growPenguinFamily(int month, ArrayList<PenguinFamily> penguinFamilyList, int[] endNumberList)
    {
        int numberNewEgg = 0;
        int numberNewChick = 0;
        for (PenguinFamily penguinFamily : penguinFamilyList)
        {
            if (month >= 8 || month <= 2)
            {
                if (penguinFamily.isParentAlive())
                {
                    penguinFamily.layEgg();
                    numberNewEgg += 1;
                    endNumberList[0] += 1;
                }
            }
            for (Chick chick : penguinFamily.getChickList())
            {
                if (chick.isAlive())
                {
                    chick.increaseAge();
                }
            }
            for (Egg egg : penguinFamily.getEggList())
            {
                if (egg.isAlive())
                {
                    egg.increaseAge();
                    boolean hatchResult = egg.hatch();
                    if (hatchResult)
                    {
                        Chick chick = new Chick(true, 0);
                        (penguinFamily.getChickList()).add(chick);
                        numberNewChick += 1;
                        endNumberList[1] += 1;
                    }
                }
            }
        }
        System.out.println("+ new chicks: " + numberNewChick);
        System.out.println("+ new eggs: " + numberNewEgg);
    }

    /**
     * The main method to start the PenguinPawPatrol program.
     */
    public static void main(String[] args)
    {
        PenguinPawPatrol penguinPawPatrol = new PenguinPawPatrol();
        penguinPawPatrol.startProgram(penguinPawPatrol);
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
    }

    /**
     * Report the summary statistics of the penguin colony simulation.
     *
     * @param penguinFamilyList    The list of penguin families representing the colony.
     * @param endNumberList        An array to store the summary statistics.
     */
    public static void reportSimulationSummary(ArrayList<PenguinFamily> penguinFamilyList, int[] endNumberList)
    {
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
        try
        {
            // Family group survival rate: (total_penguin_families_with_two_parents / total_penguin_families_at_the_start) * 100
            double familySurvival = (endNumberList[2] * 100.0 / penguinFamilyList.size());
            penguinPawPatrol.survivalList[0] = "* family group survival rate: " + String.format("%.2f%%", familySurvival);
            System.out.println(penguinPawPatrol.survivalList[0]);

            // Penguin survival rate: (total_penguin_alive / total_penguins_at_the_start) * 100
            double penguinSurvival = (endNumberList[5] * 100.0 / (penguinFamilyList.size() * 2.0));
            penguinPawPatrol.survivalList[1] = "* penguin survival rate: " + String.format("%.2f%%", penguinSurvival);
            System.out.println(penguinPawPatrol.survivalList[1]);

            // Egg survival rate: (total_eggs_hatched / total_eggs_laid) * 100
            double eggSurvival = (endNumberList[1] * 100.0 / endNumberList[0]);
            penguinPawPatrol.survivalList[2] = "* egg survival rate: " + String.format("%.2f%%", eggSurvival);
            System.out.println(penguinPawPatrol.survivalList[2]);

            // Chick survival rate: (total_chicks_alive / total_chicks hatched) * 100
            double chickSurvival = (endNumberList[6] * 100.0 / endNumberList[1]);
            penguinPawPatrol.survivalList[3] = "* chick survival rate: " + String.format("%.2f%%", chickSurvival);
            System.out.println(penguinPawPatrol.survivalList[3]);

            // Overall colony survival: (total_penguins_alive + total_chicks_alive / total_penguins_at_the_start)
            double overallSurvival = (endNumberList[5] + endNumberList[6]) / (penguinFamilyList.size() * 2.0);
            penguinPawPatrol.survivalList[4] = "* overall colony survival: " + String.format("%.2f", overallSurvival);
            System.out.println(penguinPawPatrol.survivalList[4]);
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

    /**
     * Mutator method to set the survival list to the provided array of strings.
     *
     * @param survivalList    An array of strings representing penguin survival data.
     */
    public void setSurvivalList(String[] survivalList)
    {
        this.survivalList = survivalList;
    }

    /**
     * Display the name of the month for the given month number.
     *
     * @param month    An integer representing the month.
     */
    public static void showMonth(int month)
    {
        String monthAsString = "";
        switch (month)
        {
            case 7:
                monthAsString = "July";
                break;
            case 8:
                monthAsString = "August";
                break;
            case 9:
                monthAsString = "September";
                break;
            case 10:
                monthAsString = "October";
                break;
            case 11:
                monthAsString = "November";
                break;
            case 12:
                monthAsString = "December";
                break;
            case 1:
                monthAsString = "January";
                break;
            case 2:
                monthAsString = "February";
                break;
            case 3:
                monthAsString = "March";
                break;
            case 4:
                monthAsString = "April";
                break;
            case 5:
                monthAsString = "May";
                break;
            case 6:
                monthAsString = "June";
                break;
            default:
                monthAsString = "Unrecognised";
                break;
        }
        System.out.println("\nSimulation month: " + monthAsString);
    }

    /**
     * Starts the simulation of a penguin colony and reports various aspects of the colony's status.
     * The simulation includes reading initial data from a file, simulating the colony's life over several months, reporting the colony's status at the end of each month, and calculating survival rates.
     *
     * @param penguinPawPatrol    The instance of PenguinPawPatrol used to record survival statistics.
     */
    public void startProgram(PenguinPawPatrol penguinPawPatrol)
    {
        displayWelcomeMessage();
        int dogNumber = askDogNumber();
        System.out.println("Number of dog(s): " + dogNumber);

        // STEP 1: read file
        FileIO fileIO = new FileIO();
        int[] numberAnimal = fileIO.readFile("./colony.txt");

        // STEP 2: instantiate dog, fox, cat, shark, penguin, chick, egg ...
        AnimalList animalList = new AnimalList(numberAnimal, dogNumber);
        ArrayList<Animal> dogList = animalList.getDogList();
        ArrayList<PenguinFamily> penguinFamilyList = animalList.getPenguinFamilyList();
        ArrayList<Animal> foxList = animalList.getFoxList();
        ArrayList<Animal> catList = animalList.getCatList();
        ArrayList<Animal> sharkList = animalList.getSharkList();

        // create endNumberList to record final number of every animal
        // endNumberList = {endNumberEgg (total eggs "laid"), endNumberHatch (total eggs "hatched"), endNumberCompleteFamily, endNumberMalePenguin, endNumberFemalePenguin, endNumberPenguin, endNumberChick}
        int[] endNumberList = new int[]{0, 0, 0, 0, 0, 0, 0};

        // run simulation from month July to June
        int[] monthList = new int[]{7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6};
        for (int month : monthList)
        {
            showMonth(month);

            // STEP 3: penguin lay egg, chick grow, egg grow, egg hatch
            growPenguinFamily(month, penguinFamilyList, endNumberList);

            // STEP 4: fox, cat, shark --attack--> penguin, chick, egg
            attackPenguinFamily(foxList, dogNumber, penguinFamilyList, catList, sharkList);

            // STEP 5: dog --attack--> fox, cat
            attackFoxCat(dogList, dogNumber, foxList, catList);

            // STEP 6: clear chick and egg
            for (PenguinFamily penguinFamily : penguinFamilyList)
            {
                penguinFamily.clearChickEgg();
            }

            // STEP 7: monthly report
            System.out.println("End of month colony status:");
            reportMonthStatus(penguinFamilyList, foxList, catList, sharkList);
            System.out.println("Press ENTER to continue!");
            Scanner console = new Scanner(System.in);
            String enterToContinue = console.nextLine();
            while (!Validation.isBlank(enterToContinue))
            {
                System.out.println("Invalid input! Press ENTER to continue!");
                enterToContinue = console.nextLine();
            }
        }

        // STEP 8: final report
        System.out.println("End of simulation summary:");
        reportSimulationSummary(penguinFamilyList, endNumberList);
        System.out.println("\nSimulation is done.");
        System.out.println("Press ENTER to continue!");
        Scanner console = new Scanner(System.in);
        String enterToContinue = console.nextLine();
        while (!Validation.isBlank(enterToContinue))
        {
            System.out.println("Invalid input! Press ENTER to continue!");
            enterToContinue = console.nextLine();
        }

        // STEP 9: calculate colony survival rates
        System.out.println("Colony survival rates:");
        reportSurvivalRates(endNumberList, penguinFamilyList, penguinPawPatrol);

        // STEP 10: write file
        fileIO.writeFile("./colonyFinal.txt", penguinPawPatrol.survivalList);
    }

    /**
     * Generate a string representation of the survival list, including the survival status of penguin families.
     *
     * @return    A string representation of the survival list.
     */
    public String toString()
    {
        return "Survival list = " + Arrays.toString(survivalList);
    }
}

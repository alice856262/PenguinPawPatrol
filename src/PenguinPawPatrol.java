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
        survivalList = new String[5];    // survivalList[0]: penguin family group, survivalList[1]: penguin, survivalList[2]: egg, survivalList[3]: chick, survivalList[4]: overall
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
    public int askDogNumber()
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
    public void attackFoxCat(ArrayList<Animal> dogList, int dogNumber, ArrayList<Animal> foxList, ArrayList<Animal> catList)
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
    public void attackPenguinFamily(ArrayList<Animal> foxList, int dogNumber, ArrayList<PenguinFamily> penguinFamilyList, ArrayList<Animal> catList, ArrayList<Animal> sharkList)
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
    public void displayWelcomeMessage()
    {
        System.out.println("Welcome to Paw Patrol");
        System.out.println("=====================");
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
    public void growPenguinFamily(int month, ArrayList<PenguinFamily> penguinFamilyList, int[] endNumberList)
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
                    boolean hatchResult = egg.hatch();
                    if (hatchResult)
                    {
                        Chick chick = new Chick(true, 0);
                        (penguinFamily.getChickList()).add(chick);
                        numberNewChick += 1;
                        endNumberList[1] += 1;
                    }
                    egg.increaseAge();
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
    public void showMonth(int month)
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
        penguinPawPatrol.displayWelcomeMessage();
        int dogNumber = penguinPawPatrol.askDogNumber();
        System.out.println("\nRunning simulation from month July to June.");
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
        // endNumberList = {endNumberEgg (total_eggs_laid), endNumberHatch (total_eggs_hatched = total_chicks_hatched), endNumberCompleteFamily, endNumberMalePenguin, endNumberFemalePenguin, endNumberPenguin, endNumberChick}
        // endNumberList[0]: total eggs "laid", endNumberList[1]: total eggs "hatched" (= total chicks hatched), endNumberList[2]: total complete family , endNumberList[3]: total alive male penguin, endNumberList[4]: total alive female penguin, endNumberList[5]: total alive penguin, endNumberList[6]: total alive chick
        int[] endNumberList = new int[]{0, 0, 0, 0, 0, 0, 0};

        // run simulation from month July to June
        int[] monthList = new int[]{7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6};
        Report report = new Report();
        for (int month : monthList)
        {
            penguinPawPatrol.showMonth(month);
            // STEP 3: penguin lay egg, chick grow, egg grow, egg hatch
            penguinPawPatrol.growPenguinFamily(month, penguinFamilyList, endNumberList);
            // STEP 4: fox, cat, shark --attack--> penguin, chick, egg
            penguinPawPatrol.attackPenguinFamily(foxList, dogNumber, penguinFamilyList, catList, sharkList);
            // STEP 5: dog --attack--> fox, cat
            penguinPawPatrol.attackFoxCat(dogList, dogNumber, foxList, catList);
            // STEP 6: clear chick and egg
            for (PenguinFamily penguinFamily : penguinFamilyList)
            {
                penguinFamily.clearChickEgg();
            }
            // STEP 7: monthly report
            report.reportMonthStatus(penguinFamilyList, foxList, catList, sharkList);
        }
        // STEP 8: final report
        report.reportSimulationSummary(penguinFamilyList, endNumberList);
        // STEP 9: calculate colony survival rates
        report.reportSurvivalRates(endNumberList, penguinFamilyList, penguinPawPatrol);
        // STEP 10: write file
        fileIO.writeFile("./colonyFinal.txt", penguinPawPatrol.survivalList);
        System.out.println("\nWriting survival rates into colonyFinal.txt!");
        System.out.println("Goodbye!");
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

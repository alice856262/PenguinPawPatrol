/**
 * The PenguinFamily class represents a family of penguins with unique identification, male and female penguins, a list of chicks, and a list of eggs.
 *
 * @author Pei-Jiun Chuang
 * @version ver1.0.0
 */

import java.util.ArrayList;

public class PenguinFamily
{
    private String uniqueID;
    private Penguin malePenguin;
    private Penguin femalePenguin;
    private ArrayList<Chick> chickList;
    private ArrayList<Egg> eggList;

    /**
     * Default constructor for the PenguinFamily class.
     */
    public PenguinFamily()
    {
        this.uniqueID = "Unknown";
        this.malePenguin = new Penguin(true, 'M');
        this.femalePenguin = new Penguin(true, 'F');
        this.chickList = new ArrayList<>();
        this.eggList = new ArrayList<>();
    }

    /**
     * Non-default constructor for the PenguinFamily class. Creates a new penguin family object with the unique ID.
     *
     * @param uniqueID    The unique identification for the penguin family.
     */
    public PenguinFamily(String uniqueID)
    {
        if (Validation.isValidID(uniqueID))
        {
            this.uniqueID = uniqueID;
        }
        else
        {
            this.uniqueID = "P001";
        }
        this.malePenguin = new Penguin(true, 'M');
        this.femalePenguin = new Penguin(true, 'F');
        this.chickList = new ArrayList<>();
        this.eggList = new ArrayList<>();
    }

    /**
     * Non-default constructor for the PenguinFamily class. Creates a new penguin family object with specified parameters.
     *
     * @param uniqueID         The unique identification for the penguin family.
     * @param malePenguin      The male penguin of the family.
     * @param femalePenguin    The female penguin of the family.
     * @param chickList        The list of chick penguins in the family.
     * @param eggList          The list of eggs in the family.
     */
    public PenguinFamily(String uniqueID, Penguin malePenguin, Penguin femalePenguin, ArrayList<Chick> chickList, ArrayList<Egg> eggList)
    {
        if (Validation.isValidID(uniqueID))
        {
            this.uniqueID = uniqueID;
        }
        else
        {
            this.uniqueID = "P001";
        }
        if (malePenguin.getGender() == 'M')
        {
            this.malePenguin = malePenguin;
        }
        else
        {
            this.malePenguin = new Penguin(true, 'M');
        }
        if (femalePenguin.getGender() == 'F')
        {
            this.femalePenguin = femalePenguin;
        }
        else
        {
            this.femalePenguin = new Penguin(true, 'F');
        }
        if (chickList != null)
        {
            this.chickList = chickList;
        }
        else
        {
            this.chickList = new ArrayList<>();
        }
        if (eggList != null)
        {
            this.eggList = eggList;
        }
        else
        {
            this.eggList = new ArrayList<>();
        }
    }

    /**
     * Clears the list of chicks and eggs if both male and female penguins are not alive.
     */
    public void clearChickEgg()
    {
        if ((!this.malePenguin.isAlive()) && (!this.femalePenguin.isAlive()))
        {
            eggList.clear();
            chickList.clear();
        }
    }

    /**
     * Accessor method to get the unique identification of the penguin family.
     *
     * @return    The unique identification of the penguin family.
     */
    public String getUniqueID()
    {
        return uniqueID;
    }

    /**
     * Accessor method to get the male penguin in the family.
     *
     * @return    The male penguin in the family.
     */
    public Penguin getMalePenguin()
    {
        return malePenguin;
    }

    /**
     * Accessor method to get the female penguin in the family.
     *
     * @return    The female penguin in the family.
     */
    public Penguin getFemalePenguin()
    {
        return femalePenguin;
    }

    /**
     * Accessor method to get the list of chicks in the family.
     *
     * @return    The list of chicks in the family.
     */
    public ArrayList<Chick> getChickList()
    {
        return chickList;
    }

    /**
     * Accessor method to get the list of eggs in the family.
     *
     * @return    The list of eggs in the family.
     */
    public ArrayList<Egg> getEggList()
    {
        return eggList;
    }

    /**
     * Increases the unique ID by one.
     *
     * @param uniqueNumber    The numeric part in the uniqueID.
     * @return                The incremented numeric part in the unique ID.
     */
    public int increaseID(int uniqueNumber)
    {
        if (uniqueNumber <= 0)
        {
            return 1;
        }
        return uniqueNumber + 1;
    }

    /**
     * Check if both parent penguins in the penguin family are alive.
     *
     * @return    Return true if both parent penguins are alive, false otherwise.
     */
    public boolean isParentAlive()
    {
        if (this.malePenguin.isAlive() && this.femalePenguin.isAlive())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Allows the penguin family to lay eggs if both parents are alive.
     */
    public void layEgg()
    {
        // Check if the parent is alive
        if (isParentAlive())
        {
            GenerateRandomNumber randomNumber = new GenerateRandomNumber();
            int eggNumber = randomNumber.generateRandomNumber(0, 2);
            for (int i = 0; i < eggNumber; i++)
            {
                Egg egg = new Egg();
                eggList.add(egg);
            }
        }
    }

    /**
     * Mutator method to set the unique ID for the family.
     *
     * @param uniqueID    The unique ID to be set.
     */
    public void setUniqueID(String uniqueID)
    {
        if (Validation.isValidID(uniqueID))
        {
            this.uniqueID = uniqueID;
        }
        else
        {
            this.uniqueID = "P001";
        }
    }

    /**
     * Mutator method to set the male penguin for the family.
     *
     * @param malePenguin    The male penguin to be set.
     */
    public void setMalePenguin(Penguin malePenguin)
    {
        if (malePenguin.getGender() == 'M')
        {
            this.malePenguin = malePenguin;
        }
        else
        {
            this.malePenguin = new Penguin(true, 'M');
        }
    }

    /**
     * Mutator method to set the female penguin for the family.
     *
     * @param femalePenguin    The female penguin to be set.
     */
    public void setFemalePenguin(Penguin femalePenguin)
    {
        if (femalePenguin.getGender() == 'F')
        {
            this.femalePenguin = femalePenguin;
        }
        else
        {
            this.femalePenguin = new Penguin(true, 'F');
        }
    }

    /**
     * Mutator method to set the list of chicks for the family.
     *
     * @param chickList    The list of chicks to be set.
     */
    public void setChickList(ArrayList<Chick> chickList)
    {
        if (chickList != null)
        {
            this.chickList = chickList;
        }
        else
        {
            this.chickList = new ArrayList<>();
        }
    }

    /**
     * Mutator method to set the list of eggs for the family.
     *
     * @param eggList    The list of eggs to be set.
     */
    public void setEggList(ArrayList<Egg> eggList)
    {
        if (eggList != null)
        {
            this.eggList = eggList;
        }
        else
        {
            this.eggList = new ArrayList<>();
        }
    }

    /**
     * Generate a string representation of the penguin family, including unique ID, male penguin, female penguin, chick list, and egg list.
     *
     * @return    A string representation of the penguin family object.
     */
    public String toString()
    {
//        return "Penguin Family Information:\n" +
//                "Family ID: " + uniqueID + "\n" +
//                "Penguin 1: " + malePenguin.toString() + "\n" +
//                "Penguin 2: " + femalePenguin.toString() + "\n" +
//                "Chicks: " + getChickList() + "\n" +
//                "Eggs: " + getEggList();
        return "uniqueID: " + uniqueID + "\n" +
                "malePenguin: " + malePenguin.toString() + "\n" +
                "femalePenguin: " + femalePenguin.toString() + "\n" +
                "chickList: " + getChickList() + "\n" +
                "eggList: " + getEggList();
    }
}

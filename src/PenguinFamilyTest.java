import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class PenguinFamilyTest
{
    @Test
    public void testDefaultConstructor()
    {
         PenguinFamily penguinFamily = new PenguinFamily();
         System.out.println("Create a PenguinFamily object with default constructor.");
         System.out.println(penguinFamily.toString());
    }

    @Test
    public void testNonDefaultConstructorWithUniqueIDWithValid()
    {
         PenguinFamily penguinFamily = new PenguinFamily("P001");
         System.out.println("Create a PenguinFamily object with non-default constructor with uniqueID and valid value.");
         System.out.println(penguinFamily.toString());
    }

    @Test
    public void testNonDefaultConstructorWithUniqueIDWithInvalid()
    {
        PenguinFamily penguinFamily = new PenguinFamily("ABCD");
         System.out.println("Create a PenguinFamily object with non-default constructor with uniqueID and invalid value.");
         System.out.println(penguinFamily.toString());
    }

    @Test
    public void testNonDefaultConstructorWithAllWithValid()
    {
        Penguin malePenguin = new Penguin(true, 'M');
        Penguin femalePenguin = new Penguin(true, 'F');
        ArrayList<Chick> chickList = new ArrayList<>();
        ArrayList<Egg> eggList = new ArrayList<>();
        PenguinFamily penguinFamily = new PenguinFamily("P001", malePenguin, femalePenguin, chickList, eggList);
        System.out.println("Create a PenguinFamily object with non-default constructor with all fields and valid value.");
        System.out.println(penguinFamily.toString());
    }

    @Test
    public void testNonDefaultConstructorWithAllWithInvalid()
    {
        Penguin malePenguin = new Penguin(true, 'A');
        Penguin femalePenguin = new Penguin(true, 'B');
        PenguinFamily penguinFamily = new PenguinFamily("ABCD", malePenguin, femalePenguin, null, null);
        System.out.println("Create a PenguinFamily object with non-default constructor with all fields and invalid value.");
        System.out.println(penguinFamily.toString());
    }

    @Test
    public void testGetUniqueID()
    {
        PenguinFamily penguinFamily = new PenguinFamily();
        System.out.println("Create a PenguinFamily object with default constructor to test get methods.");
        System.out.println(penguinFamily.getUniqueID());
    }

    @Test
    public void testGetMalePenguin()
    {
        PenguinFamily penguinFamily = new PenguinFamily();
        System.out.println("Create a PenguinFamily object with default constructor to test get methods.");
        System.out.println(penguinFamily.getMalePenguin());
    }

    @Test
    public void testGetFemalePenguin()
    {
        PenguinFamily penguinFamily = new PenguinFamily();
        System.out.println("Create a PenguinFamily object with default constructor to test get methods.");
        System.out.println(penguinFamily.getFemalePenguin());
    }

    @Test
    public void testGetChickList()
    {
        PenguinFamily penguinFamily = new PenguinFamily();
        System.out.println("Create a PenguinFamily object with default constructor to test get methods.");
        System.out.println(penguinFamily.getChickList());
    }

    @Test
    public void testGetEggList()
    {
        PenguinFamily penguinFamily = new PenguinFamily();
        System.out.println("Create a PenguinFamily object with default constructor to test get methods.");
        System.out.println(penguinFamily.getEggList());
    }

    @Test
    public void testSetUniqueIDWithValid()
    {
        PenguinFamily penguinFamily = new PenguinFamily();
        penguinFamily.setUniqueID("P001");
        System.out.println("Create a PenguinFamily object with default constructor to test set methods.");
        System.out.println(penguinFamily.getUniqueID());
    }

    @Test
    public void testSetUniqueIDWithInvalid()
    {
        PenguinFamily penguinFamily = new PenguinFamily();
        penguinFamily.setUniqueID("ABCD");
        System.out.println("Create a PenguinFamily object with default constructor to test set methods.");
        System.out.println(penguinFamily.getUniqueID());
    }

    @Test
    public void testSetMalePenguinWithValid()
    {
        PenguinFamily penguinFamily = new PenguinFamily();
        penguinFamily.setMalePenguin(new Penguin(true, 'M'));
        System.out.println("Create a PenguinFamily object with default constructor to test set methods.");
        System.out.println(penguinFamily.getMalePenguin());
    }

    @Test
    public void testSetMalePenguinWithInvalid()
    {
        PenguinFamily penguinFamily = new PenguinFamily();
        penguinFamily.setMalePenguin(new Penguin(true, 'F'));
        System.out.println("Create a PenguinFamily object with default constructor to test set methods.");
        System.out.println(penguinFamily.getMalePenguin());
    }

    @Test
    public void testSetFemalePenguinWithValid()
    {
        PenguinFamily penguinFamily = new PenguinFamily();
        penguinFamily.setFemalePenguin(new Penguin(true, 'F'));
        System.out.println("Create a PenguinFamily object with default constructor to test set methods.");
        System.out.println(penguinFamily.getFemalePenguin());
    }

    @Test
    public void testSetFemalePenguinWithInvalid()
    {
        PenguinFamily penguinFamily = new PenguinFamily();
        penguinFamily.setFemalePenguin(new Penguin(true, 'M'));
        System.out.println("Create a PenguinFamily object with default constructor to test set methods.");
        System.out.println(penguinFamily.getFemalePenguin());
    }

    @Test
    public void testSetChickListWithValid()
    {
        PenguinFamily penguinFamily = new PenguinFamily();
        ArrayList<Chick> chickList = new ArrayList<Chick>();
        chickList.add(new Chick(true, 0));
        chickList.add(new Chick(true, 1));
        penguinFamily.setChickList(chickList);
        System.out.println("Create a PenguinFamily object with default constructor to test set methods.");
        System.out.println(penguinFamily.getChickList());
    }

    @Test
    public void testSetChickListWithInvalid()
    {
        PenguinFamily penguinFamily = new PenguinFamily();
        penguinFamily.setChickList(null);
        System.out.println("Create a PenguinFamily object with default constructor to test set methods.");
        System.out.println(penguinFamily.getChickList());
    }

    @Test
    public void testSetEggListWithValid()
    {
        PenguinFamily penguinFamily = new PenguinFamily();
        ArrayList<Egg> eggList = new ArrayList<Egg>();
        eggList.add(new Egg(true, 0, false));
        eggList.add(new Egg(true, 1, false));
        penguinFamily.setEggList(eggList);
        System.out.println("Create a PenguinFamily object with default constructor to test set methods.");
        System.out.println(penguinFamily.getEggList());
    }

    @Test
    public void testSetEggListWithInvalid()
    {
        PenguinFamily penguinFamily = new PenguinFamily();
        penguinFamily.setEggList(null);
        System.out.println("Create a PenguinFamily object with default constructor to test set methods.");
        System.out.println(penguinFamily.getEggList());
    }

    @Test
    public void testClearChickEggCase1()
    {
        // case 1: at least one parent penguin is alive
        PenguinFamily penguinFamily = new PenguinFamily();
        ArrayList<Chick> chickList = new ArrayList<Chick>();
        chickList.add(new Chick(true, 0));
        chickList.add(new Chick(true, 1));
        penguinFamily.setChickList(chickList);
        ArrayList<Egg> eggList = new ArrayList<Egg>();
        eggList.add(new Egg(true, 0, false));
        eggList.add(new Egg(true, 1, false));
        penguinFamily.setEggList(eggList);
        penguinFamily.getMalePenguin().setAlive(false);
        System.out.println("Create a PenguinFamily object with at least one parent penguin is alive to test clearChickEgg() method.");
        System.out.println("Before clearChickEgg():");
        System.out.println(penguinFamily.getChickList());
        System.out.println(penguinFamily.getEggList());
        penguinFamily.clearChickEgg();
        System.out.println("After clearChickEgg():");
        System.out.println(penguinFamily.getChickList());
        System.out.println(penguinFamily.getEggList());
    }

    @Test
    public void testClearChickEggCase2()
    {
        // case 2: both parent penguins are not alive
        PenguinFamily penguinFamily = new PenguinFamily();
        ArrayList<Chick> chickList = new ArrayList<Chick>();
        chickList.add(new Chick(true, 0));
        chickList.add(new Chick(true, 1));
        penguinFamily.setChickList(chickList);
        ArrayList<Egg> eggList = new ArrayList<Egg>();
        eggList.add(new Egg(true, 0, false));
        eggList.add(new Egg(true, 1, false));
        penguinFamily.setEggList(eggList);
        penguinFamily.getMalePenguin().setAlive(false);
        penguinFamily.getFemalePenguin().setAlive(false);
        System.out.println("Create a PenguinFamily object with both parent penguins are not alive to test clearChickEgg() method.");
        System.out.println("Before clearChickEgg():");
        System.out.println(penguinFamily.getChickList());
        System.out.println(penguinFamily.getEggList());
        penguinFamily.clearChickEgg();
        System.out.println("After clearChickEgg():");
        System.out.println(penguinFamily.getChickList());
        System.out.println(penguinFamily.getEggList());
    }

    @Test
    public void testIncreaseIDWithValid()
    {
        PenguinFamily penguinFamily = new PenguinFamily();
        System.out.println("Input a valid number as the numeric part in the uniqueID to test increaseID() method.");
        System.out.println(penguinFamily.increaseID(1));
    }

    @Test
    public void testIncreaseIDWithInvalid()
    {
        PenguinFamily penguinFamily = new PenguinFamily();
        System.out.println("Input an invalid number as the numeric part in the uniqueID to test increaseID() method.");
        System.out.println(penguinFamily.increaseID(-1));
    }

    @Test
    public void testIsParentAliveCase1()
    {
        // case 1: both parent penguins are alive
        PenguinFamily penguinFamily = new PenguinFamily();
        System.out.println("Create a PenguinFamily object with default constructor to test isParentAlive() method.");
        System.out.println(penguinFamily.isParentAlive());
    }

    @Test
    public void testIsParentAliveCase2()
    {
        // case 2: at least one parent penguin is alive
        PenguinFamily penguinFamily = new PenguinFamily();
        penguinFamily.getMalePenguin().setAlive(false);
        System.out.println("Create a PenguinFamily object with default constructor to test isParentAlive() method.");
        System.out.println(penguinFamily.isParentAlive());
    }

    @Test
    public void testLayEggCase1()
    {
        // case 1: both parent penguins are alive, and a random number of eggs (0 or 1 or 2) are laid
        PenguinFamily penguinFamily = new PenguinFamily();
        System.out.println("Create a PenguinFamily object with both parent penguins are alive to test layEgg() method.");
        System.out.println("Before layEgg():");
        System.out.println(penguinFamily.getEggList());
        penguinFamily.layEgg();
        System.out.println("After layEgg():");
        System.out.println(penguinFamily.getEggList());
    }

    @Test
    public void testLayEggCase2()
    {
        // case 2: at least one parent penguin is not alive, so no eggs are laid
        PenguinFamily penguinFamily = new PenguinFamily();
        penguinFamily.getMalePenguin().setAlive(false);
        System.out.println("Create a PenguinFamily object with at least one parent penguin is not alive to test layEgg() method.");
        System.out.println("Before layEgg():");
        System.out.println(penguinFamily.getEggList());
        penguinFamily.layEgg();
        System.out.println("After layEgg():");
        System.out.println(penguinFamily.getEggList());
    }

    @Test
    public void testToStringCase1()
    {
        // case 1: use default constructor
        PenguinFamily penguinFamily = new PenguinFamily();
        System.out.println("Create a PenguinFamily object with default constructor to test toString() method.");
        System.out.println(penguinFamily.toString());
    }

    @Test
    public void testToStringCase2()
    {
        // case 2: use non-default constructor and invalid value
        PenguinFamily penguinFamily = new PenguinFamily("ABCD", new Penguin(true, 'A'), new Penguin(true, 'B'), new ArrayList<Chick>(), new ArrayList<Egg>());
        penguinFamily.getFemalePenguin().setAlive(false);
        ArrayList<Chick> chickList = new ArrayList<Chick>();
        chickList.add(new Chick(true, 1));
        penguinFamily.setChickList(chickList);
        ArrayList<Egg> eggList = new ArrayList<Egg>();
        eggList.add(new Egg(true, 1, false));
        penguinFamily.setEggList(eggList);
        System.out.println("Create a PenguinFamily object with non-default constructor and invalid value to test toString() method.");
        System.out.println(penguinFamily.toString());
    }
}

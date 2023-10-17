//Previous version of PenguinPawPatrol class
//
//STEP 1: read file and instantiate dog, fox, cat, shark, penguin, chick, egg ...
//STEP 2: chick grow, egg grow
//STEP 3: egg --> hatch
//STEP 4: penguin --> lay egg
//STEP 5: fox, cat, shark --attack--> penguin, chick, egg
//STEP 6: dog --attack--> fox, cat
//
//
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class PenguinPawPatrol {
//    private String[] survivalList;
//
//    public PenguinPawPatrol() {
//        survivalList = new String[5];    // [0]: family group, [1]: penguin, [2]: egg, [3]: chick, [4]: overall
//    }
//
//    public PenguinPawPatrol(String[] survival) {
//        this.survivalList = survival;
//    }
//
//    public static void main(String[] args) {
//        PenguinPawPatrol penguinPawPatrol = new PenguinPawPatrol();
//        System.out.println("Welcome to Paw Patrol");
//        System.out.println("=====================");
//        Scanner console = new Scanner(System.in);
//        Validation validation = new Validation();
//        System.out.println("How many patrol dogs (0 or 1 or 2)? ");
//        int dogNumber = console.nextInt();
//
//        // STEP 1: read file and instantiate dog, fox, cat, shark, penguin, chick, egg ...
//        FileIO fileIO = new FileIO();
//        int[] numberAnimal = fileIO.readFile("./colony.txt");
//        // System.out.println(Arrays.toString(numberAnimal));
//
//        ArrayList<Animal> dogList = new ArrayList<>();
//        for (int i = 0; i < dogNumber; i++) {
//            Dog dog = new Dog();
//            dogList.add(dog);
//        }
//
//        ArrayList<PenguinFamily> penguinFamilyList = new ArrayList<>();
//        for (int i = 0; i < numberAnimal[0]; i++) {
//            PenguinFamily penguinFamily = new PenguinFamily();
//            penguinFamily.setUniqueID("P" + String.format("%03d", penguinFamily.increaseID(i)));
//            penguinFamilyList.add(penguinFamily);
//        }
//
//        ArrayList<Animal> foxList = new ArrayList<>();
//        for (int i = 0; i < numberAnimal[1]; i++) {
//            Fox fox = new Fox();
//            foxList.add(fox);
//        }
//
//        ArrayList<Animal> catList = new ArrayList<>();
//        for (int i = 0; i < numberAnimal[2]; i++) {
//            Cat cat = new Cat();
//            catList.add(cat);
//        }
//
//        ArrayList<Animal> sharkList = new ArrayList<>();
//        for (int i = 0; i < numberAnimal[3]; i++) {
//            Shark shark = new Shark();
//            sharkList.add(shark);
//        }
//
//        System.out.println("\nRunning simulation from month July to June.");
//        System.out.println("Number of dog(s): " + dogNumber);
//        int[] monthList = new int[]{7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6};
//        int endNumberEgg = 0;
//        int endNumberHatch = 0;
//        for (int month : monthList) {
//            String monthAsString = "";
//            switch (month) {
//                case 7:
//                    monthAsString = "July";
//                    break;
//                case 8:
//                    monthAsString = "August";
//                    break;
//                case 9:
//                    monthAsString = "September";
//                    break;
//                case 10:
//                    monthAsString = "October";
//                    break;
//                case 11:
//                    monthAsString = "November";
//                    break;
//                case 12:
//                    monthAsString = "December";
//                    break;
//                case 1:
//                    monthAsString = "January";
//                    break;
//                case 2:
//                    monthAsString = "February";
//                    break;
//                case 3:
//                    monthAsString = "March";
//                    break;
//                case 4:
//                    monthAsString = "April";
//                    break;
//                case 5:
//                    monthAsString = "May";
//                    break;
//                case 6:
//                    monthAsString = "June";
//                    break;
//                default:
//                    monthAsString = "Unrecognised";
//                    break;
//            }
//            System.out.println("\nSimulation month: " + monthAsString);
//
//            // STEP 2: chick grow, egg grow, egg hatch
//            int numberNewChick = 0;
//            for (PenguinFamily penguinFamily : penguinFamilyList) {
//                for (Chick chick : penguinFamily.getChickList()) {
//                    if (chick.isAlive()) {
//                        chick.increaseAge();
//                    }
//                }
//                for (Egg egg : penguinFamily.getEggList()) {
//                    if (egg.isAlive()) {
//                        egg.increaseAge();
//                        boolean hatchResult = egg.hatch();
//                        if (hatchResult) {
//                            Chick chick = new Chick(true, 0);
//                            (penguinFamily.getChickList()).add(chick);
//                            numberNewChick += 1;
//                            endNumberHatch += 1;
//                        }
//                    }
//                }
//            }
//            System.out.println("+ new chicks: " + numberNewChick);
//
//            // STEP 3: penguin --> lay egg
//            int numberNewEgg = 0;
//            if (month >= 8 || month <= 2) {
//                for (PenguinFamily penguinFamily : penguinFamilyList) {
//                    if (penguinFamily.isParentAlive()) {
//                        penguinFamily.layEgg();
//                        numberNewEgg += 1;
//                        endNumberEgg += 1;
//                    }
//                }
//            }
//            System.out.println("+ new eggs: " + numberNewEgg);
//
//            // STEP 4: fox, cat, shark --attack--> penguin, chick, egg
//            int numberKillMalePenguin = 0;
//            int numberKillFemalePenguin = 0;
//            int numberKillPenguin = 0;
//            int numberKillChick = 0;
//            int numberKillEgg = 0;
//            for (Animal fox : foxList) {
//                if (fox.isAlive()) {
//                    int[] numberFoxKilled = fox.attack(dogNumber, penguinFamilyList);
//                    numberKillMalePenguin += numberFoxKilled[0];
//                    numberFoxKilled[0] = 0;
//                    numberKillFemalePenguin += numberFoxKilled[1];
//                    numberFoxKilled[1] = 0;
//                    numberKillChick += numberFoxKilled[2];
//                    numberFoxKilled[2] = 0;
//                    numberKillEgg += numberFoxKilled[3];
//                    numberFoxKilled[3] = 0;
//                }
//            }
//            for (Animal cat : catList) {
//                if (cat.isAlive()) {
//                    int[] numberCatKilled = cat.attack(dogNumber, penguinFamilyList);
//                    numberKillMalePenguin += numberCatKilled[0];
//                    numberCatKilled[0] = 0;
//                    numberKillFemalePenguin += numberCatKilled[1];
//                    numberCatKilled[1] = 0;
//                    numberKillChick += numberCatKilled[2];
//                    numberCatKilled[2] = 0;
//                }
//            }
//            for (Animal shark : sharkList) {
//                if (shark.isAlive()) {
//                    int[] numberSharkKilled = shark.attack(dogNumber, penguinFamilyList);
//                    numberKillMalePenguin += numberSharkKilled[0];
//                    numberSharkKilled[0] = 0;
//                    numberKillFemalePenguin += numberSharkKilled[1];
//                    numberSharkKilled[1] = 0;
//                }
//            }
//            numberKillPenguin = numberKillMalePenguin + numberKillFemalePenguin;
//            System.out.println("- penguin killed: " + numberKillPenguin + " (male: " + numberKillMalePenguin + ", female: " + numberKillFemalePenguin + ")");
//            System.out.println("- chick killed: " + numberKillChick);
//            System.out.println("- egg killed: " + numberKillEgg);
//
//            // STEP 5: dog --attack--> fox, cat
//            int numberKillFox = 0;
//            int numberKillCat = 0;
//            for (Animal dog : dogList) {
//                int[] numberDogKilled = dog.attack(dogNumber, new ArrayList<>(), foxList, catList);
//                numberKillFox += numberDogKilled[0];
//                numberDogKilled[0] = 0;
//                numberKillCat += numberDogKilled[1];
//                numberDogKilled[1] = 0;
//            }
//            System.out.println("- fox killed: " + numberKillFox);
//            System.out.println("- cat killed: " + numberKillCat);
//
//            for (PenguinFamily penguinFamily : penguinFamilyList) {
//                if ((!penguinFamily.getMalePenguin().isAlive()) && (!penguinFamily.getFemalePenguin().isAlive())) {
//                    penguinFamily.clearChickEgg();
//                }
//            }
//
//            // STEP 6: monthly report
//            System.out.println("End of month colony status:");
//
//            // Number of complete family groups
//            // What does "complete" family groups mean?
//            int numberCompleteFamily = 0;
//            for (int i = 0; i < penguinFamilyList.size(); i++) {
//                if (penguinFamilyList.get(i).isParentAlive()) {
//                    numberCompleteFamily += 1;
//                }
//            }
//            System.out.println("  complete family: " + numberCompleteFamily);
//
//            // Number of live penguins
//            int numberMalePenguin = 0;
//            int numberFemalePenguin = 0;
//            int numberPenguin = 0;
//            for (int i = 0; i < penguinFamilyList.size(); i++) {
//                if (penguinFamilyList.get(i).getMalePenguin().isAlive()) {
//                    numberMalePenguin += 1;
//                }
//                if (penguinFamilyList.get(i).getFemalePenguin().isAlive()) {
//                    numberFemalePenguin += 1;
//                }
//            }
//            numberPenguin = numberMalePenguin + numberFemalePenguin;
//            System.out.println("  live penguin count: " + numberPenguin + " (male: " + numberMalePenguin + ", female: " + numberFemalePenguin + ")");
//
//            // Number of live chicks
//            int numberChick = 0;
//            for (int i = 0; i < penguinFamilyList.size(); i++) {
//                for (Chick chick : (penguinFamilyList.get(i).getChickList())) {
//                    if (chick.isAlive()) {
//                        numberChick += 1;
//                    }
//                }
//            }
//            System.out.println("  live chick count: " + numberChick);
//
//            // Number of live (uneaten) eggs
//            int numberEgg = 0;
//            for (int i = 0; i < penguinFamilyList.size(); i++) {
//                for (Egg egg : (penguinFamilyList.get(i).getEggList())) {
//                    if (egg.isAlive()) {
//                        numberEgg += 1;
//                    }
//                }
//            }
//            System.out.println("  live egg count: " + numberEgg);
//
//            // Number of fox
//            int numberFox = 0;
//            for (int i = 0; i < foxList.size(); i++) {
//                if (foxList.get(i).isAlive()) {
//                    numberFox += 1;
//                }
//            }
//            System.out.println("  fox count: " + numberFox);
//
//            // Number of cat
//            int numberCat = 0;
//            for (int i = 0; i < catList.size(); i++) {
//                if (catList.get(i).isAlive()) {
//                    numberCat += 1;
//                }
//            }
//            System.out.println("  cat count: " + numberCat);
//
//            // Number of shark
//            int numberShark = 0;
//            for (int i = 0; i < sharkList.size(); i++) {
//                if (sharkList.get(i).isAlive()) {
//                    numberShark += 1;
//                }
//            }
//            System.out.println("  shark count: " + numberShark);
//
//            System.out.println("Press ENTER to continue!");
//            Scanner console2 = new Scanner(System.in);
//            String enterToContinue = console2.nextLine();
//        }
//
//        // STEP 7: final report
//        System.out.println("End of simulation summary:");
//
//        // Number of complete family groups
//        // What does "complete" family groups mean?
//        int endNumberCompleteFamily = 0;
//        for (int i = 0; i < penguinFamilyList.size(); i++) {
//            if (penguinFamilyList.get(i).isParentAlive()) {
//                endNumberCompleteFamily += 1;
//            }
//        }
//        System.out.println("  complete family: " + endNumberCompleteFamily);
//
//        //  Number of live penguins
//        int endNumberMalePenguin = 0;
//        int endNumberFemalePenguin = 0;
//        int endNumberPenguin = 0;
//        for (int i = 0; i < penguinFamilyList.size(); i++) {
//            if (penguinFamilyList.get(i).getMalePenguin().isAlive()) {
//                endNumberMalePenguin += 1;
//            }
//            if (penguinFamilyList.get(i).getFemalePenguin().isAlive()) {
//                endNumberFemalePenguin += 1;
//            }
//        }
//        endNumberPenguin = endNumberMalePenguin + endNumberFemalePenguin;
//        System.out.println("  live penguin count: " + endNumberPenguin + " (male: " + endNumberMalePenguin + ", female: " + endNumberFemalePenguin + ")");
//
//        // Number of live chicks
//        int endNmberChick = 0;
//        for (int i = 0; i < penguinFamilyList.size(); i++) {
//            for (Chick chick : (penguinFamilyList.get(i).getChickList())) {
//                if (chick.isAlive()) {
//                    endNmberChick += 1;
//                }
//            }
//        }
//        System.out.println("  live chick count: " + endNmberChick);
//
//        System.out.println("\nSimulation is done.");
//        System.out.println("Press ENTER to continue!");
//        String enterToContinue = console.nextLine();
//
//        System.out.println("Colony survival rates:");
//        // Family group survival rate: (total_penguin_families_with_two_parents / total_penguin_families_at_the_start)) * 100
//        double familySurvival = (endNumberCompleteFamily * 100.0 / penguinFamilyList.size());
//        penguinPawPatrol.survivalList[0] = "* family group survival rate: " + String.format("%.2f%%", familySurvival);
//        System.out.println(penguinPawPatrol.survivalList[0]);
//
//        // Penguin survival rate: (total_penguin_alive / total_penguins_at_the_start) * 100
//        double penguinSurvival = (endNumberPenguin * 100.0 / (penguinFamilyList.size() * 2.0));
//        penguinPawPatrol.survivalList[1] = "* penguin survival rate: " + String.format("%.2f%%", penguinSurvival);
//        System.out.println(penguinPawPatrol.survivalList[1]);
//
//        // Egg survival rate: (total_eggs_hatched / total_eggs_laid) * 100
//        double eggSurvival = (endNumberHatch * 100.0 / endNumberEgg);
//        penguinPawPatrol.survivalList[2] = "* egg survival rate: " + String.format("%.2f%%", eggSurvival);
//        System.out.println(penguinPawPatrol.survivalList[2]);
//
//        // Chick survival rate: (total_chicks_alive / total_chicks hatched) * 100
//        double chickSurvival = (endNmberChick * 100.0 / endNumberHatch);
//        penguinPawPatrol.survivalList[3] = "* chick survival rate: " + String.format("%.2f%%", chickSurvival);
//        System.out.println(penguinPawPatrol.survivalList[3]);
//
//        // Overall colony survival: (total_penguins_alive + total_chicks_alive / total_penguins_at_the_start)
//        double overallSurvival = (endNumberPenguin + endNmberChick) / (penguinFamilyList.size() * 2.0);
//        penguinPawPatrol.survivalList[4] = "* overall colony survival: " + String.format("%.2f", overallSurvival);
//        System.out.println(penguinPawPatrol.survivalList[4]);
//
//        // STEP 8: write file
//        fileIO.writeFile("./colonyFinal.txt", penguinPawPatrol.survivalList);
//    }
//}

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Farm f1 = populate();
        System.out.println(f1.getSheds());
        print(f1);
        menu(f1);

    }

    public enum animalType{
        DairyCow, BeefCow, Goat, Sheep
    }
    public static Farm populate() throws IOException {
        Farm farm = new Farm();

        File inputFile = new File("farm.txt");
        Scanner file = new Scanner(inputFile);
    try{
        while (file.hasNext()) {
            Farm f1 = new Farm(file.next(),new ArrayList<Shed>());
            int numOfSheds = file.nextInt();
            MilkTank t1 = new MilkTank(file.next(),file.nextInt());
            MilkTank t2 = new MilkTank(file.next(),file.nextInt());
            MilkTank t3 = new MilkTank(file.next(),file.nextInt());
            MilkTank t4 = new MilkTank(file.next(),file.nextInt());
            for (int i = 0; i< numOfSheds; i++) {
                f1.addShed(new Shed());
                int numofAnimals = file.nextInt();
                for (int j = 0; j < numofAnimals; j++) {
                    String type = file.next();
                    if (type.equals("DairyCow")) {
                        f1.getShed(i).addAnimal(new DairyCow(file.next()));
                    } else if (type.equals("BeefCow")) {
                        f1.getShed(i).addAnimal(new BeefCow(file.next(), file.nextInt(), file.nextInt(), file.next()));
                    } else if (type.equals("Sheep")) {
                        f1.getShed(i).addAnimal(new Sheep(file.next(), file.nextInt(), file.nextInt(), file.next()));
                    } else if (type.equals("Goat")) {
                        f1.getShed(i).addAnimal(new Goat(file.next()));
                    }else{
                        throw new java.lang.RuntimeException("File Structure Incorrect");
                    }
                }

            }

            // assume farm.txt always have 3 sheds one shed with no milkable, one with two types of milkables, and the other with one type of milkable

            for (int z = 0; z< numOfSheds;z++){
                int dc =0;
                int goat = 0;
                for (int a = 0;a < f1.getShed(z).getAnimals().size(); a++){

                    if(f1.getShed(z).getAnimal(a) instanceof DairyCow){
                        dc++;
                    }else if(f1.getShed(z).getAnimal(a) instanceof Goat){
                        goat++;
                    }
                }
                if (dc != 0 && goat == 0){
                    f1.getShed(z).setCowTank(t1);
                    f1.getShed(z).installMilkingMachine(new MilkingMachine());
                }else if(dc == 0 && goat != 0){
                    f1.getShed(z).setGoatTank(t4);
                    f1.getShed(z).installMilkingMachine(new MilkingMachine());
                }else if(dc != 0 && goat != 0){
                    f1.getShed(z).setCowTank(t2);
                    f1.getShed(z).setGoatTank(t3);
                    f1.getShed(z).installMilkingMachine(new MilkingMachine());


                }
            }
            farm = f1;
            }}catch(IndexOutOfBoundsException e){
        System.out.println("file structure incorrect");
    }

        return farm;
        }

        public static void print(Farm farm){
            PrintWriter printer = null;
          try{
         printer = new PrintWriter(new File("write.txt"));}
          catch (FileNotFoundException e){
              System.out.println("file not found");
          }
          //owner and num of sheds
          printer.println(farm.getOwner()+ " " +farm.getSheds().size());

          // tanks used in the sheds
          for (int i =0 ; i<farm.getSheds().size();i++){

              if (farm.getShed(i).getGoatTank() != null){
                  printer.println(farm.getShed(i).getGoatTank().getName() + " " + farm.getShed(i).getGoatTank().getCapacity());
              }
              if (farm.getShed(i).getCowTank() != null){
                  printer.println(farm.getShed(i).getCowTank().getName() + " " + farm.getShed(i).getCowTank().getCapacity());
              }
          }

          for (int i =0 ; i<farm.getSheds().size();i++){
              printer.println(farm.getShed(i).getAnimals().size());

              for (int j=0; j<farm.getShed(i).getAnimals().size();j++){

                  //check if milkable
                  if (farm.getShed(i).getAnimal(j) instanceof Milkable){
                  printer.println(farm.getShed(i).getAnimal(j).getClass().getSimpleName() + " "+(farm.getShed(i).getAnimal(j)).getName());
                  }
                  //check if non milkable
                  if (farm.getShed(i).getAnimal(j) instanceof NonMilkable){
                      printer.println(farm.getShed(i).getAnimal(j).getClass() + " " +farm.getShed(i).getAnimal(j).getName() + " " +((NonMilkable) farm.getShed(i).getAnimal(j)).getWeight() + " " + ((NonMilkable) farm.getShed(i).getAnimal(j)).getAge() + " " + ((NonMilkable) farm.getShed(i).getAnimal(j)).getPedigree());
                  }
            }
          }
          printer.close();

        }

        public static void menu(Farm farm) {
        Scanner keyboard = new Scanner(System.in);
        boolean isRunning = true;
        int days=0;
        //main menu
        while (isRunning) {
            days++;
            System.out.println("day: " + days);
            System.out.println("1. view/edit shed\n2. DeleteShed\n3.milk collection");
            int input0 = keyboard.nextInt();
            if (input0 == 1) {
                //first layer
                System.out.println("---Viewing/Editing Shed---");
                System.out.println("pick shed");
                for (int i = 0; i < farm.getSheds().size(); i++) {
                    System.out.println(i + ". " + farm.getSheds().get(i));
                }
                int input1 = keyboard.nextInt();

                //second layer

                System.out.println("currently in : " + farm.getSheds().get(input1));
                Shed currentShed = (Shed) farm.getSheds().get(input1);
                System.out.println("select action \n1. view animals \n2. milk all animal\n3. milk a specific animal \n4. tank actions\n5.  milking machine actions\n6. add animal\n7. edit animal\n8. animal death\n9. sort animal\n10. quit");
                int input2 = keyboard.nextInt();
                if (input2 == 6) {
                    //third layer
                    System.out.println("select animal type");
                    int count = 1;
                    for (int i = 0; i<animalType.values().length;i++){
                        System.out.println(count + ". "+animalType.values()[i]);
                        count++;
                    }
                    int input3 = keyboard.nextInt();
                    //add dairycow
                    if (input3 == 1) {
                        //fourth layer
                        System.out.println("animal name : ");
                        String inputName = keyboard.next();
                        DairyCow addedDC = new DairyCow(inputName);
                        currentShed.addAnimal(addedDC);
                        //add beefcow
                    }else if(input3 == 2){
                        System.out.println("animal name : ");
                        String inputName = keyboard.next();
                        System.out.println("pedigree : ");
                        String inputPedigree = keyboard.next();
                        System.out.println("age");
                        int inputAge = keyboard.nextInt();
                        System.out.println("weight");
                        int inputWeight = keyboard.nextInt();

                        BeefCow addedBC = new BeefCow(inputName,inputWeight,inputAge,inputPedigree);
                        currentShed.addAnimal(addedBC);
                    }
                    else if(input3 == 3){
                        System.out.println("animal name : ");
                        String inputName = keyboard.next();
                        Goat addedGoat = new Goat(inputName);
                        currentShed.addAnimal(addedGoat);
                    }
                    else if(input3 == 4){
                        System.out.println("animal name : ");
                        String inputName = keyboard.next();
                        System.out.println("pedigree : ");
                        String inputPedigree = keyboard.next();
                        System.out.println("age");
                        int inputAge = keyboard.nextInt();
                        System.out.println("weight");
                        int inputWeight = keyboard.nextInt();

                        Sheep addedSheep = new Sheep(inputName,inputWeight,inputAge,inputPedigree);
                        currentShed.addAnimal(addedSheep);
                    }
                } else if (input2 == 1) {
                    System.out.println("--- VIEWING ANIMALS ---");
                    for (int i =0; i<currentShed.getAnimals().size();i++){
                        System.out.println(i + ". " + currentShed.getAnimal(i));
                    }
                } else if (input2 == 2) {
                    System.out.println("--- MILKED ALL ANIMALS ---");
                    currentShed.milkAllAnimal();
                }else if (input2 == 3) {
                    System.out.println("--- MILKING A SPECIFIC ANIMAL ---");
                    System.out.println("pick animal : " + currentShed.getAnimals());
                    int milkAnimal = keyboard.nextInt();
                    currentShed.milkAnimal(currentShed.getAnimal(milkAnimal));
                }else if (input2 == 4) {
                    System.out.println("--- Select Milk Tank Action ---");
                    System.out.println("1. get free space\n2. get capacity\n3. set capacity");
                    int selectedOption = keyboard.nextInt();
                    if (selectedOption == 1){
                        if (currentShed.getCowTank() != null){
                            System.out.println("cow tank free space : " + currentShed.getCowTank().freeSpace());
                        }
                        if (currentShed.getGoatTank() != null){
                            System.out.println("goat tank free space : " +currentShed.getGoatTank().freeSpace());
                        }
                    }else if(selectedOption == 2){
                        if (currentShed.getCowTank() != null){
                            System.out.println("cow tank capacity "+currentShed.getCowTank().getCapacity());
                        }
                        if (currentShed.getGoatTank() != null){
                            System.out.println("goat tank capacity "+ currentShed.getGoatTank().getCapacity());
                        }
                    }else if(selectedOption == 3){
                        System.out.println("select tank to chang capacity:");
                        System.out.println("1. goat tank\n2. cow tank");
                        int selectedTank = keyboard.nextInt();
                        System.out.println("new capacity : ");
                        int newCap = keyboard.nextInt();
                        if (selectedTank ==1){
                            if (currentShed.getGoatTank()==null){
                                System.out.println("no goat tank in shed");
                            }else{
                        currentShed.getGoatTank().setCapacity(newCap);
                        System.out.println("updated capacity" + currentShed.getGoatTank().getCapacity());}}
                        else if (selectedTank ==2){
                            if (currentShed.getCowTank()==null){
                                System.out.println("no cow tank in shed");
                            }else{currentShed.getCowTank().setCapacity(newCap);
                            System.out.println("updated capacity" + currentShed.getCowTank().getCapacity());}}
                    }
                }else if (input2 == 5) {
                    System.out.println("--- Select Milking Machine Action ---");
                    System.out.println("1. set milk tank ");
                    int selectedOption = keyboard.nextInt();

                }else if (input2 == 7) {
                    System.out.println("--- EDITING ANIMALS ---");
                    System.out.println("select animal to edit");
                    for (int i =0; i<currentShed.getAnimals().size();i++){
                        System.out.println(i + ". " + currentShed.getAnimal(i));
                    }
                    //fourth layer
                    int selectedAnimal = keyboard.nextInt();
                    if (currentShed.getAnimal(selectedAnimal) instanceof Milkable ){
                        System.out.println("select field\n1. udder cap\n2.name");
                        //fifth layer
                        int selectedField = keyboard.nextInt();
                        if (selectedField == 1){
                            //sixthlayer
                            System.out.println("enter uddercap ");
                            int editCap = keyboard.nextInt();
                            ((Milkable)currentShed.getAnimal(selectedAnimal)).setUdderCap(editCap);
                        }else if(selectedField == 2){
                            System.out.println("enter name ");
                            String editName = keyboard.next();
                            ( currentShed.getAnimal(selectedAnimal)).setName(editName);
                        }
                    }else if(currentShed.getAnimal(selectedAnimal) instanceof Milkable == false){
                        System.out.println("select field\n1. name\n2. age\n3. weight\n4. pedigree");
                        int selectedField = keyboard.nextInt();
                        if (selectedField == 1){
                            //sixthlayer
                            System.out.println("enter name");
                            String editName = keyboard.next();
                             currentShed.getAnimal(selectedAnimal).setName(editName);
                        }else if(selectedField == 2){
                            System.out.println("enter new age");
                            int editAge = keyboard.nextInt();
                            if (currentShed.getAnimal(selectedAnimal) instanceof BeefCow){
                                 ((BeefCow) currentShed.getAnimal(selectedAnimal)).setAge(editAge);}
                            else { ((Sheep) currentShed.getAnimal(selectedAnimal)).setAge(editAge);}
                        }else if(selectedField == 3){
                            System.out.println("enter weight");
                            int editAge = keyboard.nextInt();
                            if (currentShed.getAnimal(selectedAnimal) instanceof BeefCow){
                                ((BeefCow) currentShed.getAnimal(selectedAnimal)).setWeight(editAge);}
                            else { ((Sheep) currentShed.getAnimal(selectedAnimal)).setWeight(editAge);}
                        }else if(selectedField == 4){
                            System.out.println("enter new pedigree");
                            String editPedigree = keyboard.next();
                            if (currentShed.getAnimal(selectedAnimal) instanceof BeefCow){
                                ((BeefCow) currentShed.getAnimal(selectedAnimal)).setPedigree(editPedigree);}
                            else { ((Sheep) currentShed.getAnimal(selectedAnimal)).setPedigree(editPedigree);}
                        }
                    }

                }else if (input2 == 8) {
                    System.out.println("select animal");
                    for (int i =0; i<currentShed.getAnimals().size();i++){
                        System.out.println(i + ". " + currentShed.getAnimal(i));
                    }
                    int selectedAnimal = keyboard.nextInt();
                    currentShed.death(currentShed.getAnimal(selectedAnimal));


                }else if (input2 == 4) {
                    System.out.println("current shed goat tank : " + currentShed.getGoatTank());
                    System.out.println("current shed Cow tank : " + currentShed.getCowTank());
                } else if (input2 == 9) {
                    System.out.println("select sort options");
                    System.out.println("1.sort normally\n2.sort NonMilkable by weight only\n3.sort NonMilkable by age only ");
                    int selectedOpt = keyboard.nextInt();
                    if (selectedOpt == 1){
                    ArrayList<Milkable>milkables = currentShed.sortMilkables();
                    System.out.println("sorted Milkables: " + milkables);
                    ArrayList<NonMilkable>nonMilkables = currentShed.sortNonMilkables();
                    System.out.println("sorted nonMilkables: " + nonMilkables);}
                    else if(selectedOpt == 2){
                        ArrayList<NonMilkable>nonMilkables = currentShed.sortNonMilkables();
                        Collections.sort(nonMilkables, new CompWeight());
                        System.out.println("sorted by weight: " + nonMilkables );
                    }else if(selectedOpt ==3){
                        ArrayList<NonMilkable>nonMilkables = currentShed.sortNonMilkables();
                        Collections.sort(nonMilkables, new CompAge());
                        System.out.println("sorted by Age: " +nonMilkables );
                    }
                } else if (input2 == 10) {
                    isRunning = false;
                }
            }else if(input0 == 2){
                for (int i =0; i<farm.getSheds().size();i++){
                    System.out.println(i +" " + farm.getShed(i));
                }
                int input = keyboard.nextInt();
                while(input > farm.getSheds().size()-1){
                    System.out.println("try Again");
                    input = keyboard.nextInt();
                }
                farm.deleteShed(farm.getShed(input));

            }else if(input0 == 3){
                farm.milkAll();
            }
        }
        }


    }


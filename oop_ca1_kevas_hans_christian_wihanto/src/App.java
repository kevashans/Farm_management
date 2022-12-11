//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Scanner;
//public class App {
//    public static void main(String[] args) throws IOException {
//
//
//        Farm f1 = populate();
//
//        System.out.println(f1.getSheds());
//
//        menu(f1);
//
//    }
//
//    public static Farm populate() throws IOException {
//        Farm farm = new Farm();
//        File inputFile = new File("farm.txt");
//        Scanner file = new Scanner(inputFile);
//        while (file.hasNext()) {
//
//
//            Farm f1 = new Farm(file.next(), new ArrayList<Shed>(file.nextInt()));
//            MilkTank t1 = new MilkTank(file.next(),file.nextInt());
//            MilkTank t2 = new MilkTank(file.next(),file.nextInt());
//            Shed s1 = new Shed(new ArrayList<Animal>(file.nextInt()));
//            BeefCow bc1 = new BeefCow(file.next(),file.nextInt(),file.nextInt(), file.next());
//            DairyCow dc1 = new DairyCow(file.next());
//            Sheep sh1 = new Sheep(file.next(),file.nextInt(),file.nextInt(), file.next());
//            MilkingMachine m1 = new MilkingMachine(t1);
//
//            Shed s2 = new Shed(new ArrayList<Animal>(file.nextInt()));
//            BeefCow bc2 = new BeefCow(file.next(),file.nextInt(),file.nextInt(), file.next());
//            Sheep sh2 = new Sheep(file.next(),file.nextInt(),file.nextInt(), file.next());
//
//            Shed s3 = new Shed(new ArrayList<Animal>(file.nextInt()));
//            BeefCow bc3 = new BeefCow(file.next(),file.nextInt(),file.nextInt(), file.next());
//            Goat g1 = new Goat(file.next());
//            Sheep sh3 =  new Sheep(file.next(),file.nextInt(),file.nextInt(), file.next());
//            MilkingMachine m2 = new MilkingMachine(t2);
//
//
//            //shed1
//            s1.addAnimal(bc1);
//            s1.addAnimal(dc1);
//            s1.addAnimal(sh1);
//            s1.setTank(t1);
//            s1.installMilkingMachine(m1);
//            f1.addShed(s1);
//
//            //shed2
//            s2.addAnimal(bc2);
//            s2.addAnimal(sh2);
//            f1.addShed(s2);
//
//            //shed3
//            s3.addAnimal(bc3);
//            s3.addAnimal(g1);
//            s3.addAnimal(sh3);
//            s3.setTank(t2);
//            s3.installMilkingMachine(m2);
//
//            f1.addShed(s3);
//
//
//
//
//            farm = f1;
//        }
//        return farm;
//    }
//    public static void menu(Farm farm) {
//        Scanner keyboard = new Scanner(System.in);
//        boolean isRunning = true;
//        //main menu
//        while (isRunning) {
//            System.out.println("1. view/edit shed\n2. Add Shed\n3. DeleteShed\n4. milk collection");
//            int input0 = keyboard.nextInt();
//            if (input0 == 1) {
//                //first layer
//                System.out.println("---Viewing/Editing Shed---");
//                System.out.println("pick shed");
//                for (int i = 0; i < farm.getSheds().size(); i++) {
//                    System.out.println(i + ". " + farm.getSheds().get(i));
//                }
//                int input1 = keyboard.nextInt();
//
//                //second layer
//
//                System.out.println("currently in : " + farm.getSheds().get(input1));
//                Shed currentShed = (Shed) farm.getSheds().get(input1);
//                System.out.println("select action \n1. view animals \n2. milk all animal\n3. milk a specific animal \n4. tank actions\n5.  milking machine actions\n6. add animal\n7. edit animal\n8. animal death\n9. quit");
//                int input2 = keyboard.nextInt();
//                if (input2 == 6) {
//                    //third layer
//                    System.out.println("select animal type");
//                    System.out.println("1. Dairy Cow\n2. Beef Cow\n3. Goat\n4. Sheep");
//                    int input3 = keyboard.nextInt();
//                    //add dairycow
//                    if (input3 == 1) {
//                        //fourth layer
//                        System.out.println("animal name : ");
//                        String inputName = keyboard.next();
//                        DairyCow addedDC = new DairyCow(inputName);
//                        currentShed.addAnimal(addedDC);
//                        //add beefcow
//                    }else if(input3 == 2){
//                        System.out.println("animal name : ");
//                        String inputName = keyboard.next();
//                        System.out.println("pedigree : ");
//                        String inputPedigree = keyboard.next();
//                        System.out.println("age");
//                        int inputAge = keyboard.nextInt();
//                        System.out.println("weight");
//                        int inputWeight = keyboard.nextInt();
//
//                        BeefCow addedBC = new BeefCow(inputName,inputWeight,inputAge,inputPedigree);
//                        currentShed.addAnimal(addedBC);
//                    }
//                    else if(input3 == 3){
//                        System.out.println("animal name : ");
//                        String inputName = keyboard.next();
//                        Goat addedGoat = new Goat(inputName);
//                        currentShed.addAnimal(addedGoat);
//                    }
//                    else if(input3 == 4){
//                        System.out.println("animal name : ");
//                        String inputName = keyboard.next();
//                        System.out.println("pedigree : ");
//                        String inputPedigree = keyboard.next();
//                        System.out.println("age");
//                        int inputAge = keyboard.nextInt();
//                        System.out.println("weight");
//                        int inputWeight = keyboard.nextInt();
//
//                        Sheep addedSheep = new Sheep(inputName,inputWeight,inputAge,inputPedigree);
//                        currentShed.addAnimal(addedSheep);
//                    }
//                } else if (input2 == 1) {
//                    System.out.println("--- VIEWING ANIMALS ---");
//                    System.out.println(currentShed.getAnimals());
//                } else if (input2 == 2) {
//                    System.out.println("--- MILKED ALL ANIMALS ---");
//                    currentShed.milkAllAnimal(currentShed.getAnimals());
//                }else if (input2 == 3) {
//                    System.out.println("--- MILKING A SPECIFIC ANIMAL ---");
//                    System.out.println("pick animal : " + currentShed.getAnimals());
//                    int milkAnimal = keyboard.nextInt();
//                    currentShed.milkAnimal(currentShed.getAnimal(milkAnimal));
//                }else if (input2 == 4) {
//                    System.out.println("--- Select Milk Tank Action ---");
//                    System.out.println("1. get free space\n2. get capacity\n3. set capacity");
//                    int selectedOption = keyboard.nextInt();
//                    if (selectedOption == 1){
//                        System.out.println(currentShed.getMilkTank().freeSpace());
//                    }else if(selectedOption == 2){
//                        System.out.println(currentShed.getMilkTank().getCapacity());
//                    }else if(selectedOption == 3){
//                        System.out.println("new capacity : ");
//                        int newCap = keyboard.nextInt();
//                        currentShed.getMilkTank().setCapacity(newCap);
//                        System.out.println("updated capacity" + currentShed.getMilkTank().getCapacity());
//                    }
//                }else if (input2 == 5) {
//                    System.out.println("--- Select Milking Machine Action ---");
//                    System.out.println("1. set milk tank ");
//                    int selectedOption = keyboard.nextInt();
//
//                }else if (input2 == 7) {
//                    System.out.println("--- EDITING ANIMALS ---");
//                    System.out.println("select animal to edit");
//                    System.out.println(currentShed.getAnimals());
//                    //fourth layer
//                    int selectedAnimal = keyboard.nextInt();
//                    if (currentShed.getAnimal(selectedAnimal) instanceof Milkable ){
//                        System.out.println("select field\n1. udder cap\n2.name");
//                        //fifth layer
//                        int selectedField = keyboard.nextInt();
//                        if (selectedField == 1){
//                            //sixthlayer
//                            System.out.println("enter uddercap ");
//                            int editCap = keyboard.nextInt();
//                            ((Milkable)currentShed.getAnimal(selectedAnimal)).setUdderCap(editCap);
//                        }else if(selectedField == 2){
//                            System.out.println("enter name ");
//                            String editName = keyboard.next();
//                            ( currentShed.getAnimal(selectedAnimal)).setName(editName);
//                        }
//                    }else if(currentShed.getAnimal(selectedAnimal) instanceof Milkable == false){
//                        System.out.println("select field\n1. name\n2. age\n3. weight\n4. pedigree");
//                        int selectedField = keyboard.nextInt();
//                        if (selectedField == 1){
//                            //sixthlayer
//                            System.out.println("enter name");
//                            String editName = keyboard.next();
//                             currentShed.getAnimal(selectedAnimal).setName(editName);
//                        }else if(selectedField == 2){
//                            System.out.println("enter new age");
//                            int editAge = keyboard.nextInt();
//                            if (currentShed.getAnimal(selectedAnimal) instanceof BeefCow){
//                                 ((BeefCow) currentShed.getAnimal(selectedAnimal)).setAge(editAge);}
//                            else { ((Sheep) currentShed.getAnimal(selectedAnimal)).setAge(editAge);}
//                        }else if(selectedField == 3){
//                            System.out.println("enter weight");
//                            int editAge = keyboard.nextInt();
//                            if (currentShed.getAnimal(selectedAnimal) instanceof BeefCow){
//                                ((BeefCow) currentShed.getAnimal(selectedAnimal)).setWeight(editAge);}
//                            else { ((Sheep) currentShed.getAnimal(selectedAnimal)).setWeight(editAge);}
//                        }else if(selectedField == 4){
//                            System.out.println("enter new pedigree");
//                            String editPedigree = keyboard.next();
//                            if (currentShed.getAnimal(selectedAnimal) instanceof BeefCow){
//                                ((BeefCow) currentShed.getAnimal(selectedAnimal)).setPedigree(editPedigree);}
//                            else { ((Sheep) currentShed.getAnimal(selectedAnimal)).setPedigree(editPedigree);}
//                        }
//                    }
//
//                }else if (input2 == 8) {
//                    System.out.println("select animal");
//                    System.out.println(currentShed.getAnimals());
//                    int selectedAnimal = keyboard.nextInt();
//                    currentShed.death(currentShed.getAnimal(selectedAnimal));
//
//
//                }else if (input2 == 4) {
//                    System.out.println("current shed tank : " + currentShed.getMilkTank());
//                }else if (input2 == 9) {
//                    isRunning = false;
//                }
//            }else if(input0 == 4){
//                for (int i = 0; i<farm.getSheds().size();i++){
//                    if (farm.getShed(i).getMilkTank()!= null){
//                    farm.getShed(i).getMilkTank().getFromtank();}
//                }
//            }
//        }
//        }
//
//
//
//}
//

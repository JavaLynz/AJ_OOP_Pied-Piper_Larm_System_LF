import java.util.Random;
import java.util.Scanner;

public class AlarmSystemSimulation {


    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Methods m = new Methods();
        Room[] myRooms = new Room[10];
        int x = 0;
        myRooms[0] = new Room("Garage");
        myRooms[1] = new Room("Vardagsrum");
        myRooms[2] = new Room("Kök");
        myRooms[3] = new Room("Sovrum 1");
        myRooms[4] = new Room("Sovrum 2");
        myRooms[5] = new Room("Sovrum 3");
        myRooms[6] = new Room("Sovrum 4");
        myRooms[7] = new Room("Sovrum 5");
        myRooms[8] = new Room("Hall");
        myRooms[9] = new Room("Trädgården");

//        while (x < 10){
//            System.out.println(myRooms[x].getName());
//            x = x + 1;
//        }

        //add window and door detectors to garage
        myRooms[0].addDoorDetector(new DoorDetector());
        myRooms[0].addWindowDetector(new WindowDetector());

        //add 2 windows, door and motion detectors to vardagsrum
        myRooms[1].addWindowDetector(new WindowDetector());
        myRooms[1].addWindowDetector(new WindowDetector());
        myRooms[1].addMotionDetector(new MotionDetector());
        myRooms[1].addDoorDetector(new DoorDetector());

        //add 1 window to kitchen
        myRooms[2].addWindowDetector(new WindowDetector());

        //add 2 windows to sovrum 1
        myRooms[3].addWindowDetector(new WindowDetector());
        myRooms[3].addWindowDetector(new WindowDetector());

        //add 1 window and 1 door to sovrum 2
        myRooms[4].addWindowDetector(new WindowDetector());
        myRooms[4].addDoorDetector(new DoorDetector());
        //add 1 window to sovrum 3
        myRooms[5].addWindowDetector(new WindowDetector());

        //add 2 windows to sovrum 4
        myRooms[6].addWindowDetector(new WindowDetector());
        myRooms[6].addWindowDetector(new WindowDetector());

        //add 1 window to sovrum 5
        myRooms[7].addWindowDetector(new WindowDetector());

        //add detectors to hallen
        myRooms[8].addWindowDetector(new WindowDetector());
        myRooms[8].addDoorDetector(new DoorDetector());
        myRooms[8].addMotionDetector(new MotionDetector());

        // add motion detector to pool area
        myRooms[9].addMotionDetector(new MotionDetector());
        myRooms[9].activateAllDetectors();

            m.printMenu();

            // test
        //System.out.println(myRooms[8].getName() + ": " + myRooms[8].getDetectors().getLast().getType() + " detektor aktiv? " + myRooms[8].getDetectors().getLast().isActive());





            int choice;
            boolean run = true;

            while (run) {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> {
                        //activate all detectors
                        for (Room r : myRooms) {
                            r.activateAllDetectors();
                            System.out.println(r.getName() + ", alla detektorer är på!");
                            // check status of detectors
//                            for (Detector d : r.getDetectors()) {
//                                System.out.println(r.getName() + ": "  + d.getType() + " is active " + d.isActive());
//                            }

                        }

                        System.out.println("Hela larmsystemet är aktivt!");

                        System.out.println();
                        System.out.println("Tryck enter för meny.");
                        scanner.nextLine();
                        m.printMenu();
                    }
                    case 2 -> {
                        //deactivate all detectors
                        for (Room r : myRooms) {
                            r.deActivateAllDetectors();
                            // check status of detectors
                            for (Detector d : r.getDetectors()) {
                                  System.out.println(r.getName() + ": "  + d.getType() + " is active? " + d.isActive());
                        }

                        }
                        System.out.println("Larmsystemet är avaktivt!");
                        System.out.println("Rökdetektorer alltid på!");

                        System.out.println();
                        System.out.println("Tryck enter för meny.");
                        scanner.nextLine();
                        m.printMenu();
                    }
                    case 3 -> {

                        for (Room r : myRooms) {
                            for (Detector d : r.getDetectors()) {
                                r.deActivateAllDetectors();
                                }
                        }
                        System.out.println("Larmsystemet har avbrytas / återställas.");

                        System.out.println();
                        System.out.println("Tryck enter för meny.");
                        scanner.nextLine();
                        m.printMenu();

                    }

                    case 4 -> {
                        //simulate break+in
                        // generate random room
                        Random random1 = new Random();
                        int randomIndexRoom = random1.nextInt(myRooms.length);
                        // check random number generated and related room
                        //System.out.println(randomIndexRoom);
                        //System.out.println(myRooms[randomIndexRoom].getName());
                        Room selectedRoom = myRooms[randomIndexRoom];
                        //activate if window or door detector
                        int randomIndexDetector = random1.nextInt(selectedRoom.getDetectors().size());
                        Detector selectedDetector = selectedRoom.getDetectors().get(randomIndexDetector);

                        if (selectedDetector instanceof SmokeDetector) {
                            randomIndexDetector = random1.nextInt(selectedRoom.getDetectors().size());
                            selectedDetector = selectedRoom.getDetectors().get(randomIndexDetector);
                        }

                        selectedDetector.detect();



                        System.out.println("Brott har simulerats i: " + selectedRoom.getName() + ", vid " + selectedDetector.getType());


                        System.out.println();
                        System.out.println("Tryck enter för återställning av larmsystemet.");
                        scanner.nextLine();

                        for (Room r : myRooms) {
                            for (Detector d : r.getDetectors()) {
                                r.deActivateAllDetectors();
                            }
                        }
                        System.out.println("Larmsystemet har avbrytas / återställas.");

                        System.out.println();
                        System.out.println("Tryck enter för meny.");
                        scanner.nextLine();


                        m.printMenu();
                    }

                    case 5 -> {
                        //simulate fire
                        // generate random room
                        Random random = new Random();
                        int randomIndexRoom = random.nextInt(myRooms.length);
                        // check random number generated and related room
                        //System.out.println(randomIndexRoom);
                        //System.out.println(myRooms[randomIndexRoom].getName());
                        Room selectedRoom = myRooms[randomIndexRoom];
                         //choose and activate smoke detector
                        for (Detector d : selectedRoom.getDetectors()) {
                                if ( d instanceof SmokeDetector) {
                                    ((SmokeDetector)d).detect();
                                }
                            }


                        // activate alarm
                        System.out.println("Brand har simulerats i: " + selectedRoom.getName());

                        System.out.println();
                        System.out.println("Tryck enter för återställning av larmsystemet.");
                        scanner.nextLine();

                        for (Room r : myRooms) {
                            for (Detector d : r.getDetectors()) {
                                r.deActivateAllDetectors();
                            }
                        }

                        System.out.println("Larmsystemet har avbrytas / återställas.");System.out.println();
                        System.out.println("Tryck enter för meny.");
                        scanner.nextLine();

                        m.printMenu();
                    }


                    case 6 -> {
                        myRooms[9].getDetectors().getLast().detect();
                        System.out.println();
                        System.out.println("Rörelse upptäckt i poolområdet!");

                        System.out.println();
                        System.out.println("Tryck enter för återställning av larmsystemet.");
                        scanner.nextLine();

                        for (Room r : myRooms) {
                            for (Detector d : r.getDetectors()) {
                                r.deActivateAllDetectors();
                            }
                        }
                        System.out.println("Larmsystemet har avbrytas / återställas.");

                        System.out.println();
                        System.out.println("Tryck enter för meny.");
                        scanner.nextLine();

                        m.printMenu();
                    }

                    case 7 -> {
                        // show status of detectors
                        // test
                            //myRooms[7].getDetectors().getLast().activate();
                            //myRooms[8].getDetectors().getLast().activate();
                        for (Room room : myRooms) {
                            for (Detector d : room.getDetectors()) {
                            }
                            System.out.println();
                            System.out.print("I " + room.getName() + ": ");
                            ;
                            for (Detector d : room.getDetectors()) {
                                boolean hasActiveDetector = false;
                                if (d.isActive()) {
                                    System.out.print(d.getType() + " detector is active, ");
                                    hasActiveDetector = true;
                                }
                                if (!hasActiveDetector) {
                                    System.out.print(d.getType() + " detector inactive, ");

                            }
                        }

                        }
                        System.out.println();
                        System.out.println();
                        System.out.println("Tryck enter för meny.");
                        scanner.nextLine();

                        m.printMenu();
                    }


                    case 8 -> {
                        System.out.println("Programmet avslutas\n Tack och hej!");
                        run = false;
                    }

                    default -> {
                        System.out.println("Ogiltigt val.Försök igen.");
                        m.printMenu();
                    }



                }
            }
    }

}
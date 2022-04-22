package com.race;

import java.io.*;
import java.util.*;

public class Formula1ChampionshipManager implements ChampionshipManager {


    static Scanner data=new Scanner(System.in);



    ArrayList<String> driverTeam=new ArrayList<>();


    ArrayList<Formula1Driver> driverList = new ArrayList<>();

    static Formula1ChampionshipManager menu=new Formula1ChampionshipManager();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args, String[] information) throws IOException {
        int length;
        Scanner input = new Scanner(System.in);

        System.out.println("To see all information...");

        boolean con=true;

        while (con) {
            System.out.println("Enter a letter");
            System.out.println("A : Add a new driver"+
                    "\n"+"B : Delete a Driver "+
                    "\n"+"C : Change the constructor team "+
                    "\n"+"D : Display all Statistics "+
                    "\n"+"E : Display Table"+
                    "\n"+"F : Add a race "+
                    "\n"+"G : Save "+
                    "\n"+"H : Load  "+
                    "\n"+"I : Exit ");
            String select = scanner.next();
            if (select.equalsIgnoreCase("A")) {
                menu.newDriver();
//                continue;
            } else if (select.equalsIgnoreCase("B")) {
                menu.deleteDriver();
            } else if (select.equalsIgnoreCase("C")) {
                menu.changeDriverTeam();
            } else if (select.equalsIgnoreCase("D")) {
                menu.displayDriverStatistics();
            } else if (select.equalsIgnoreCase("E")) {
                menu.newDriver();
            } else if (select.equalsIgnoreCase("F")) {
                menu.addNewRacePositions();
            } else if (select.equalsIgnoreCase("G")) {


                System.out.println("To see all information...");
                length = input.nextInt();
                information = new String[length];
                //to store data to an array
                for(int data = 0; data<length; data++){
                    information[data] = input.next();
                }
                input.close();
                for(int data = 0; data<length; data++){
                    System.out.println("Your details" +(data+1));
                }
                menu.saveData(information);
            } else if (select.equalsIgnoreCase("H")) {
                menu.readSavedData(information);
            } else if (select.equalsIgnoreCase("I")) {
                break;
            }else{
                System.out.println("Invalid!!!");
            }
        }

    }
    @Override
    public void newDriver() {

        //Asking questions
        System.out.println("Enter the driver name: ");
        String name = data.next();

        System.out.println("Enter the Team: ");
        String team = data.next();

        System.out.println("Enter driver Location: ");
        String location = data.next();


        boolean driverExists = false;

        //team unique or not
        for (int i = 0; i < driverTeam.size()-1; i++) {
            if (driverTeam.get(i).equalsIgnoreCase(team)) {
                driverExists = true;
                System.out.println("Please use another team name...");

                break;
            }
        }


        if (!driverExists) {
            Formula1Driver driver = new Formula1Driver(name,team,location);
            driverList.add(driver);
            driverTeam.add(team);
            System.out.println("Driver added sucessfully...");


        }

    }

    @Override
    public void deleteDriver() {
        System.out.println("Enter the driver name you want to remove: ");
        String nameDriver = data.next();

        boolean driverExists = false;
        for (int j = 0; j < driverList.size()-1; j++) {
            if (driverList.get(j).getDriverName().equalsIgnoreCase(nameDriver)) {
                driverExists = true;
                driverList.remove(j);
                driverTeam.remove(j);
                System.out.println("Driver Details Deleted successfully..");

                break;
            }

        }
        if (!driverExists){
            System.out.println("No Driver Registered by This Name...");
        }


    }


    @Override
    public void changeDriverTeam() {
        System.out.println("Enter the team do you want to switch : ");
        String changeTeam = data.next();


        System.out.println("Enter the driver name: ");
        String name = data.next();
        boolean teamExists = false;

        for (int y = 0; y < driverTeam.size()-1; y++) {
            if (driverTeam.get(y).equalsIgnoreCase(changeTeam)) {
                teamExists = true;
                Formula1Driver driver = driverList.get(y);
                driver.setDriverName(name);
                driverList.set(y, driver);
                System.out.println("Driver changed ..");

                break;
            }

        }
        if (!teamExists){

            System.out.println("No team Registered by This Name...");
        }



    }

    @Override
    public void displayDriverStatistics() {

        System.out.println("Enter the driver name: ");
        String name = data.next();

        boolean driverExists = false;

        for (Formula1Driver driver:driverList){

            if (driver.getDriverName().equalsIgnoreCase(name)){
                driverExists = true;

                System.out.println("DRIVER team : " + driver.getTeam());
                System.out.println("DRIVER location : " + driver.getLocation());
                System.out.println("First positions : " + driver.getnoOfFirstPositions());
                System.out.println("Second positions : " + driver.getnoOfSecondPositions());
                System.out.println("Third positions : " + driver.getnoOfThirdPositions());
                System.out.println("Full points : " + driver.gettotalDriverFullPoints());
            }
        }
        if (!driverExists){


            System.out.println("No driver Registered by This Name...");
        }


    }

    @Override
    public void displayDriverTable() {


    }

    public void addNewRacePositions(String raceDate, Map<String, Integer> positions, Formula1ChampionshipManager d) {
        System.out.print(" Enter the Date (YYYY/MM/DD) : ");
        String rDate = data.next();
        boolean raceExists = false;


        Map<String,Integer> places = new HashMap<>();

        for (int i = 0; i < d.driverList.size(); i ++ ){
            System.out.println("Enter driver name : ");
            String dName = data.next();
            if (dName.equals("-1"))
                raceExists = true;
                break;
            System.out.println("Enter driver place : ");
            int position = data.nextInt();
            positions.put(dName,position);
        }
        if (!raceExists){


            System.out.println("Data added...");
        }
        }



//        Iterator it = places.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry) it.next();
//            // Update statistics
//            for (Formula1Driver d : driverList) {
//                if (d.getDriverName().equals(pair.getKey())) {
//                    d.calculations(true, (int) pair.getValue()); // Set positions
//                }
//            }




    public void saveData(String[] information) throws IOException {
        information = Arrays.stream(information)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\HP\\Desktop\\Assignment\\inputData.txt", false));
        for(int i = 0; i < information.length; i++) {
            writer.write(information[i].toString());
            writer.newLine();
        }
        writer.flush();
        System.out.println("Data Entered in to the file successfully");


    }

    public void readSavedData(String[] information) {
        information = Arrays.stream(information)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);
        try {
            File myObj = new File("C:\\Users\\HP\\Desktop\\Assignment\\inputData.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }







}




package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RunManager {

    private static HashMap<String, ArrayList<Double>> runData = new HashMap<>();

    public static void main(String[] args) {
        userSelection();
    }

    //User options menu
    public static int userMenu() {
        System.out.println("Run Time Analyzer\n" + "Please make a selection and press enter: ");
        System.out.println("(1) Enter new run time: ");
        System.out.println("(2) Print times for each location: ");
        System.out.println("(3) Print fastest times for each location: ");
        System.out.println("(4) Exit program" + "\n:");

        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        return Integer.parseInt(choice);
    }

    public static void userSelection() {
        Scanner in = new Scanner(System.in);
        while (true) {
            int choice = userMenu();
            //Selection 1
            if (choice == 1) {
                System.out.println("Enter the location of the run: ");
                String lake = in.nextLine();
                System.out.println("Enter your run time in (mm:ss) format: ");
                String t0 = in.nextLine();
                String t1 = t0.replaceAll(":", "."); //replace ":" from user input with "."
                double time = Double.parseDouble(t1); //convert user input to double
                if (runData.get(lake) == null) {
                    runData.put(lake, new ArrayList<>());
                    runData.get(lake).add(time);
                }
                runData.get(lake).add(time);
            } //Selection 2
            else if (choice == 2) {
                for (Map.Entry<String, ArrayList<Double>> lapTimes : runData.entrySet()) {
                    String lakes = lapTimes.getKey();
                    ArrayList times = lapTimes.getValue();
                    System.out.println("Lake " + lakes + ":\tTime: " + times);
                }
            } //Selection 3
            else if (choice == 3) {
                System.out.println();
            } //Selection 4
            else {
                System.out.println("Exiting Program");
                break;
            }
        }
    }
}
//            if (runData.containsKey(lake) ){
//                //runData.put(lake, ArrayList.add(time));
//                runData.get(lake).add(time);
//                userMenu();
//            }
//            else {
//                runData.put(lake, null);
//                runData.put((lake), ArrayList.add(time));
//                userMenu();
//            }
//            for (Map.Entry<String, ArrayList<Double>> lapTimes : runData.entrySet() ) {
//                String lakes = lapTimes.getKey();
//                ArrayList times = lapTimes.getValue();
//                System.out.println("Lake " + lakes + ":\tTime: " + times);
//            }
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

    /* User options menu */
    public static int userMenu() {
        System.out.println("RUN TIME ANALYZER\n" + "PLEASE MAKE A SELECTION AND PRESS ENTER: ");
        System.out.println("(1) ENTER NEW RUN TIME: ");
        System.out.println("(2) PRINT TIMES FOR EACH LOCATION: ");
        System.out.println("(3) PRINT FASTEST TIME FOR EACH LOCATION: ");
        System.out.println("(4) EXIT PROGRAM" + "\n:");

        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        return Integer.parseInt(choice);
    }

    public static void userSelection() {
        Scanner in = new Scanner(System.in);
        while (true) {
            int choice = userMenu();
            /* Selection 1 */
            if (choice == 1) {
                System.out.println("ENTER THE LAKE'S NAME: ");
                String lake = in.nextLine().toUpperCase();
                System.out.println("ENTER YOUR RUN TIME IN (MM:SS) FORMAT: ");
                String t0 = in.nextLine();
                String t1 = t0.replaceAll(":", "."); //replace ":" from user input with "."
                double time = Double.parseDouble(t1); //convert user input to double
                if (runData.get(lake) == null) {
                    runData.put(lake, new ArrayList<>());
                    runData.get(lake).add(time);
                } else {
                    runData.get(lake).add(time);
                }
            /* Selection 2 */
            } else if (choice == 2) {
                for (Map.Entry<String, ArrayList<Double>> lapTimes : runData.entrySet()) {
                    String lakes = lapTimes.getKey();
                    ArrayList times = lapTimes.getValue();
                    System.out.println("LAKE " + lakes + "\nTIME(S):");
                    for (Object list : times) {
                        String t = list.toString();
                        String t2 = t.replace(".", ":");
                        System.out.println(t2);
                    }
                }
            /* Selection 3 */
            } else /* Selection 4 */if (choice == 3)
                for (Map.Entry<String, ArrayList<Double>> lapTimes : runData.entrySet()) {
                    String lakes = lapTimes.getKey();
                    ArrayList times = lapTimes.getValue();
                    for (Object d : times) {
                        System.out.println(d);
                    }
                    // System.out.println("Lake " + lakes + ":\tTime: " + times);
                }
            else {
                System.out.println("EXITING PROGRAM");
                break;
            }
        }
    }
}
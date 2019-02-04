package survivalgame;

import java.io.IOException;
import java.util.Scanner;

public class SurvivalGame {

    public static Items food = new Items("food", 0);
    public static Items bricks = new Items("bricks", 0);
    public static Stats citySize = new Stats("citySize", 0);
    public static Stats residents = new Stats("residents", 0);
    public static Stats bricksPerCycle = new Stats("bricksPerCycle", 1);

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {

        intro();
        while (true) {
            mainScreen();
        }
    }

    public static void intro() {
        System.out.println("- Welcome to The Survival Game by Ashley Best");
        System.out.println("- Your goal is to increase the size of your city.");
        System.out.println("- Type in 'info' to see items and stats.");
        System.out.println("- Type 'build' to build new structures.");
        System.out.println("- Press enter to get more bricks.");
        System.out.println("- Good luck.");
        System.out.println("");
    }

    public static void mainScreen() throws IOException, InterruptedException {

        String enter = input.nextLine();
        if (enter.isEmpty()) {
            cycleChecker();
            getBricks();
        } else if (enter.equals("info")) {
            info();
        } else if (enter.equals("build")) {
            build();
        }

    }

    public static void getBricks() {
        int totalBricks = bricks.getValue();
        bricks.setValue(totalBricks += bricksPerCycle.getValue());
        System.out.println("");
        System.out.println("Bricks acquired: " + bricksPerCycle.getValue());
        System.out.println("");
    }

    public static void cycleChecker(){
        bricksPerCycle.setValue((residents.getValue()*5)+1);
    }
    
    public static void info() {
        System.out.println("");
        System.out.println("--Items--");
        System.out.println("Bricks: " + bricks.getValue());
        System.out.println("--Stats--");
        System.out.println("City Size: " + citySize.getValue());
        System.out.println("Residents: " + residents.getValue());
        System.out.println("Bricks per cycle: " + bricksPerCycle.getValue());
    }

    public static void build() {
        int totalBricks = bricks.getValue();
        int totalResidents = residents.getValue();
        System.out.println("1. Hut | 1 Resident | 20 Bricks");
        System.out.println("2. House | 5 Residents | 100 Bricks");
        System.out.println("3. Mansion | 20 Residents | 500 Bricks");

        try {
            int choice = input.nextInt();
            if (choice == 1 && bricks.getValue() >= 20) {
                int totalCitySize = citySize.getValue();
                citySize.setValue(totalCitySize += 1);
                bricks.setValue(totalBricks - 20);
                residents.setValue(totalResidents += 1);
                System.out.println("Hut built!");
            } else if (choice == 2 && bricks.getValue() >= 100) {
                int totalCitySize = citySize.getValue();
                citySize.setValue(totalCitySize += 5);
                bricks.setValue(totalBricks - 100);
                residents.setValue(totalResidents += 5);
                System.out.println("House built!");
            } else if (choice == 3 && bricks.getValue() >= 500) {
                int totalCitySize = citySize.getValue();
                citySize.setValue(totalCitySize += 25);
                bricks.setValue(totalBricks - 500);
                residents.setValue(totalResidents += 20);
                System.out.println("Mansion built!");
            } else {
                System.out.println("Invalid option.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}

package org.example;

import java.util.*;

public class Main {

    public static boolean isInteger(String input){
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        try {
            Integer.valueOf(input);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
    public static boolean isInteger(Character input){
        try {
            int tryThis = (int)input;
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e){
            return false;
        }
        return true;
    }
    public static Grid StartGame(){
        // Get Rows and Cols
        System.out.println("New game: Setup");
        System.out.println("Which size grid would you like? Enter a number below to select.");
        System.out.println("0. Small (5x5) \n1. Medium (8x8) \n2. Large (12x12) \n3. Custom");
        Scanner userInput = new Scanner (System.in);
        String Response = userInput.nextLine();
        int size;
        if (isInteger(Response)){
            size = Integer.valueOf(Response);
        }
        else{
            System.out.println("Input error. Type a number only (e.g. type 0, 1, 2, or 3)");
            return StartGame();
        }
        int[] dimensions = switchOnGridSize(size);
        int rows = dimensions[0];
        int cols = dimensions[1];
        Grid OutGrid = new Grid(rows, cols);

        // set mines
        System.out.println("Select difficulty option. \n 0. Sparse mine density \n 1. Regular mine density \n " +
                "2. Heavy mine density \n 3. Insane mine density");
        Response = userInput.nextLine();
        int densitySelection;
        if (isInteger(Response)) {
            densitySelection = Integer.valueOf(Response);
        }
        else{
            OutGrid.PrintErrorMessage("\nInput error. Insane mode selected.");
            densitySelection = 3;
        }
        double mineDensity = switchOnMineDensity(densitySelection);
        OutGrid.SetMines(mineDensity);

        // Set the remaining tiles
        OutGrid.SetRemainingTiles();
        OutGrid.PrintGrid();
        OutGrid.GameplayLoop();

        return OutGrid;
    }

    // returns an integer as [rows, cols]
    public static int[] switchOnGridSize(int selection){
        switch(selection){
            case 0:
                return new int[] {5, 5};
            case 1:
                return new int[] {8, 8};
            case 2:
                return new int[] {12, 12};
            case 3:
                System.out.println("Enter how many rows should the grid have?");
                Scanner switchScanner = new Scanner (System.in);
                String rows = switchScanner.nextLine();
                System.out.println("Enter how many columns should the grid have?");
                String cols = switchScanner.nextLine();
                if (!(isInteger(rows) && isInteger(cols))){
                    System.out.println("\nError: non-integer input. Try that again.");
                    return switchOnGridSize(selection);
                }
                int rowsOut = Integer.valueOf(rows);
                int colsOut = Integer.valueOf(cols);
                return new int[] {rowsOut, colsOut};
            default:
                System.out.println("Input error. Type a number only (e.g. type 0, 1, 2, or 3)");
                Scanner errorScanner = new Scanner (System.in);
                int choice = Integer.valueOf(errorScanner.nextLine());
                return switchOnGridSize(choice);
        }
    }

    public static double switchOnMineDensity(int selection){
        switch(selection){
            case 0: return 0.05;
            case 1: return 0.07;
            case 2: return 0.1;
            case 3: return 0.2;
            default:
                System.out.println("Input error. Type a number only (e.g. type 0, 1, 2, or 3)");
                Scanner errorScanner = new Scanner (System.in);
                int choice = Integer.valueOf(errorScanner.nextLine());
                return switchOnMineDensity(choice);
        }
    }

    public static void main(String[] args) {
        Grid GameGrid = StartGame();
    }
}
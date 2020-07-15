package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);

        char[] field = new char[9];

        System.out.print("Enter cells: ");
        String cells = scanner.nextLine();
        field = cells.toCharArray();

        printTheField(field);
        System.out.println(currentState(field));



    }

    private static void printTheField(char[] field){
        System.out.println("---------");

        System.out.println("| " + field[0] + " " +  field[1] + " " +  field[2] + " |");
        System.out.println("| " + field[3] + " " +  field[4] + " " +  field[5] + " |");
        System.out.println("| " + field[6] + " " +  field[7] + " " +  field[8] + " |");

        System.out.println("---------");

    }

    private static String currentState(char[] field){
        //"Game not finished" - when no side has a three in a row but the field has empty cells;

        //"Draw" - when no side has a three in a row and the field has no empty cells;
        //"X wins" - when the field has three X in a row;
        //"O wins" - when the field has three O in a row;
        //"Impossible" - when the field has three X in a row as well as three O in a row. Or the field has a lot more X's than O's or vice versa (if the difference is 2 or more, should be 1 or 0).

    }

}

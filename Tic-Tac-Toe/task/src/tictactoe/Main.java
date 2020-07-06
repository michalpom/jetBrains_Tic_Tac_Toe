package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);

        char[] symbol = new char[9];

        System.out.print("Enter cells: ");
        String cells = scanner.nextLine();
        symbol = cells.toCharArray();

        System.out.println("---------");

        System.out.println("| " + symbol[0] + " " +  symbol[1] + " " +  symbol[2] + " |");
        System.out.println("| " + symbol[3] + " " +  symbol[4] + " " +  symbol[5] + " |");
        System.out.println("| " + symbol[6] + " " +  symbol[7] + " " +  symbol[8] + " |");

        System.out.println("---------");
    }
}

package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);
        char[] field = new char[9];

        //asking for field input `
        System.out.print("Enter cells: ");
        String cells = scanner.nextLine(); //reading as string
        field = cells.toCharArray(); //parse string to array

        //conversion array to matrix
        char[][] matrix = new char[3][3];
        matrix = conversionArrToMatrix(field);

        FieldState currentState = new FieldState(matrix, field);
        //printing the field
        currentState.printTheField(field);

        //printing matrix
        //printTheMatrix(matrix);
        System.out.println(currentState.currentState(matrix));
    }




    private static char[][] conversionArrToMatrix(char[] field) {
        char[][] matrix = new char[3][3];
        for (int i = 0; i < 3; i++) {
            matrix[0][i] = field[i];
        }
        for (int i = 0; i < 3; i++) {
            matrix[1][i] = field[i + 3];
        }
        for (int i = 0; i < 3; i++) {
            matrix[2][i] = field[i + 6];
        }
        return matrix;
    }

}

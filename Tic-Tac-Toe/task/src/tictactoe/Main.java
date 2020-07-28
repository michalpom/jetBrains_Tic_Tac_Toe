package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);
        char[] field = new char[9];

        //asking for field input
        System.out.print("Enter cells: ");
        String cells = scanner.nextLine(); //reading as string
        field = cells.toCharArray(); //parse string to array

        //conversion array to matrix
        char[][] matrix = new char[3][3];
        matrix = conversionArrToMatrix(field);

        FieldState currentState = new FieldState(matrix, field);
        //printing the field
        //currentState.printTheField();
        //printing the matrix
        currentState.printTheMatrix();

        EnterTheSign enterTheSign = new EnterTheSign();
        //Enter the coordinates:
        //1. check the values
        enterTheSign.setMatrix(currentState.getMatrix());

        //2. if values valid enter the sandman xd and return new matrix
        if(enterTheSign.validateTheCoordinates()){
            enterTheSign.insertCell();
            //3. set new matrix to FieldState object, print the matrix
            currentState.setMatrix(enterTheSign.getMatrix());
        }


        currentState.printTheMatrix();
        //System.out.println(currentState.returnCurrentState());
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


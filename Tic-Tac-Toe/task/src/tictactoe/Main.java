package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here

        //new game loop for stage 5.
        char[][] matrix = new char[3][3];
        //empty field
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = '_';
            }

        }
        FieldState currentState = new FieldState(matrix);

        currentState.printTheMatrix();
        EnterTheSign enterTheSign = new EnterTheSign();
        //setting start field
        enterTheSign.setMatrix(currentState.getMatrix());

        //Enter the coordinates:
        //if values valid enter them to matrix and return new matrix
        boolean gameFinished = false;
        int whoseTurn = 0;

        while (!gameFinished) {
            //x or o move
            if (enterTheSign.validateTheCoordinates()) {
                enterTheSign.insertCell(whoseTurn);
                currentState.setMatrix(enterTheSign.getMatrix());
                if (whoseTurn == 0) {
                    whoseTurn = 1;
                } else {
                    whoseTurn = 0;
                }
            }
            currentState.printTheMatrix();

            if (currentState.returnCurrentState().equals("Draw") || currentState.returnCurrentState().equals("O wins")
                    || currentState.returnCurrentState().equals("X wins")) {
                System.out.println(currentState.returnCurrentState());
                gameFinished = true;
            }

        }
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


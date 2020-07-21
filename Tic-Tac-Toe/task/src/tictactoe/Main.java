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
        char[][] matrix = new char[3][3];

        matrix = conversionArrToMatrix(field);
        //test print
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j]);

            }
            System.out.println();
        }
        System.out.println(currentState(matrix));


    }

    private static void printTheField(char[] field) {
        System.out.println("---------");

        System.out.println("| " + field[0] + " " + field[1] + " " + field[2] + " |");
        System.out.println("| " + field[3] + " " + field[4] + " " + field[5] + " |");
        System.out.println("| " + field[6] + " " + field[7] + " " + field[8] + " |");

        System.out.println("---------");

    }

    private static String currentState(char[][] matrix) {
        int countX = 0;
        int countO = 0;
        int allX = 0;
        int allO = 0;
        int empty = 0;
        //counting empty Xs and Os
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == '_') {
                    empty++;
                }

                if (matrix[i][j] == 'X') {
                    allX++;
                }
                if (matrix[i][j] == 'O') {
                    allO++;
                }
            }
        }

        //check if there are three X or Y horizontal
        for (int i = 0; i < 3; i++) {
            countX = 0;
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 'X') {
                    countX++;
                    if (countX == 3) {
                        break;
                    }
                }
            }
            if (countX == 3) {
                break;
            }
        }
        for (int i = 0; i < 3; i++) {
            countO = 0;
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 'O') {
                    countO++;
                    if (countO == 3) {
                        break;
                    }
                }
            }
            if (countO == 3) {
                break;
            }
        }

        //vertical? xd
        if(countX<3){
            for (int i = 0; i < 3; i++) {
                countX = 0;
                for (int j = 0; j < 3; j++) {
                    if (matrix[j][i] == 'X') {
                        countX++;
                        if (countX == 3) {
                            break;
                        }
                    }
                }
                if (countX == 3) {
                    break;
                }
            }}
        if(countO<3){
            for (int i = 0; i < 3; i++) {
                countO = 0;
                for (int j = 0; j < 3; j++) {
                    if (matrix[j][i] == 'O') {
                        countO++;
                        if (countO == 3) {
                            break;
                        }
                    }
                }
                if (countO == 3) {
                    break;
                }
            }}
        //diagonal
        if (countX < 3 || countO < 3) {
            if (matrix[0][0] == 'X' && matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]) {
                countX = 3;
            }
            if (matrix[0][0] == 'O' && matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]) {
                countO = 3;
            }
            if (matrix[0][2] == 'X' && matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0]) {
                countX = 3;
            }
            if (matrix[0][2] == 'O' && matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0]) {
                countO = 3;
            }
        }


        if (countX < 3 && countO < 3 && empty > 0 && (Math.abs(allO-allX) <2)) {
            //"Game not finished" - when no side has a three in a row but the field has empty cells;
            return "Game not finished";
        } else if (countX < 3 && countO < 3 && empty == 0) {
            //"Draw" - when no side has a three in a row and the field has no empty cells;
            return "Draw";
        } else if ((countO == 3 && countX == 3) || (Math.abs(allO-allX) >1)) {
            //"Impossible" - when the field has three X in a row as well as three O in a row. Or the field has a lot more X's than O's or vice versa (if the difference is 2 or more, should be 1 or 0).
            return "Impossible";
        } else if (countO == 3) {
            //"O wins" - when the field has three O in a row;
            return "O wins";
        } else if (countX == 3) {
            //"X wins" - when the field has three X in a row;
            return "X wins";
        } else {
            return "Impossible";
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

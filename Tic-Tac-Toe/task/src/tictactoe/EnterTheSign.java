package tictactoe;

import java.util.Scanner;

public class EnterTheSign {
    private int x;
    private int y;
    private char[][] matrix = new char[3][3];

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public boolean validateTheCoordinates() {
        Scanner scanner = new Scanner(System.in);
        boolean validValues = false;
        while (!validValues) {
            System.out.print("Enter the coordinates: ");
            if (scanner.hasNextInt()) {
                this.x = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    this.y = scanner.nextInt();
                    if (valuesInRange(this.x, this.y)) {
                        if (isCellFree(this.x, this.y)) {
                            validValues = true;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                        }
                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }

                } else {
                    System.out.println("You should enter numbers!");
                }
            } else {
                System.out.println("You should enter numbers!");
            }
            scanner.nextLine();
        }
        return true;}

    private boolean valuesInRange(int x, int y) {
        if ((x > 0 && x < 4) && (y > 0 && y < 4)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isCellFree(int x, int y) {

        if (this.matrix[3 - y][x - 1] == '_') {
            return true;
        } else {
            return false;
        }
    }

    public void insertCell(){
        //entering value to a cell
        this.matrix[3 - this.y][this.x - 1] = 'X';
    }
}

package tictactoe;

public class FieldState {
    private int countX;
    private int countO;
    private int allX;
    private int allO;
    private int empty;
    private char[][] matrix;
    private char[] field;

    public FieldState(char[][] matrix, char[] field) {
        this.matrix = matrix;
        this.field = field;
    }
    public FieldState(char[][] matrix) {
        this.matrix = matrix;
    }

    //setters
    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public void setField(char[] field) {
        this.field = field;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public char[] getField() {
        return field;
    }

    public void printTheField() {
        //simple printing from array
        System.out.println("---------");

        System.out.println("| " + field[0] + " " + field[1] + " " + field[2] + " |");
        System.out.println("| " + field[3] + " " + field[4] + " " + field[5] + " |");
        System.out.println("| " + field[6] + " " + field[7] + " " + field[8] + " |");

        System.out.println("---------");

    }

    public void printTheMatrix(){
        //printing from matrix
        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }
    private void calculateCurrentState(char[][] matrix) {
        countX = 0;
        countO = 0;
        allX = 0;
        allO = 0;
        empty = 0;
        //counting empty, Xs and Os
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

        //check if there are three X or Y vertical
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

    }

    public String returnCurrentState()
    {
        //first calculate
        calculateCurrentState(this.matrix);

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
}


import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        String[][] matrix = new String[n][n];

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                matrix[i][j] = ".";
            }

        }

        //middle
        int middle = n/2;

        for (int i = 0; i < n; i++) {
            matrix[middle][i] = "*"; //row
            matrix[i][middle] = "*"; //column
        }

        //main and secondary diagonal

        for (int i = 0; i < n ; i++) {
            matrix[i][i] =  "*";
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j == n - 1){
                    matrix[i][j] =  "*";
                }

            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();

        }
        
    }
}
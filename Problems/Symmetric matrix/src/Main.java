import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        //save values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        //check of symmetry
        boolean symmetric = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]){
                    symmetric = false;
                }
            }
        }

        if (symmetric){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
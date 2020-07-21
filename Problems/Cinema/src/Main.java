import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];

        //save values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int places = scanner.nextInt();

        //check of available places
        int row = 0;
        int counter = 0;
        for (int i = 0; i < n; i++) {
            counter=0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0){
                    counter++;
                    if (counter==places){
                        row = i +1;
                        break;
                    }
                    continue;
                }else{
                    counter=0;
                    continue;
                }

            }
            if (counter==places){
                break;
            }
        }

        System.out.println(row);

    }
}
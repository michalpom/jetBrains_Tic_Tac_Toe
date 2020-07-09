import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int shift = scanner.nextInt();

        shift = shift%input.length;

        for (int i = 0; i < shift; i++){
            String last = input[input.length-1];
            for (int j = input.length; j >= 2; j--){
                input[j-1]=input[j-2];
            }
            input[0]=last;


        }

        for (int k = 0; k < input.length; k++){
            System.out.print(input[k]+ " ");
        }

    }
}
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int a = scanner.nextInt();
        int[] array = new int[a];

        for (int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        int sum = 0;

        for (int i = 0; i < array.length; i++){
            if (array[i] > n) {
                sum = sum + array[i];
            }
        }

        System.out.println(sum);

    }
}
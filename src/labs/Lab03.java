package labs;

import mooc.EdxIO;

public class Lab03 {
    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {

            int n = io.nextInt();
            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = io.nextInt();
            }

            io.print(1 + " ");

            for (int j = 1; j < n; j++) {
                int k = 0;
                int i = j - 1;
                while (i >= 0 && array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    i--;
                    k++;
                }
                io.print(j - k + 1 + " ");
            }

            io.println();

            for (int item : array) {
                io.print(item + " ");
            }
        }
    }

    private static void swap(int[] array, int firstNum, int secondNum) {
        int temp = array[firstNum];
        array[firstNum] = array[secondNum];
        array[secondNum] = temp;
    }
}

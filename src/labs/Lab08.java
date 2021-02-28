package labs;

import mooc.EdxIO;

public class Lab08 {
    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {

            int n = io.nextInt();
            int[] array = new int[n];
            int i = 0;

            for (i = 0; i < n; i++) {
                array[i] = i + 1;
            }

            for (i = 2; i < n; i++) {
                swap(array, i, i / 2);
            }

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

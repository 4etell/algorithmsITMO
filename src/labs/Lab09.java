package labs;

import mooc.EdxIO;

public class Lab09 {
    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {

            int n = io.nextInt();
            int k1 = io.nextInt();
            int k2 = io.nextInt();
            int[] array = new int[n + 1];
            int A = io.nextInt();
            int B = io.nextInt();
            int C = io.nextInt();
            array[1] = io.nextInt();
            array[2] = io.nextInt();

            for (int i = 3; i <= n; ++i) {
                array[i] = A * array[i - 2] + B * array[i - 1] + C;
            }

            quickSort(array, 1, n, k1, k2);

            for (int i = k1; i <= k2; ++i) {
                io.print(array[i] + " ");
            }
        }

    }

    private static void quickSort(int[] array, int low, int high, int k1, int k2) {

        if (low > k2 || high < k1)
            return;

        int i = low, j = high;
        int pivot = array[low + (high - low) / 2];

        while (i <= j) {

            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }

        }

        if (low < j)
            quickSort(array, low, j, k1, k2);

        if (i < high)
            quickSort(array, i, high, k1, k2);
    }

    private static void swap(int[] array, int firstNum, int secondNum) {
        int temp = array[firstNum];
        array[firstNum] = array[secondNum];
        array[secondNum] = temp;
    }
}

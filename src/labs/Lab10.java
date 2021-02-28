package labs;

import mooc.EdxIO;

public class Lab10 {
    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {

            int n = io.nextInt();
            int k = io.nextInt();
            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = io.nextInt();
            }

            int high = ((n - 1) / k) * k;

            for (int i = 0; i < k; i++) {
                quickSort(array, i, high, k);
                high++;

                if (high > n - 1)
                    high -= k;
            }

            io.print(check(array, n) ? "YES" : "NO");

        }

    }

    private static void quickSort(int[] array, int low, int high, int k) {

        int i = low, j = high;
        int pivot = array[low];

        while (i <= j) {

            while (array[i] < pivot) {
                i += k;
            }

            while (array[j] > pivot) {
                j -= k;
            }

            if (i <= j) {
                swap(array, i, j);
                i += k;
                j -= k;
            }

        }

        if (low < j)
            quickSort(array, low, j, k);

        if (i < high)
            quickSort(array, i, high, k);
    }

    private static void swap(int[] array, int firstNum, int secondNum) {
        int temp = array[firstNum];
        array[firstNum] = array[secondNum];
        array[secondNum] = temp;
    }

    private static boolean check(int[] array, int n) {
        for (int i = 1; i < n; i++) {
            if (array[i] < array[i - 1]) return false;
        }
        return true;
    }
}

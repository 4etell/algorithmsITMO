package labs;

import mooc.EdxIO;

import java.math.BigInteger;

public class Lab07 {

    private static BigInteger count = BigInteger.valueOf(0);
    private static final EdxIO io = EdxIO.create();

    public static void main(String[] args) {
        int n = io.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = io.nextInt();
        }

        mergeSort(array, n);

        io.print(""+ count);
        io.close();
    }

    public static void merge(int[] array, int[] leftArray,
                             int[] rightArray, int leftArrayLength, int rightArrayLength) {
        int i = 0, j = 0, k = 0;
        while (i < leftArrayLength && j < rightArrayLength) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];

            } else {
                count = count.add(BigInteger.valueOf(leftArrayLength - i));
                array[k++] = rightArray[j++];
            }
        }
        while (i < leftArrayLength) {
            array[k++] = leftArray[i++];
        }
        while (j < rightArrayLength) {
            array[k++] = rightArray[j++];
        }
    }

    private static void mergeSort(int[] array, int n) {
        if (n < 2) {
            return;
        }

        int midIdx = n / 2;
        int[] leftArray = new int[midIdx];
        int[] rightArray = new int[n - midIdx];

        System.arraycopy(array, 0, leftArray, 0, midIdx);
        System.arraycopy(array, midIdx, rightArray, 0, n - midIdx);

        mergeSort(leftArray, midIdx);
        mergeSort(rightArray, n - midIdx);

        merge(array, leftArray, rightArray, midIdx, n - midIdx);
    }

}

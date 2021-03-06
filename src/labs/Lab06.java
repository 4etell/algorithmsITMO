package labs;

import mooc.EdxIO;

public class Lab06 {

    private static final EdxIO io = EdxIO.create();

    public static void main(String[] args) {
        int n = io.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = io.nextInt();
        }

        mergeSort(array, 0, n - 1);
        for (int item : array) {
            io.print(item + " ");
        }
        io.close();
    }

    private static void merge(int[] array, int leftIdx, int midIdx, int rightIdx) {

        int leftArrayLength = midIdx - leftIdx + 1;
        int rightArrayLength = rightIdx - midIdx;
        int i = 0, j = 0;
        int k = leftIdx;
        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[rightArrayLength];

        for (i = 0; i < leftArrayLength; ++i)
            leftArray[i] = array[leftIdx + i];
        for (j = 0; j < rightArrayLength; ++j)
            rightArray[j] = array[midIdx + 1 + j];

        i = 0;
        j = 0;

        while (i < leftArrayLength && j < rightArrayLength) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArrayLength) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArrayLength) {
            array[k++] = rightArray[j++];
        }

        io.println((leftIdx + 1) + " " + (rightIdx + 1) + " " + array[leftIdx] + " " + array[rightIdx]);
    }


    private static void mergeSort(int[] array, int leftIdx, int rightIdx) {
        if (leftIdx < rightIdx) {
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;

            mergeSort(array, leftIdx, midIdx);
            mergeSort(array, midIdx + 1, rightIdx);

            merge(array, leftIdx, midIdx, rightIdx);
        }
    }
}

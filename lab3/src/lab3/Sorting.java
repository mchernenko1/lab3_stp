package lab3;

public class Sorting {
    int[] bubbleSort(int[] array) {
        int n = array.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    int[] insertionSort(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(array[j] < array[j-1]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        return array;
    }

    void quickSort(int[] array, int start, int end){
        if (array == null || array.length == 0)
            return;

        if (start >= end)
            return;

        int middle = start + (end - start) / 2;
        int pivot = array[middle];

        int i = start, j = end;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (start < j)
            quickSort(array, start, j);

        if (end > i)
            quickSort(array, i, end);
    }

    void cycleSort(int[] array){
        for (int cycleStart = 0; cycleStart < array.length - 1; cycleStart++) {
            int value = array[cycleStart];

            int position = cycleStart;
            for (int i = cycleStart + 1; i < array.length; i++)
                if (array[i] < value)
                    position++;

            if (position == cycleStart)
                continue;

            while (value == array[position])
                position++;

            int temp = array[position];
            array[position] = value;
            value = temp;
            while (position != cycleStart) {
                position = cycleStart;
                for (int i = cycleStart + 1; i < array.length; i++)
                    if (array[i] < value)
                        position++;

                while (value == array[position])
                    position++;

                temp = array[position];
                array[position] = value;
                value = temp;
            }
        }
    }

    void shellSort(int[] array){
        int increment = array.length / 2;
        while (increment > 0) {
            for (int i = increment; i < array.length; i++) {
                int j = i;
                int temp = array[i];
                while (j >= increment && array[j - increment] > temp) {
                    array[j] = array[j - increment];
                    j = j - increment;
                }
                array[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
    }

    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;


    public static void buildHeap(int []a) {
        n = a.length-1;
        for(int i=n/2; i>=0; i--){
            maxHeap(a,i);
        }
    }

    public static void maxHeap(int[] a, int i) {
        left = 2*i;
        right = 2*i+1;

        if(left <= n && a[left] > a[i]){
            largest=left;
        } else {
            largest=i;
        }

        if(right <= n && a[right] > a[largest]) {
            largest=right;
        }
        if(largest!=i) {
            exchange(i, largest);
            maxHeap(a, largest);
        }
    }

    public static void exchange(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void heapSort(int[] myArray) {
        a = myArray;
        buildHeap(a);
        for(int i=n; i>0; i--) {
            exchange(0, i);
            n=n-1;
            maxHeap(a, 0);
        }
    }
}

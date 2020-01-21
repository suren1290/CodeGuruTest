package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */
public class SortingAlgorithms {
    public SortingAlgorithms() {
    }

    public static void mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private static void mergeSortHelper(int[] arr, int low, int high) {
        int mid = 0;
        if (low < high) {
            mid = (low + high) / 2;
            mergeSortHelper(arr, low, mid);
            mergeSortHelper(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] helper = new int[arr.length];
        int left = low;
        int right = high;
        int middle = mid + 1;
        int k = left;
        while (left <= mid && middle <= right) {
            if (arr[left] <= arr[middle]) {
                helper[k++] = arr[left++];
            } else {
                helper[k++] = arr[middle++];
            }
        }
        while (left <= mid) {
            helper[k++] = arr[left++];
        }
        while (middle <= right) {
            helper[k++] = arr[middle++];
        }
        for (int i = low; i <= high; i++) {
            arr[i] = helper[i];
        }
    }

    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);

    }

    private static void quickSortHelper(int[] arr, int low, int high) {
        if(arr.length==0||arr==null)
                return;
        if (low >= high)
            return;

        int mid = (low + high) / 2;
        int pivot = arr[mid];

        int i = low, j = high;

        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSortHelper(arr, low, j);
        if (high > i)
            quickSortHelper(arr, i, high);
    }

    public static void insertionSort(int[] arr) {
        for (int j = 1; j < arr.length; ++j) {
            int key = arr[j];

            int i;
            for (i = j - 1; i >= 0 && arr[i] > key; --i) {
                arr[i + 1] = arr[i];
            }

            arr[i + 1] = key;
        }

    }

    public static void reverseInserionSort(int[] arr) {
        for (int j = 1; j < arr.length; ++j) {
            int key = arr[j];

            int i;
            for (i = j - 1; i >= 0 && arr[i] < key; --i) {
                arr[i + 1] = arr[i];
            }

            arr[i + 1] = key;
        }

    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            int mini = k;
            int min = arr[k];
            for (int j = k; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    mini = j;
                }
            }
            swap(arr, mini, k);
        }
    }

    public static void insertion2(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            while (j > 0) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
                j--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void radixSort(int[] arr) {

    }

    public static void heapSort(int[] arr) {
        heapSortHelper(arr, arr.length-1);
    }

    private static void heapSortHelper(int[] arr, int n){
        buildheap(arr, n);
        for(int i=n;i>0;i--){
            swap(arr, 0, i);
            n = n - 1;
            maxheap(arr, 0, n);
        }
    }

    public static void buildheap(int[] arr, int n) {
        for (int i = n/2;i >= 0;i++) {
            maxheap(arr, i, n);
        }
    }

    public static void maxheap(int[] arr, int k, int n) {
        int left = 2*k;
        int right = 2*k + 1;
        int largest = 0;
        if(left <= n && arr[left] > arr[k]) {
            largest = left;
        } else {
            largest = k;
        }

        if(right <= n && arr[right] > arr[largest]) {
            largest = right;
        }
        if(largest != k){
            swap(arr, k, largest);
            maxheap(arr, largest, n);
        }
    }


}


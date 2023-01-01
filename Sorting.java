package com.lpa.exercise;

    /*
    Sorting & Searching Algorithms
    Author @LwinPhyoAung
    Bubble Sort
    Selection Sort
    Insertion Sort
    Merge Sort
    Quick Sort
    isSort(check is array sorted)
    Linear Search
    Binary Search
     */

import java.util.Random;

public class Sorting {

    private Sorting(){

    }

    public static void bubbleSort(Comparable[] arr){

        //int count = 0;
        int N = arr.length;
        for (int i = 0; i<N; i++){

            for (int j = 0; j<N-1; j++){

                //count+=1;
                if (isLess(arr[j+1], arr[j])){

                    swap(arr,j,j+1);
                }

            }

        }

        //System.out.println("Running Time : " + count);

   }

    public static void selectionSort(Comparable[] arr){

        //int count = 0;
        int N = arr.length;
        for (int i = 0; i<N; i++){

            int min = i;
            for (int j = i+1; j<N; j++){

                //count+=1;
                if (isLess(arr[j], arr[min])){

                    min = j;
                }

            }

            swap(arr,i,min);
        }

        //System.out.println("Running Time : " + count);

    }

    public static void insertionSort(Comparable[] arr){

        //int count = 0;
        int N = arr.length;
        for (int i = 1; i<N; i++){

            int j = i;
            while (j>0 && isLess(arr[j], arr[j-1])){

                //count+=1;
                swap(arr, j,j-1);
                j--;
            }

        }

        //System.out.println("Running Time : " + count);

    }

    public static void mergeSort(Comparable[] arr){
        Comparable[] aux = new Comparable[arr.length];
        mergeSort(arr, aux, 0, arr.length-1);
    }

    private static void mergeSort(Comparable[] arr, Comparable[] aux, int lo, int hi){

        if (hi<=lo){
            return;
        }

        int mid = lo + (hi - lo)/2;
        mergeSort(arr, aux, lo, mid);
        mergeSort(arr, aux, mid+1, hi);
        merge(arr, aux, lo, mid, hi);

    }

    private static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi){

        for (int i = lo; i<=hi; i++){
            aux[i] = arr[i];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k<=hi; k++){

            if (i > mid){
                arr[k] = aux[j++];
            } else if (j > hi) {
                arr[k] = aux[i++];
            } else if (isLess(aux[j], aux[i])) {
                arr[k] = aux[j++];
            }else {
                arr[k] = aux[i++];
            }

        }

    }

//    public void quickSort(Comparable[] arr){
//
//    }

    public static void shuffle(Comparable[] arr){

        int N = arr.length;
        for (int i = 0; i<N; i++){

            int r = new Random().nextInt(i+1);
            swap(arr,r,i);
        }

    }

    public static boolean isSorted(Comparable[] arr){

        int N = arr.length;
        for (int i = 0; i<N-1; i++){
            if (!isLess(arr[i], arr[i+1])){
                return false;
            }
        }
        return true;

    }

    public static boolean linearSearch(Comparable[] arr, Comparable key){

        for (Comparable c : arr){

            if (c.compareTo(key) == 0){
                return true;
            }

        }
        return false;

    }

    public static boolean binarySearch(Comparable[] arr, Comparable key){

        int N = arr.length;
        int lo = 0;
        int hi = N-1;
        while (lo<=hi){

            int mid = lo + (hi - lo)/2;
            int comp = arr[mid].compareTo(key);
            if (comp < 0){
                lo = mid + 1;
            } else if (comp > 0) {
                hi = mid - 1;
            } else {
                return true;
            }

        }
        return false;

    }

    public static void printArray(Comparable[] arr){
        System.out.println();
        System.out.print("[");
        for (Comparable c : arr){
            System.out.print(" " + c + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    private static boolean isLess(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }

    private static void swap(Comparable[] a,int x,int y){
        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

}
//
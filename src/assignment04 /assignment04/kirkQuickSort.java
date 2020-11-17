package assignment04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class kirkQuickSort<T extends Comparable<? super T>> {

    public static void main(String args[]) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            int rand = (int) (Math.random() * arrayList.size());
            arrayList.add(rand);
        }

        System.out.println("Non Sorted ArrayList");
        System.out.println(arrayList);

        quickSortDriverKirk(arrayList, Comparator.naturalOrder());
        System.out.println("Sorted array list");
        System.out.println(arrayList);


    }


    static <T> void quickSortDriverKirk(ArrayList<T> arrayList, Comparator comparator) {
        T[] arr = (T[]) new Object[arrayList.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrayList.get(i);
        }

        quickSortKirk(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            arrayList.set(i, arr[i]);
        }


    }

    static <T> void random(T[] arr, int low, int high) {
        Random rand = new Random();

        int pivot = rand.nextInt(high - low) + low;
        T temp1 = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = temp1;
    }


    static <T> int partitionKirk(T[] arr, int low, int high, Comparator comparator) {

        random(arr, low, high); //Picking random integer
        T pivot = arr[high];


        //index for smaller element
        int i = (low - 1);
        for (int j = low; j < high; j++) {

            //if current element is smaller than pivot
            if (comparator.compare(arr[j], pivot) < 0) {
                i++;

                //swap them
                T tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

            }
        }

        T temp1 = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp1;

        return i + 1;
    }


    static <T> void quickSortKirk(T[] arr, int low, int high) {
        if (low < high) {

            int pi = partitionKirk(arr, low, high, Comparator.naturalOrder());

            quickSortKirk(arr, low, pi - 1); //left side
            quickSortKirk(arr, pi + 1, high); //right side


        }

    }


}

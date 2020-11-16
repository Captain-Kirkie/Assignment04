package assignment04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class TimingMergeSort {


    public static void main(String[] args) {

        double pow = 11;
        int N = (int) Math.pow(2, pow);

        ArrayList<Integer> sortedArrayList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            sortedArrayList.add(i);
        }

        System.out.println("Sorted list");
        System.out.println(sortedArrayList);

        //shuffle
        TimingMergeSort.shuffleList(sortedArrayList);

        System.out.println("Shuffled List");
        System.out.println(sortedArrayList);

        System.out.println("Resort list");
        sortUtil.mergesortDriver(sortedArrayList, Comparator.naturalOrder());
        System.out.println(sortedArrayList);

        System.out.println("Reshuffle list");
        TimingMergeSort.shuffleList(sortedArrayList);
        System.out.println(sortedArrayList);


    }

    //generate best case
    public static ArrayList<Integer> generateBestCase(int Size) {
        ArrayList<Integer> bestCaseDoubleArray = new ArrayList<>(); //will already be in sorted order
        for (int i = 0; i <= Size; i++) {
            bestCaseDoubleArray.add(i);
        }
        return bestCaseDoubleArray;
    }

    //average case
    public static ArrayList<Integer> generateAverageCase(int size) {
        ArrayList<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int rand = (int) (Math.random() * size);
            randomList.add(rand);
        }
        return randomList;
    }

    //worst case
    public static ArrayList<Integer> generateWorstCase(int size) {
        ArrayList<Integer> worstCaseArrayList = new ArrayList<>();
        for (int i = size; i > 0; i++) {
            worstCaseArrayList.add(i);
        }
        return worstCaseArrayList;
    }
    //shuffle function
    public static void shuffleList(ArrayList arrayList) {
        Random ran = new Random();
        for (int i = 0; i < arrayList.size(); i++) {
            int nxt = ran.nextInt(arrayList.size());
            Collections.swap(arrayList, i, nxt);
        }
    }


    //TODO: implement timing
}

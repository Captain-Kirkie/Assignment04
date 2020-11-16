package assignment04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TimingMergeSort {


    public static void main(String[] args) {

        double pow = 11;
        int N = (int) Math.pow(2, pow); //this will be the size of the list every time


        ArrayList<Integer> randList1 = TimingMergeSort.shuffleListNonRandom(20);
        ArrayList<Integer> randList2 = TimingMergeSort.shuffleListNonRandom(20);
        ArrayList<Integer> randList3 = TimingMergeSort.shuffleListNonRandom(20);
        ArrayList<Integer> randList4 = TimingMergeSort.shuffleListNonRandom(20);

        System.out.println(randList1);
        System.out.println(randList2);
        System.out.println(randList3);
        System.out.println(randList4);


    }

    /**
     * generates an array list of specified size in sorted order
     *
     * @param Size
     * @return
     */
    //generate best case
    public static ArrayList<Integer> generateBestCase(int Size) {
        ArrayList<Integer> bestCaseDoubleArray = new ArrayList<>(); //will already be in sorted order
        for (int i = 0; i <= Size; i++) {
            bestCaseDoubleArray.add(i);
        }
        return bestCaseDoubleArray;
    }

    /**
     * Genearates an randomly Orders list of specified size
     *
     * @param size
     * @return
     */
    //average case
    public static ArrayList<Integer> generateAverageCase(int size) {
        ArrayList<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int rand = (int) (Math.random() * size);
            randomList.add(rand);
        }
        return randomList;
    }

    /**
     * generates a list that is sorted in reverse order
     *
     * @param size
     * @return
     */
    //worst case
    public static ArrayList<Integer> generateWorstCase(int size) {
        ArrayList<Integer> worstCaseArrayList = new ArrayList<>();
        for (int i = size; i > 0; i++) {
            worstCaseArrayList.add(i);
        }
        return worstCaseArrayList;
    }

    /**
     * returns a shuffled array always in the same order
     *
     * @param size
     * @return
     */
    public static ArrayList<Integer> shuffleListNonRandom(int size) {
        ArrayList<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < size; i++) { //populate a sorted list
            randomList.add(i);
        }

        Random ran = new Random(size);
        for (int i = 0; i < size; i++) {
            int nxt = ran.nextInt(size);
            Collections.swap(randomList, i, nxt);
        }
        return randomList;
    }

    /**
     * This randomly shuffles a list
     *
     * @param arrayList
     */
    public static void shuffleListRandom(ArrayList arrayList) {
        Random ran = new Random();
        for (int i = 0; i < arrayList.size(); i++) {
            int nxt = ran.nextInt(arrayList.size());
            Collections.swap(arrayList, i, nxt);
        }


    }

}

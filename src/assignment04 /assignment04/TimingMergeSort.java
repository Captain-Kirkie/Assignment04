package assignment04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class TimingMergeSort {


    public static void main(String[] args) {

        ArrayList<Double> avgList = new ArrayList<>();

        long startTime, stopTime, popArrayStartTime, popArrayStopTime;
;
        for (int r = 11; r < 20; r++) { //how many averages to calculate

            ArrayList<Double> timeList = new ArrayList<Double>(); //reset the list

            startTime = System.nanoTime();
            while (System.nanoTime() - startTime < 1000000000) {
                //empty block
                //Wait for thread to stabalize
            }
            int N = (int) Math.pow(2, r); //this will be the size of the collection


            System.out.println("Size of N: " + N);
            double timesToLoop = 500;
            startTime = System.nanoTime(); //time it
            double totalTimeToPopArray = 0;
            for (int k = 0; k < timesToLoop; k++){
                popArrayStartTime = System.nanoTime();
                ArrayList<Integer> testArray = TimingMergeSort.shuffleListNonRandom(N); //create random array of size N
                popArrayStopTime = System.nanoTime();
                totalTimeToPopArray = popArrayStopTime - popArrayStartTime;

                startTime = System.nanoTime();
                sortUtil.quickSortDriver(testArray, Comparator.naturalOrder());
            }

            double midPoint = System.nanoTime();

            for (int empty = 0; empty < timesToLoop; empty++) {
                //runs and does nothing
            }
            stopTime = System.nanoTime();
            double newAvg = (((midPoint - startTime) - totalTimeToPopArray) - (stopTime - midPoint)) / timesToLoop;
            //System.out.println(newAvg);
            avgList.add(newAvg);
        }

        for (Double d : avgList) {
            System.out.println(d);
        }




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
    public static ArrayList<Integer> genrateRandomArray(int size) {
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

package assignment04;
//used as reference https://big-o.io/examples/merge-sort/java-generic/
//merge Sort N Log(N)

import java.util.ArrayList;
import java.util.Comparator;

//used as reference http://www.java2s.com/Tutorial/Java/0140__Collections/GenericMergeSorterwithgenericComparator.htm
public class sortUtil<T extends Comparable<? super T>> {
    final static int THRESHOLD = 10;
    public static void main(String args[]) {

        //Make a reverse order comparator for integers
        Comparator<Integer> reverseOrderIntegerComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
        //comparator to sort strings in reverse order
        Comparator<String> reverseOrderStringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

        //populate with random numbers
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            int rand = (int) (Math.random() * 100);
            integerArrayList.add(rand);
        }
        //sort based of natural order
        System.out.println(integerArrayList);
        sortUtil.mergesortDriver(integerArrayList, Comparator.naturalOrder());
        System.out.println("Sorted ");
        System.out.println(integerArrayList);


        //sort based of natural order
        System.out.println(integerArrayList);
        sortUtil.mergesortDriver(integerArrayList, reverseOrderIntegerComparator);
        System.out.println("Sorted Reverse order ");
        System.out.println(integerArrayList);

        //Sorting strings
        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("David");
        stringArrayList.add("Luke");
        stringArrayList.add("Clark");
        stringArrayList.add("Kirk");
        stringArrayList.add("Evie");
        stringArrayList.add("Rachel");
        stringArrayList.add("Anna");
        stringArrayList.add("Maggie");
        stringArrayList.add("Mark");
        stringArrayList.add("Madeline");
        stringArrayList.add("Kristin");
        stringArrayList.add("Victoria");
        stringArrayList.add("Peter");
        stringArrayList.add("Bennit");
        stringArrayList.add("Mario");
        stringArrayList.add("Nick");

        System.out.println();
        sortUtil.mergesortDriver(stringArrayList, Comparator.naturalOrder());
        System.out.println("Sorted Strings ");
        System.out.println(stringArrayList);

        sortUtil.mergesortDriver(stringArrayList, reverseOrderStringComparator);
        System.out.println("Sorted Strings Reverse Order");
        System.out.println(stringArrayList);
    }

    public static <T> void mergesortDriver(ArrayList<T> arrayList, Comparator<? super T> comparator) {
        //copy the array list over to the array
        T[] array = (T[]) new Object[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }

        mergeSort(array, 0, array.length - 1, comparator);

        //copy back to arrayList
        for(int i = 0; i < arrayList.size(); i++){
            arrayList.set(i, array[i]);
        }
    }

    private static <T> void mergeSort(T[] array, int start, int end, Comparator<T> comparator) {
        if (start == end) { //if there is only one item in the array
            return;
        }
        

        int mid = (start + end) / 2;
        //sort both halves
        mergeSort(array, start, mid, comparator); //sort left half of array
        mergeSort(array, mid + 1, end, comparator); //sort the right

        //merge them
        merge(array, start, mid, end, comparator);
    }

    private static <T> void merge(T[] array, int start, int mid, int end, Comparator<T> comparator) {
        int size = end - start + 1;
        Object[] values = new Object[size];

        int leftPointer = start;
        int rightPointer = mid + 1;

        int indexCurrent = 0;

        while (leftPointer <= mid && rightPointer <= end) {
            if (comparator.compare(array[leftPointer], array[rightPointer]) <= 0) {
                values[indexCurrent] = array[leftPointer];
                leftPointer++;
            } else {
                values[indexCurrent] = array[rightPointer];
                rightPointer++;
            }
            indexCurrent++;
        }

        //clean up remaining array values
        while (leftPointer <= mid) { //clean up remaining left array
            values[indexCurrent] = array[leftPointer];
            leftPointer++;
            indexCurrent++;
        }
        //clean up right array
        while (rightPointer <= end) {
            values[indexCurrent] = array[rightPointer];
            rightPointer++;
            indexCurrent++;
        }

        for (indexCurrent = 0; indexCurrent < size; indexCurrent++) {
            array[start + indexCurrent] = (T) values[indexCurrent];
        }
    }


}

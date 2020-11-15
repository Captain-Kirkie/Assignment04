package assignment04;

// https://big-o.io/examples/insertion-sort/java-generic/
public class insertionSort<T extends Comparable<? super T>> {



   public static void main(String[] args){
       String[] stringArray = {"David", "Clark" , "Luke", "Kirk", "Bennit", "Mario", "Nick", "Peter", "Kristin",
               "Tori", "Rachel", "Maggie", "Anna", "Madi", "Mark"};

       //unsorted
       System.out.println("Unsorted string array ");
       System.out.println();
       for(int i = 0; i < stringArray.length; i++){
           System.out.println(stringArray[i]);
       }

       System.out.println();

       System.out.println("Sorted String array");
       System.out.println();
       insertionSort<String> stringInsertionSort = new insertionSort<>();
       stringInsertionSort.insertionSort(stringArray);

       for(int i = 0; i < stringArray.length; i++){
           System.out.println(stringArray[i]);
       }


       Integer[] intArray = {69,420,666,720,360,540,180,900};
       System.out.println("Unsorted array ");
       System.out.println();
       for(int i = 0; i < intArray.length; i++){
           System.out.println(intArray[i]);
       }


       insertionSort<Integer> intSorter = new insertionSort<>();
       intSorter.insertionSort(intArray);
       System.out.println("Sorted array ");
       System.out.println();
       for(int i = 0; i < intArray.length; i++){
           System.out.println(intArray[i]);
       }

   }



    void insertionSort(T[] arr) { //TODO: pass a comparator
        //start at first index and itterate through the end
        for (int i = 1; i < arr.length; i++) {
            int currentIndex = i;
            //Check if current index is at least one
            //If item before the current index is greater than the item at teh current index, swap them

            while (currentIndex > 0 && arr[currentIndex - 1].compareTo(arr[currentIndex]) >= 1) { //if item before current index is larger
                T temp = arr[currentIndex];
                arr[currentIndex] = arr[currentIndex - 1];
                arr[currentIndex - 1] = temp;
                currentIndex--;
            }
        }
    }


}

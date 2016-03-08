import java.util.Random;

/**
 * Created by justin on 2/11/16.
 */
public class AlgorithmTester {

    public static void main(String[] args){

        Random random = new Random();

        int TEST_ARRAY_SIZE = 10;
        boolean sortWorks = true;
        ArrayUtil arrayUtil = new ArrayUtil();

        int[] testArray = arrayUtil.randomIntArray(TEST_ARRAY_SIZE, 1000);

        int key = random.nextInt(TEST_ARRAY_SIZE);

        //put your Sort algorithm Class name here and un-blockComment

        MergeSort s1 = new MergeSort(testArray);


        int[] sortedArray = s1.getSortedArray();

        System.out.println("\nSort");
        System.out.println("----------------------------------");
        System.out.println("Time: " + s1.getTime() + "ms");
        for (int i = 0; i < sortedArray.length; i++){
            System.out.print("[" + sortedArray[i] + "] ");
        }
        for (int i = 0; i < sortedArray.length - 1; i++){

            if (i > i + 1){
                sortWorks = false;
            }
        }
        System.out.println("\nWorks: " + sortWorks);


        //use this section for Search algorithms

        BinarySearch s5 = new BinarySearch(sortedArray, sortedArray.length, testArray[key]);


        System.out.println("\nSearch");
        System.out.println("----------------------------------");
        System.out.println("Time: " + s5.getTime() + "ms");
        System.out.println("Target: " + testArray[key]);
        System.out.println("Target Index: " + s5.getTarget());
        if (sortedArray[s5.getTarget()] == testArray[key]){
            System.out.println("Works: true");
        } else {
            System.out.println("Works: false");
        }

    }
}

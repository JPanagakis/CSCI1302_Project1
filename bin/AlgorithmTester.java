/**
 * Created by justin on 2/11/16.
 */
public class AlgorithmTester {

    public static void main(String[] args){

        private int TEST_ARRAY_SIZE = 20000;
        ArrayUtil arrayUtil = new ArrayUtil();

        int[] testArray = arrayUtil.randomIntArray(TEST_ARRAY_SIZE, 100);

        sortSearchAlgorithm1 s1 = new sortSearchAlgorithm(testArray);

        System.out.println(s1.getTime() + "ms");
        System.out.println("Congrats, this works");
    }
}

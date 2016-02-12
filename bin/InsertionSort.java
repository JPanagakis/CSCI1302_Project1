/**
 * Created by justin on 2/12/16.
 */
public class InsertionSort {

    private long time;
    private StopWatch stopWatch;
    private int[] array;

    public InsertionSort(int[] a){

        stopWatch = new StopWatch();
        array = a;

        doSort(array);
    }

    public void doSort(int[] array){

        stopWatch.start();

        int x;
        int j;

        for (int i = 1; i < array.length; i++){
            x = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > x){

                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = x;
        }

        stopWatch.stop();
        time = stopWatch.getElapsedTime();
    }

    public long getTime(){return time;}

    public int[] getSortedArray(){return array;}
}

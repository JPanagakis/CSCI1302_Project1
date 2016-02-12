/**
 * Created by justin on 2/12/16.
 */
public class InterpolationSearch {

    private int target;
    private long time;
    private StopWatch stopWatch;
    private int[] array;

    public InterpolationSearch(int[] a, int size, int key){

        stopWatch = new StopWatch();
        array = a;

        target = doSearch(array, size, key);
    }

    public int doSearch(int[] array, int size, int key){

        stopWatch.start();

        int low = 0;
        int high = size - 1;
        int mid;

        while (array[high] != array[low] && key >= array[low] && key <= array[high]){
            mid = low + ((key - array[low]) * (high - low) / (array[high] - array[low]));

            if (array[mid] < key){
                low = mid + 1;
            } else if (key < array[mid]){
                high = mid - 1;
            } else {
                stopWatch.stop();
                time = stopWatch.getElapsedTime();
                return mid;
            }
        }

        if (key == array[low]){
            stopWatch.stop();
            time = stopWatch.getElapsedTime();
            return low;
        } else {
            stopWatch.stop();
            time = stopWatch.getElapsedTime();
            return -1;
        }
    }

    public long getTime(){return time;}

    public int getTarget(){return target;}
}

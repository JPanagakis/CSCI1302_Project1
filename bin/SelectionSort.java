import javax.swing.*;

public class SelectionSort {

    private long time;
    private int[] sortedArray;
    private StopWatch stopWatch;

    public SelectionSort(int[] a) {

        stopWatch = new StopWatch();
        doSelectionSort(a);
    }

    public void doSelectionSort(int[] arr){

        stopWatch.start();

        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        sortedArray = arr;
        stopWatch.stop();
        time = stopWatch.getElapsedTime();
    }
    public int[] getSortedArray() {
        return sortedArray;
    }

    public long getTime(){
        return time;
    }
}

import javax.swing.*;

public class BinarySearch {

    int[] data;
    int size;
    private StopWatch stopWatch;
    private long time;

    public boolean binarySearch(int key) 
    {
         stopwatch = new Stopwatch();
         int low = 0;
         int high = size - 1;
         
         stopWatch.start();
          
         while(high >= low) {
             int middle = (low + high) / 2;
             if(data[middle] == key) {
                 return true;
             }
             if(data[middle] < key) {
                 low = middle + 1;
             }
             if(data[middle] > key) {
                 high = middle - 1;
             }
        }
        return false;
        stopWatch.stop();
        time = getElapsedTime();
   }
       public long getTime(){
          return time;
       }
}

public class BinarySearch {

    private StopWatch stopWatch;
    private long time;
    private int target;

    public BinarySearch(int[] a, int size, int key){

       stopWatch = new StopWatch();
       target = binarySearch(a, size, key);
    }

    public int binarySearch(int[] data, int size, int key)
    {
         int low = 0;
         int high = size - 1;
         
         stopWatch.start();
          
         while(high >= low) {
             int middle = (low + high) / 2;
             if(data[middle] == key) {

                 stopWatch.stop();
                 time = stopWatch.getElapsedTime();
                 return middle;
             }
             if(data[middle] < key) {
                 low = middle + 1;
             }
             if(data[middle] > key) {
                 high = middle - 1;
             }
        }


        stopWatch.stop();
        time = stopWatch.getElapsedTime();
        return -1;
   }
       public long getTime(){
          return time;
       }
       public int getTarget(){
          return target;
       }
}

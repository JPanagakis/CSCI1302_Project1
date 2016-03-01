/**
*created by Lateef Davis 02/16/2016
*/

public class MergeSort  { 

    private int[] array; 
    private int[] tempMergArr; 
    private int length; 
    private StopWatch timeKeep;
    private long time;
    
/**
Turns a number into its English name.
@param inputArr[]
*/
public MergeSort(int[] b)
{
	timeKeep = new StopWatch();
	sort(b);
}

public void sort(int[] inputArr) 
{ 
	timeKeep.start();
	
    this.array = inputArr; 
    this.length = inputArr.length; 
    this.tempMergArr = new int[length]; 

    doMergeSort(0, length - 1); 
    timeKeep.stop();
    time = timeKeep.getElapsedTime();
} 

public long getTime()
{
	return time;
}

/**
Merges the lower index and higher index.
@param lowerIndex, higherIndex 
*/
private void doMergeSort(int lowerIndex, int higherIndex) 
{ 
    if (lowerIndex < higherIndex) 
    { 
        int middle = lowerIndex + (higherIndex - lowerIndex) / 2; 
        
        // Below step sorts the left side of the array 
        doMergeSort(lowerIndex, middle); 
        // Below step sorts the right side of the array 
        doMergeSort(middle + 1, higherIndex); 
        // Now merge both sides 
        mergeParts(lowerIndex, middle, higherIndex); 
    } 
} 

/**
Turns a number into its English name.
@param lowerIndex, middle, and higherIndex
*/
private void mergeParts(int lowerIndex, int middle, int higherIndex) 
{ 
    for (int i = lowerIndex; i <= higherIndex; i++) 
    { 
        tempMergArr[i] = array[i]; 
      
    } 
    
    int i = lowerIndex; 
    int j = middle + 1; 
    int k = lowerIndex; 
    
    while (i <= middle && j <= higherIndex) 
    { 
       if (tempMergArr[i] <= tempMergArr[j]) 
       { 
          array[k] = tempMergArr[i]; 
          i++; 
        } 
        else 
        { 
          array[k] = tempMergArr[j]; 
          j++; 
        } 
        k++; 
        } 
        
        while (i <= middle) 
        { 
          array[k] = tempMergArr[i]; 
          k++; 
          i++; 
        } 
    }

public int[] getSortedArray() 
{
	
	return null;
} 
}

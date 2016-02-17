/**
*created by Lateef Davis 02/16/2016
*/

public class MergeSort  { 

    private int[] array; 
    private int[] tempMergArr; 
    private int length; 
    
/**
Turns a number into its English name.
@param number a positive integer < 1,000
@return the name of number (e.g., “two hundred seventy four”)
*/
public void sort(int inputArr[]) 
{ 
  
    this.array = inputArr; 
    this.length = inputArr.length; 
    this.tempMergArr = new int[length]; 

    doMergeSort(0, length - 1); 
} 

/**
Turns a number into its English name.
@param number a positive integer < 1,000
@return the name of number (e.g., “two hundred seventy four”)
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
@param number a positive integer < 1,000
@return the name of number (e.g., “two hundred seventy four”)
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
}

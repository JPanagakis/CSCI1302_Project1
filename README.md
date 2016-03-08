# CSCI1302_Project1
First Group Project in my CSCI1302 class. Measuring efficiency of sort and search algorithms.

### Classes and Their Functions
- [x] **AlgorithmEfficiency** (Extends JFrame, contains main())
- [x] **AlgEffPanel** (Extends JPanel, displays results of algorithm testing)
- [x] **InsertionSort** (A sort algorithm)
- [x] **MergeSort** (A sort algorithm)
- [x] **SelectionSort** (A sort algorithm)
- [x] **InterpolationSearch** (A search algorithm)
- [x] **BinarySearch** (A search algorithm)
- [x] **StopWatch** (Times how long each algorithm takes, imported from /ch14/section_2/, modified)
- [x] **ArrayUtil** (Generates arrays, imported from /ch14/section_2/, modified)
- [x] **AlgorithmTester** (This is not a part of the final product. This is just a tester class used to test our Sort and Search algorithms so that we don't have to change the **SortPannel**. See comments in the class for instructions on its usage)

### Sort Algorithms
  Each of the sort algorithms will depend on their own **StopWatch** instances to measure time in ms.
  Each of the sort algorithms should contain the following methods:
- **public SortAlgorithm(int[] array)** //Initializer. Takes an integer array argument generated by the **ArrayUtil** in **AlgEffPanel**. Needs to be initialized with a pre-made array so that every sort algorithm can run the same array.
- **public void doSort(int[] array)** //Performs the sort algorithm. It should set the sorted values to an array, measure the time it takes to perform the sort, and set that time to a long variable "time".
- **public long getTime()** //Returns the time it took to perform the sort. Used in **AlgEffPanel** to display the efficiency of each algorithm.
- **public int[] getSortedArray()** //Returns the sorted array. Used in **AlgEffPanel** to test whether or not every algorithm ends up with the same output. Validates the time.

Use **InsertionSort** as a reference if needed.

### Search Algorithms
  Each of the search algorithms will depend on their own **StopWatch** instances to measure time in ms.
  Each of the search algorithms should contain the following methods:
- **public SearchAlgorithm(int[] array,@ int size , int key)** //Initializer. Takes an integer array arument from one of the Sort algorithms in **AlgEffPanel**, the integer size of the array (**@** may not be neccessary depending on algorithm), and an integer key, which is the number the algorithm is searching for.
- **public int doSearch(int[] array, int size, int key)** //Performs the search algorithm. It should set the searched integer to variable "target", measure the time it takes to perform the search, and set that time to a long variable "time".
- **public long getTime()** //Returns the time it took to perform the search. Used in **AlgEffPanel** to display the efficiency of each algorithm.
- **public int getTarget()** //Returns the variable "target". Used in **AlgEffPanel** to test whether or not every algorithm ends up with the same searched number. Validates the time.

Use **InterpolationSearch** as a reference if needed.

### Output
  The final product should be a window with a chart. The 1st column displays the size of each array being tested. Columns 2-4 should each be devoted to the 3 sort algorithms. The 5th column should be either "true" or "false" depending on whether all the search algorithms returned the same sorted array. Columns 6 and 7 should each be devoted to the 2 search algorithms. Each row should contain the time results for each array. For example:

    |------------------------------------------------------------------|
    | Array Size | Sort1 | Sort2 | Sort3 | Correct | Search1 | Search2 |
    |------------------------------------------------------------------|
    | 200        | 65ms  | 20ms  | 75ms  | true    | 1ms     | 2ms     |
    | 2000       | 100ms | 300ms | 84ms  | false   | 2ms     | 5ms     |
    | 20000      | 200ms | 300ms | 95ms  | true    | 3ms     | 10ms    |
    |------------------------------------------------------------------|
    |                    |    Button to Run Test   |                   |
    |------------------------------------------------------------------|

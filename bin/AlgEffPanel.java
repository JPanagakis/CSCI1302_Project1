import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by justin on 2/8/16.
 */
public class AlgEffPanel extends JPanel {

    private final int NUMBER_OF_TESTS = 5;

    private GridBagConstraints c;
    private Font fontLabel, fontResult, fontButton;
    private JTextPane[] labels = new JTextPane[7];
    private JTextField[] sortTestSize = new JTextField[NUMBER_OF_TESTS];
    private JTextField[] sortResults1 = new JTextField[NUMBER_OF_TESTS];
    private JTextField[] sortResults2 = new JTextField[NUMBER_OF_TESTS];
    private JTextField[] sortResults3 = new JTextField[NUMBER_OF_TESTS];
    private JTextField[] sortResults4 = new JTextField[NUMBER_OF_TESTS];
    private JTextField[] searchResults1 = new JTextField[NUMBER_OF_TESTS];
    private JTextField[] searchResults2 = new JTextField[NUMBER_OF_TESTS];
    private JButton testButton;
    private ArrayUtil arrayUtil = new ArrayUtil();

    private final int[] TEST_ARRAY_SIZE = {100, 1000, 10000, 50000, 100000};

    // Initialize SortPanel Object
    public AlgEffPanel(){

        defineLayout();
        createAllArrays();
        setLabels();

        addComponents();

        testButtonAction();
    }

    // Defines the layout, font, and general constraints
    public void defineLayout(){

        setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 0.5;

        fontLabel = new Font("Calibri", Font.BOLD, 16);
        fontResult = new Font("Sans", Font.PLAIN, 14);
        fontButton = new Font("Calibri", Font.BOLD, 20);
    }

    // Creates all Arrays by passing them into createArray()
    public void createAllArrays(){
        createLabelArray(labels);
        createArray(sortTestSize);
        createArray(sortResults1);
        createArray(sortResults2);
        createArray(sortResults3);
        createArray(sortResults4);
        createArray(searchResults1);
        createArray(searchResults2);
    }

    // Creates JText Fields and adds them to arrays
    public void createLabelArray(JTextPane[] jtArray){

        for (int i = 0; i < 7; i++){

            // Overrride gets rid of border
            JTextPane jt = new JTextPane(){
                @Override public void setBorder(Border border){}
            };
            jt.setEditable(false);
            jt.setAlignmentX(Component.CENTER_ALIGNMENT);

            jt.setFont(fontLabel);
            jt.setBackground(Color.lightGray);

            // Center text
            StyledDocument doc = jt.getStyledDocument();
            SimpleAttributeSet center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            doc.setParagraphAttributes(0, doc.getLength(), center, false);

            jtArray[i] = jt;
        }
    }

    // Creates JText Fields and adds them to arrays
    public void createArray(JTextField[] jtArray){

        for (int i = 0; i < 5; i++){

            // Overrride gets rid of border
            JTextField jt = new JTextField(""){
                @Override public void setBorder(Border border){}
            };
            jt.setEditable(false);
            jt.setHorizontalAlignment(JTextField.CENTER);

            jt.setFont(fontResult);

            jtArray[i] = jt;
        }
    }

    // Sets labels to their proper text
    public void setLabels(){

        labels[0].setText("\nArray Size\n\n");
        labels[1].setText("\nInsertion\nSort\n");
        labels[2].setText("\nMerge\nSort\n");
        labels[3].setText("\nSelection\nSort\n");
        labels[4].setText("\nSort Match\n\n");
        labels[5].setText("\nInterpolation\nSearch\n");
        labels[6].setText("\nBinary\nSearch\n");

        for (int i = 0; i < 5; i++){

            sortTestSize[i].setText(Integer.toString(TEST_ARRAY_SIZE[i]));
        }
    }

    // Adds all Components for the UI
    public void addComponents(){

        addLabels(labels);
        addResults(sortTestSize, 0);
        addResults(sortResults1, 1);
        addResults(sortResults2, 2);
        addResults(sortResults3, 3);
        addResults(sortResults4, 4);
        addResults(searchResults1, 5);
        addResults(searchResults2, 6);
        addTestButton();
    }

    /**
     * Adds the Labels to the Panel
     * @param jtArray JTextField array containing JTextFields to add to the panel
     */
    public void addLabels(JTextPane[] jtArray){

        c.gridy = 0;

        for (int i = 0; i < jtArray.length; i++){

            c.gridx = i;
            add(jtArray[i], c);
        }
    }

    /**
     * Adds the Results to the Panel
     * @param jtArray JTextField array containing JTextFields to add to the panel
     * @param j is the x value of the column being applied
      */
    public void addResults(JTextField[] jtArray, int j){

        c.gridx = j;

        for (int i = 0; i < jtArray.length; i++){

            c.gridy = i + 1;
            add(jtArray[i], c);
        }
    }

    // Configures the testButton and adds it to the Panel
    public void addTestButton(){

        testButton = new JButton("Run Test");
        testButton.setFont(fontButton);

        c.gridy = 6;
        c.gridx = 2;
        c.gridwidth = 3;
        c.ipady = 40;

        add(testButton, c);
    }

    // This defines the actions to be performed when the button is pressed
    public void testButtonAction(){

        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                setLoadingText(sortResults1);
                setLoadingText(sortResults2);
                setLoadingText(sortResults3);
                setLoadingText(sortResults4);
                setLoadingText(searchResults1);
                setLoadingText(searchResults2);

                testSortAlgorithms();
            }
        });
    }

    // Creates a loading screen
    public void setLoadingText(JTextField[] jtArray){

        for (JTextField jt : jtArray){

            jt.setText("Testing...");
        }
    }

    // Performs the actual test
    public void testSortAlgorithms(){

        for (int i = 0; i < NUMBER_OF_TESTS; i++){

            Random random = new Random();
            boolean match = true;
            int[] testArray = arrayUtil.randomIntArray(TEST_ARRAY_SIZE[i], 1000000);
            int key = random.nextInt(TEST_ARRAY_SIZE[i]);

            //"Sortx" will be replaced with the names of their corresponding Sort Algorithms.

            InsertionSort s1 = new InsertionSort(testArray);
            MergeSort s2 = new MergeSort(testArray);
            SelectionSort s3 = new SelectionSort(testArray);

            int[] sortedArray = s1.getSortedArray();

            InterpolationSearch s5 = new InterpolationSearch(sortedArray, sortedArray.length, testArray[key]);
            BinarySearch s6 = new BinarySearch(sortedArray, sortedArray.length, testArray[key]);

            sortResults1[i].setText(Long.toString(s1.getTime()) + "ms");
            sortResults2[i].setText(Long.toString(s2.getTime()) + "ms");
            sortResults3[i].setText(Long.toString(s3.getTime()) + "ms");

            for (int j = 0; j < TEST_ARRAY_SIZE.length; j++){

                if (s1.getSortedArray()[j] != s2.getSortedArray()[j] || s1.getSortedArray()[j] != s3.getSortedArray()[j]){
                    match = false;
                }
            }

            sortResults4[i].setText(Boolean.toString(match));
            searchResults1[i].setText(Long.toString(s5.getTime()) + "ms");
            searchResults2[i].setText(Long.toString(s6.getTime()) + "ms");

        }
    }
}

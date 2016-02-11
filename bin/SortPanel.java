import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by justin on 2/8/16.
 */
public class SortPanel extends JPanel {

    private final int NUMBER_OF_TESTS = 5;

    private GridBagConstraints c;
    private Font fontLabel, fontResult, fontButton;
    private JTextField[] labels = new JTextField[5];
    private JTextField[] sortTestSize = new JTextField[NUMBER_OF_TESTS];
    private JTextField[] sortResults1 = new JTextField[NUMBER_OF_TESTS];
    private JTextField[] sortResults2 = new JTextField[NUMBER_OF_TESTS];
    private JTextField[] sortResults3 = new JTextField[NUMBER_OF_TESTS];
    private JTextField[] sortResults4 = new JTextField[NUMBER_OF_TESTS];
    private JButton testButton;
    private ArrayUtil arrayUtil = new ArrayUtil();

    private final int[] TEST_ARRAY_SIZE = {100, 1000, 10000, 50000, 100000};

    // Initialize SortPanel Object
    public SortPanel(){

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
        createArray(labels);
        createArray(sortTestSize);
        createArray(sortResults1);
        createArray(sortResults2);
        createArray(sortResults3);
        createArray(sortResults4);
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

            if (jtArray == labels){
                jt.setFont(fontLabel);
            } else {
                jt.setFont(fontResult);
            }
            jtArray[i] = jt;
        }
    }

    // Sets labels to their proper text
    public void setLabels(){

        labels[0].setText("Array Size");
        labels[1].setText("Sort 1");
        labels[2].setText("Sort 2");
        labels[3].setText("Sort 3");
        labels[4].setText("Sorts Match");

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
        addTestButton();
    }

    /**
     * Adds the Labels to the Panel
     * @param jtArray JTextField array containing JTextFields to add to the panel
     */
    public void addLabels(JTextField[] jtArray){

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
        c.gridx = 1;
        c.gridwidth = 3;
        c.ipady = 40;

        add(testButton, c);
    }

    // This defines the actions to be performed when the button is pressed
    public void testButtonAction(){

        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("button works");

                setLoadingText(sortResults1);
                setLoadingText(sortResults2);
                setLoadingText(sortResults3);
                setLoadingText(sortResults4);

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

            boolean match = true;
            int[] testArray = arrayUtil.randomIntArray(TEST_ARRAY_SIZE[i], 100);

            /*

            //"Sortx" will be replaced with the names of their corresponding Sort Algorithms.

            Sort1 s1 = new Sort1(testArray);
            Sort2 s2 = new Sort2(testArray);
            Sort3 s3 = new Sort3(testArray);

            sortResults1[i].setText(Integer.toString(s1.getTime()) + "ms");
            sortResults2[i].setText(Integer.toString(s2.getTime()) + "ms");
            sortResults3[i].setText(Integer.toString(s3.getTime()) + "ms");

            for (int j = 0; j < TEST_ARRAY_SIZE[i].length; j++){

                if (s1.getSortedArray[j] != s2.getSortedArray[j] || s1.getSortedArray[j] != s3.getSortedArray[j]){
                    match = false;
                }
            }

            sortResults4[i].setText(Boolean.toString(match));
            */
        }
    }
}

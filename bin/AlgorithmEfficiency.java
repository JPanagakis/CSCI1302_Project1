import javax.swing.*;

/**
 * Created by justin on 2/8/16.
 */

//We cannot use Binary Search, Linear Search, Selection Sort, or Merge Sort

public class AlgorithmEfficiency extends JFrame {

    public AlgorithmEfficiency(){

        setTitle("Algorithm Efficiency");
        setSize(1000, 550);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){

        AlgorithmEfficiency frame = new AlgorithmEfficiency();
        AlgEffPanel panel = new AlgEffPanel();

        frame.add(panel);
        frame.setVisible(true);
    }
}

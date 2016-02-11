import javax.swing.*;

/**
 * Created by justin on 2/8/16.
 */
public class SortEfficiency extends JFrame {

    public SortEfficiency(){

        setTitle("Sort Efficiency");
        setSize(800, 550);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){

        SortEfficiency frame = new SortEfficiency();
        SortPanel panel = new SortPanel();

        frame.add(panel);
        frame.setVisible(true);
    }
}

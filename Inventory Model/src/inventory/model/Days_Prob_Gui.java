package inventory.model;

import static inventory.model.Days_Prob_Gui.sol;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
/**
 *
 * @author Yousef
 */
public class Days_Prob_Gui {
    public static javax.swing.JTextField[][] R1;
    public static float [][] sol;
    JFrame frame = new JFrame("Get Days with Probability");
    
    public Days_Prob_Gui(int jj)
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 500);

        GridLayout grid = new GridLayout(jj+2, 2, 10, 10);
        //GridLayout grid = new GridLayout(8,2);
            
        frame.setLayout(grid);
        R1 = new JTextField[jj+1][2];
        sol = new float[jj][2];

        for(int i=0; i < jj+1; i++) 
        {
            for(int j=0;j<2;j++)
            {
                R1[i][j] = new JTextField(Integer.toString(0));

                frame.add(R1[i][j]);
            }
        }
        R1[0][0].setText("Days/Weeks");
        R1[0][0].setEditable(false);
        R1[0][1].setText("Probability");
        R1[0][1].setEditable(false);

        JButton Submit = new JButton();
        Submit.setText("Submit");
        frame.add(Submit);
        frame.setVisible(true);
        
        Submit.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                for(int i=0; i < jj; i++) 
                {
                    sol[i][0] = Float.parseFloat(R1[i+1][0].getText());
                    sol[i][1] = Float.parseFloat(R1[i+1][1].getText());
                }
                Probability p = new Probability(sol,jj);
                frame.hide();
            }
        });
        
    }
}

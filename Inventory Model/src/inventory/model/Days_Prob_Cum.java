package inventory.model;


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
public class Days_Prob_Cum {
    public static javax.swing.JTextField[][] R1;
    public static float [][] sol;
    JFrame frame = new JFrame("Days with Probability");
    
    public Days_Prob_Cum(float[] days, float[] prob, float[] cum_Prob, int[][] interval, int jj)
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, 800);

        GridLayout grid = new GridLayout(jj+2, 4, 10, 10);
        //GridLayout grid = new GridLayout(8,2);
            
        frame.setLayout(grid);
        R1 = new JTextField[jj+1][4];

        R1[0][0] = new JTextField("Days/Weeks");
        R1[0][0].setEditable(false);
        frame.add(R1[0][0]);
        R1[0][1] = new JTextField("Probability");
        R1[0][1].setEditable(false);
        frame.add(R1[0][1]);
        R1[0][2] = new JTextField("Cumluative Prob");
        R1[0][2].setEditable(false);
        frame.add(R1[0][2]);
        R1[0][3] = new JTextField("Interval");
        R1[0][3].setEditable(false);
        frame.add(R1[0][3]);
        for(int i=1; i < jj+1; i++) 
        {
            R1[i][0] = new JTextField(Float.toString(days[i-1]));
            frame.add(R1[i][0]);
            R1[i][1] = new JTextField(Float.toString(prob[i-1]));
            frame.add(R1[i][1]);
            R1[i][2] = new JTextField(Float.toString(cum_Prob[i-1]));
            frame.add(R1[i][2]);
            R1[i][3] = new JTextField(Float.toString(interval[i-1][0]) + " __ " + Float.toString(interval[i-1][1]));
            frame.add(R1[i][3]);
        }

        JButton Submit = new JButton();
        Submit.setText("Submit");
        frame.add(Submit);
        frame.setVisible(true);
        
        Submit.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(jj == 3 || jj == 4)
                {
                    InventoryModel.size2=jj;
                    InventoryModel.leadTime=days;
                    InventoryModel.prob2=prob;
                    InventoryModel.cum_Prob2=cum_Prob;
                    InventoryModel.interval2=interval;
                    InventoryModel.simulation=10;
                    InventoryModel.rop= 2;
                    InventoryModel.units=10;
                    InventoryModel.inventory = 5;
                    frame.hide();
                    Final_Table f = new Final_Table();
                    
                }
                else
                {
                    InventoryModel.size1=jj;
                    InventoryModel.days=days;
                    InventoryModel.prob=prob;
                    InventoryModel.cum_Prob=cum_Prob;
                    InventoryModel.interval1=interval;
                    Days_Prob_Gui a = new Days_Prob_Gui(3);  
                    frame.hide();
                }
                
            }
        });
        
    }
    
}

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
public class Final_Table {
    
    int rop,stock_out,size1,size2,simulate,moo,wait,lo;
    int inventory,j;
    //int[] r_n1 = {06,63,57,94,52,69,32,30,48,88};
    int[] r_n1 = {00,21,82,80,98,96,60,50,88,90};

    int[] r_n2 = {6,00,66,58};
    int[][] interval1,interval2;
    float[]  days,prob, cum_Prob,leadtime,prob2,cum_prob2;
    boolean[] units_recieved , order;
    public static javax.swing.JTextField[][] R1;
    JFrame frame = new JFrame("The Final Table");
    
    public Final_Table()
    {
        j=0;
        lo=0;
        wait=500;
        size1=InventoryModel.size1;
        size2=InventoryModel.size2;
        days=InventoryModel.days;
        leadtime=InventoryModel.leadTime;
        prob=InventoryModel.prob;
        prob2=InventoryModel.prob2;
        cum_Prob=InventoryModel.cum_Prob;
        cum_prob2=InventoryModel.cum_Prob2;
        interval1=InventoryModel.interval1;
        interval2=InventoryModel.interval2;
        simulate = InventoryModel.simulation;
        rop = InventoryModel.rop;
        stock_out = InventoryModel.units;
        inventory = InventoryModel.inventory;
        
        units_recieved = new boolean[simulate];
        order = new boolean[simulate];
        Func();
        Print_Table();
        
    }
    public void Func ()
    {
        System.out.println("\n\nSimulation is : " + simulate + "/ Rop : " + rop + "/  Units : " + stock_out );
        System.out.println("Days\tProb\tCum_prob\tinterval\tSize1" + size1);
        for(int i=0 ; i<size1 ; i++)
        {
            System.out.println(days[i] + "\t" +prob[i] + "\t" +cum_Prob[i] + "\t\t" + interval1[i][0] + "-" + interval1[i][1]);
        }
        System.out.println("\n\nLead Time\tProb\tCum_prob\tinterval\tsize2" + size2);
        for(int i=0 ; i<size2 ; i++)
        {
            System.out.println(leadtime[i] + "\t" +prob2[i] + "\t" +cum_prob2[i] + "\t\t" + interval2[i][0] + "-" + interval2[i][1]);
        }
        System.out.println("Intervals only \n");
        for(int i=0 ; i<size1 ; i++)
        {
            System.out.println(interval1[i][0] + "\t" + interval1[i][1]);
        }
         System.out.println("Intervals only toooo\n");
        for(int i=0 ; i<size2 ; i++)
        {
            System.out.println(interval2[i][0] + "\t" + interval2[i][1]);
        }
    }

    public void Print_Table ()
    {
      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1400, 1000);

        GridLayout grid = new GridLayout(simulate+2, 10, 10, 10);
            
        frame.setLayout(grid);
        R1 = new JTextField[simulate+1][10];

        R1[0][0] = new JTextField("Days");
        R1[0][0].setEditable(false);
        frame.add(R1[0][0]);
        R1[0][1] = new JTextField("Unit Recieved");
        R1[0][1].setEditable(false);
        frame.add(R1[0][1]);
        R1[0][2] = new JTextField("Begining");
        R1[0][2].setEditable(false);
        frame.add(R1[0][2]);
        R1[0][3] = new JTextField("Random Number");
        R1[0][3].setEditable(false);
        frame.add(R1[0][3]);
        R1[0][4] = new JTextField("Demand");
        R1[0][4].setEditable(false);
        frame.add(R1[0][4]);
        R1[0][5] = new JTextField("Ending");
        R1[0][5].setEditable(false);
        frame.add(R1[0][5]);
        R1[0][6] = new JTextField("Lost Sales");
        R1[0][6].setEditable(false);
        frame.add(R1[0][6]);
        R1[0][7] = new JTextField("Order");
        R1[0][7].setEditable(false);
        frame.add(R1[0][7]);
        R1[0][8] = new JTextField("Random Nummber");
        R1[0][8].setEditable(false);
        frame.add(R1[0][8]);
        R1[0][9] = new JTextField("Lead Time");
        R1[0][9].setEditable(false);
        frame.add(R1[0][9]);

        
        for(int i=1; i < simulate+1; i++) 
        {
            R1[i][0] = new JTextField(Integer.toString(i));
            frame.add(R1[i][0]);
            System.out.println(i + "Frame Added " + R1[i][0].getText());
            
            if(units_recieved[i-1] == false)
            {
                if(inventory <0){inventory=0;}
                R1[i][1] = new JTextField(Boolean.toString(units_recieved[i-1]));
                frame.add(R1[i][1]);  
                System.out.println(i + "if Frame Added " + R1[i][1].getText());
            }
            else
            {
                R1[i][1] = new JTextField(Integer.toString(stock_out));
                if(inventory <0){inventory=0;}
                inventory = inventory + stock_out;
                frame.add(R1[i][1]);            
                System.out.println(i + "else Frame Added " + R1[i][1].getText());
            }
                       
            R1[i][2] = new JTextField(Integer.toString(inventory));
            frame.add(R1[i][2]);
            System.out.println(i + "Frame Added " + R1[i][2].getText());
                       
            R1[i][3] = new JTextField(Integer.toString(r_n1[i-1]));
            frame.add(R1[i][3]);
            System.out.println(i + "Frame Added " + R1[i][3].getText());
                       
            for(int ii=0 ; ii<size1 ; ii++)
            {
                if(r_n1[i-1] == 0)
                {
                    R1[i][4] = new JTextField(Float.toString(days[size1-1]));
                    frame.add(R1[i][4]);
                    System.out.println(i + "Loop if Frame Added0000000" + R1[i][4].getText());
                    moo=(int)days[size1-1];
                    break;
                }
                else
                {
                    if(r_n1[i-1] == interval1[ii][0] || r_n1[i-1] > interval1[ii][0] && r_n1[i-1] < interval1[ii][1] || r_n1[i-1] == interval1[ii][1])
                    {
                        R1[i][4] = new JTextField(Float.toString(days[ii]));
                        frame.add(R1[i][4]);
                        System.out.println(i + "Loop if Frame Added m4 00000" + R1[i][4].getText());
                        moo=(int)days[ii];
                        break;
                    }
                }
            }

            inventory = inventory - moo  ;
            moo=0;
            if(inventory > 0 || inventory ==0)
            {
                R1[i][5] = new JTextField(Integer.toString(inventory));
                frame.add(R1[i][5]);  
                System.out.println(i + "If Frame Added " + R1[i][5].getText());
            }
            else
            {
                R1[i][5] = new JTextField(Integer.toString(0));
                frame.add(R1[i][5]);
                System.out.println(i + "Else Frame Added " + R1[i][5].getText());
            }

            if(inventory < 0)
            {
                R1[i][6] = new JTextField(Integer.toString(-1*inventory));
                frame.add(R1[i][6]);
                System.out.println(i + "IFFF Frame Added " + R1[i][6].getText());
            }
            else
            {
                R1[i][6] = new JTextField(Integer.toString(0));
                frame.add(R1[i][6]);
                System.out.println(i + "Elseee Frame Added " + R1[i][6].getText());
            }

            if(inventory > rop)
            {
                R1[i][7] = new JTextField(Boolean.toString(order[i-1]));
                frame.add(R1[i][7]);     
                System.out.println(i + "7 1 Frame Added " + R1[i][7].getText());
            }
            else
            {
                if(wait == 500)
                {
                    System.out.println(i + "    Wait2222 : " + wait);
                    order[i-1]=true;
                    R1[i][7] = new JTextField(Boolean.toString(order[i-1]));
                    frame.add(R1[i][7]);
                    System.out.println(i + "7 2 Frame Added " + R1[i][7].getText());
                }
                else
                {
                    if(i < wait || wait == i)
                    {
                        R1[i][7] = new JTextField(Boolean.toString(order[i-1]));
                        frame.add(R1[i][7]);  
                        System.out.println(i + "7 3 Frame Added " + R1[i][7].getText());
                    }
                    else
                    {
                        System.out.println(i + "    Wait233333332 : " + wait);
                        order[i-1]=true;
                        R1[i][7] = new JTextField(Boolean.toString(order[i-1]));
                        frame.add(R1[i][7]);   
                        System.out.println(i + "7 4 Frame Added " + R1[i][7].getText());
                    }
                }
            }

            if(order[i-1] == true)
            {
                R1[i][8] = new JTextField(Integer.toString(r_n2[j]));
                frame.add(R1[i][8]);
                System.out.println(i + "if Frame Added " + R1[i][8].getText());
                
                System.out.println(i + " hhhhhhhhhhhhh   " + r_n2[j]);

                for(int ii=0 ; ii<size2 ; ii++)
                {
                    if(r_n2[j] ==0)
                    {
                        lo=30;
                        R1[i][9] = new JTextField(Float.toString(leadtime[size2-1]));
                        if(i == simulate)
                        {
                            frame.add(R1[i][9]);
                            System.out.println(i + "if Frame Added " + R1[i][9].getText());
                            wait=i-1+(int)leadtime[size2-1]+1;
                            System.out.println(i + "   / To Un  : "+ wait);
                            wait=i-1+(int)leadtime[size2-1]+2;
                            System.out.println(i + "    Real Wait : " + wait);
                            break;
                        }
                        else
                        {
                            units_recieved[i-1+(int)leadtime[size2-1]+1] =true;
                            frame.add(R1[i][9]);
                            System.out.println(i + "if Frame Added " + R1[i][9].getText());
                            wait=i-1+(int)leadtime[size2-1]+1;
                            System.out.println(i + "   / To Un  : "+ wait);
                            wait=i-1+(int)leadtime[size2-1]+2;
                            System.out.println(i + "    Real Wait : " + wait);
                            break;  
                        } 
                    }
                    else
                    {
                        if(r_n2[j] == interval2[ii][0] ||r_n2[j] > interval2[ii][0] && r_n2[j] < interval2[ii][1] || r_n2[j] == interval2[ii][1])
                        {
                            lo=15;
                            R1[i][9] = new JTextField(Float.toString(leadtime[ii]));
                            if(i == simulate)
                            {
                                frame.add(R1[i][9]);
                                System.out.println(i + "if Frame Added " + R1[i][9].getText());
                                wait=i-1+(int)leadtime[ii]+1;
                                System.out.println(i + "   / To Un  : "+ wait);
                                wait=i-1+(int)leadtime[ii]+2;
                                System.out.println(i + "    Real Wait : " + wait);
                                break;
                            }
                            else
                            {
                                units_recieved[i-1+(int)leadtime[ii]+1] =true;
                                frame.add(R1[i][9]);
                                System.out.println(i + "if Frame Added " + R1[i][9].getText());
                                wait=i-1+(int)leadtime[ii]+1;
                                System.out.println(i + "   / To Un  : "+ wait);
                                wait=i-1+(int)leadtime[ii]+2;
                                System.out.println(i + "    Real Wait : " + wait);
                                break;  
                            }
                        }
                    }
                }
                j++;
                System.out.println("lo is equal : " + lo);
            }
            else
            {
                R1[i][8] = new JTextField(Integer.toString(0));
                frame.add(R1[i][8]);
                System.out.println(i + "Elseee Frame Added " + R1[i][8].getText());
                R1[i][9] = new JTextField(Integer.toString(0));
                frame.add(R1[i][9]);                  
                System.out.println(i + "Elsee Frame Added " + R1[i][9].getText());
            }
         
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
                
            }
        });
    }
    
}

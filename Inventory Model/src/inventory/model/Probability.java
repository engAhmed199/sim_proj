package inventory.model;

/**
 *
 * @author Yousef
 */
public class Probability 
{
    int[][] interval;
    float[]  days,prob, cum_Prob;

    public float[] Calculate_Cum(float[] prob , int size)
    {
        float[] cum_Prob = new float [size];
        cum_Prob[0]=prob[0];
        for(int i=1 ; i<size ; i++)
        {
            cum_Prob[i]=cum_Prob[i-1]+prob[i];
        }
        return cum_Prob;
    }
    
    public final int[][] Calculate_Interval(float[] cum_prob , int size)
    {
        interval[0][0] = 01;
        interval[0][1]=(int) (cum_Prob[0] * 100);
        for(int i=1 ; i<size ; i++)
        {
            interval[i][0] = interval[i-1][1]+1;
            interval[i][1]=(int) (cum_Prob[i] * 100);
        } 
        interval[size-1][1]=100;
        return interval;
    }
    
    public Probability(float[][] a ,int size)
    {
        days = new float[size];
        prob = new float[size];
        for(int i=0 ; i<size ; i++)
        {
            days[i]=a[i][0];
            prob[i]=a[i][1];
        }

        cum_Prob = new float[size];
        interval = new int[size][size];
        
        cum_Prob = Calculate_Cum(prob,size);
        interval = Calculate_Interval(cum_Prob, size);
        
        Days_Prob_Cum d = new Days_Prob_Cum( days,  prob,  cum_Prob, interval,size);
    }
}

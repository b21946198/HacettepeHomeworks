import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * This class accomplishes Mission Exterminate
 */
public class OptimalFinalDefenseGP
{
    private ArrayList<Integer> bombWeights;

    public OptimalFinalDefenseGP(ArrayList<Integer> bombWeights) {
        this.bombWeights = bombWeights;
    }

    public ArrayList<Integer> getBombWeights() {
        return bombWeights;
    }

    /**
     *
     * @param maxNumberOfAvailableAUAVs the maximum number of available AUAVs to be loaded with bombs       = 8
     * @param maxAUAVCapacity the maximum capacity of an AUAV                                               = 10
     * @return the minimum number of AUAVs required using first fit approach over reversely sorted items.
     * Must return -1 if all bombs can't be loaded onto the available AUAVs
     */
    public int getMinNumberOfAUAVsToDeploy(int maxNumberOfAvailableAUAVs, int maxAUAVCapacity)
    {
        int total = 0;
        for(int elt : bombWeights)
            total += elt;
        if(total > maxNumberOfAvailableAUAVs * maxAUAVCapacity)
            return -1;

        bombWeights.sort(Collections.reverseOrder());
        int result = 0;

        int[] remaining = new int[maxNumberOfAvailableAUAVs];
        Arrays.fill(remaining, maxAUAVCapacity);

        for(int i = 0; i < this.bombWeights.size(); i++)
        {
            int weight = this.bombWeights.get(i);

            if(weight > maxAUAVCapacity)
                return -1;

            else if(weight <= remaining[0])
            {
                remaining[0] -= weight;
            }

            else
            {
                for(int j = 1; j < maxNumberOfAvailableAUAVs; j++)
                {
                    if(weight <= remaining[j])
                    {
                        remaining[j] -= weight;
                        break;
                    }
                }
            }
        }

        for(int elt : remaining)
            if(elt != 10)
                result++;

        return result;
    }


    public void printFinalDefenseOutcome(int maxNumberOfAvailableAUAVs, int AUAV_CAPACITY)
    {
        int minNumberOfAUAVsToDeploy = this.getMinNumberOfAUAVsToDeploy(maxNumberOfAvailableAUAVs, AUAV_CAPACITY);

        if(minNumberOfAUAVsToDeploy!=-1) {
            System.out.println("The minimum number of AUAVs to deploy for complete extermination of the enemy army: " + minNumberOfAUAVsToDeploy);
        }
        else
        {
            System.out.println("We cannot load all the bombs. We are doomed.");
        }
    }



}

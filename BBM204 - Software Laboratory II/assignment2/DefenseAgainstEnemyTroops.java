import java.util.ArrayList;

public class DefenseAgainstEnemyTroops
{
    private ArrayList<Integer> numberOfEnemiesArrivingPerHour;

    public DefenseAgainstEnemyTroops(ArrayList<Integer> numberOfEnemiesArrivingPerHour)
    {
        this.numberOfEnemiesArrivingPerHour = numberOfEnemiesArrivingPerHour;
    }

    public ArrayList<Integer> getNumberOfEnemiesArrivingPerHour() {
        return numberOfEnemiesArrivingPerHour;
    }

    private int getRechargedWeaponPower(int hoursCharging){
        return hoursCharging*hoursCharging;
    }

    /**
     *     Function to implement the given dynamic programming algorithm
     *     SOL(0) <- 0
     *     HOURS(0) <- [ ]
     *     For{j <- 1...N}
     *         SOL(j) <- max_{0<=i<j} [ (SOL(i) + min[ E(j), P(j − i) ] ]
     *         HOURS(j) <- [HOURS(i), j]
     *     EndFor
     *
     * @return OptimalEnemyDefenseSolution
     */

    public OptimalEnemyDefenseSolution getOptimalDefenseSolutionDP()
    {
        int N = this.numberOfEnemiesArrivingPerHour.size();
        int[] sol = new int[N];
        ArrayList<int[]> hours = new ArrayList<>();

        sol[0] = 0;
        hours.add(new int[]{});

        for(int j = 1; j < N; j++)
        {
            int max = 0;
            int idx = 0;

            for(int i = 0; i < j; i++)
            {
                //int a = (int) Math.pow((N-j), 2);
                //int b = Math.min(this.numberOfEnemiesArrivingPerHour.get(j), a);

                int temp = (int) (sol[i] + Math.min(this.numberOfEnemiesArrivingPerHour.get(j), Math.pow((j-i), 2)));

                if (temp > max)
                {
                    max = temp;
                    idx = i;
                }
            }

            sol[j] = max;


            //sol[j] = max + (int) Math.min(this.numberOfEnemiesArrivingPerHour.get(j), Math.pow((N-j-1), 2));

            int[] tmp = new int[hours.get(idx).length + 1];

            for (int k = 0; k < hours.get(idx).length; k++)
                tmp[k] = hours.get(idx)[k];

            tmp[hours.get(idx).length] = j + 1;

            hours.add(tmp);
        }

        int max = 0;
        int idx = 0;
        for (int i = 0; i < sol.length; i++)
        {
            int elt = sol[i];
            if (elt > max)
            {
                max = elt;
                idx = i;
            }
        }

        ArrayList<Integer> tmp = new ArrayList<>();

        for(int elt : hours.get(idx))
            tmp.add(elt);

        max += this.numberOfEnemiesArrivingPerHour.get(N - 1);

        OptimalEnemyDefenseSolution defense = new OptimalEnemyDefenseSolution(max, tmp);

        return defense;

    }
}

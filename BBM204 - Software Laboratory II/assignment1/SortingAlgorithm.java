import java.util.ArrayList;

public class SortingAlgorithm
{
    public int[] arr;

    SortingAlgorithm(int[] arr)
    {
        this.arr = arr;
    }

    public void countingSort()
    {

        int n = arr.length;                 // length of the array
        int[] output = new int[n + 1];      // auxiliary space O(n)

        int max = arr[0];                   // the maximum element in the array

        for (int i = 1; i < n; i++)
        {
            if (arr[i] > max)
                max = arr[i];
        }

        int[] count = new int[max + 1];     // auxiliary space O(k) where k is max element

        for (int i = 0; i < max; i++)
        {
            count[i] = 0;
        }

        for (int i = 0; i < n; i++)
        {
            count[arr[i]]++;
        }

        for (int i = 1; i <= max; i++)
        {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--)
        {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for (int i = 0; i < n; i++)
        {
            arr[i] = output[i];
        }
    }


    public void pigeonholeSort()
    {
        int N = arr.length;
        int min = arr[0];
        int max = arr[0];

        for(int i = 0; i < N; i++)
        {
            if(arr[i] < min)
                min = arr[i];                   // the minimum element in the array

            if(arr[i] > max)
                max = arr[i];                   // the maximum element in the array
        }

        int range = max - min + 1;

        int[] holes = new int[range];           // auxiliary space O(N) where N is max element - min element

        for(int i = 0; i < N; i++)
        {
            holes[arr[i] - min]++;
        }

        int index = 0;

        for(int i = 0; i < range; i++)
        {
            while(holes[i] --> 0)               // make sure the position is checked first time which means zero but initial zero
            {
                arr[index++] = i + min;
            }
        }
    }


    public void callMergeSort()
    {
        mergeSort(0, arr.length - 1);
    }


    private void mergeSort(int low, int high)                //low = 0   &   high = arr.length - 1
    {

        if(low < high && (high - low) >= 1)
        {
            int mid = (high + low) / 2;
            mergeSort(low, mid);                            // recursively called the function
            mergeSort(mid + 1, high);

            merge(low, high);                               // merge the arrays
        }
    }


    private void merge(int low, int high)
    {
        int mid = (low + high) / 2;
        int left = low;
        int right = mid + 1;

        ArrayList<Integer> aux = new ArrayList<>();         // auxiliary space O(n) because of recursion where n is length of the array which is going to be sorted

        while(left <= mid && right <= high)
        {
            if(arr[left] <= arr[right])
            {
                aux.add(arr[left++]);
            }

            else
            {
                aux.add(arr[right++]);
            }
        }

        while(left <= mid)
        {
            aux.add(arr[left++]);
        }

        while(right <= high)
        {
            aux.add(arr[right++]);
        }

        int i = 0;
        int j = low;

        while(i < aux.size())
        {
            arr[j++] = aux.get(i++);
        }
    }


    public void insertionSort()
    {
        int N = arr.length;                         // length of the array

        for(int i = 0; i < N; i++)
        {
            int j = i;

            while(j != 0 && arr[j] < arr[j-1])      // classic insertion sort algorithm
            {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }

        }
    }


    public void reverse()
    {
        reverseMergeSort(0, arr.length - 1);                // reverse(descending order) the array with merge sort
    }


    private void reverseMergeSort(int low, int high)                //low = 0   &   high = arr.length - 1
    {

        if(low < high && (high - low) >= 1)
        {
            int mid = (high + low) / 2;
            reverseMergeSort(low, mid);
            reverseMergeSort(mid + 1, high);                    // recursive calls

            reverseMerge(low, high);                                // merge reversed arrays
        }
    }


    private void reverseMerge(int low, int high)
    {
        int mid = (low + high) / 2;
        int left = low;
        int right = mid + 1;

        ArrayList<Integer> aux = new ArrayList<>();

        while(left <= mid && right <= high)
        {
            if(arr[left] >= arr[right])                                 // descending order property
            {
                aux.add(arr[left++]);
            }

            else
            {
                aux.add(arr[right++]);
            }
        }

        while(left <= mid)
        {
            aux.add(arr[left++]);
        }

        while(right <= high)
        {
            aux.add(arr[right++]);
        }

        int i = 0;
        int j = low;

        while(i < aux.size())
        {
            arr[j++] = aux.get(i++);
        }
    }
}

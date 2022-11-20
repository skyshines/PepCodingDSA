//{ Driver Code Starts
import java.util.*;



class Count_0_In_Sorted_Matrix
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<n; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new GfG().countZeros(arr, n));
		t--;
		}
	}
}
// } Driver Code Ends


class GfG
{
    int countZeros(int a[][], int n)
    {
        //Search in sorted matrix II
        //choosing a top right corner or left bottom corner
        int i = 0;
        int j = n - 1;
        
        int count = 0;
        
        while(i < n && j >= 0){
            if(a[i][j] == 1){
                //wo coulmn kice kaam ka nhi uske niche sab one h honge
                //so discard that column
                j--;
            }else{
                count += j + 1; // agar zero mila end tak matlab
                //us row k zeroth index tak zero h honge
                //then moving to next row
                 i++;
            }
        }
        
        return count;
    }
}

/*time complexity
i travlled N;
j travlled N;
O(N + N) --> O(N)

*/

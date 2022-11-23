import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static int minTotalDistance(int[][] grid) {
        //1.Getting x coordinates -- > traversing row wise since x coordinate is increasing in row wise sense
        //and by doing this the list of x coordinates we will get will be sorted
        
        ArrayList<Integer> xcord = new ArrayList<>();
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    xcord.add(row);
                }
            }
        }
        //2/Getting y coordinates -- > traversing column wise
        
        ArrayList<Integer> ycord - new ArrayList<>();
        
        for(int col = 0; col < grid[0].length; col++){
            for(int row = 0; row < grid.length; row++){
                if(grid[row][col] == 1){
                    ycord.add(col);
                }
            }
        }
        //3.Calculating mid point
        
        int x = xcord.get(xcord.size() / 2); //agar even bhi hote na, dono k distance same aati
        //example 2 4 , median aaya 3 distance 1 + 1 = 2, now median is 2 , distance is 0 + 2 = 2, now median is 4, 
        //distance is 2 + 0 = 2, so distance same rahi
        int y = ycord.get(ycord.size() / 2);
        
        //4.Calculating distance -- > min distance (since calcualted with respect to median)
        //distance = dx + dy; math.abds s diff add karte raho d mai;
        
        int distance = 0;
        
        for(int i = 0; xcord.size() / 2; i++){
            distance += (int)Math.abs(xcord.get(i) - x) + (int)Math.abs(ycord.get(i) - y);
        }
        
        //5.return ans;
        return distance;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();


        int[][] grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        int dist = minTotalDistance(grid);
        System.out.println(dist);
    }
}

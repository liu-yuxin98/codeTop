import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MeiTuanQ4 {

    public static int minWeight(String s) {
        int length = s.length();
        int min = length;

        for(int i=(int)Math.sqrt(length);i>=1;i--){
            if(length%i==0){
                int x = i;
                int y = length/i;
                Character[][] grid = convertString(s,x,y);
                int curValue = CountDifferentArea(grid);
                min = Math.min(min,curValue);
                if(min<=2){
                    return min;
                }
            }
        }
        return min;

    }

    public static Character[][] convertString(String s, int x, int y) {
        Character[][] grid = new Character[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                grid[i][j] = s.charAt(i * x + j);
            }
        }

        // enlarge grid
        Character[][] newGrid = enlargeGrid(grid);
        return newGrid;
    }

    public static Character[][] enlargeGrid(Character[][] grid) {
        Character[][] newGrid = new Character[grid.length + 2][grid[0].length + 2];
        for (int i = 0; i < newGrid.length; i++) {
            newGrid[i][0] = '0';
            newGrid[i][newGrid[0].length - 1] = '0';
        }
        for (int j = 0; j < newGrid[0].length; j++) {
            newGrid[0][j] = '0';
            newGrid[newGrid.length - 1][j] = '0';
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                newGrid[i + 1][j + 1] = grid[i][j];
            }
        }
        return newGrid;
    }

    public static int CountDifferentArea(Character[][] grid) {
        int cnt = 0;
        for(int i=1;i<grid.length-1;i++){
            for(int j=1;j<grid[i].length-1;j++){
                if(grid[i][j]!='0'){
                    cnt += 1;
                    //bfs to find
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i,j});

                    while(stack.size()>0){
                        int [] item = stack.pop();
                        int x = item[0];
                        int y = item[1];
                        Character curValue = grid[x][y];
                        if(curValue=='0'){
                            break;
                        }
                        grid[x][y] = '0';
                        List<int []> directions = new ArrayList<>();
                        directions.add(new int[]{x-1,y});
                        directions.add(new int[]{x+1,y});
                        directions.add(new int[]{x,y-1});
                        directions.add(new int[]{x,y+1});
                        for(int[] direction:directions){
                            if(grid[ direction[0] ][ direction[1] ]==curValue){
                                stack.push(direction);
                            }
                        }
                    }

                }

            }

        }
        return cnt;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        System.out.println(minWeight(s));
//
//        int n = 9;
//        String s = "aababbabb";
//        System.out.println(minWeight(s));
    }
}

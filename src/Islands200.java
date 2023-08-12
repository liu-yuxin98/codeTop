import java.util.*;

public class Islands200 {
    public int numIslands(char[][] grid) {
        char[][] newGrid = enlargeGrid(grid);
        int cnt = 0;
        Deque<int []> fifoQueue = new LinkedList<>();
        for(int i=1;i< newGrid.length-1;i++){
            for(int j=1;j<newGrid[0].length-1;j++){
                //bfs
                if(newGrid[i][j]=='1'){

                    cnt += 1;
                    newGrid[i][j] = '0';
                    dfs(newGrid, new int[]{i,j});
//                    fifoQueue.push(new int[]{i,j});

//                    while(!fifoQueue.isEmpty()){
//                        int[] pos = fifoQueue.removeFirst();
//                        newGrid[pos[0]][pos[1]] = '0';
//                        List<int []> neighbors = findNeighbors(pos);
//                        for(int[] neighbor:neighbors){
//                            if(newGrid[neighbor[0]][neighbor[1]]=='1'){
//                                fifoQueue.addLast(neighbor);
//                                newGrid[neighbor[0]][neighbor[1]] = '0';
//                            }
//                        }
//                    }

                }
            }
        }
        return cnt;
    }

    public void dfs(char[][] newGrid, int[] pos){
        int x = pos[0];
        int y = pos[1];
        List<int []> neighbors = findNeighbors(pos);
        for(int[] neighbor:neighbors){
            if(newGrid[neighbor[0]][neighbor[1]]=='1'){
                newGrid[neighbor[0]][neighbor[1]] = '0';
                dfs(newGrid,neighbor);
            }
        }
    }
    public List<int []> findNeighbors(int [] pos){
        int x = pos[0];
        int y = pos[1];
        List<int []> neighbors = new ArrayList<>();
        neighbors.add(new int[]{x-1,y});
        neighbors.add(new int[]{x+1,y});
        neighbors.add(new int[]{x,y-1});
        neighbors.add(new int[]{x,y+1});
        return neighbors;
    }

    public char[][] enlargeGrid(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        char[][] newGrid = new char[m+2][n+2];
        for(int i=0;i<m+2;i++){
            newGrid[i][0] = '0';
            newGrid[i][n+1] = '0';
        }
        for(int j=0;j<n+2;j++){
            newGrid[0][j] = '0';
            newGrid[m+1][j] = '0';
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                newGrid[i+1][j+1] = grid[i][j];
            }
        }
        return newGrid;
    }

}

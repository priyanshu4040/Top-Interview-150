class Solution {
    private class Entry {
        int h,i,j;
        Entry(int h, int i, int j) {
            this.h = h;
            this.i = i;
            this.j = j;
        }
    }

    private boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }

    private boolean isOnBoundary(int i, int j, int rows, int cols) {
        return i == 0 || j == 0 || i == rows-1 || j == cols-1;
    }

    public int trapRainWater(int[][] heightMap) {
     int rows = heightMap.length;
     int cols = heightMap[0].length;

     PriorityQueue<Entry> queue = new PriorityQueue<>((a,b)-> a.h - b.h);
     boolean[][] visited = new boolean[rows][cols];

     int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
     //marking boundary elements as visited, so that we can't thier value in result(trapWater)
     for(int i = 0; i < rows; i++) {
        for(int j = 0; j < cols; j++) {
            if(isOnBoundary(i,j,rows,cols)) {
                queue.offer(new Entry(heightMap[i][j],i,j));
                visited[i][j] = true;
            }
        }
     }

     int maxValue = 0;
     int trapWater = 0;

     while(!queue.isEmpty()) {
        Entry entry = queue.poll();
        maxValue = Math.max(maxValue,entry.h);

        for(int[] dir : directions) {
            int newX = entry.i + dir[0];
            int newY = entry.j + dir[1];

            if(isValid(newX,newY,rows,cols) && !visited[newX][newY]) {
                visited[newX][newY] = true;

                int currentHeight = heightMap[newX][newY];

                if(currentHeight < maxValue) {
                    trapWater += maxValue - currentHeight;
                }

                queue.offer(new Entry(heightMap[newX][newY],newX,newY));
            }
        }
     }
        return trapWater;

    }
}


//2nd Solution
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n-1, leftMax = height[0], rightMax = height[n-1], total = 0;

        while(left <= right) {

            if(leftMax >= rightMax) {
                total = total + Math.max(0,(rightMax - height[right]));
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
            else {
                total = total + Math.max(0,(leftMax - height[left]));
                leftMax = Math.max(leftMax, height[left]);
                left++;
            }
        }

        return total;
        
    }
}

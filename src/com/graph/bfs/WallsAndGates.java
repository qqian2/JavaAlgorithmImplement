package com.graph.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
  hit: bfs starts with all 0 positions
 */
public class WallsAndGates {
    public final static int[][] DIRS = {{-1,0},{1,0},{0,1},{0,-1}};
    static class Cell{
        private int i;
        private int j;
        public Cell(int i, int j){
            this.i = i;
            this.j = j;
        }
        @Override
        public boolean equals(Object o){
            if(!(o instanceof Cell)){
                return false;
            }
            Cell c = (Cell)o;
            if(c.i == i && c.j == j )
                return true;
            return false;
        }
        @Override
        public int hashCode(){
            return i*10+j;
        }
    }
    public int[][] wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0||rooms[0].length == 0)
            return rooms;
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<Cell> queue = new ArrayDeque<>();
        HashSet<Cell> visited = new HashSet<>();
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(rooms[i][j] == 0){
                    Cell cur = new Cell(i,j);
                    queue.offer(cur);
                    visited.add(cur);
                }
            }
        }
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                Cell cur = queue.poll();
                for(int[] dir: DIRS){
                    int newI = cur.i+dir[0];
                    int newJ = cur.j+dir[1];
                    if(newI>=0&&newI<row&&newJ>=0&&newJ<col&&rooms[newI][newJ]!=-1){
                        Cell newCell = new Cell(newI, newJ);
                        if(!visited.contains(newCell)){
                            visited.add(newCell);
                            rooms[newI][newJ] = level;
                            queue.offer(newCell);
                        }
                    }
                }
            }
            level++;
        }
        return rooms;
    }
}

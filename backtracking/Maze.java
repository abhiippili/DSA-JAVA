package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
//        System.out.println(count(3,3));
//        printPaths("", 3, 3);
//        System.out.println(listPaths("", 3, 3));
//        System.out.println(listPathDiagonal("", 3, 3));
        boolean[][] maze = {
            {true, false, false, false},
            {true, true, false, true},
            {true, true, false, false},
                {false, true, true, true}
        };
        int[][] path = new int[maze.length][maze[0].length];
//        printAllPaths("", maze, 0, 0, path, 1);
//        printAllPaths("", path, 0, 0, 1);
//        System.out.println(listPathObstacles("", maze, 0, 0));
        System.out.println(listAllPaths("",maze, 0, 0));
    }

    static int count(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }
        int ans = count(r, c - 1) + count(r - 1, c);
        return ans;
    }
    static void printPaths(String p, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }
        if(r > 1){
            printPaths(p + 'D', r - 1, c);
        }
        if(c > 1){
            printPaths(p + 'R', r, c - 1);
        }
    }
    static ArrayList<String> listPaths(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();
        if(r > 1){
            left = listPaths(p + 'D', r - 1, c);
        }
        if(c > 1){
            right = listPaths(p + 'R', r, c - 1);
        }
        left.addAll(right);
        return left;
    }
    static ArrayList<String> listPathDiagonal(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(r > 1){
            list.addAll(listPathDiagonal(p + 'D', r - 1, c));
        }
        if(r > 1 && c > 1){
            list.addAll(listPathDiagonal(p + 'd', r - 1, c - 1));
        }
        if(c > 1) {
            list.addAll(listPathDiagonal(p + 'R', r, c - 1));
        }
        return list;
    }

    static ArrayList<String> listPathObstacles(String p, boolean[][] maze, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        if(!maze[r][c]) {
            ArrayList<String> list = new ArrayList<>();
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(r < maze.length - 1){
            list.addAll(listPathObstacles(p + 'D', maze, r + 1, c));
        }
        if(r < maze.length - 1 && c < maze[0].length - 1){
            list.addAll(listPathObstacles(p + 'd', maze, r + 1, c + 1));
        }
        if(c < maze[0].length - 1){
            list.addAll(listPathObstacles(p + 'R', maze, r, c + 1));
        }
        return list;
    }

    static ArrayList<String> listAllPaths(String p, boolean[][] maze, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(!maze[r][c]){
            return list;
        }
        //marking it as visited in calling phase, to not end up in same pos in same path
        maze[r][c] = false;
        if(r < maze.length - 1){
            list.addAll(listAllPaths(p + 'D', maze, r + 1, c));
        }
        if(c < maze[0].length - 1){
            list.addAll(listAllPaths(p + 'R', maze, r, c + 1));
        }
        if(r > 0){
            list.addAll(listAllPaths(p + 'U', maze, r - 1, c));
        }
        if(c > 0){
            list.addAll(listAllPaths(p + 'L', maze, r, c - 1));
        }
        //revert the changes, in return phase so that others can choose this path
        maze[r][c] = true;
        return list;
    }


    static void printAllPaths(String p, int[][] maze, int r, int c, int stage){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            maze[r][c] = stage;
            for(int[] arr : maze){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            //backtrack
            maze[r][c] = 0;
            return;
        }
        if(maze[r][c] != 0){
            return;
        }
        maze[r][c] = stage;
        if(r < maze.length - 1){
            printAllPaths(p + 'D', maze, r + 1, c, stage + 1);
        }
        if(c < maze[0].length - 1){
            printAllPaths(p + 'R', maze, r, c + 1, stage + 1);
        }
        if(r > 0){
            printAllPaths(p + 'U', maze, r - 1, c, stage + 1);
        }
        if(c > 0){
            printAllPaths(p + 'L', maze, r, c - 1, stage + 1);
        }
        maze[r][c] = 0;
        //we need not back track thinking that it would anyways be overridden
        //but there is a possibilty that other rec call might not include it
        //in the path, which is not good.
        return;
    }
}

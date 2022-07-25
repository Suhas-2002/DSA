//*Rat In a Maze

/*Problem: Given a maze(2D matrix) with obstacles, starting from (0,0) you have to
reach (n-1, n-1). If you are currently on (x,y), you can move to (x+1,y) or (x,y+1).
You can not move to the walls.
Idea: Try all the possible paths to see if you can reach (n-1,n-1)*/

/*Input:
0 denotes wall, 1 denotes free path
two numbers n, m
Next n lines contain m numbers (0 or 1)
Output:
Print 1 if rat can reach (n-1,m-1)
Print 0 if it can not reach (n-1,m-1)*/

//*Source code 

#include<bits/stdc++.h>
using namespace std;

// A utility function to check if x, y is valid index for N*N maze
bool isSafe(int **arr, int x, int y, int n){ 
    if(x<n && y<n && arr[x][y]==1) return true;
    else return false;
}

/*This function solves the Maze problem using Backtracking.
It mainly uses RatinMaze() to solve the problem. It
returns false if no path is possible, otherwise return
true and prints the path in the form of 1s. Please note
that there may be more than one solutions, this function
prints one of the feasible solutions.*/

bool RatinMaze(int **arr, int x, int y, int n, int** Solarr){

    // if (x, y is goal) return true
    if(x==n-1 && y==n-1) {
        Solarr[x][y]=1;
        return true;
    }

    // Check if maze[x][y] is valid
    if(isSafe(arr,x,y,n)){
        // Check if the current block is already part of
        // solution path.
        if (Solarr[x][y] == 1) return false;

        // mark x, y as part of solution path
        Solarr[x][y] = 1;

        /* Move forward in x direction */
        if(RatinMaze(arr,x+1,y,n,Solarr)) return true;

        // If moving in x direction doesn't give solution
        // then Move down in y direction
        if(RatinMaze(arr,x,y+1,n,Solarr)) return true;

        // If none of the above movements work then
        // BACKTRACK: unmark x, y as part of solution path
        Solarr[x][y]=0; // Backtracking
        return false;
    }
    return false;//No result
}

int main(){
    int n;
    cin >> n;
    //Dinamic array 
    int**  arr = new int* [n];
    int**  Solarr = new int* [n];

    for(int i=0; i<n; i++) arr[i] = new int[n];
    for(int i=0; i<n; i++) Solarr[i] = new int[n];

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin >> arr[i][j];
        }
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            Solarr[i][j]=0;
        }
    }

    cout << "\n";

    if(RatinMaze(arr,0,0,n,Solarr)){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                cout << Solarr[i][j] << " ";
            }
            cout<<"\n";
        }
    }
    else cout<<"Solution doesn't exist";
}


//*Test case - 1
/*
INPUT
1 0 1 0 1           
1 1 1 1 1
0 1 0 1 0
1 0 0 1 1
1 1 1 0 1

OUTPUT
1 0 0 0 0
1 1 1 1 0
0 0 0 1 0 
0 0 0 1 1
0 0 0 0 1 
*/


//*Test case - 2
/*
INPUT
1 0 1 0 1           
1 1 1 1 1
0 1 0 1 0
1 0 0 1 0
1 1 1 0 0

OUTPUT
Solution doen't exist
*/

/*
Complexity Analysis: 

Time Complexity: O(2^(n^2)). 
The recursion can run upper-bound 2^(n^2) times.
Space Complexity: O(n^2). 
Output matrix is required so an extra space of size n*n is needed.
*/

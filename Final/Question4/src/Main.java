package Question4.src;

public class Main {

    public static void main(String[] args) {

        // 0 is treated good point and 1 is treated as bad point/obstacle as per the question
        int[][] givenMatrix =  {
                {0,0,0,0},
                {0,1,0,0},
                {0,0,0,0},
                {1,0,0,0},
                {0,1,0,0}
        };

        int result = uniquePathsWithObstacles(givenMatrix);
        System.out.println("The total number of unique ways to reach the end of matrix for given matrix are " + result);
    }

    // Time complexity is going to be O(nxm) as we are traversing the matrix only once
    // Space complexity is going to be O(1) as we are making change in place
    public static int uniquePathsWithObstacles(int[][] givenMatrixGrid) {

        int numberOfRows = givenMatrixGrid.length;
        int numberOfColumns = givenMatrixGrid[0].length;

        // if given matrix is 0 then no path exists
        if(numberOfRows == 0 || numberOfColumns == 0) {
            return 0;
        }

        // if there is only one row and column in the matrix and if there is obstacle in that
        // element then the result is 0 else 1
        if(numberOfColumns == 1 && numberOfRows == 1) {
            return givenMatrixGrid[0][0] == 1 ? 0: 1;
        }

        givenMatrixGrid[0][0] = 1;

        // first working on first row of the matrix
        for (int i = 1; i < numberOfColumns; i++) {
            if(givenMatrixGrid[0][i] == 0 && givenMatrixGrid[0][i-1] == 1) {
                givenMatrixGrid[0][i] = 1;
            } else {
                givenMatrixGrid[0][i] = 0;
            }
        }

        // first working on first column of the matrix
        for (int j = 1; j < numberOfRows; j++) {
            if(givenMatrixGrid[j][0] == 0 && givenMatrixGrid[j-1][0] == 1) {
                givenMatrixGrid[j][0] = 1;
            } else {
                givenMatrixGrid[j][0] = 0;
            }
        }

        // traverse through element from first row and first column
        // logic is that since the robot can only move in right and downward direction, we need to add the elements
        // row-1 and column-1 element to determine the number of ways to reach that element,
        // if the element itself is obstacle:1 then it is a dead end
        for(int i=1; i < numberOfRows; i++) {
            for(int j = 1; j < numberOfColumns; j++) {
                if(givenMatrixGrid[i][j] == 0) {
                    givenMatrixGrid[i][j] = givenMatrixGrid[i-1][j] + givenMatrixGrid[i][j-1];
                } else {
                    // we hit an obstacle so a dead-end
                    givenMatrixGrid[i][j] = 0;
                }
            }
        }

        // the last element in the matrix will have the total number of ways to reach the end of the matrix
        return givenMatrixGrid[numberOfRows-1][numberOfColumns-1];
    }
}


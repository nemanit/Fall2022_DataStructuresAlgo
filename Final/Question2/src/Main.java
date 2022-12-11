package Question2.src;

public class Main {

    static int givenMatrixRows = 0;
    static int givenMatrixColumns = 0;
    public static void main(String[] args) {
        char[][] givenMatrix = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        givenMatrixRows = givenMatrix.length;
        givenMatrixColumns = givenMatrix[0].length;
        int result = numIslands(givenMatrix);

        System.out.println("Total number of islands found are " + result);
    }

    // Time complexity is O(mxn) where m is the number of rows and n is number of columns
    // Space complexity is O(mxn) as we have created a visitedMatrixFlag matrix
    public static int numIslands(char[][] givenMatrix) {

        // if there is only a single element, just return the value itself as number of islands
        if(givenMatrixColumns == 1 && givenMatrixRows == 1) {
            return givenMatrix[0][0];
        }

        // used to track if an element in matrix is already visited or not
        boolean[][] visitedMatrixFlag = new boolean[givenMatrixRows][givenMatrixColumns];
        int numberOfIslandsFound = 0;

        for(int i = 0; i < givenMatrixRows; i++) {
            for(int j = 0; j < givenMatrixColumns; j++) {
                // if the element in matrix is 1 and not visited then there should be an island in the matrix
                if(givenMatrix[i][j] == '1' && !visitedMatrixFlag[i][j]) {
                    numberOfIslandsFound = numberOfIslandsFound + 1;
                    checkNeighboursOfElement(givenMatrix, visitedMatrixFlag, i, j);
                }
            }
        }

        return numberOfIslandsFound;
    }

    // this function is used to check that all four sides of the islands are visited recursively thereby completely mapping out the island
    public static void checkNeighboursOfElement(char[][] givenMatrix, boolean[][]visitedMatrixFlag, int row, int column) {

        if(row < 0 || row >= givenMatrixRows || column < 0 || column >= givenMatrixColumns || visitedMatrixFlag[row][column] || givenMatrix[row][column] == '0' )
            return;

        visitedMatrixFlag[row][column] = true;

        checkNeighboursOfElement(givenMatrix, visitedMatrixFlag, row, column-1);
        checkNeighboursOfElement(givenMatrix, visitedMatrixFlag, row, column+1);
        checkNeighboursOfElement(givenMatrix, visitedMatrixFlag, row-1, column);
        checkNeighboursOfElement(givenMatrix, visitedMatrixFlag, row+1, column);
    }

}


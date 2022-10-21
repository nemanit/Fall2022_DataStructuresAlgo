class Solution {
    public boolean exist(char[][] board, String word) {

        if (word.length() == 0) {
            return false;
        }

        char[] wordCharArray = word.toCharArray();

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                if (dfsBoardChar(board, wordCharArray, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfsBoardChar(char[][] board, char[] wordCharArray, int index, int row, int col) {


        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '*') {
            return false;
        }

        if (wordCharArray[index] != board[row][col]) {
            return false;
        }


        if (index == wordCharArray.length - 1) {
            return true;
        }

        board[row][col] = '*';

        boolean exists = dfsBoardChar(board,wordCharArray, index + 1, row + 1,col) || dfsBoardChar(board,wordCharArray,index + 1, row - 1, col)
                || dfsBoardChar(board, wordCharArray, index + 1, row, col + 1) || dfsBoardChar(board, wordCharArray,index + 1, row, col - 1);

        board[row][col] = wordCharArray[index];

        return exists;
    }

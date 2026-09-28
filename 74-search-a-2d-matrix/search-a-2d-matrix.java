class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int startRow = 0, endRow = m - 1;

        while(startRow <= endRow) {
            int midRow = startRow + (endRow - startRow) / 2;

            if(target >= matrix[midRow][0] && target <= matrix[midRow][n-1]) {
                return searchRow (matrix, target, midRow);
            } else if (target >= matrix[midRow][n-1]) {
                startRow = midRow + 1;
            } else {
                endRow = midRow - 1;
            }
        }
        return false;
    }

    public boolean searchRow(int[][] matrix, int target, int row) {
        int n = matrix[0].length;
        int startCol = 0, endCol = n-1;

        while(startCol <= endCol) {
            int mid = startCol + (endCol - startCol) / 2;

            if(target == matrix[row][mid]) {
                return true;
            } else if (target > matrix[row][mid]) {
                startCol = mid + 1;
            } else {
                endCol = mid - 1;
            }
        }
        return false;
    }
}
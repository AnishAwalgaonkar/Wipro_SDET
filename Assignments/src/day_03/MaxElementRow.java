package day_03;
class MaxElementRow {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 5, 3},
            {9, 2, 8},
            {4, 6, 7}
        };
        for (int[] row : arr) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i][0];

            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
            System.out.println("Row " + i + " max: " + max);
        }
    }
}

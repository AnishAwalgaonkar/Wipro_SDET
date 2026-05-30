package day_03;

class SortArray {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 7};
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.print("Sorted array in ascending order: ");
        for (int num : arr) System.out.print(num + " ");
        
        System.out.println();
        
        System.out.print("Sorted array in ascending order: ");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

    }
}

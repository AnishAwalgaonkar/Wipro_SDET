package day_03;
class Palindrome {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};
        int n = arr.length;
        boolean isPalindrome = true;
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != arr[n - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
        if (isPalindrome)
            System.out.println("The array is Palindrome");
        else
            System.out.println("The array is not Palindrome");
    }
}

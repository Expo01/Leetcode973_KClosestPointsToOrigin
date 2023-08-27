import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }

}


class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] squareSums = new int[N]; // will contain the sum of squared x and y point values for 'n' number of points
        
        for (int i = 0; i < N; ++i) // calls helper method to return sum of squares
            squareSums[i] = squareXandY(points[i]);

        Arrays.sort(squareSums); // what is the efficiency and mechanism of inbuilt sort? 
        int sumAtKthIndex = squareSums[K-1]; // once sorted, we find and assign the sum at the designated index

        int[][] ans = new int[K][2]; // answer will have K elements, each element containing 2 elements for X and Y
        int t = 0;

        for (int i = 0; i < N; ++i) // note that the problem states we want the K closest elements, but those suppose 'top 3'
            // elements can be returned int the 'ans' multidimensional array in any order
            if (squareXandY(points[i]) <= sumAtKthIndex) // we say if the sum of Squares at point in points is <= to our established
                // Kth sum value, then add the point and increment 't'
                ans[t++] = points[i]; // this is a java quick for both adding point[i] and t, then incrementing t++ in one statement
        return ans;
    }

    public int squareXandY(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}


//FRAMEWORK FOR QUICK SORT O(N LOG N) but i know this isn't the answer 
//public class Solution {
//    private static void swap(int[][] array, int firstIndex, int secondIndex) {
//        int temp = array[firstIndex];
//        array[firstIndex] = array[secondIndex];
//        array[secondIndex] = temp;
//    }
//    private static int pivot(int[][] array, int pivotIndex, int endIndex) {
//        int swapIndex = pivotIndex; //swap and pivot both on index 0 or first index of chunk
//        for (int i = pivotIndex + 1; i <= endIndex; i++) { // note this is <= endIndex not < as with length
//            if (array[i][0]* array[i][0] + array[i][1]*array[i][1] < array[pivotIndex]) { // so on and so fortht
//                // changing sortring to be via lowest hypoteneuse
//                swapIndex++;
//                swap(array, swapIndex, i);
//            }
//        }
//        swap(array, pivotIndex, swapIndex);
//        return swapIndex;
//    }
//
//    private static void quickSortHelper(int[] array, int left, int right) { //
//        if (left < right) {
//            int pivotIndex = pivot(array, left, right);
//            quickSortHelper(array, left, pivotIndex - 1);
//            quickSortHelper(array, pivotIndex + 1, right);
//        }
//    }
//
//    public static void quickSort(int[] array) { // pass array with min and max index parameters
//        quickSortHelper(array, 0, array.length - 1);
//
//    }
//}
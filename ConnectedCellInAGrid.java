//Con Scanner
import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        int [][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = input.nextInt();

            }
        }
        input.close();

        System.out.println(Region(array));
    }

    public static int Region(int [][] array) {
        int maxRegion = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 1) {
                    int size = findRegion(array, i, j);
                    maxRegion = Math.max(maxRegion, size);
                }
            }
        }
        return maxRegion;
    }

    private static int findRegion(int [][] array, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || array == null || array[i][j] == 0) {
            return 0;
        }

        array[i][j] = 0;
        int size = 1;

        for (int f = i - 1; f <= i + 1; f++) {
            for (int c = j - 1; c <= j + 1; c++) {
                size += findRegion(array, f, c);
            }
        }
        return size;
    }
}   

 

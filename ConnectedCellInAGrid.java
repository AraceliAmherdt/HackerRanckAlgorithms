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

 
 // Con Buffer
 
 import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int connectedCell(List<List<Integer>> matrix) {
        int [][] array = new int[matrix.size()];
        array = matrix.toArray(array);
        
        for (int i=0; i < matrix.size; i++) {
        for (int j=0; j < matrix[i].size; j++) {
      //System.out.println (matrix[i][j]);
      
  }
}

    }

}

public class ConnectedCellinAGrid {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

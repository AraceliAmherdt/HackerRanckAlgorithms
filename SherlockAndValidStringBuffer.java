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
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
     int[] alphabet = new int['z' - 'a' + 1]; // Se hace de z -> a porque se resta, y sino el valor queda en negativo.
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++; // El metodo charAt separa los caracteres del String y los divide en celdas, despues, dependiendo de la celda se sabe que caracter es.
        }
                
        int f1 = 0, f2 = 0, fc1 = 0, fc2 = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] != 0) {
                if (alphabet[i] == f1) {
                    fc1++;
                } else if (alphabet[i] == f2) {
                    fc2++;
                } else if (f1 == 0) {
                    f1 = alphabet[i];
                    fc1++;
                } else if (f2 == 0) {
                    f2 = alphabet[i];
                    fc2++;
                } else {
                    return "NO";
                }
            }
        }
        return f2 == 0 || (f1 == f2 - 1 && fc2 == 1) || (f1 - 1 == f2 && fc1 == 1) ||
            (f1 == 1 && fc1 == 1) || (f2 == 1 && fc2 == 1) ? "YES" : "NO";
    }
    }



public class SherlockAndValidStringBuffer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

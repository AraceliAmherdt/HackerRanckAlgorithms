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

public class Solution {
    public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);  
      
    String s = input.next();
    int [] alphabet = new int ['z' - 'a' + 1];
    for (int i = 0; i<alphabet.length; i++){
     alphabet[s.charAt(i) - 'a']++;   
    }
    
    }
}

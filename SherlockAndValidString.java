import java.util.*;

public class SherlockAndValidString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(isValid(s));
    }

    public static String isValid(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        Collection<Integer> values = frequencyMap.values();
        int distinctValues = (int) values.stream().distinct().count();

        if (distinctValues == 1) {
            return "YES";
        } else if (distinctValues == 2) {
            int min = Collections.min(values);
            int max = Collections.max(values);
            int minCount = (int) values.stream().filter(v -> v == min).count();
            int maxCount = (int) values.stream().filter(v -> v == max).count();
            if ((min == 1 && minCount == 1) || (max - min == 1 && maxCount == 1)) {
                return "YES";
            }
        }

        return "NO";
    }
}

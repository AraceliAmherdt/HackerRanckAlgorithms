import java.util.*;

public class SherlockAndValidString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(isValid(s));
    }

    public static String isValid(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char a : s.toCharArray()) { //toCharArray separa los caracteres de un string
            frequencyMap.put(a, frequencyMap.getOrDefault(a, 0) + 1); //Se usa getOrDefault para evitar problemas de valores nulos y sirve para inicializar un contador
        }

        Collection<Integer> values = frequencyMap.values();
        int distinctValues = (int) values.stream().distinct().count(); //Stream permite realizar varias operaciones sobre la coleccion, distinct elimina duplicados

        if (distinctValues == 1) {
            return "YES";
        } else if (distinctValues == 2) {
            int min = Collections.min(values); //Encuentra el valor minimo
            int max = Collections.max(values); //Encuentra el valor maximo
            int minCount = (int) values.stream().filter(v -> v == min).count(); //Cuenta cuantas veces aparece el valor minimo
            int maxCount = (int) values.stream().filter(v -> v == max).count(); //Cuenta cuantas veces aparece el valor maximo
            if ((min == 1 && minCount == 1) || (max - min == 1 && maxCount == 1)) { //La primera comprueba si el valor minimo es igual a 1 y aparece una sola vez, la segunda si la dif entre el valor maximo y el minimo es igual a 1 y el valor maximo aparece una sola vez (se puede borrar)
                return "YES";
            }
        }

        return "NO";
    }
}


import java.util.ArrayList;
import java.util.Collections;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> enteros = new ArrayList<Integer>();
        Integer e1 = 0;
        Integer e2 = 2;
        Integer e3 = 1;

        enteros.add(e1);
        enteros.add(e2);
        enteros.add(e3);

        Collections.sort(enteros);
        int i = 0;
        for (Integer entero : enteros) {
            System.out.println("DATO " + (i + 1) + " >> " + entero);
            i++;
        }

    }
}

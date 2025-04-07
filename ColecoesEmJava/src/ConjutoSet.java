import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

public class ConjutoSet {
    public static void main(String[] args) {

        var numerosSet = new TreeSet<>();

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.printf("informe um numba:");
            int numba = sc.nextInt();
            numerosSet.add(numba);
        }

        if (numerosSet.contains(30)) {
            System.out.printf("O numero 30 esta presente na lista\n");
        }else System.out.printf("o numero 30 n esta presente na lista \n");

        numerosSet.addAll(Arrays.asList( 20 , 60 , 70));

        numerosSet.remove(40);

        System.out.println(numerosSet.size());

        System.out.println(numerosSet);

        numerosSet.clear();

    }
}

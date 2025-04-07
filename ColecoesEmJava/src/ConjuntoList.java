
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ConjuntoList {
    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>(List.of( 1,10,20,21,30,40,50));



        if (numeros.contains(30)){
            System.out.printf("O numero 30 esta na lista\n");
        }else System.out.printf("O numeor 30 n esta presente na lista\n");
        if (numeros.contains(15)){
            System.out.printf("O numero 15 esta na lista\n");
        }else System.out.printf("O numeor 15 n esta presente na lista\n");

        numeros.add(60);

        System.out.printf("Listando:\n");
        for (int i = 0; i < numeros.size(); i++) {

            System.out.println(numeros.get(i));

        }

        Collections.sort(numeros);

        System.out.printf("Listando crescente:\n");
        for (int i = 0; i < numeros.size(); i++) {

            System.out.println(numeros.get(i));

        }

        Collections.sort(numeros, Collections.reverseOrder());

        System.out.printf("Listando decrescente:\n");
        for (int i = 0; i < numeros.size(); i++) {

            System.out.println(numeros.get(i));

        }

        var numerosPares = new ArrayList<>();

        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i)%2==0){
                numerosPares.add(numeros.get(i));
            }


        }

        System.out.printf("Listando numeros pares:\n");
        for (int i = 0; i < numerosPares.size(); i++) {

            System.out.println(numerosPares.get(i));

        }

        numeros.clear();
        numerosPares.clear();
    }
}
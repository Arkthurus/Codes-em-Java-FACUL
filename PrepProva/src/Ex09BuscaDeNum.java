import java.util.ArrayList;
import java.util.Scanner;

public class Ex09BuscaDeNum {
    public static void main(String[] args) {

        while(true){

            ArrayList<Vetor3> vetor = new ArrayList<>();

            vetor.add(new Vetor3(1));
            vetor.add(new Vetor3(2));
            vetor.add(new Vetor3(3));
            vetor.add(new Vetor3(4));
            vetor.add(new Vetor3(5));

            buscaVetor(vetor);
        }

    }

    protected static  void buscaVetor(ArrayList<Vetor3> vetor) {

        Scanner sc = new Scanner(System.in);

        boolean encontrado = false;

        System.out.printf("informe o valor de busca: ");
        int busca = sc.nextInt();

        for (int i = 0; i < 5; i++) {
            if(busca==vetor.get(i).GetNum()){
                System.out.printf("Num encontrado no Indice %d\n", i);
                encontrado=true;
                break;
            }
        }

        if(!encontrado){
            System.out.printf("Numero  não existe no vetor\n");
        }
        encontrado=false;
    }
}
class Vetor3{
    private int num;

    protected Vetor3(int num){this.num = num;};
    protected void SetNum(int num){this.num = num;}
    protected int GetNum(){return num;}

}

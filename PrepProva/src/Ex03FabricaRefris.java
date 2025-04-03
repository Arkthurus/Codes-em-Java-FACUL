import java.util.Scanner;

public class Ex03FabricaRefris {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int garrafa2l, garrafa600ml, lata350ml;

        Scanner sc = new Scanner(System.in);

        System.out.printf("Garrafa 2l: ");
        garrafa2l = sc.nextInt();
        System.out.printf("Garrafa 600ml: ");
        garrafa600ml = sc.nextInt();
        System.out.printf("Lata 350ml: ");
        lata350ml = sc.nextInt();

        float totalLitros=CalcLitros(garrafa2l, garrafa600ml, lata350ml);

        MostrarLitros(totalLitros);

    }

    protected static void MostrarLitros(float info){
        System.out.printf("%.2f litro(s)\n", info);
    }

    protected static float CalcLitros(int garrafa2l,  int garrafa600ml, int lata350ml) {

        float totalLitros=(garrafa2l*2f)+(garrafa600ml*0.6f)+(lata350ml*0.35f);

        return  totalLitros;
    }

}

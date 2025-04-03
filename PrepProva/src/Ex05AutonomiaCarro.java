import java.util.Scanner;

public class Ex05AutonomiaCarro {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        float capTanque, QtdLitros, kmPercorrido, autonomia, consumoMedio;

        System.out.printf("Capacidade Tanque: ");
        capTanque= sc.nextFloat();
        System.out.printf("Litros Abastecidos: ");
        QtdLitros= sc.nextFloat();
        System.out.printf("Km percorrido: ");
        kmPercorrido= sc.nextFloat();

        consumoMedio=CalcConsumo(kmPercorrido, QtdLitros);
        autonomia=CalcAutonomia(consumoMedio, capTanque, QtdLitros);

        System.out.printf("Autonomia: %.2f km\n", autonomia);
        System.out.printf("Consumo: %.2f km\\litro\n", consumoMedio);

        sc.close();

    }

    protected static float CalcConsumo(float kmPercorrido, float CombustivelGasto){
        float consumoMedio= kmPercorrido/CombustivelGasto;
        return consumoMedio;
    }

    protected static float CalcAutonomia(float consumo, float capTanque, float QtdAbastecidos){
        float autonomia= (capTanque-QtdAbastecidos)*consumo;
        return autonomia;
    }
}

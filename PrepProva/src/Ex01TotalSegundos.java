import java.util.Scanner;

public class Ex01TotalSegundos {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int horas, minutos, segundos;

        Scanner sc = new Scanner(System.in);

        System.out.printf("Informe a quantidade de horas: ");
        horas = sc.nextByte();
        System.out.printf("Informe a quantidade de minutos: ");
        minutos = sc.nextByte();
        System.out.printf("Informe a quantidade de segundos: ");
        segundos = sc.nextByte();
        int horasCalc=horas*3600;
        int minutosCalc=minutos*60;

        int totalSegundos = horasCalc+minutosCalc+segundos;

        System.out.printf("%dhora(s) %dminusto(s) %dsegundo(s) totalizam %ds.", horas, minutos, segundos, totalSegundos);
    }





}
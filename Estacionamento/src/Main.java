import java.lang.reflect.Array;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<CARRO> carros = new ArrayList<CARRO>();

        while (true){
            System.out.printf("+-----------Carros----------+\n");
            System.out.printf("|                             |\n");
            System.out.printf("+ [1] adicionar Carro       +\n");
            for (int i = 0; i < carros.size(); i++) {
                System.out.printf("|                             |\n");
                System.out.printf("+ [%d] %s                      \n", i+2, carros.get(i).getNome());
            }
            System.out.printf("|                             |\n");
            System.out.printf("+-----------------------------+\n");
            int escolha= sc.nextInt();
            for (int i = 0; i < carros.size(); i++) {
                if (escolha==(i+2)){MenuCarro(carros.get(i));}
            }
            if (escolha==1){novoCarro(carros);}
        }
    }
    protected static void novoCarro(ArrayList<CARRO> carro){

        Scanner sc = new Scanner(System.in);

        System.out.printf("Informe a Placa: ");
        String placa = sc.nextLine();
        System.out.printf("Informe o Modelo: ");
        String modelo = sc.nextLine();
        carro.add(new CARRO(placa, modelo));

    }
    protected static void newEstada(CARRO carro){

        LocalDate hoje = LocalDate.now();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DateTimeFormatter formatoHoras = DateTimeFormatter.ofPattern("HH:mm");

        Scanner sc = new Scanner(System.in);

        System.out.printf("Deseja criar um novo Recibo?[S/N]\n");
        String escolha = sc.nextLine();
        if (escolha.equalsIgnoreCase("N")){return;}

        System.out.printf("Informe a hora de ENTRADA[hh:mm]: ");
        String entradaString = sc.nextLine();
        LocalTime entrada = LocalTime.parse(entradaString, formatoHoras);

        System.out.printf("Informe a hora de SAIDA[hh:mm]: ");
        String saidaString = sc.nextLine();
        LocalTime saida = LocalTime.parse(saidaString, formatoHoras);

        long diferenca = Duration.between(entrada, saida).toMinutes();

        float valor = 5.0f;

        if (diferenca > 60){
            diferenca-=60;
            valor+=Math.ceil(diferenca/15)*2;
        }

        carro.recibos.add(new RECIBO(hoje.format(formato), entrada, saida, valor));
        System.out.printf("Estada Registrada!\n");

    }
    protected static void MenuCarro(CARRO carro){

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.printf("+-------------%s--------------+\n", carro.getNome());
            System.out.printf("|                             |\n");
            System.out.printf("             %s                \n", carro.getPlaca());
            System.out.printf("|                             |\n");
            System.out.printf("+ [1] Nova Estada              \n");
            System.out.printf("|                             |\n");
            System.out.printf("+ [2] Estadas Anteriores       \n");
            System.out.printf("|                             |\n");
            System.out.printf("+ [3] voltar                  \n");
            System.out.printf("|                             |\n");
            System.out.printf("+-----------------------------+\n");
            int escolha = sc.nextInt();
            sc.nextLine();
            if (escolha==1){ newEstada(carro);}
            if (escolha==2){

                if (carro.recibos.isEmpty()){System.out.printf("Nenhuma Estada atrelada ao Carro!\n");continue;}

                System.out.println("----------------------------------------------------");
                System.out.println("Modelo: " + carro.getNome());
                System.out.println("Placa: " + carro.getPlaca());
                System.out.println("----------------------------------------------------");
                for (int i = 0; i < carro.recibos.size(); i++) {

                    System.out.println("Ticket %d: " + (i+1));
                    System.out.println("Data: " + carro.recibos.get(i).getData());
                    System.out.println();
                    System.out.println("Entrada: " + carro.recibos.get(i).getEntrada());
                    System.out.println();
                    System.out.println("Saida: " + carro.recibos.get(i).getSaida());
                    System.out.println();
                    System.out.println("Valor: R$" + carro.recibos.get(i).getValor());
                    System.out.println("----------------------------------------------------");
                }
                System.out.printf("[1]voltar");
                int escolha2 = sc.nextInt();
                sc.nextLine();
            }
            if (escolha==3){break;}
        }
    }
}
class CARRO{
    private String nome;
    private String placa;
    public ArrayList<RECIBO> recibos = new ArrayList<>();

    //CONSTRUCTOR
    public CARRO(String placa, String nome){
        this.placa=placa;
        this.nome=nome;
    }
    //GETTERS
    public String getPlaca() {return placa;}
    public String getNome() {return nome;}
}
class RECIBO{
    private String data;
    private LocalTime entrada;
    private LocalTime saida;
    private float Valor;

    //CONSTRUCTOR
    public RECIBO(String data, LocalTime entrada, LocalTime saida, float valor){
        this.data=data;
        this.entrada=entrada;
        this.saida=saida;
    }
    //GETTERS
    public String getData(){return data;}
    public LocalTime getEntrada(){return entrada;}
    public LocalTime getSaida() {return saida;}
    public float getValor() {return Valor;}
}
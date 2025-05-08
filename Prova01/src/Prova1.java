import java.util.ArrayList;
import java.util.Scanner;

public class Prova1 {
    public static void main(String[] args) {

        ArrayList<CARROS> carros = new ArrayList<>();
        carros.add(new CARROS("Kwid", "Branco", 2020, 20, 0));
        carros.add(new CARROS("Mobi", "preto", 2019, 30,0));

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.printf("+--------------------------+\n");
            System.out.printf("+----------CARROS----------+\n");
            System.out.printf("+--------------------------+\n");
            System.out.printf("|                          |\n");
            for (int i = 0; i < carros.size(); i++) {
                System.out.printf("| [%d] %s                   \n", i+1, carros.get(i).getModelo());
                System.out.printf("|                          \n");
            }
            System.out.printf("+--------------------------+\n");
            int escolha = sc.nextInt();
            for (int i = 0; i < carros.size(); i++) {
                if (escolha==(i+1)){
                    menuCarro(carros.get(i));
                }
            }
        }


    }



    protected static void menuCarro(CARROS carro){

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println();
            System.out.printf("+--------------------------+\n");
            System.out.printf("+           %s", carro.getModelo());
            System.out.printf("+--------------------------+\n");
            System.out.printf("| - modelo: %s              \n", carro.getModelo());
            System.out.printf("|                          |\n");
            System.out.printf("| - cor: %s\n", carro.getCor());
            System.out.printf("|                          |\n");
            System.out.printf("| - ano: %d\n", carro.getAno());
            System.out.printf("|                          |\n");
            System.out.printf("| - VelMax: %d\n", carro.getVelMax());
            System.out.printf("|                          |\n");
            System.out.printf("| - VelAtual: %d\n", carro.getVelAtual());
            System.out.printf("|                          |\n");
            System.out.printf("+--------------------------+\n");
            System.out.printf("|  [1]+vel [2]-vel [3]Info |\n");
            System.out.printf("|          [4]sair         |\n");
            System.out.printf("+--------------------------+\n");
            int escolhaVoltar= sc.nextByte();
            if (escolhaVoltar == 1) {
                aumentarVel(carro);
            }
            if (escolhaVoltar==2){
                diminuirVel(carro);
            }
            if (escolhaVoltar==3){
                mostrarInfo(carro);
            }
            if (escolhaVoltar==4){
                break;
            }
        }


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    protected static void aumentarVel(CARROS carro){
        if (carro.getVelAtual()==carro.getVelMax()){
            System.out.printf("O MOTOR N AGUENTA MAIS JA TA NO MAXIMO!!!!!\n");
            menuCarro(carro);

        }else {
            int aceleracao=carro.getVelAtual()+10;
            carro.setVelAtual(aceleracao);
            System.out.printf("VRUM! VRUM! carrinho aumentou a velocidade em 10Km/h!!\n");
            menuCarro(carro);
        }
    }
    protected static void diminuirVel(CARROS carro){
        if (carro.getVelAtual()==0){
            System.out.printf("A Carranga ta parada ja fih!\n");
            menuCarro(carro);
        }else {
            int freio = carro.getVelAtual()-10;
            carro.setVelAtual(freio);
            System.out.printf("PISA NO FREIO ZÉ!!! isso menos 10Km/h ja ta bão\n");
            menuCarro(carro);
        }
    }
    protected static void mostrarInfo(CARROS carro){
        if (carro.getVelAtual()==0){
            System.out.printf("O %s %s está parado ali Zé\n", carro.getModelo(), carro.getCor());
            menuCarro(carro);
        }else if (carro.getVelAtual()== carro.getVelMax()){
            System.out.printf("O %s %s ATINGIU SUA VELOCIDADE MAXIMA FIH!!!!\n", carro.getModelo(), carro.getCor());
            menuCarro(carro);
        }else {
            System.out.printf("O %s %s esta atualmente a %d Km/h!!\n", carro.getModelo(), carro.getCor(),carro.getVelAtual());
            menuCarro(carro);
        }
    }

}
class CARROS{
    private String modelo;
    private String cor;
    private int ano;
    private int velMax;
    private int velAtual;

    //CONSTRUCTOR
    public CARROS(String modelo, String cor, int ano, int velMax, int velAtual){
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.velMax = velMax;
        this.velAtual = velAtual;
    }
    //GETTERS
    protected String getModelo(){return modelo;}
    protected String getCor(){return cor;}
    protected int getAno(){return ano;}
    protected int getVelMax(){return velMax;}
    protected int getVelAtual(){return velAtual;}
    //SETTERS
    protected void setModelo(String modelo){this.modelo=modelo;}
    protected void setCor(String cor){this.cor=cor;}
    protected void setAno(int ano){this.ano=ano;}
    protected void setVelMax(int velMax){this.velMax=velMax;}
    protected void setVelAtual(int velAtual){this.velAtual=velAtual;}

}
import java.util.Scanner;

public class Ex03_BombaGasolina {
    public static void main(String[] args){
        Bomba b1 = new Bomba();
        b1.numero=1;
        b1.combustivel="ETANOL";
        b1.valorL=4.13f;
        b1.qtdCombustivel=555;

        b1.abastecerPorValor();

        //.out.printf("Vai de Etanol ou Gasolina?");
        //String escolha = scanner.next();
       // escolha.equalsIgnoreCase(this)
    }
}
class Bomba{
    int numero;
    String combustivel;
    float valorL;
    int qtdCombustivel;

    Scanner scanner = new Scanner(System.in);

    public void abastecerPorValor(){
        System.out.printf("Quanto vai ser?");
        float valor= scanner.nextFloat();
        float qtdAbastecido=valor/this.valorL;
        System.out.println(qtdAbastecido);
    }
    public void abatecerPorLitro(){

    }
    public  void alterarValor(){
        System.out.printf("Informe o novo valor do Litro: ");
        this.valorL= scanner.nextFloat();
        System.out.printf("Valor do Litro definido como R$%.2f", this.valorL);
    }
    public  void alterarQtdCombustivel(){
        System.out.printf("Defina a quantidade de combustivel na bomba; ");
        this.qtdCombustivel= scanner.nextInt();
        System.out.printf("Quantidade de Combustivel definida como: %d", this.qtdCombustivel);
    }
    public void status(){

        System.out.printf("+---------Bomba%d----------+\n", this.numero);
        System.out.printf("+-------------------------+\n");
        System.out.printf("+Tipo: %s                  \n", this.combustivel);
        System.out.printf("+Valor Litro: %s           \n", this.valorL);
        System.out.printf("+Combustivel restante: %d  \n", this.qtdCombustivel);
        System.out.printf("+-------------------------+\n");
    }
}

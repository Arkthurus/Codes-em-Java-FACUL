import java.util.Scanner;

public class Ex01_ContaCorrente {
    public static  void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        Conta c1 = new Conta();
        c1.nome = "Arthur";
        c1.numeroConta = 123456789;

        Conta c2 = new Conta();
        c2.nome = "Lincoln";
        c2.numeroConta = 987654321;

        System.out.printf(" ______________________________________________________________________________ \n");
        System.out.printf("/                          Informe o Numero da Conta                           \\ \n");
        System.out.printf("\\-----------------------------------------------------------------------------/\n");
        int numeroConta = scanner.nextInt();
        if (numeroConta==c1.numeroConta){
            c1.menu();
        }
        if (numeroConta==c2.numeroConta){
            c2.menu();
        }

    }
}
class Conta{
    String nome;
    int numeroConta;
    float saldo=0;

    public void menu(){
        while (true){
            System.out.printf(" ______________________________________________________________________________ \n");
            System.out.printf("/                               Banco do Kréu                                  \\ \n");
            System.out.printf("|------------------------------------------------------------------------------|\n");
            System.out.printf("                                Nome: %s                                        \n", this.nome);
            System.out.printf("|                                                                              |\n");
            System.out.printf("                                Conta: %d                                       \n", this.numeroConta);
            System.out.printf("|                                                                              |\n");
            System.out.printf("                                Saldo: %.2f                                     \n", this.saldo);
            System.out.printf("|------------------------------------------------------------------------------|\n");
            System.out.printf("|                                   Ações                                      |\n");
            System.out.printf("|------------------------------------------------------------------------------|\n");
            System.out.printf("|                 1-Deposito        2-Saque        3-Sair                      |\n");
            System.out.printf("\\______________________________________________________________________________/ \n");

            Scanner scanner = new Scanner(System.in);
            int escolha;
            do{
                escolha = scanner.nextInt();
            }while (escolha>3||escolha<0);
            if (escolha==1){
                this.Deposito();
            }
            if (escolha==2){
                this.Saque();
            }
            if (escolha==3){
                System.out.printf("Programa Encerrado\n");
                break;
            }
        }
    }


    public void Deposito(){
        System.out.printf(" ______________________________________________________________________________ \n");
        System.out.printf("/                         Informe o valor do Deposito                          \\ \n");
        System.out.printf("\\-----------------------------------------------------------------------------/\n");
        Scanner scanner = new Scanner(System.in);
        this.saldo= scanner.nextFloat();
        this.menu();
    }

    public void Saque(){
        System.out.printf(" ______________________________________________________________________________ \n");
        System.out.printf("/                           Informe o valor do Saque                           \\ \n");
        System.out.printf("\\-----------------------------------------------------------------------------/\n");
        Scanner scanner = new Scanner(System.in);
        float valorSaque = scanner.nextFloat();
        if (valorSaque>this.saldo){
            System.out.printf("Valor informado excede o saldo disponivel\n retornando ao Menu\n");
        }
        if (valorSaque<this.saldo){
            this.saldo-=valorSaque;
        }

    }
}

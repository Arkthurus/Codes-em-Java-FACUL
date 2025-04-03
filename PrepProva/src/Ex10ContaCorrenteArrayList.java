import java.util.ArrayList;
import java.util.Scanner;

public class Ex10ContaCorrenteArrayList {
        public static  void main(String[]args) {

            while (true){

                Scanner scanner = new Scanner(System.in);

                ArrayList<Conta2> contas = new ArrayList<>();

                contas.add(new Conta2("Arthur", 123456789));
                contas.add(new Conta2("Lincoln", 987654321));

                System.out.printf(" ______________________________________________________________________________ \n");
                System.out.printf("/                          Informe o Numero da Conta                           \\ \n");
                System.out.printf("\\-----------------------------------------------------------------------------/\n");
                int numeroConta = scanner.nextInt();

                boolean existe = false;
                for (int i=0; i<contas.size(); i++){
                    if (contas.get(i).getNumeroConta() == numeroConta){menu(contas.get(i));existe=true;}
                }
                if (!existe){
                    System.out.printf("Conta n existe!\n");
                }

            }

        }

        protected static void menu(Conta2 contas){
            while (true){
                System.out.printf(" ______________________________________________________________________________ \n");
                System.out.printf("/                               Banco do Kréu                                  \\ \n");
                System.out.printf("|------------------------------------------------------------------------------|\n");
                System.out.printf("                                Nome: %s                                        \n", contas.getNome());
                System.out.printf("|                                                                              |\n");
                System.out.printf("                                Conta: %d                                       \n", contas.getNumeroConta());
                System.out.printf("|                                                                              |\n");
                System.out.printf("                                Saldo: %.2f                                     \n", contas.getSaldo());
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
                if (escolha==1){Deposito(contas);}
                if (escolha==2){Saque(contas);}
                if (escolha==3){
                    System.out.printf("Programa Encerrado\n");
                    break;
                }
            }
        }

    protected static void Deposito(Conta2 conta){
        System.out.printf(" ______________________________________________________________________________ \n");
        System.out.printf("/                         Informe o valor do Deposito                          \\ \n");
        System.out.printf("\\-----------------------------------------------------------------------------/\n");
        Scanner scanner = new Scanner(System.in);
        float deposito = conta.getSaldo() + scanner.nextFloat();
        conta.setSaldo(deposito);
        menu(conta);
    }

    protected static void Saque(Conta2 contas){
        System.out.printf(" ______________________________________________________________________________ \n");
        System.out.printf("/                           Informe o valor do Saque                           \\ \n");
        System.out.printf("\\-----------------------------------------------------------------------------/\n");
        Scanner scanner = new Scanner(System.in);
        float valorSaque = contas.getSaldo() - scanner.nextFloat();
        if (valorSaque<0){
            System.out.printf("Valor informado excede o saldo disponivel\n retornando ao Menu\n");
            menu(contas);
        }
        if (valorSaque>0){
            contas.setSaldo(valorSaque);
        }

    }
    }
    class Conta2{
        String nome;
        int numeroConta;
        float saldo=0;

        protected Conta2(String nome, int numeroConta){
            this.nome = nome;
            this.numeroConta = numeroConta;
        }
        protected void setNome(String nome){this.nome=nome;}
        protected void setNumeroConta(int numeroConta){this.numeroConta=numeroConta;}
        protected void setSaldo(float saldo){this.saldo=saldo;}
        protected String getNome(){return nome;}
        protected int getNumeroConta(){return numeroConta;}
        protected float getSaldo(){return saldo;}

    }


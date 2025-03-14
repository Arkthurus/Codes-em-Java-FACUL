public class Ex02 {

    public static void salario(int rank, float horas){
        float salario;
        switch (rank){
            case 1 :
                salario=horas*20.0f;
                System.out.printf("Bem-Vindo Professor Rank FERRO\n");
                System.out.printf("Seu salário é de: R$%.2f\n", salario);
                break;
            case 2 :
                salario=horas*25.0f;
                System.out.printf("Bem-Vindo Professor Rank OURO\n");
                System.out.printf("Seu salário é de: R$%.2f\n", salario);
                break;
            case 3 :
                salario=horas*30.0f;
                System.out.printf("Bem-Vindo Professor Rank DIAMANTE\n");
                System.out.printf("Seu salário é de: R$%.2f\n", salario);
                break;
            default:
                System.out.printf("TA DEMITIDO!!!\n");
        }
    }

    public static void main(String[]args){
        int rank=1;
        float horas=200.0f;
        salario(rank, horas);
    }
}

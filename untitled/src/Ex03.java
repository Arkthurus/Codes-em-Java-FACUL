public class Ex03 {
    public static void main(String[]args){
        int classe=1;
        float kwConsumido=100.0f;
        float valor=Conta(classe, kwConsumido);
        System.out.printf("Tu ta devenu R$%.2f",valor);
    }

    public static float Conta(int classe, float qtdKw){
        float valorTipo[]={
            //pessoa fisica 1[i=0]
            0.6f,
            //comercio 2[i=1]
            0.48f,
            //industria
            1.29f
        };
        return valorTipo[classe-1]*qtdKw;
    }
}

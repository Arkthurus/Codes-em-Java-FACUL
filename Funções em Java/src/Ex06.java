import com.sun.jdi.Value;

public class Ex06 {
    public static void main(String[]args){
        int num1 = 1 , num2 = 2 , num3 = 3;
        int maiorNum=Maior(num1,num2,num3);
        System.out.printf("Maior numero encontrado: %d", maiorNum);
    }
    public static int Maior(int n1, int n2, int n3){
        int maior=Integer.MIN_VALUE;
        int vetMaior[]={n1,n2,n3};
        for (int i = 0; i < vetMaior.length; i++) {
            System.out.printf("Num%d: %d\n", i+1, vetMaior[i]);
            if (vetMaior[i]>maior){maior=vetMaior[i];}
        }
        return maior;
    }
}

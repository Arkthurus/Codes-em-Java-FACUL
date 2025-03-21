import java.util.Scanner;

public class Ex02_Pessoa {
    public static void main(String[] args){
        PessoaStats p1 = new PessoaStats();
        p1.nome = "Thais Carla";
        p1.idade = 26;
        p1.altura = 1.65f;
        p1.peso = 140f;

        PessoaStats p2 = new PessoaStats();
        p2.nome = "Lincoln";
        p2.idade = 21;
        p2.altura = 2.90f;
        p2.peso = 3f;

        p1.Emagrecer();
        p1.Envelhecer();
        p2.Engordar();
        p2.Engordar();
        p2.Emagrecer();
        p2.Envelhecer();

    }
}
class PessoaStats{
    String nome;
    int idade;
    float peso;
    float altura;

    public void Envelhecer(){
        this.idade++;
        System.out.println(this.nome + " envelheceu e agr tem " + this.idade + " anos\n");
        if (this.idade<=21){
            this.altura+=0.01f;
            System.out.println("E agr tem " + this.altura + " de altura\n");
        }
    }
    public void Emagrecer(){
        this.peso-=10f;
        System.out.println(this.nome + " perdeu " + "10Kg " + "e agr tem " + this.peso + "Kg\n");
    }
    public  void Engordar(){
        this.peso+=10f;
        System.out.println(this.nome + " ganhou 10Kg e agr tem " + this.peso + "Kg\n");
    }
}

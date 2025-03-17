public class Exemplo {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        p1.nome = "Arthur";
        p1.idade = 20;

        Pessoa p2 = new Pessoa();
        p2.nome = "Lincoln";
        p2.idade = 21;

        p1.status();
        p1.falar();
        p1.calarBoca();
    }
}

class Pessoa{
    String nome;
    int idade;
    boolean falando = false;
    boolean comendo = false;

    public void status(){
        System.out.printf("Nome: %s\n", this.nome);
        System.out.printf("Idade: %d\n", this.idade);
        System.out.printf("Falando: %b\n", this.falando);
    }

    public void falar(){
        if (this.falando==true){
            System.out.println(this.nome + " ja esta falando\n");
        }
        else {
            this.falando=true;
            System.out.println(this.nome + " esta falando\n");
        }
    }

    public void calarBoca(){
        if (this.falando==false){
            System.out.println(this.nome + " ja esta quieto\n");
        }
        else {
            this.falando=false;
            System.out.println(this.nome + " calou a boca\n");
        }
    }

    public void comer(){
        if (this.falando==true && this.comendo==false){
            this.falando=false;
            this.comendo=true;
            System.out.println(this.nome + " parou de falar para comer\n");
        }
        if (this.falando==false && this.comendo==false){
            this.comendo=true;
            System.out.println(this.nome + "esta comendo\n");
        }
    }

    public void paraComer(){
        this.comendo=false;
        System.out.println(this.nome + " parou de comer");
    }
}


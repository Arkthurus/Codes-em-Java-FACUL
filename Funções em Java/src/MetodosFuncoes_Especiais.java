public class MetodosFuncoes_Especiais {
    public static void main(String[]args){
        Carro c1 = new Carro("Ford Ka", "Vermelho", 2014, 23000, 422657);
    }
}
class Carro{
    private String modelo;
    private String cor;
    private int km;
    private float preco;

    //Constructor(define as variaveis por ordem)
    private int ano;
    public Carro(String modelo, String cor, int ano, int km, float preco){
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.km = km;
        this.preco = preco;
    }

    //Setter(Permitem modifica os valores dos atriutos privados de forma controlada)
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setCor(String cor){
        this.cor = cor;
    }
    public void setAno(int ano){
        this.ano = ano;
    }
    public void setKm(int km){
        this.km = km;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }

    //Getter(Permitem acessar pos valores dos atriutos privados de forma controlada)
    public String getModelo() {
        return modelo;
    }
    public String gerCor(){return cor;}
    public int getAno() {return ano;}
    public int getKm() {return km;}
    public float getPreco() {return preco;}
}
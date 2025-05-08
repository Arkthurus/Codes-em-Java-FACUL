import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Veiculo> frota = new ArrayList<>();
        frota.add(new Carro("Fiat", "Toro", 2020, 30, 10));
        frota.add(new Moto("Suzuki", "Kawazaki", 2015, 60, 20));
        
        MostrarFrota(frota);
        frota.get(0).acelerar();
        frota.get(1).acelerar();
        frota.get(0).frear();
        frota.get(1).frear();
        frota.get(0).CalcAutonomia();
        frota.get(1).CalcAutonomia();
        System.out.println(frota.get(1).PrecisaAbastecer()?frota.get(0).getMarca()+frota.get(0).getModelo()+"Precisa Abastecer" : frota.get(0).getMarca()+frota.get(0).getModelo()+"Não Precisa Abastecer");        
        System.out.println(frota.get(1).PrecisaAbastecer()?frota.get(1).getMarca()+frota.get(1).getModelo()+"Precisa Abastecer" : frota.get(1).getMarca()+frota.get(1).getModelo()+"Não Precisa Abastecer");        
        frota.get(0).Viajar(299);        
        frota.get(1).Viajar(499);
        frota.get(0).MostrarInfo();
        frota.get(1).MostrarInfo();
        frota.remove(0);
        MostrarFrota(frota);
    }
    public static void MostrarFrota(ArrayList<Veiculo> frota){
        System.out.println();
        System.out.println("--------Frota--------");
        for (var veiculo : frota) {
            if (veiculo instanceof Carro) { //istanceof = se o veiculo for do tipo/instancia Carro
                System.out.println("Carro - "+ veiculo.getMarca()+" "+veiculo.getModelo());
                continue;
            }
            System.out.println("Moto - "+ veiculo.getMarca()+" "+veiculo.getModelo());
        }
        System.out.println("---------------------");
    }
}
abstract class Veiculo { //abstract a torna n instanciavel, vira um modelo para as subclasses
    private String marca;
    private String modelo;
    private int anoFabricacao;
    protected double combustivel;
    protected double consumoMedio;
        
        //CONSTRUCTOR
        public Veiculo(String marca, String modelo, int anoFabricacao, double combustivel, double consumoMedio) {
            this.marca = marca;
            this.modelo = modelo;
            this.anoFabricacao = anoFabricacao;
            this.combustivel = combustivel;
            this.consumoMedio = consumoMedio;
        }
        //GETTERS
        public String getMarca() {return marca;}    
        public String getModelo() {return modelo;}
        public int getAnoFabricacao() {return anoFabricacao;} 
        public double getCombustivel() {return combustivel;} 
        public double getConsumoMedio() {return consumoMedio;}
        //SETTERS
        public void setMarca(String marca) {this.marca = marca;}
        public void setModelo(String modelo) {this.modelo = modelo;}
        public void setAnoFabricacao(int anoFabricacao) {this.anoFabricacao = anoFabricacao;}
        public void setCombustivel(double combustivel) {this.combustivel = combustivel;}
        public void setConsumoMedio(double consumoMedio) {this.consumoMedio = consumoMedio;}
    
        public boolean PrecisaAbastecer(){
            return (consumoMedio*combustivel)<30?true:false;
        }
        public void Viajar(float distancia){
            double combustivelDisp=combustivel*consumoMedio;
            double combRest=(combustivelDisp-distancia)/consumoMedio;
            if (combustivelDisp<distancia) {
                System.out.println("Não foi possivel realizar a viagem!");
            }else System.out.println("Viagem realizada com sucesso! Restaram "+combRest+" litros de combustível no veículo!");
            setCombustivel(combRest);        
        }
        public void MostrarInfo(){
            System.out.println();
            System.out.println("---------------------------------------------");
            System.out.println("Veiculo: "+marca+" "+modelo);
            System.out.println("Ano: "+anoFabricacao);
            System.out.println("Autonomia: "+(combustivel*consumoMedio+"Km"));
            System.out.println("Precisa Abastecer? "+ (PrecisaAbastecer() ? "sim" : "não"));
            System.out.println("---------------------------------------------");
        }
        public abstract void CalcAutonomia();
        public abstract void acelerar();
        public abstract void frear();
        
    }
    
class Carro extends Veiculo{
    //CONSTRUCTOR
    public Carro(String marca, String modelo, int anoFabricacao, double combustivel, double consumoMedio) {
        super(marca, modelo, anoFabricacao, combustivel, consumoMedio);
    }
    @Override
    public void CalcAutonomia(){
        double Autonomia=consumoMedio*combustivel;
        System.out.println("O "+getMarca()+getModelo()+ " ainda pode percorrer "+Autonomia+"Km");
    }
    @Override
    public void acelerar(){System.out.println("---------------------------------------------");System.out.println("O "+getMarca()+getModelo()+" está acelerando!");System.out.println("---------------------------------------------");}
    @Override
    public void frear(){System.out.println("---------------------------------------------");System.out.println("O "+getMarca()+getModelo()+" está freando!");System.out.println("---------------------------------------------");}
}
class Moto extends Veiculo{
    //CONSTRUCTOR
    public Moto(String marca, String modelo, int anoFabricacao, double combustivel, double consumoMedio) {
        super(marca, modelo, anoFabricacao, combustivel, consumoMedio);
    }
    @Override
    public void CalcAutonomia(){
        double Autonomia=consumoMedio*combustivel;
    System.out.println("A "+getMarca()+getModelo()+ " ainda pode percorrer "+Autonomia+"Km");
    }
    @Override
    public void acelerar(){System.out.println("---------------------------------------------");System.out.println("A "+getMarca()+getModelo()+" está acelerando!");System.out.println("---------------------------------------------");}
    @Override
    public void frear(){System.out.println("---------------------------------------------");System.out.println("A "+getMarca()+getModelo()+" está freando!");System.out.println("---------------------------------------------");}
}
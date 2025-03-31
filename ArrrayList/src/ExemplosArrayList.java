    import java.util.ArrayList;
    import java.util.Scanner;

    public class ExemplosArrayList {
        /* Criando uma lista de frutas */
        static ArrayList<Fruta> frutas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numeroFrutas=0;

        public static void main(String[] args) {

            ExemplosArrayList exemplo = new ExemplosArrayList();
            Scanner scanner = new Scanner(System.in);

            while(true) {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.printf("[1]Adicionar Fruta\n[2]Buscar Fruta\n[3]Editar QTD Fruta\n[4]Listar Frutas\n[5]Remover fruta\n[6]Status\n[7]Limpar Lista\n[8]Sair\n");
                int escolha = scanner.nextInt();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                if (escolha==1){ exemplo.AdicionarFruta();}
                if (escolha==2){ exemplo.ProcurarFruta();}
                if (escolha==3){ exemplo.AlterarQTD();}
                if (escolha==4){ exemplo.ListarFrutas();}
                if (escolha==5){ exemplo.RemoverFruta();}
                if (escolha==6){
                    if (frutas.isEmpty()){
                        System.out.println("A lista esta vazia\n");
                        try {
                            Thread.sleep(1000);  // Tenta pausar por 1 segundo
                        } catch (InterruptedException e) {
                            // Se ocorrer a exceção, o código dentro deste bloco será executado
                            e.printStackTrace();  // Exibe o erro no console (opcional)
                        }
                    }
                    else{
                        System.out.println("A lista tem "  + frutas.size() + " elemento(s)\n");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (escolha==7){ frutas.clear(); System.out.printf("A lista foi zerada!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (escolha==8){ System.out.printf("Programa finalizado!");break;}
            }
        }
        protected void ProcurarFruta(){
            if(frutas.isEmpty()){System.out.printf("A lista esta vazia!\n");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                boolean encontrouLaranja = false;
                System.out.printf("Digite o nome da fruta a ser buscada: ");
                String nomeFruta = scanner.nextLine();
                for (int i = 0; i < frutas.size(); i++){
                    if (frutas.get(i).getNome().equalsIgnoreCase(nomeFruta)) {
                        encontrouLaranja = true;
                        System.out.printf("%s existe na Lista\n", nomeFruta);
                        break;
                    }
                }
                if (encontrouLaranja==true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (encontrouLaranja==false){
                    System.out.printf("%s não existe na lista\n", nomeFruta);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        protected void AdicionarFruta(){

            if (numeroFrutas==6){
                System.out.printf("A lista esta Cheia!\n");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.printf("Digite o nome da Fruta: ");
                String nome = scanner.nextLine();
                try {
                    Thread.sleep(0250);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.printf("Digite q QTD: ");
                int QTD = scanner.nextInt();
                scanner.nextLine();
                frutas.add(new Fruta(nome, QTD));
                numeroFrutas++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        protected void ListarFrutas(){
            if (frutas.isEmpty()){System.out.printf("A lista esta vazia!\n");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("Elementos da lista:");
                for (int i = 0; i < frutas.size(); i++) {
                    Fruta fruta = frutas.get(i);
                    fruta.mostrarInformacoes();
                }
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        protected void AlterarQTD(){
            if (frutas.isEmpty()){System.out.printf("A lista esta vazia!\n");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.printf("Informe o nome da fruta q tera sua QTD alterada: ");
                String nomeFrutaBusca = scanner.nextLine();
                boolean encontrou = false;
                for (int i = 0; i < frutas.size(); i++) {
                    if (frutas.get(i).getNome().equalsIgnoreCase(nomeFrutaBusca)) {
                        System.out.printf("Informe o novo valor da QTD:");
                        int qtd = scanner.nextInt();
                        frutas.get(i).setQuantidade(qtd);
                        encontrou = true;
                    }
                }
                if (encontrou==true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (encontrou==false){
                    System.out.printf("%s n foi encontrada na lista!\n", nomeFrutaBusca);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        protected void RemoverFruta(){
            if(frutas.isEmpty()){System.out.printf("A lista esta vazia!\n");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.printf("Informe o nome da fruta q sera excluida: ");
                String nomeFrutaEx = scanner.nextLine();
                boolean encontrou = false;
                for (int i = 0; i < frutas.size(); i++){
                    if (frutas.get(i).getNome().equalsIgnoreCase(nomeFrutaEx)){
                        frutas.remove(i);
                        encontrou = true;
                    }
                }
                if (encontrou==true){
                    try {
                        System.out.printf("Fruta excluida da lista!\n");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (encontrou==false){
                    System.out.printf("%s n foi encontrada na lista!\n", nomeFrutaEx);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



    class Fruta{
        private String nome;
        private int quantidade;

        Scanner scanner = new Scanner(System.in);

        public Fruta(String nome, int quantidade){
            this.nome = nome;
            this.quantidade = quantidade;
        }

        public void setNome(String nome){
            this.nome = nome;
        }

        public String getNome(){
            return nome;
        }

        public void setQuantidade(int quantidade){
            this.quantidade = quantidade;
        }

        public int getQuantidade(){
            return quantidade;
        }

        public void mostrarInformacoes(){
            System.out.println("Nome: " + nome + " / Quantidade: " + quantidade);
        }
    }


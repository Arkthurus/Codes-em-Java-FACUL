public class ErrorTreatments {
    public static void main(String[] args) {
        try {
            USER u1 = new USER("Arthu", 100, "ArthurGamil.com");
            System.out.println("User cadastrado com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("Erros:");
            System.out.println(e.getMessage());
        }
    }
}
class USER{
    public String nome;
    public int idade;
    public String email;

    //CONSTRUCTOR
    public USER(String nome, int idade, String email){

        StringBuilder errors = new StringBuilder();

        if (idade<18||idade>99) {errors.append("Erro: a idade deve ser maior que 18 e menor que 99!\n");}
        
        if (!email.contains("@")) {errors.append("Erro: o Email deve conter '@'\n");}

        if (errors.length()>0) {
            throw new IllegalArgumentException(errors.toString());
        }

        this.nome=nome;
        this.idade=idade;
        this.email=email;
    }
}


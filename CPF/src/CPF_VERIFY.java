public class CPF_VERIFY {
    public static void main(String[] args) throws Exception {
        String  CPF   = "22233366638";
        int     soma  = 0;
        int     mod   = 10;
        boolean igual = true;
        
        for (int i = 0; i < CPF.length()-2; i++) {
            if (CPF.charAt(i)!=CPF.charAt(i+1)) {
                igual=false;
            }else igual =  true;
            soma += (CPF.charAt(i) - 48)*mod;
            mod--;
            System.out.println(soma);
        }

        int digito1 = (11-(soma%11)) > 9? 0 : 11-(soma%11);
        
        if (igual) {System.out.println("O CPF é invalido, Caracteres iguais");}
        else if(digito1==CPF.charAt(9)-48) {
            mod   = 11;
            int soma2 =  0;
            int FirstVerify = 11-(soma%11);
            for (int i = 0; i < CPF.length()-1; i++) {
                soma2 += (CPF.charAt(i) - 48)*mod;
                mod--;
                System.out.println(soma2);
            }
            int digito2 = (11-(soma2%11)) > 9? 0 : 11-(soma2%11);
            if (digito2==CPF.charAt(10)-48) {System.out.println("O CPF é valido!");}else System.out.println("O CPF é invalido, Segundo digito invalido!");
        }else System.out.println("O CPF é invalido, Primeiro digito invalido!");
    }
}

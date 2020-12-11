package backend;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Autenticacao {

    private static boolean autenticar;

    // método criptografa senha + email (email é utilizado com "sal", fator que dificulta a quebra da seguranca) 
    //do usuário para ser salva em arquivo com mais segurança.
    //uso de função hash SHA-256
    public static String encriptarSenha(String email, String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        senha = email+senha;
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
        
        //System.out.println(messageDigest);

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhaHexa = hexString.toString();

        //System.out.println(senhaHexa);

        return senhaHexa;
    }

    //método utilizado para fazer login no sistema.
    //este método criptografa a senha fornecida pelo usuário e a 
    //compara com a senha salva em arquivo que deve ser passada como parâmetro deste método
    public static boolean autenticar(String email, String senha, String senhaArquivo)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        boolean autenticado = false;
        String senhaCriptografada = encriptarSenha(email, senha);
        if(senhaCriptografada.equals(senhaArquivo)){ //modificar para pegar senha do arquivo
            autenticado = true;
        }
        return autenticado;
    }

    //main utilizada apenas para fins de teste
    // public static void main(String[] args) {
    //     try {
    //         encriptarSenha("valesca", "123");
    //     } catch (NoSuchAlgorithmException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     } catch (UnsupportedEncodingException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    //     try {
    //         autenticar = autenticar("valesca", "123", "182734");
    //         System.out.println("Autenticado: "+ autenticar);
    //     } catch (NoSuchAlgorithmException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     } catch (UnsupportedEncodingException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    // }
}

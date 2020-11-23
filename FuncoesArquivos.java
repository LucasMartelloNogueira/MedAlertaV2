import java.io.*;
import java.util.Scanner;

public class FuncoesArquivos {

    public static void criarArquivo(String nomeArquivo){
        try{
            File arquivo = new File(nomeArquivo);
            if (arquivo.createNewFile()){
                System.out.println("arquivo criado: " + arquivo.getName());
            }
            else{
                System.out.println("arquivo ja existe!");
            }
        }
        catch (IOException e){
            System.out.println("Erro: ");
            e.printStackTrace();
        }
    }

    public static void escreverArquivo(String nomeArquivo, String linha){
        try{
            FileWriter escritorArquivo = new FileWriter(nomeArquivo);
            escritorArquivo.write(linha);
            escritorArquivo.close();
        }
        catch (IOException e){
            System.out.println("Erro: ");
            e.printStackTrace();
        }
    }

    public static void lerArquivo(String nomeArquivo){
        try{
            File arquivo = new File(nomeArquivo);
            Scanner leitorArquivo = new Scanner(arquivo);
            while (leitorArquivo.hasNextLine()){
                String linha = leitorArquivo.nextLine();
                System.out.println(linha);
            }
            leitorArquivo.close();
        }
        catch (IOException e){
            System.out.println("Erro: ");
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) throws FileNotFoundException{
        String linhaTeste = "Lucas,22,homem\n";
        String[] linha = linhaTeste.split(",");
        for (String info : linha){
            System.out.println("info: " + info);
        }
    }
}

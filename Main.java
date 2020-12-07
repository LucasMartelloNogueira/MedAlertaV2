import java.util.ArrayList;

import backend.Agenda;
import backend.Endereco;
import backend.Gerenciador;
import backend.Pessoa;
import backend.usuario.PessoaFisica;
import frontend.Inicio;

public class Main {
    public static void main(String[] args) {
        //criar thread para tela principal
        //criar thread para gerenciador

        Inicio telaInicial = new Inicio();
        Thread interfaceComUsuario = new Thread(telaInicial);
        interfaceComUsuario.start();

        Gerenciador g = new Gerenciador();
        Thread gerenciador = new Thread(g);
        gerenciador.start();

        //linhas de teste
        // Agenda agenda = new Agenda();
        // agenda.adicionarContato(new PessoaFisica("João", "12345678", "joao@teste.com", new Endereco("Rua 1", "1")));
        // agenda.adicionarContato(new PessoaFisica("Ana", "12345678", "joao@teste.com", new Endereco("Rua 1", "1")));
        // agenda.adicionarContato(new PessoaFisica("Larissa", "12345678", "joao@teste.com", new Endereco("Rua 1", "1")));
        // agenda.adicionarContato(new PessoaFisica("Yan", "12345678", "joao@teste.com", new Endereco("Rua 1", "1")));
        // ArrayList<Pessoa> a = agenda.getContatos();
        // System.out.println("Teste de ordenação dos contatos");
        // for(Pessoa pessoa: a){
        //     System.out.println(pessoa.getNome());
        // }
    }
}

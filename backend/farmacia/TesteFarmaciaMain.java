package backend.farmacia;

import java.lang.reflect.Field;
import java.util.ArrayList;

import backend.Endereco;
import backend.FuncoesArquivos;
import backend.Medicamento;
import backend.Pessoa;
import backend.usuario.PessoaFisica;
import backend.Agenda;
import backend.Contactavel;

import java.io.*;

public class TesteFarmaciaMain {
    
    public static void main(String[] args) {

        // TESTANDO SALVAR FARMACIAS E USUARIOS EM ARQUIVOS
        PessoaJuridica farmacia1 = new PessoaJuridica("Raia", "tel123", "raia@gmail.com", "senha1");
        farmacia1.setCnpj("cnpj123", false);

        Endereco enderecoFarmacia = new Endereco("joao pessoa", "18");
        farmacia1.setEndereco(enderecoFarmacia, false);

        Endereco enderecoLucas = new Endereco("Jao Pessoa", "95");
        PessoaFisica pessoaFisica1 = new PessoaFisica("Lucas", "123", "lucas@gmail.com", "senha2", enderecoLucas);

        Endereco enderecoLeo = new Endereco("Herotides", "70");
        PessoaFisica pessoaFisica2 = new PessoaFisica("Leo", "456", "leo@gmail.com", "senha3", enderecoLeo);

        Agenda agendaFarmacia = new Agenda();
        agendaFarmacia.adicionarContato(pessoaFisica1);
        agendaFarmacia.adicionarContato(pessoaFisica2);
        farmacia1.setContatosClientes(agendaFarmacia, false);
        farmacia1.salvarDadosArquivo();

        pessoaFisica1.addFarmaciaAosContatos(farmacia1);
        pessoaFisica1.salvarDadosArquivo();

        pessoaFisica2.addFarmaciaAosContatos(farmacia1);
        pessoaFisica2.salvarDadosArquivo();


        // TESTANDO RESGATAR AS FARMACIAS E USUARIOS DOS ARQUIVOS
        // PessoaJuridica farmacia1 = PessoaJuridica.resgatarFarmaciaArquivo("Raia", "senha1", false, false);
        // for (Pessoa usuario : farmacia1.getContatosClientes().getContatos()){
        //     System.out.println("nome: " + usuario.getNome());
        //     System.out.println("endereco: " + usuario.getNome());
        //     System.out.println("-------------------------");
        // }


        // TESTANDO MODIFICAR OS ARQUIVOS DA FARMACIA
        // PessoaJuridica farmacia1 = PessoaJuridica.resgatarFarmaciaArquivo("Raia", "senha1", false, false);
        // farmacia1.setCnpj("cnpj999", true);


        // TESTANDO A CRIACAO DO ESTOQUE E GRAVANDO NO ARQUIVO
        // PessoaJuridica farmacia1 = PessoaJuridica.resgatarFarmaciaArquivo("Raia", "senha1", false, false);
        // Estoque estoque1 = new Estoque();

        // Medicamento medicamento1 = new Medicamento("dorflex", "comprimido", "nenhuma");
        // ItemEstoque itemEstoque1 = new ItemEstoque(medicamento1, 10);

        // Medicamento medicamento2 = new Medicamento("repoflor", "comprimido", "nenhuma");
        // ItemEstoque itemEstoque2 = new ItemEstoque(medicamento2, 20);

        // estoque1.addMedicamentoEstoque(itemEstoque1);
        // estoque1.addMedicamentoEstoque(itemEstoque2);

        // farmacia1.setSenha("senhaGenerica");
        // farmacia1.setEstoque(estoque1, true);
        // farmacia1.salvarDadosArquivo();


        // TESTANDO RESGATAR A FARMACIA DO ARQUIVO COM ESTOQUE                
        // PessoaJuridica farmacia1 = PessoaJuridica.resgatarFarmaciaArquivo("Raia", "senhaGenerica", false, false);
        // farmacia1.getEstoque().printEstoque();
        

        // TESTANDO RESGATAR O ESTOQUE, EFETURAR MUDANÇAS NELE E VER SE FOI ATUALIZADO NO ARQUIVO
        // PessoaJuridica farmacia1 = PessoaJuridica.resgatarFarmaciaArquivo("Raia", "senhaGenerica", false, false);
        // farmacia1.adicionarMedicamentoEstoque("repoflor", 10);
        // farmacia1.atualizarQntMedicamentoEstoque("Diosmin", 1000);
        
    }
}

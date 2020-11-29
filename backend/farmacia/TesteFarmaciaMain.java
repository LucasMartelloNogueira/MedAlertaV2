package backend.farmacia;

import java.lang.reflect.Field;
import java.util.ArrayList;

import backend.Endereco;
import backend.FuncoesArquivos;
import backend.Medicamento;
import backend.Pessoa;
import backend.usuario.PessoaFisica;
import backend.Agenda;

import java.io.*;

public class TesteFarmaciaMain {
    
    public static void main(String[] args) {

        // TESTE PARA RESGATAR INFO DE FARMACIAS DO ARQUIVO
        // PessoaJuridica farmacia = PessoaJuridica.resgatarFarmaciaArquivo("Raia");
        // System.out.println("CONTATOS: ");
        // for (Pessoa contato : farmacia.getContatosClientes().getContatos()){
        //     System.out.println("nome: " + contato.getNome());
        // }
        
        // TESTE PARA RESGATAR USUARIOS DO ARQUIVO
        // PessoaFisica pessoaFisica = PessoaFisica.resgatarUsuarioArquivo("Lucas", false);
        // System.out.println("nome: " + pessoaFisica.getNome() + "/ telefone: " + pessoaFisica.getTelefone());
        // System.out.println("FARMACIAS:");
        // for (Pessoa farmacia : pessoaFisica.getContatosFarmacias().getContatos()){
        //     System.out.println("nome: " + farmacia.getNome());
        //     System.out.println("---------------");
        // }

        // PessoaJuridica farmacia = PessoaJuridica.resgatarFarmaciaArquivo("Raia", false);
        // System.out.println("nome: " + farmacia.getNome() + "/ cnpj: " + farmacia.getCnpj());
        // System.out.println("CONTATOS");
        // for (Pessoa contato : farmacia.getContatosClientes().getContatos()){
        //     System.out.println("nome: " + contato.getNome());
        //     System.out.println("---------------");
        // }

        // PessoaJuridica farmacia = new PessoaJuridica("Raia", "123", "bla@gmail.com");
        // farmacia.setCnpj("182");

        // Estoque estoqueTeste = new Estoque();

        // Medicamento medicamento1 = new Medicamento("dorflex", "bla", "bla");
        // estoqueTeste.addMedicamentoEstoque(medicamento1, 2);

        // Medicamento medicamento2 = new Medicamento("azitromicina", "bla2", "bla2");
        // estoqueTeste.addMedicamentoEstoque(medicamento2, 5);

        // farmacia.setEstoque(estoqueTeste);
        // farmacia.salvarEstoqueArquivo();
        
        // String nomeArquivoEstoque = farmacia.getNomeArquivoEstoque();
        // Estoque estoque = PessoaJuridica.resgatarEstoqueArquivo(nomeArquivoEstoque);
        // farmacia.setEstoque(estoque);
        // farmacia.getEstoque().printEstoque();

        // String nullString6 = FuncoesArquivos.obterStringDeNullsCsv(6);
        // System.out.println(nullString6);

        
        // Endereco endereco1 = new Endereco("jao pessoa", "95");
        // PessoaFisica pessoaFisica1 = new PessoaFisica("Lucas", "123", "lucas@email.com", endereco1);
        // pessoaFisica1.salvarDadosArquivo();

        // for (String s : listaTeste){
        //     System.out.println("elemento: " + s);
        // }

        // Endereco endereco2 = new Endereco("bla bla", "90");
        // PessoaFisica pessoaFisica2 = new PessoaFisica("Leo", "456", "leo@email.com", endereco2);

        // farmacia.addUsuarioAosContatos(pessoaFisica1);
        // farmacia.addUsuarioAosContatos(pessoaFisica2);
        // farmacia.salvarDadosArquivo();

        // pessoaFisica1.addFarmaciaAosContatos(farmacia);
        // pessoaFisica1.salvarDadosArquivo();

        // pessoaFisica2.addFarmaciaAosContatos(farmacia);
        // pessoaFisica2.salvarDadosArquivo();

        // Endereco endereco3 = new Endereco("rua sg", "70");
        // PessoaFisica pessoaFisica3 = new PessoaFisica("Valesca", "789", "Valesca@email.com", endereco3);

        // String[] listaTeste = pessoaFisica1.toString().split(",");

        // for (String s : listaTeste){
        //     System.out.println("elemento: " + s);
        // }

        // Agenda agenda = new Agenda();
        // agenda.adicionarContato(pessoaFisica1);
        // agenda.adicionarContato(pessoaFisica2);

        // farmacia.setContatosClientes(agenda);

        // farmacia.setCnpj("aaaaaaa");
        // Endereco endereco = new Endereco("jao Pessoa", "95");
        // farmacia.setEndereco(endereco);

        // String f = farmacia.toString();
        // System.out.println("string farmaica csv: " + f);
        // farmacia.salvarDadosArquivo();
        // Field[] atributos = farmacia.getClass().getDeclaredFields();
        // System.out.println("qnt de atributos: " + atributos.length);

        // for (Field f : atributos){
        //     System.out.println("nome atributo: " + f.getName() + " / mod: " + f.getModifiers());
            // System.out.println(f);
        
        // String f = farmacia.toString();
        // System.out.println(f);

        // PessoaFisica usuario = PessoaFisica.resgatarUsuarioArquivo("Lucas");
        // System.out.println("telefone: " + usuario.getTelefone());
        // System.out.println("email: " + usuario.getEmail());
        // System.out.println("endereco: " + usuario.getEndereco().getNomeDaRua() + ", " + usuario.getEndereco().getNumero());
    }
}

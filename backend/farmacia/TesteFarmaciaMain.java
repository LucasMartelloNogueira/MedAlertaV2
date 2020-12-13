package backend.farmacia;

import java.lang.reflect.Field;
import java.util.ArrayList;

import backend.Endereco;
import backend.FuncoesArquivos;
import backend.Medicamento;
import backend.Pessoa;
import backend.usuario.PessoaFisica;
import backend.usuario.Uso;
import backend.Agenda;
import backend.usuario.Medico;

import java.io.*;

public class TesteFarmaciaMain {
    
    public static void main(String[] args) {


        // TESTE SALVAR USER
        // Endereco endereco = new Endereco("joao pessoa", "95");
        // PessoaFisica pessoa = new PessoaFisica("Lucas", "2710", "lucas@gmail.com", "123", "123", endereco);
        // pessoa.salvarDadosArquivo();

        // TESTE RESGATAR USER
        // PessoaFisica pessoaFisica = PessoaFisica.resgatarUsuarioArquivo("lucas@gmail.com", "123", false, false);
        // for (Pessoa medico : pessoaFisica.getContatosMedicos().getContatos()){
        //     System.out.println("nome: " + medico.getNome());
        // }

        // for (Pessoa farmacia : pessoaFisica.getContatosFarmacias().getContatos()){
        //     System.out.println("nome: " + farmacia.getNome());
        // }
        // System.out.println("nome: " + pessoaFisica.getNome());

        // Medico medico = new Medico("medico", "123", "medico@gmail.com", "123", "drogas");
        // medico.salvarDadosArquivo();
        // pessoaFisica.adicionarContatoMedico(medico);

        // Endereco endereco = new Endereco("joao pessoa", "95");
        // PessoaJuridica farmacia = new PessoaJuridica("raia", "123", "raia@gmail.com", "123", "123", endereco);
        // farmacia.salvarDadosArquivo();
        // pessoaFisica.addFarmaciaAosContatos(farmacia);

    }
}

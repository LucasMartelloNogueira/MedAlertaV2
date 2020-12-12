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

        // TESTANDO SALVAR FARMACIAS E USUARIOS EM ARQUIVOS
        // PessoaJuridica farmacia1 = new PessoaJuridica("Raia", "tel123", "raia@gmail.com", "senha1");
        // farmacia1.setCnpj("cnpj123", false);

        // Endereco enderecoFarmacia = new Endereco("joao pessoa", "18");
        // farmacia1.setEndereco(enderecoFarmacia, false);

        // Endereco enderecoLucas = new Endereco("Jao Pessoa", "95");
        // PessoaFisica pessoaFisica1 = new PessoaFisica("Lucas", "123", "lucas@gmail.com", "cpf1", "senha2", enderecoLucas);

        // Endereco enderecoLeo = new Endereco("Herotides", "70");
        // PessoaFisica pessoaFisica2 = new PessoaFisica("Leo", "456", "leo@gmail.com", "cpf2", "senha3", enderecoLeo);

        // Agenda agendaFarmacia = new Agenda();
        // agendaFarmacia.adicionarContato(pessoaFisica1);
        // agendaFarmacia.adicionarContato(pessoaFisica2);
        // farmacia1.setContatosClientes(agendaFarmacia, false);
        // farmacia1.salvarDadosArquivo();

        // pessoaFisica1.addFarmaciaAosContatos(farmacia1);
        // pessoaFisica1.salvarDadosArquivo();

        // pessoaFisica2.addFarmaciaAosContatos(farmacia1);
        // pessoaFisica2.salvarDadosArquivo();


        // TESTANDO RESGATAR AS FARMACIAS E USUARIOS DOS ARQUIVOS
        // PessoaJuridica farmacia1 = PessoaJuridica.resgatarFarmaciaArquivo("raia@gmail.com", "senha1", false, false);
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

        // farmacia1.setEstoque(estoque1, true);
        // farmacia1.salvarDadosArquivo();


        // TESTANDO RESGATAR A FARMACIA DO ARQUIVO COM ESTOQUE                
        // PessoaJuridica farmacia1 = PessoaJuridica.resgatarFarmaciaArquivo("Raia", "senha1", false, false);
        // // System.out.println(farmacia1.getEstoque());
        // farmacia1.getEstoque().printEstoque();
        

        // TESTANDO RESGATAR O ESTOQUE, EFETURAR MUDANÇAS NELE E VER SE FOI ATUALIZADO NO ARQUIVO
        // PessoaJuridica farmacia1 = PessoaJuridica.resgatarFarmaciaArquivo("Raia", "senha1", false, false);
        // farmacia1.adicionarMedicamentoEstoque("betaserc", 10);
        // farmacia1.atualizarQntMedicamentoEstoque("repoflor", 1000);
        

        // TESTANDO A CRIAÇÃO DE USUÁRIOS
        // Endereco enderecoLucas = new Endereco("Jao Pessoa", "95");
        // PessoaFisica pessoaFisica1 = new PessoaFisica("Lucas", "123", "lucas@gmail.com", "cpf1", "senha2", enderecoLucas);

        // Endereco enderecoLeo = new Endereco("Herotides", "70");
        // PessoaFisica pessoaFisica2 = new PessoaFisica("Leo", "456", "leo@gmail.com", "cpf2", "senha3", enderecoLeo);

        // pessoaFisica1.salvarDadosArquivo();
        // pessoaFisica2.salvarDadosArquivo();

        // TESTANDO RECUPERAR OS USUARIOS DO ARQUIVO
        // PessoaFisica pessoaFisica1 = PessoaFisica.resgatarUsuarioArquivo("lucas@gmail.com", "senha2", false, false);
        // System.out.println("nome: " + pessoaFisica1.getNome());
        // System.out.println("cpf: " + pessoaFisica1.getCpf());

        
        // TESTANDO CRIAR UMA LISTA DE USOS E SALVAR NO ARQUIVO
        // Endereco enderecoLucas = new Endereco("Jao Pessoa", "95");
        // PessoaFisica pessoaFisica1 = new PessoaFisica("Lucas", "123", "lucas@gmail.com", "cpf1", "senha2", enderecoLucas);
        
        // ArrayList<String> horarios1 = new ArrayList<>();
        // horarios1.add("8 hrs");
        // horarios1.add("16 hrs");
        // Medicamento remedio1 = new Medicamento("dorflex");
        // Uso uso1 = new Uso(remedio1, 2, horarios1, 10, 5);
        // pessoaFisica1.adicionarUsoNaListaUsoMedicamentos(uso1);

        // ArrayList<String> horarios2 = new ArrayList<>();
        // horarios2.add("8 hrs");
        // horarios2.add("16 hrs");
        // Medicamento remedio2 = new Medicamento("Rivotril");
        // Uso uso2 = new Uso(remedio2, 2, horarios2, 10, 5);
        // pessoaFisica1.adicionarUsoNaListaUsoMedicamentos(uso2);

        // pessoaFisica1.salvarArquivoUsos();
        // pessoaFisica1.salvarDadosArquivo();


        // TESTANDO RESGATAR O ARQUIVO DE USOS DE MEDICAMENTOS
        // PessoaFisica pessoaFisica1 = PessoaFisica.resgatarUsuarioArquivo("Lucas", "senha2", false, false);
        // for (Uso uso : pessoaFisica1.getListaUsoMedicamentos()){
        //     System.out.println("remedio: " + uso.getRemedio().getNome() + " / qnt disponivel: " + uso.getQtdDisponivel());
        //     System.out.println("------------");
        // }

        
        // TESTANDO MUDAR OS ARQUIVOS DE USOS DO USUARIOS
        // PessoaFisica pessoaFisica1 = PessoaFisica.resgatarUsuarioArquivo("Lucas", "senha2", false, false);
        // ArrayList<String> horarios2 = new ArrayList<>();
        // horarios2.add("8 hrs");
        // horarios2.add("16 hrs");
        // Medicamento remedio2 = new Medicamento("Melatoina");
        // Uso uso2 = new Uso(remedio2, 2, horarios2, 10, 420);
        // pessoaFisica1.adicionarUsoNaListaUsoMedicamentos(uso2);
        // pessoaFisica1.removerUsoNaListaUsoMedicamentos("dorflex");
        // pessoaFisica1.atualizarQntRemediosListaUsoMedicamentos("Rivotril", 999);

        // TESTE MEDICO ARQUIVO
        // Medico medico1 = new Medico("dr Reid", "2710", "reid@gmail.com", "senhaMedico", "cardiologista");
        // medico1.salvarDadosArquivo();


        // TESTE RESGATAR MEDICO ARQUIVO
        // Medico medico1 = Medico.resgatarMedicoArquivo("dr Reid", "senhaMedico", false);
        // System.out.println("especialidade: " + medico1.getEspecialidade());

        // Medicamento medicamento = new Medicamento("dorflex");
        // System.out.println("preco: " + medicamento.getPreco());
        
        // TESTE PARA ALTERAR LISTA DE CONTATOS MEDICOS

        // Endereco enderecoLucas = new Endereco("Jao Pessoa", "95");
        // PessoaFisica pessoaFisica1 = new PessoaFisica("Lucas", "123", "lucas@gmail.com", "cpf1", "senha2", enderecoLucas);
        // Medico medico1 = new Medico("dr Reid", "2710", "reid@gmail.com", "senhaMedico", "cardiologista");

        // Agenda contatosMedicos = new Agenda();
        // contatosMedicos.adicionarContato(medico1);
        // pessoaFisica1.setContatosMedicos(contatosMedicos);
        // pessoaFisica1.salvarDadosArquivo();
        // medico1.salvarDadosArquivo();

        // RESGATANDO USUARIO E FAZENDO ALTERACAO NOS CONTATOS

        PessoaFisica pessoaFisica1 = PessoaFisica.resgatarUsuarioArquivo("lucas@gmail.com", "senha2", false, false);
        System.out.println("nome: " + pessoaFisica1.getNome());
        // Agenda agendaTemp = pessoaFisica1.getContatosMedicos();
        // agendaTemp.removerContato("dr Reid");
        // pessoaFisica1.setContatosMedicos(agendaTemp);
        // pessoaFisica1.salvarDadosArquivo();
    }
}

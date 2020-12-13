package backend.gerenciamento;

import java.util.ArrayList;

import backend.FuncoesArquivos;
import backend.usuario.PessoaFisica;
import backend.usuario.Uso;

public class Gerenciador implements Runnable {
    private static ArrayList<Uso> listaDeUsos = new ArrayList<Uso>();
    private static PessoaFisica pessoa;

    public static void setPessoa(PessoaFisica p) {
        Gerenciador.pessoa = p;
    }

    private static void atualizarUso(String nomeMedicamento) {
        int novaQtdDisponivel = pessoa.getUsoListaUsoMedicamentos(nomeMedicamento).getQtdDisponivel() - 1;
        pessoa.atualizarQntRemediosListaUsoMedicamentos(nomeMedicamento, novaQtdDisponivel);
    }

    private static int verificarIntervaloDoGerenciador() {
        int menor = 24;
        if (listaDeUsos != null) {
            for (Uso uso : listaDeUsos) {
                if (uso.getIntervalo() < menor) {
                    menor = uso.getIntervalo();
                }
            }
        }
        return menor;
    }

    private static void enviarNotificacao(String notificacao, Uso uso) {
        Runnable runNotify = () -> {
            boolean tomouRemedio = Notificacao.notificar(notificacao);
            if (tomouRemedio) {
                atualizarUso(uso.getRemedio().getNome());
            }
        };
        Thread threadNotify = new Thread(runNotify);
        threadNotify.start();
    }

    private static void enviarNotificacaoCompra(Uso uso) {
        String notificacao = "Existem apenas "+uso.getQtdDisponivel()+" comprimidos do seu remédio "+uso.getRemedio().getNome()+"\n"+
        "É nessário comprar mais para terminar seu tratamento!";
        
        Runnable runNotify = () -> {
            boolean tomouRemedio = Notificacao.notificar(notificacao);
            if (tomouRemedio) {
                atualizarUso(uso.getRemedio().getNome());
            }
        };
        Thread threadNotify = new Thread(runNotify);
        threadNotify.start();
    }

    private static boolean verificarQtdRemedio(Uso uso) {
        boolean remedioAcabando = false;
        int qtd = uso.getQtdDisponivel();
        int duracao = uso.getDuracaoDoTratamento();
        int qtdAoDia = uso.getHorariosDeUso().size();
        int qtdNecessaria = duracao*qtdAoDia;

        if(qtdNecessaria > qtd){
            remedioAcabando = true;
        }
        return remedioAcabando;
    }

    private static void atualizarDuracaoDeUso(Uso uso) {
        uso.setDuracaoDoTratamento(uso.getDuracaoDoTratamento()-1);
        String strUso = uso.toString();
        FuncoesArquivos.alterarLinhaArquivo("Uso"+pessoa.getCpf()+".txt", uso.getRemedio().getNome(), strUso);
    }

    @Override
    public void run() {
        // lê usos do arquivo do usuário
        //listaDeUsos = (ArrayList<Uso>) PessoaFisica.resgatarListaUsoMedicamentosArquivo(pessoa.getNomeArquivoUsos());
        // if (listaDeUsos == null) {
        //     Thread.interrupted();
        // }
 
        // calcula todos os horários de cada um dos usos
        // for (Uso uso : listaDeUsos) {
        //     uso.calcularHorariosDeUso();
        // }
        System.out.println(pessoa.getNome());

        while (true) {
            listaDeUsos = (ArrayList<Uso>) PessoaFisica.resgatarListaUsoMedicamentosArquivo(pessoa.getNomeArquivoUsos());
            for (Uso uso : listaDeUsos) {
                uso.calcularHorariosDeUso();
                System.out.println(uso.getRemedio().getNome()+" "+ pessoa.getNome());
            }

            //enviar notificacao para tomar o medicamento na hora correta
            for (Uso uso : listaDeUsos) {
                for (Integer horario : uso.getHorariosDeUso()) {
                    if (Data.horaDoRemedio(uso,horario)) {
                        enviarNotificacao("Nome do remédio:" + uso.getRemedio().getNome() + "\nEspecificações:"
                                + uso.getRemedio().getEspecificacoes() + "\nCondições de uso: "
                                + uso.getRemedio().getCondicoesDeUso() + "\nDose: 1 comprimido\n"
                                + "Você tomou o remédio às " + horario
                                + " horas?\n Se sim, clique em SIM para confirmar. Clique em NÂO, caso contrário.",
                                uso);
                    }
                }
            }

            //enviar notificacao para comprar remedios caso não seja suficiente para o término do tratamento
            for (Uso uso : listaDeUsos) {
                if (verificarQtdRemedio(uso)) {
                    enviarNotificacaoCompra(uso);
                }  
            }

            //diminui um dia na duracao de uso a cada virada de dia
            if(Data.ehMeiaNoite()){
                for (Uso uso : listaDeUsos) {
                    atualizarDuracaoDeUso(uso);  
                } 
            }
            
            //gerenciador dorme 
            int menorIntervalo = verificarIntervaloDoGerenciador();
            //long dormir = menorIntervalo * 3600000;
            long dormir = 59000;
            try {
                Thread.sleep(dormir);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }  
        }
    }
}

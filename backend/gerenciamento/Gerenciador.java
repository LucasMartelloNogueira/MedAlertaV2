package backend.gerenciamento;

import java.util.ArrayList;

import backend.usuario.PessoaFisica;
import backend.usuario.Uso;

public class Gerenciador implements Runnable {
    private static ArrayList<Uso> listaDeUsos = new ArrayList<Uso>();
    private static PessoaFisica pessoa;
    private static boolean emEspera = true; // aguardando login ser feito no frontend

    public static void setFimDaEspera(boolean espera, PessoaFisica p) {
        Gerenciador.emEspera = espera;
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

    public static void enviarNotificacao(String notificacao, Uso uso) {
        Runnable runNotify = () -> {
            boolean tomouRemedio = Notificacao.notificar(notificacao);
            if (tomouRemedio) {
                atualizarUso(uso.getRemedio().getNome());
            }
        };
        Thread threadNotify = new Thread(runNotify);
        threadNotify.start();
    }

    @Override
    public void run() {
        while (emEspera) {
            try {
                Thread.sleep(10000); // dorme por 10 segundos
                System.out.println("Gerenciador do sistema em espera...");
            } catch (InterruptedException e) {
                //
            }
        }

        // lê usos do arquivo do usuário
        listaDeUsos = (ArrayList<Uso>) PessoaFisica.resgatarListaUsoMedicamentosArquivo(pessoa.getNomeArquivoUsos());
        if (listaDeUsos == null) {
            Thread.interrupted();
        }

        // calcula todos os horários de cada um dos usos
        for (Uso uso : listaDeUsos) {
            uso.calcularHorariosDeUso();
        }

        while (true) {
            for (Uso uso : listaDeUsos) {
                for (Integer horario : uso.getHorariosDeUso()) {
                    if (Data.horaDoRemedio()) {
                        enviarNotificacao("Nome do remédio:" + uso.getRemedio().getNome() + "\nEspecificações:"
                                + uso.getRemedio().getEspecificacoes() + "\nCondições de uso: "
                                + uso.getRemedio().getCondicoesDeUso() + "\nDose: 1 comprimido\n"
                                + "Você tomou o remédio às " + horario
                                + " horas?\n Se sim, clique em SIM para confirmar. Clique em NÂO, caso contrário.",
                                uso);
                    }
                }
            }

            for (Uso uso : listaDeUsos) {
                for (Integer horario : uso.getHorariosDeUso()) {
                    if (Data.horaDoRemedio()) {
                        enviarNotificacao("Nome do remédio:" + uso.getRemedio().getNome() + "\nEspecificações:"
                                + uso.getRemedio().getEspecificacoes() + "\nCondições de uso: "
                                + uso.getRemedio().getCondicoesDeUso() + "\nDose: 1 comprimido\n"
                                + "VOcê tomou o remédio às " + horario
                                + " horas?\n Se sim, clique em SIM para confirmar. Clique em NÂO, caso contrário.",
                                uso);
                    }
                }
            }

            int menorIntervalo = verificarIntervaloDoGerenciador();
            long dormir = menorIntervalo * 3600000;
            try {
                Thread.sleep(dormir);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }  
        }
    }
}

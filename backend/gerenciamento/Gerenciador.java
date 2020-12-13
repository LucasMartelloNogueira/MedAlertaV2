package backend.gerenciamento;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import backend.FuncoesArquivos;
import backend.usuario.PessoaFisica;
import backend.usuario.Uso;

public class Gerenciador implements Runnable {
    private static ArrayList<Uso> listaDeUsos = new ArrayList<Uso>();
    private static PessoaFisica pessoa;

    public static void setPessoa(PessoaFisica p) {
        Gerenciador.pessoa = p;
    }

    private static void atualizarUso(String nomeMedicamento, int dose, int qtd) {
        int novaQtdDisponivel = 0;
        System.out.println(pessoa.getUsoListaUsoMedicamentos(nomeMedicamento));
        novaQtdDisponivel = qtd - dose;
        System.out.println(pessoa);
        File arquivoEstoque = new File(pessoa.getNomeArquivoUsos());
        if(arquivoEstoque.exists()){
            List<Uso> estoque = PessoaFisica.resgatarListaUsoMedicamentosArquivo(pessoa.getNomeArquivoUsos());
            pessoa.setListaUsoMedicamentos(estoque, false);
        }
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

    private static boolean enviarNotificacao(String notificacao, Uso uso) {
        Runnable runNotify = () -> {
            boolean tomouRemedio = Notificacao.notificar(notificacao);
            if (tomouRemedio) {
                System.out.println(uso.getRemedio().getNome());
                System.out.println(uso.getDose());
                atualizarUso(uso.getRemedio().getNome(), uso.getDose(), uso.getQtdDisponivel());
            }
        };
        Thread threadNotify = new Thread(runNotify);
        threadNotify.start();

        return false; //para que o programa continue
    }

    private static boolean enviarNotificacaoCompra(Uso uso) {
        String notificacao = "Existem apenas " + uso.getQtdDisponivel() + " comprimidos do seu remédio "
                + uso.getRemedio().getNome() + "\n" + "É nessário comprar mais para terminar seu tratamento!";

        Runnable runNotify = () -> {
            Notificacao.notificarCompra(notificacao);
        };
        Thread threadNotify = new Thread(runNotify);
        threadNotify.start();

        return false; //para que o programa continue
    }

    private static boolean verificarQtdRemedio(Uso uso) {
        boolean remedioAcabando = false;
        int qtd = uso.getQtdDisponivel();
        int duracao = uso.getDuracaoDoTratamento();
        int qtdAoDia = uso.getHorariosDeUso().size();
        int qtdNecessaria = duracao * qtdAoDia;

        if (qtdNecessaria > qtd) {
            remedioAcabando = true;
        }
        return remedioAcabando;
    }

    private static void atualizarDuracaoDeUso(Uso uso) {
        if(uso.getDuracaoDoTratamento()==0) return;
        uso.setDuracaoDoTratamento(uso.getDuracaoDoTratamento() - 1);
        String strUso = uso.toString();
        FuncoesArquivos.alterarLinhaArquivo(pessoa.getNomeArquivoUsos(), uso.getRemedio().getNome(), strUso);
    }

    private static void excluirUso(Uso uso) {
        Gerenciador.pessoa.removerUsoNaListaUsoMedicamentos(uso.getRemedio().getNome());
    }

    @Override
    public void run() {
        /* lê usos do arquivo do usuário
        // listaDeUsos = (ArrayList<Uso>)
        // PessoaFisica.resgatarListaUsoMedicamentosArquivo(pessoa.getNomeArquivoUsos());
        // if (listaDeUsos == null) {
        // Thread.interrupted();
        // }
        // calcula todos os horários de cada um dos usos
        // for (Uso uso : listaDeUsos) {
        // uso.calcularHorariosDeUso();
        // }
        */

        
        //thread que envia notificações de compra de remédios a cada 1 hora
        //além disso, verfica a necessidade diminuir em um dia a duração do tratamento todo dia às 0hXmin
        //verifica a necessidade de enviar notificações sobre horario de tomar medicamento
        while (true) {
            //lê arquivo de usos do usuário
            listaDeUsos = (ArrayList<Uso>) PessoaFisica.resgatarListaUsoMedicamentosArquivo(pessoa.getNomeArquivoUsos());
            
            //calcula horários de uso de acordo com intervalo e hora inicial
            for (Uso uso : listaDeUsos) {
                uso.calcularHorariosDeUso();
            }

            // enviar notificacao para comprar remedios caso não seja suficiente para o
            // término do tratamento
            for (Uso uso : listaDeUsos) {
                if (verificarQtdRemedio(uso)) {
                    while(enviarNotificacaoCompra(uso)){}
                }
                //System.out.println("compra "+uso.getRemedio().getNome());
            }

            //enviar notificacao para tomar o medicamento na hora correta
            for (Uso uso : listaDeUsos) {
                for (Integer horario : uso.getHorariosDeUso()) {
                    if (Data.horaDoRemedio(uso,horario)) {
                        while(enviarNotificacao("Nome do remédio: " + uso.getRemedio().getNome() + "\nDias da semana: "
                                + uso.getHorarios().toString()+ "\nHorário: "
                                + horario + "h\nDose: "+uso.getDose() +" comprimido(s)\n"
                                + "Você tomou o remédio às " + horario
                                + " horas?\n Se sim, clique em SIM para confirmar. Clique em NÃO, caso contrário.",
                                uso));
                    }
                }
            }

            //System.out.println("aqui!!!");

            //exclui uso quando a duracao do tramento é finalizada
            for(Uso uso: listaDeUsos){
                if(uso.getDuracaoDoTratamento() == 0){
                    excluirUso(uso);
                }
            }
            

            //diminui um dia na duracao de uso a cada virada de dia
            if(Data.ehMeiaNoite()){
                for (Uso uso : listaDeUsos) {
                    atualizarDuracaoDeUso(uso);  
                } 
            }
            
            //gerenciador dorme por uma hora
            int menorIntervalo = verificarIntervaloDoGerenciador();
            //long dormir = menorIntervalo * 3600000;
            long dormir = 3600000;
            //System.out.print("aqui!!!!!!!");
            try {
                Thread.sleep(dormir);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }  
        }
    }
}

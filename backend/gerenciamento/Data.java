package backend.gerenciamento;

import java.util.ArrayList;
import java.util.Calendar;

import backend.usuario.Uso;

//classe responsavel por verificacoes de hora
public class Data {
    private static boolean duracaoDoTratamentoAtualizada = true;

    public static boolean horaDoRemedio(Uso uso, Integer horario) {
        boolean ehHoraDoRemedio = false;
        
        if(verificarHora(horario) && verificarDia(uso.getHorarios())){
            ehHoraDoRemedio = true;
        }

        return ehHoraDoRemedio;
    }

    // retorna true se já tiver passado da meia noite para decrementar um dia na
    // duracao do tratamento
    public static boolean ehMeiaNoite() {
        boolean meiaNoite = false;
        Calendar c = Calendar.getInstance();
        int horaAtual = c.get(Calendar.HOUR_OF_DAY);

        if(horaAtual == 0){
            if(duracaoDoTratamentoAtualizada == false){
                meiaNoite = true;
                Data.duracaoDoTratamentoAtualizada = true;
            }
        }

        if(duracaoDoTratamentoAtualizada==true && horaAtual != 0){
            Data.duracaoDoTratamentoAtualizada = false;
        }

        return meiaNoite;
    }

    //verifica se o horario do uso passado como parâmetro corresponde com a hora atual
    public static boolean verificarHora(Integer hora) {
        Calendar c = Calendar.getInstance();
        int horaAtual = c.get(Calendar.HOUR_OF_DAY);

        if(hora == horaAtual){
            return true;
        }

        return false;
    }

    public static int formatarDia(String dia) {
        int d = 0;

        switch (dia) {
            case "seg":
                d = 2;
                break;
            case "ter":
                d = 3;
                break;
            case "qua":
                d = 4;
                break;
            case "qui":
                d = 5;
                break;
            case "sex":
                d = 6;
                break;
            case "sab":
                d = 7;
                break;
            default: //dom
                d = 1; 
                break;
        }

        return d;
    }

    public static boolean verificarDia(ArrayList<String> dias) {
        Calendar c = Calendar.getInstance();
        int hoje = c.get(Calendar.DAY_OF_WEEK);

        for(String dia: dias){
            if(formatarDia(dia) == hoje){
                return true;
            }
        }

        return false;
    }

    //main utilizada para fins de teste
    // public static void main(String[] args) {
    //     Calendar c = Calendar.getInstance();
    //     System.out.println(c.getTime());

    //     int d = c.get(Calendar.DAY_OF_WEEK);
    //     System.out.println("Dia: " + d);

    //     int h = c.get(Calendar.HOUR_OF_DAY);
    //     System.out.println("Hora: " + h);
    // }
}

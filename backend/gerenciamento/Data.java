package backend.gerenciamento;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Data {
    public static boolean horaDoRemedio() {
        return true;
    }

    public static void main(String[] args) {
        // Calendar c = Calendar.getInstance();
        // System.out.println(c.getTime());
        Calendar c = Calendar.getInstance();
		//c.set(2013, Calendar.FEBRUARY, 28);
		Date data = c.getTime();
		System.out.println("Data atual sem formatação: "+data);

		//Formata a data
		DateFormat formataData = DateFormat.getDateInstance();
		System.out.println("Data atual com formatação: "+ formataData.format(data));

		//Formata Hora
        DateFormat hora = DateFormat.getTimeInstance();
		System.out.println("Hora formatada: "+hora.format(data));

		//Formata Data e Hora
		DateFormat dtHora = DateFormat.getDateTimeInstance();
        System.out.println(dtHora.format(data));
        
        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL); //Data COmpleta
        System.out.println("Data brasileira: "+f.format(data));
        
        f = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println("Data resumida 1: "+f.format(data));

		f = DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println("Data resumida 2: "+f.format(data));
    }
}

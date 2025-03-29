package utilidades;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class FuncionesFechas {
    /*
     * Pasa una fecha de tipo String a LocalDate.
     */
    public LocalDate parseoStringALocalDate (String fecha){
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fecha, formatoFecha);
    }
    /*
    * Pasa una fecha de tipo LocalDate a String.
    */
    public String parseoLocalDateAString (LocalDate fecha){
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(formatoFecha);
    }
}

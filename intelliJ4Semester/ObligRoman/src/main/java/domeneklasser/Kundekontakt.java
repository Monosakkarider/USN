package domeneklasser;

import java.util.Date;

public class Kundekontakt {
    private String kundenr;
    private Date dato;
    private String beskrivelse;

    public Kundekontakt(String kundenr, Date dato, String beskrivelse) {
        this.kundenr = kundenr;
        this.dato = dato;
        this.beskrivelse = beskrivelse;
    }

    public String getKundenr() {
        return kundenr;
    }

    public Date getDato() {
        return dato;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setKundenr(String kundenr) {
        this.kundenr = kundenr;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String toString() {
        return "Kundenr: " + kundenr + " Dato: " + dato + " Beskrivelse: " + beskrivelse;
    }
}

package domeneklasser;

public class Kunde {
    private String kundenr;
    private String kundenavn;

    public Kunde(String kundenr, String kundenavn) {
        this.kundenr = kundenr;
        this.kundenavn = kundenavn;
    }

    public String getKundenr() {
        return kundenr;
    }

    public String getKundenavn() {
        return kundenavn;
    }

    public void setKundenr(String kundenr) {
        this.kundenr = kundenr;
    }

    public void setKundenavn(String kundenavn) {
        this.kundenavn = kundenavn;
    }

    public String toString() {
        return "Kundenr: " + kundenr + " Kunde: " + kundenavn;
    }
}

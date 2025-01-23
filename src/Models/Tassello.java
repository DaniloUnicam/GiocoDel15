package Models;

public class Tassello {
    private Posizione posizione;
    private int valore;

    public Tassello(Posizione posizione, int valore) {
        this.posizione = posizione;
        this.valore = valore;
    }

    public Posizione getPosizione() {
        return posizione;
    }

    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }
}

package com.company;

public abstract class Balozo {

    private String nev;
    private int sorszam;
    private int tancSzam;
    private int zsebPenz;
    private int koltottPenz;

    private static int utolsoSorszam;

    public Balozo(String nev, int zsebPenz) {
        this.nev = nev;
        this.zsebPenz = zsebPenz;
        Balozo.utolsoSorszam++;
        this.sorszam = Balozo.utolsoSorszam;
    }

    //táncolás után növekszik a táncok száma
    public void tancol() {
        tancSzam++;
    }

    //a fizetendő ártól függ, hogy tud-e fogyasztani
    public boolean fogyaszt(int ar) {
        if (koltottPenz + ar < zsebPenz) {
            koltottPenz += ar;
            zsebPenz -= ar;
            return true;
        }
        return false;
    }

    //a paraméterben szereplő lányra szavaz
    public void szavaz(Lany lany) {
        lany.szavazatotKap();
    }

    public String getNev() {
        return nev;
    }

    public int getSorszam() {
        return sorszam;
    }

    public int getTancSzam() {
        return tancSzam;
    }

    public int getKoltottPenz() {
        return koltottPenz;
    }

    public static int getUtolsoSorszam() {
        return utolsoSorszam;
    }

    @Override
    public String toString() {
        return "A " + this.getClass().getSimpleName().toLowerCase()
                + " sorszáma: " + sorszam + ", neve: " + nev;
    }

    abstract public String osztalyNev();
}

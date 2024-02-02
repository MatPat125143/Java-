public class Produkt {
    private String nazwa;
    private double cena;
    private int pojemnosc;
    private  int ilosc;

    public Produkt(String nazwa, double cena, int ilosc) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.ilosc = ilosc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }
    public int getIlosc() {
        return ilosc;
    }

    public void zmniejszIlosc() {
        ilosc--;
    }
}

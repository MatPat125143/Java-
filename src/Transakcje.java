public class Transakcje {
    private String nazwaNapoju;
    private double cena;
    private String data;

    public Transakcje(String nazwaNapoju, double cena, String data) {
        this.nazwaNapoju = nazwaNapoju;
        this.cena = cena;
        this.data = data;
    }

    public String getNazwaNapoju() {
        return nazwaNapoju;
    }

    public double getCena() {
        return cena;
    }

    public String getData() {
        return data;
    }
}

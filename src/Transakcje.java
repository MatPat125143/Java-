public class Transakcje {
    private int id;
    private String nazwa;
    private String dataTransakcji;
    private double kwota;

    public Transakcje(int id, String nazwa, String dataTransakcji, double kwota) {
        this.id = id;
        this.nazwa = nazwa;
        this.dataTransakcji = dataTransakcji;
        this.kwota = kwota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getDataTransakcji() {
        return dataTransakcji;
    }

    public void setDataTransakcji(String dataTransakcji) {
        this.dataTransakcji = dataTransakcji;
    }

    public double getKwota() {
        return kwota;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }
}

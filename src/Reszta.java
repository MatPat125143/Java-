public class Reszta {
    public static String wydajReszte(double kwotaZakupu, double cenaProduktu) {
        double reszta = kwotaZakupu - cenaProduktu;

        if (reszta >= 0) {
            int calkowitaReszta = (int) reszta;
            int grosze = (int) ((reszta - calkowitaReszta) * 100);

            return "Reszta do wydania: " + calkowitaReszta + " zł " + grosze + " gr";
        } else {
            return "Niewystarczająca kwota. Brakuje: " + (-reszta) + " zł";
        }
    }
}

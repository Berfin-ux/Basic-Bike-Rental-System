public class Musteri {
    int id;
    String saat;

    public Musteri(int id, String saat) {
        this.id = id;
        this.saat = saat;
    }

    @Override
    public String toString() {
        return "(" + "ID: " + id +
                ", Saat: " + saat + ")";
    }
}

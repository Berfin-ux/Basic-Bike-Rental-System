public class Duraklar implements Comparable<Duraklar> {
    String durakAd;
    int bosP;
    int tandemB;
    int normalB;

    public Duraklar(String durakAd, int bosP, int tandemB, int normalB) {
        this.durakAd = durakAd;
        this.bosP = bosP;
        this.tandemB = tandemB;
        this.normalB = normalB;
    }

    @Override
    public String toString() {
        return "(" + "Durak Adı: " + durakAd + "   Boş Park:  " + bosP +
                "   TB: " + tandemB + "   NB: " + normalB + ")";
    }

    @Override
    public int compareTo(Duraklar o) {
        if (o.durakAd.compareTo(this.durakAd) == 1) {
            return 1;
        } else {
            return 0;
        }
    }
}

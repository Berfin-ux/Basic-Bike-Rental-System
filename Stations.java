import java.util.List;

public class Stations implements Comparable<Stations> {
    String durakAdi;
    int bosPark;
    int tB;
    int nB;
    List<Musteri> list;

    public Stations(String durakAdi, int bosPark, int tB, int nB, List<Musteri> list) {
        this.durakAdi = durakAdi;
        this.bosPark = bosPark;
        this.tB = tB;
        this.nB = nB;
        this.list = list;
    }

    @Override
    public String toString() {
        return "(" + "Durak Adı: " + durakAdi + "   Boş Park:  " + bosPark +
                "   TB: " + tB + "   NB: " + nB + "   Müşteriler: " + list + ")";
    }

    @Override
    public int compareTo(Stations o) {
        if(this.durakAdi.compareTo(o.durakAdi)==0){
            return 0;
        }
        else if (this.durakAdi.compareTo(o.durakAdi)<0){
            return -1;
        }
        else {
            return 1;
        }

    }
}


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Deneme {
    public static void main(String[] args) {
        String[] duraklar = {"Inciraltı, 28, 2, 10", "Sahilevleri, 8, 1, 11", "Doğal Yaşam Parkı, 17, 1, 6", "Bostanlı İskele, 7, 0, 5",
                "Bornova Metro, 4, 3, 8", "Fahrettin Altay, 8, 0, 4", "Alsancak İskele, 5, 1, 14", "Konak Metro, 19, 0, 1",
                "Göztepe Köprü, 15, 0, 15"};

        String duraks = "";
        int k = 0;

        Random random = new Random();


        Tree tree = new Tree();

        for (int i = 0; i < duraklar.length; i++) {

            List<Musteri> mList = new ArrayList<>();
            int r3 = random.nextInt(10) + 1;

            for (int j = 0; j < r3; j++) {

                int r0 = random.nextInt(20) + 1;
                int r1 = random.nextInt(24);
                int r2 = random.nextInt(60);

                String a = String.valueOf(r1);
                String b = String.valueOf(r2);
                String saat = a + ":" + b;

                Musteri m = new Musteri(r0, saat);
                mList.add(m);

            }

            duraks = duraklar[i];
            String[] duraklar2 = duraks.split(", ");
            int a = Integer.valueOf(duraklar2[k+3])-mList.size();
            Stations d;
            if (a>=0) {
                d = new Stations(duraklar2[k], Integer.valueOf(duraklar2[k + 1])+mList.size(), Integer.valueOf(duraklar2[k + 2]), Integer.valueOf(duraklar2[k + 3])-mList.size(), mList);
            } else {
                 d = new Stations(duraklar2[k], Integer.valueOf(duraklar2[k + 1]) + Integer.valueOf(duraklar2[k+3]), Integer.valueOf(duraklar2[k + 2]), 0, mList);
            }

            tree.insert(d);
        }

        tree.inOrder();
        System.out.println();
        System.out.println("*******************************");
        System.out.print("Ağacın Derinliği: ");
        System.out.println(tree.maxDepth(tree.root));
        System.out.println("*******************************");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Aramak istediğiniz müşterinin ID bilgisini giriniz : ");
        int id = scanner.nextInt();
        tree.search(id);
        System.out.println("*******************************");


        Scanner sc = new Scanner(System.in);
        System.out.print("Müşterinin bulunduğu durağı giriniz: ");
        String st = sc.nextLine();
        System.out.print("Müşterinin ID'sini giriniz: ");
        int i = sc.nextInt();
        Musteri mt = new Musteri(i,"9:51");
        tree.insertMusteri(mt, st);
        tree.inOrder();
        System.out.println();
        System.out.println("*******************************");


    }
}

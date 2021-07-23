
class Node2 {
    Stations object;
    Node2 leftChild;
    Node2 rightChild;

    public Node2(Stations station) {
        this.object = station;
        rightChild = null;
        leftChild = null;
    }

    public void ekle(Stations station) {
        if (station.compareTo(object) < 0) {
            if (leftChild == null) {
                leftChild = new Node2(station);
            } else {
                leftChild.ekle(station);
            }
        } else if (station.compareTo(object) > 0){
            if (rightChild == null) {
                rightChild = new Node2(station);
            } else {
                rightChild.ekle(station);
            }
        }
    }

    public void inOrder() {
        System.out.println("_________________________________");
        System.out.println("");
        System.out.println("Durak Adı: " + object.durakAdi + " Boş Park: " + object.bosPark + " Tandem Bisiklet: " + object.tB +
                " Normal Bisiklet: " + object.nB);
        System.out.println("Müşteriler: ");
        for (int a=0; a<object.list.size(); a++) {
            System.out.println(object.list.get(a));
        }

        if (leftChild != null) {
            leftChild.inOrder();
        } if (rightChild != null) {
            rightChild.inOrder();
        }
    }

    public void searchTree(Node2 root, int d) {
        if (root != null) {
            searchTree(root.leftChild, d);
            for (int a=0; a<root.object.list.size(); a++) {
                if (d == root.object.list.get(a).id) {
                    System.out.println( root.object.durakAdi + " Müşteri " + root.object.list.get(a));
                }
            }
            searchTree(root.rightChild, d);
        }
    }

    public void ekleMusteri(Node2 root , Musteri musteri,String location){
        if(root != null){
            ekleMusteri(root.leftChild,musteri,location);

            if(location.equalsIgnoreCase(root.object.durakAdi)){
                root.object.list.add(musteri);
                int normalB = root.object.nB-1;
                root.object.nB = normalB;
                int bosP = root.object.bosPark+1;
                root.object.bosPark = bosP;
            }
            ekleMusteri(root.rightChild,musteri,location);
        }
    }

}

public class Tree {
    public Node2 root = null;

    public Tree() {

    }

    public void insert(Stations object) {
       if (root == null) {
           root = new Node2(object);
       } else {
           root.ekle(object);
       }
    }

    public void inOrder() {
        if (root != null) {
            root.inOrder();
        }
    }

    public void search(int id) {
        if (root != null) {
            root.searchTree(root, id);
        }
    }

    public int maxDepth(Node2 node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(node.leftChild);
            int rightDepth = maxDepth(node.rightChild);

            if (leftDepth < rightDepth) {
                return rightDepth+1;
            } else {
                return leftDepth+1;
            }
        }
    }

    public void insertMusteri(Musteri musteri , String loc){
        if(root != null){
            root.ekleMusteri(root,musteri,loc);
        }

    }
}

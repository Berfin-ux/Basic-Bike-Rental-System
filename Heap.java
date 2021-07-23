import java.util.ArrayList;
import java.util.Random;

class Node {
    private Duraklar iData;

    public Node(Duraklar key) {
        iData = key;
    }

    public Duraklar getKey() {
        return iData;
    }

    public void setKey(Duraklar id) {
        iData = id;
    }
}
public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int mx) {
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty() {
        return currentSize==0;
    }

    public boolean insert(Duraklar key) {
        if (currentSize == maxSize) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int index) {
        int parent = (index-1) / 2;
        Node bottom = heapArray[index];
        while (index > 0 && heapArray[parent].getKey().normalB < bottom.getKey().normalB) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent-1)/2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize && heapArray[leftChild].getKey().normalB < heapArray[rightChild].getKey().normalB) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }
            if (top.getKey().normalB >= heapArray[largerChild].getKey().normalB) {
                break;
            }
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    public boolean change(int index, int newValue)
    {
        if(index<0 || index>=currentSize)
            return false;
        int oldValue = heapArray[index].getKey().normalB;
        heapArray[index].getKey().normalB = newValue;
        if(oldValue < newValue)
            trickleUp(index);
        else
            trickleDown(index);
        return true;
    }

    public void maxNode(){
        for(int i = 0 ; i < 3 ; i++){
            System.out.println(heapArray[i].getKey());
        }

    }


    public void displayHeap() {
        System.out.println("Heap Array: ");
        for(int m=0; m<currentSize; m++)
            if(heapArray[m] != null)
                System.out.println( heapArray[m].getKey() + " ");
            else
                System.out.print( "--");
        System.out.println();
    }

    public static void main(String[] args) {
        String[] duraklar = {"Inciraltı, 28, 2, 10", "Sahilevleri, 8, 1, 11", "Doğal Yaşam Parkı, 17, 1, 6", "Bostanlı İskele, 7, 0, 5",
                "Bornova Metro, 4, 3, 8", "Fahrettin Altay, 8, 0, 4", "Alsancak İskele, 5, 1, 14", "Konak Metro, 19, 0, 1",
                "Göztepe Köprü, 15, 0, 15"};
        int size = duraklar.length;

        Heap heap = new Heap(size);
        String duraks = "";
        int k = 0;
        Random random = new Random();
        ArrayList<Duraklar> list = new ArrayList<>();

        for (int i = 0; i < duraklar.length; i++) {
            duraks = duraklar[i];
            String[] duraklar2 = duraks.split(", ");

            Duraklar durak = new Duraklar(duraklar2[k], Integer.valueOf(duraklar2[k + 1]), Integer.valueOf(duraklar2[k + 2]), Integer.valueOf(duraklar2[k + 3]));
           list.add(durak);

        }

        for(int j = 0 ; j<list.size(); j++  ){
            heap.insert(list.get(j));
        }

        heap.displayHeap();
        System.out.println();
        System.out.println("En fazla Normal Bisiklet olan üç istasyon: ");
        heap.maxNode();

    }
}


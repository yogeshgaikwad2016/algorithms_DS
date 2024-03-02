package algorithm;

class HashMap {
    LinkedList[] node;
    int n;

    HashMap(int n) {
        this.n = n;
        this.node = new LinkedList[n];
    }

    int calculateHashVal(int val) {
        return val % n;
    }

    void add(int val) {
        int hashVal = calculateHashVal(val);
        if (this.node[hashVal] == null) {
            LinkedList list1 = new LinkedList();
            list1.addData(val);
            this.node[hashVal] = list1;
        } else {
            LinkedList list1 = this.node[hashVal];
            list1.addData(val);
        }
    }

    void get(int search) {
        int hashVal = calculateHashVal(search);
        LinkedList list1 = this.node[hashVal];
        if (list1 == null) {
            System.out.println("No data present.");
        } else {
            if (list1.search(search)) {
                System.out.println("Value " + search + " is present");
            } else {
                System.out.println("No data exists.");
            }
        }
    }

    void delete(int deleteTerm) {
        int hashVal = calculateHashVal(deleteTerm);
        LinkedList list1 = this.node[hashVal];
        if (list1 == null) {
            System.out.println("No data present.");
        } else {
            list1.deleteData(deleteTerm);
        }
    }

    void display() {
        for (int i = 0; i < n; i++) {
            LinkedList list1 = this.node[i];
            if (list1 != null) {
                System.out.print("Loc [" + i + "] Value(s) ");
                list1.display();
            } else {
                System.out.println("Loc [" + i + "] Value(s) -> Empty");
            }
        }
    }
}

public class HashMapAlgorithm {

    public static void main(String[] args) {
        HashMap map = new HashMap(5);
        map.add(20);
        map.add(10);
        map.add(30);
        map.add(60);
        map.add(40);
        map.add(80);
        map.add(90);
        map.add(100);
        map.add(5);

        map.display();

        map.get(40);

        map.delete(60);
        
        map.display();
    }
}

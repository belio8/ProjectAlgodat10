public class RiwayatTransaksi {
    NodeRiwayat top; 

    // Menambahkan node baru ke stack
    public void push(String nama, int total) {
        NodeRiwayat nodeBaru = new NodeRiwayat(nama, total);
        nodeBaru.next = top;
        top = nodeBaru;
    }

    // Menampilkan riwayat transaksi
    public void tampilkan() {
        if (top == null) {
            System.out.println("   (Riwayat kosong)");
            return;
        }
        NodeRiwayat current = top;
        while (current != null) {
            System.out.println("   " + current.getInfo());
            current = current.next;
        }
    }

    // Mengurutkan riwayat transaksi
    public void urutkanHistory() {
        if (top == null || top.next == null) {
            System.out.println(">> Data belum cukup untuk disorting.");
            return;
        }

        NodeRiwayat sortedList = null; 
        NodeRiwayat current = top;     

        while (current != null) {
            NodeRiwayat nextNode = current.next; 

            // Insertion Sort (Descending)
            if (sortedList == null || current.totalBelanja >= sortedList.totalBelanja) {
                current.next = sortedList;
                sortedList = current;
            } else {
                NodeRiwayat temp = sortedList;
                while (temp.next != null && temp.next.totalBelanja > current.totalBelanja) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }

            current = nextNode;
        }

        top = sortedList;
        System.out.println(">> History berhasil diurutkan (Insertion Sort - Total Terbesar).");
    }
}

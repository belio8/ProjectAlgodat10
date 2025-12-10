public class RiwayatTransaksi {
    NodeRiwayat top; 

    public void push(String nama, int total) {
        NodeRiwayat nodeBaru = new NodeRiwayat(nama, total);
        nodeBaru.next = top;
        top = nodeBaru;
    }

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

    public void urutkanHistory() {
        if (top == null || top.next == null) {
            System.out.println(">> Data belum cukup untuk disorting.");
            return;
        }

        NodeRiwayat temp = top;

        while (temp != null) {
            NodeRiwayat maxNode = temp;
            NodeRiwayat r = temp.next;

            while (r != null) {
                if (r.totalBelanja > maxNode.totalBelanja) {
                    maxNode = r;
                }
                r = r.next;
            }

            if (maxNode != temp) {
                swapData(temp, maxNode);
            }
            temp = temp.next;
        }

        System.out.println(">> History berhasil diurutkan (Selection Sort - Total Terbesar).");
    }

    private void swapData(NodeRiwayat a, NodeRiwayat b) {
        int tempTotal = a.totalBelanja;
        a.totalBelanja = b.totalBelanja;
        b.totalBelanja = tempTotal;

        String tempNama = a.namaPelanggan;
        a.namaPelanggan = b.namaPelanggan;
        b.namaPelanggan = tempNama;
    }
}
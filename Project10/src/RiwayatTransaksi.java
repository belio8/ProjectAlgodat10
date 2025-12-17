public class RiwayatTransaksi {
    NodeRiwayat top; 

    public void push(String nama, int total) {
        NodeRiwayat nodeBaru = new NodeRiwayat(nama, total);
        nodeBaru.next = top;
        top = nodeBaru;
    }

    public void tampilkan() {
        if (top == null) {
            System.out.println(Warna.RED + "   (Riwayat kosong)" + Warna.RESET);
            return;
        }
        NodeRiwayat current = top;
        int no = 1;
        System.out.printf("%-5s %-15s %-15s%n", "No", "Pelanggan", "Total Belanja");
        System.out.println("------------------------------------");
        while (current != null) {
            System.out.printf("%-5d %-15s Rp%-12d%n", no, current.namaPelanggan, current.totalBelanja);
            current = current.next;
            no++;
        }
        System.out.println("------------------------------------");
    }
    public void urutkanHistory() {
        if (top == null || top.next == null) {
            System.out.println(">> Data belum cukup untuk disorting.");
            return;
        }

        NodeRiwayat sortedList = null; 
        NodeRiwayat current = top;     

        while (current != null) {
            NodeRiwayat nextNode = current.next; 

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
        System.out.println(">> History berhasil diurutkan (Total Terbesar).");
    }
    public int totalPenjualan() {
        int sum = 0;
        NodeRiwayat c = top;
        while (c != null) {
            sum += c.totalBelanja;
            c = c.next;
        }
        return sum;
    }
}

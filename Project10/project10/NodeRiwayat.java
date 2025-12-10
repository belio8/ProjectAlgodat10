public class NodeRiwayat {
    String namaPelanggan;
    int totalBelanja;
    NodeRiwayat next;

    public NodeRiwayat(String nama, int total) {
        this.namaPelanggan = nama;
        this.totalBelanja = total;
    }

    public String getInfo() {
        return "Pelanggan: " + namaPelanggan + " | Total: Rp " + totalBelanja;
    }
}
public class Barang {
    String nama;
    int harga;
    int stok;

    public Barang(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getInfo() {
        return nama + " | Rp " + harga + " | Stok: " + stok;
    }
}
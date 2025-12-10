public class Barang {
    String nama;
    int harga;
    int stok;
    int terjual;
    double diskonBarang;  // field baru untuk diskon per item

    // Konstruktor
    public Barang(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.terjual = 0;
        this.diskonBarang = 0.0; // default: tanpa diskon
    }

    // Setter untuk mengatur diskon per item (0.0 - 1.0)
    public void setDiskonBarang(double diskon) {
        if (diskon < 0.0) diskon = 0.0;
        if (diskon > 1.0) diskon = 1.0;
        this.diskonBarang = diskon;
    }

    // Getter untuk harga setelah diskon
    public int getHargaSetelahDiskon() {
        return (int)(harga - (harga * diskonBarang));
    }

    // Info barang (tampilkan diskon jika ada)
    public String getInfo() {
        String dsc = diskonBarang > 0 ? " | Diskon: " + (int)(diskonBarang * 100) + "%" : "";
        return Warna.CYAN + nama + Warna.RESET +
               " | Rp " + harga +
               " | Stok: " + stok +
               " | Terjual: " + terjual + dsc;
    }
}
public class Barang {
    String nama;
    int harga;
    int stok;
    int terjual;
    double diskonBarang;  

    public Barang(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.terjual = 0;
        this.diskonBarang = 0.0; 
    }

    public void setDiskonBarang(double diskon) {
        if (diskon < 0.0) diskon = 0.0;
        if (diskon > 1.0) diskon = 1.0;
        this.diskonBarang = diskon;
    }

    public int getHargaSetelahDiskon() {
        return (int)(harga - (harga * diskonBarang));
    }

    public String getInfo() {
        String dsc = diskonBarang > 0 ? " | Diskon: " + (int)(diskonBarang * 100) + "%" : "";
        return Warna.CYAN + nama + Warna.RESET +
               " | Rp " + harga +
               " | Stok: " + stok +
               " | Terjual: " + terjual + dsc;
    }
}
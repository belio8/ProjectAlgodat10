public class Pelanggan {
    
    public String nama;
    public KeranjangBelanja keranjang;
    public Pelanggan next; 

    public Pelanggan(String nama, KeranjangBelanja keranjang) {
        this.nama = nama;
        this.keranjang = keranjang;
    }
}
public class Keranjang {
    Barang barang;
    int qty;
    Keranjang next;

    Keranjang(Barang barang, int qty) {
        this.barang = barang;
        this.qty = qty;
    }
}
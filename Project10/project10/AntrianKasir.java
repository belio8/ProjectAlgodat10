public class AntrianKasir {
    Pelanggan front, rear;

    public void tambahPelanggan(String nama, KeranjangBelanja keranjang) {
        Pelanggan p = new Pelanggan(nama, keranjang);
        if (rear == null) {
            front = rear = p;
        } else {
            rear.next = p;
            rear = p;
        }
        System.out.println(">> " + nama + " berhasil masuk antrian kasir.");
    }

    public Pelanggan hapusPelanggan() {
        if (front == null) return null;
        Pelanggan temp = front;
        front = front.next;
        if (front == null) rear = null;
        return temp;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
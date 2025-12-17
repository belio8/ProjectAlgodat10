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
        System.out.println(">> " + nama + " masuk antrian kasir.");
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

    public void lihatAntrian() {
        if (isEmpty()) {
            System.out.println("   (Antrian kosong)");
            return;
        }
        System.out.println("================================");
        System.out.println("         DAFTAR ANTRIAN         ");
        System.out.println("================================");
        Pelanggan current = front;
        int nomor = 1;
        while (current != null) {
            System.out.println("   " + nomor + ". " + current.nama);
            current = current.next;
            nomor++;
        }
        System.out.println("   ----------------------");
    }
}
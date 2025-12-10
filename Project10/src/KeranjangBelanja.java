public class KeranjangBelanja {
    Keranjang head;

    // Push barang ke stack
    public void push(Barang b, int qty) {
        Keranjang nodeBaru = new Keranjang(b, qty);
        nodeBaru.next = head;
        head = nodeBaru;
    }

    // Pop barang teratas dari stack
    public Keranjang pop() {
        if (head == null) return null;
        Keranjang temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public Keranjang peek() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    
    public void hapusBerdasarkanNama(String nama, Inventaris gudang) {
        KeranjangBelanja tempStack = new KeranjangBelanja();
        boolean found = false;
        while (!isEmpty()) {
            Keranjang top = pop();
            if (top.barang.nama.equalsIgnoreCase(nama)) {
                top.barang.stok += top.qty;
                System.out.println(">> " + nama + " dihapus dari keranjang. Stok dikembalikan.");
                found = true;
                break;
            } else {
                tempStack.push(top.barang, top.qty);
            }
        }
        // Kembalikan sisa barang ke stack utama
        while (!tempStack.isEmpty()) {
            Keranjang t = tempStack.pop();
            push(t.barang, t.qty);
        }
        if (!found) System.out.println("Barang tidak ditemukan di keranjang.");
    }
`
    public void kembalikanSemuaStok() {
        while(head != null) {
            head.barang.stok += head.qty;
            head = head.next;
        }
    }

    public int hitungTotal() {
        int total = 0;
        Keranjang current = head;
        System.out.println("   --- Rincian Belanja ---");
        while (current != null) {
            int subtotal = current.barang.harga * current.qty;
            System.out.println("   - " + current.barang.nama + " (" + current.qty + "x) = Rp " + subtotal);
            total += subtotal;
            current = current.next;
        }
        return total;
    }
}
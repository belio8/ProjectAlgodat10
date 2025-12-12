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
       
        while (!tempStack.isEmpty()) {
            Keranjang t = tempStack.pop();
            push(t.barang, t.qty);
        }
        if (!found) System.out.println("Barang tidak ditemukan di keranjang.");
    }

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
    public int hitungTotalDenganDiskon() {
        int total = 0;
        Keranjang current = head;
        System.out.printf("%-15s %-15s %-10s %-10s %-10s%n", 
            "Barang", "Jumlah Barang", "Harga", "Diskon", "Subtotal");
        System.out.println("---------------------------------------------------------------");
        while (current != null) {
            int harga = current.barang.harga;
            double dItem = current.barang.diskonBarang; 
            int hargaSetelahDiskonItem = (int) Math.round(harga * (1.0 - dItem));
            int subtotal = hargaSetelahDiskonItem * current.qty;
            String dscStr = dItem > 0 ? (int)(dItem * 100) + "%" : "-";
            System.out.printf("%-15s %-10d Rp%-9d %-10s Rp%-9d%n",
                    current.barang.nama, current.qty, hargaSetelahDiskonItem, dscStr, subtotal);
            total += subtotal;
            current = current.next;
        }

        double diskonTotal = 0;
        if (total >= 200000) diskonTotal = 0.20;
        else if (total >= 100000) diskonTotal = 0.10;

        if (diskonTotal > 0) {
            int potongan = (int) Math.round(total * diskonTotal);
            System.out.println(">> Diskon total " + (int)(diskonTotal * 100) + "% = Rp " + potongan);
            total -= potongan;
        }

        System.out.println("TOTAL BAYAR SETELAH DISKON: Rp " + total);
        return total;
    }
    public boolean editQty(String namaBarang, int qtyBaru) {
        Keranjang cur = head;
        while (cur != null) {
            if (cur.barang.nama.equalsIgnoreCase(namaBarang)) {

                cur.barang.stok += cur.qty;
                if (qtyBaru <= 0) {
      
                    hapusItem(namaBarang);
                    return true;
                }
          
                if (cur.barang.stok < qtyBaru) return false;
                cur.barang.stok -= qtyBaru;
                cur.qty = qtyBaru;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public boolean hapusItem(String namaBarang) {
        Keranjang cur = head, prev = null;
        while (cur != null) {
            if (cur.barang.nama.equalsIgnoreCase(namaBarang)) {
                cur.barang.stok += cur.qty; // kembalikan stok
                if (prev == null) head = cur.next;
                else prev.next = cur.next;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

}
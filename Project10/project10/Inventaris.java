// jabatan pegawai (nanti)
public class Inventaris {
    NodeTree root;

    public void tambah(String nama, int harga, int stok) {
        root = tambahRekursif(root, new Barang(nama, harga, stok));
    }

    private NodeTree tambahRekursif(NodeTree current, Barang b) {
        if (current == null) return new NodeTree(b);
        
        if (b.nama.compareToIgnoreCase(current.data.nama) < 0) {
            current.kiri = tambahRekursif(current.kiri, b);
        } else if (b.nama.compareToIgnoreCase(current.data.nama) > 0) {
            current.kanan = tambahRekursif(current.kanan, b);
        } else {
            current.data.stok += b.stok;
        }
        return current;
    }

    public Barang cari(String nama) {
        return searchRecursive(root, nama);
    }

    private Barang searchRecursive(NodeTree current, String nama) {
        if (current == null) return null;
        if (nama.equalsIgnoreCase(current.data.nama)) return current.data;

        if (nama.compareToIgnoreCase(current.data.nama) < 0) {
            return searchRecursive(current.kiri, nama);
        } else {
            return searchRecursive(current.kanan, nama);
        }
    }

    public void hapus(String nama) {
        root = hapusRekursif(root, nama);
    }

    private NodeTree hapusRekursif(NodeTree current, String nama) {
        if (current == null) return null;

        if (nama.compareToIgnoreCase(current.data.nama) < 0) {
            current.kiri = hapusRekursif(current.kiri, nama);
        } else if (nama.compareToIgnoreCase(current.data.nama) > 0) {
            current.kanan = hapusRekursif(current.kanan, nama);
        } else {
            if (current.kiri == null) return current.kanan;
            if (current.kanan == null) return current.kiri;

            Barang terkecil = cariMin(current.kanan);
            current.data = terkecil;
            current.kanan= hapusRekursif(current.kanan, terkecil.nama);
        }
        return current;
    }

    private Barang cariMin(NodeTree root) {
        Barang min = root.data;
        while (root.kiri != null) {
            min = root.kiri.data;
            root = root.kiri;
        }
        return min;
    }

    public void tampilkanSemua() {
        inOrder(root);
    }

    private void inOrder(NodeTree node) {
        if (node != null) {
            inOrder(node.kiri);
            System.out.println(node.data);
            inOrder(node.kanan);
        }
    }
}
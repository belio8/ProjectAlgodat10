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
        int comparison = nama.compareToIgnoreCase(current.data.nama);

        if (comparison == 0) {
            return current.data; 
        } else if (comparison < 0) {
            return searchRecursive(current.kiri, nama);
        } else {
            return searchRecursive(current.kanan, nama);
        }

    }

    public void tampilkanSemua() {
        if (root == null) System.out.println("   (Gudang Kosong)");
        else inOrder(root);
    }

    private void inOrder(NodeTree node) {
        if (node != null) {
            inOrder(node.kiri);
            System.out.println("   " + node.data.getInfo());
            inOrder(node.kanan);
        }
    }
}
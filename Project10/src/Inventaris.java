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

        if (comparison == 0) return current.data;
        else if (comparison < 0) return searchRecursive(current.kiri, nama);
        else return searchRecursive(current.kanan, nama);
    }

    public void tampilkanSemua() {
        if (root == null) {
            System.out.println(Warna.RED + "   (Gudang Kosong)" + Warna.RESET);
        } else {
            System.out.printf("%-25s %-10s %2s %-10s %-10s%n", "Nama", "Harga"," ", "Stok", "Terjual");
            System.out.println("-----------------------------------------------");
            if (!adaStok(root)) {
                System.out.println(Warna.RED + "   (Semua barang habis)" + Warna.RESET);
            } else {
                inOrder(root);
            }
        }
    }

    private void inOrder(NodeTree node) {
        if (node != null) {
            inOrder(node.kiri);
            if (node.data.stok > 0) {
                String warnaStok = node.data.stok < 5 ? Warna.RED : Warna.GREEN;
                System.out.printf("%-25s %2s %-10d " + warnaStok + "%-10d" + Warna.RESET + " %-10d%n",
                    node.data.nama, "Rp", node.data.harga, node.data.stok, node.data.terjual);
            }
            inOrder(node.kanan);
        }
    }

    private boolean adaStok(NodeTree node) {
        if (node == null) return false;
        if (node.data.stok > 0) return true;
        return adaStok(node.kiri) || adaStok(node.kanan);
    }
    private Barang cariBarangPalingLarisRekursif(NodeTree node, Barang currentMax) {
        if (node == null) return currentMax;

        if (currentMax == null || node.data.terjual > currentMax.terjual) {
            currentMax = node.data;
        }

        currentMax = cariBarangPalingLarisRekursif(node.kiri, currentMax);
        currentMax = cariBarangPalingLarisRekursif(node.kanan, currentMax);

        return currentMax;
    }

    public Barang cariBarangPalingLaris() {
        Barang hasil = cariBarangPalingLarisRekursif(root, null);
        if (hasil == null || hasil.terjual == 0) {
            System.out.println(">> Belum ada barang yang terjual.");
            return null;
        }
        return hasil;
    }
    public Barang cariBarangTermurah() {
        return cariTermurah(root, null);
    }

    private Barang cariTermurah(NodeTree node, Barang min) {
        if (node == null) return min;
        if (min == null || node.data.harga < min.harga) min = node.data;
        min = cariTermurah(node.kiri, min);
        min = cariTermurah(node.kanan, min);
        return min;
    }
    public Barang cariBarangTermahal() {
        return cariTermahal(root, null);
    }

    private Barang cariTermahal(NodeTree node, Barang max) {
        if (node == null) return max;
        if (max == null || node.data.harga > max.harga) max = node.data;
        max = cariTermahal(node.kiri, max);
        max = cariTermahal(node.kanan, max);
        return max;
    }
    public void top3BarangLaris() {
        Barang max1 = null, max2 = null, max3 = null;
        max1 = cariTop(root, max1, max2, max3, 1);
        max2 = cariTop(root, max1, max2, max3, 2);
        max3 = cariTop(root, max1, max2, max3, 3);

        if (max1 != null) System.out.println("1. " + max1.getInfo());
        if (max2 != null) System.out.println("2. " + max2.getInfo());
        if (max3 != null) System.out.println("3. " + max3.getInfo());
    }

    private Barang cariTop(NodeTree node, Barang max1, Barang max2, Barang max3, int posisi) {
        if (node == null) return (posisi == 1 ? max1 : posisi == 2 ? max2 : max3);
        Barang b = node.data;

        if (posisi == 1) {
            if (max1 == null || b.terjual > max1.terjual) max1 = b;
        } else if (posisi == 2) {
            if ((max2 == null || b.terjual > max2.terjual) && b != max1) max2 = b;
        } else if (posisi == 3) {
            if ((max3 == null || b.terjual > max3.terjual) && b != max1 && b != max2) max3 = b;
        }

        max1 = cariTop(node.kiri, max1, max2, max3, 1);
        max2 = cariTop(node.kiri, max1, max2, max3, 2);
        max3 = cariTop(node.kiri, max1, max2, max3, 3);

        max1 = cariTop(node.kanan, max1, max2, max3, 1);
        max2 = cariTop(node.kanan, max1, max2, max3, 2);
        max3 = cariTop(node.kanan, max1, max2, max3, 3);

        return (posisi == 1 ? max1 : posisi == 2 ? max2 : max3);
    }
}
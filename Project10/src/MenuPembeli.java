import java.util.Scanner;

public class MenuPembeli {
    public static void tampilkan(Scanner scanner, Inventaris gudang, AntrianKasir kasir) {
        System.out.print("\nMasukkan Nama Anda: ");
        String namaPembeli = scanner.nextLine();
        KeranjangBelanja keranjang = new KeranjangBelanja();
        
        boolean belanja = true;
        while (belanja) {
            System.out.println("\n--- Halo " + namaPembeli + " ---");
            System.out.println("1. Lihat Barang");
            System.out.println("2. Cari & Beli");
            System.out.println("3. Cek Keranjang");
            System.out.println("4. Checkout");
            System.out.print("Pilih: ");
            
            int p = scanner.nextInt();
            scanner.nextLine();

            switch (p) {
                case 1: gudang.tampilkanSemua(); break;
                case 2:
                    System.out.print("Cari nama: ");
                    String cari = scanner.nextLine();
                    Barang b = gudang.cari(cari);
                    if (b != null) {
                        System.out.println(b.getInfo());
                        System.out.print("Beli berapa? ");
                        int qty = scanner.nextInt();
                        if (qty <= b.stok && qty > 0) {
                            keranjang.push(b, qty);
                            b.stok -= qty;
                            System.out.println(">> Masuk keranjang!");
                        } else System.out.println(">> Stok kurang/input salah.");
                    } else System.out.println(">> Barang tidak ada.");
                    break;
                case 3:
                    if (keranjang.isEmpty()) System.out.println("Keranjang kosong.");
                    else keranjang.hitungTotal();
                    break;
                case 4:
                    if (!keranjang.isEmpty()) {
                        kasir.tambahPelanggan(namaPembeli, keranjang);
                        belanja = false;
                    } else {
                        System.out.println("Belum belanja.");
                        System.out.print("Keluar? (y/n): ");
                        if(scanner.next().equalsIgnoreCase("y")) belanja = false;
                    }
                    break;
                default: System.out.println("Pilihan salah.");
            }
        }
    }
}
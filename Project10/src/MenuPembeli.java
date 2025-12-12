import java.util.Scanner;

public class MenuPembeli {
    public static void tampilkan(Scanner scanner, Inventaris gudang, AntrianKasir kasir) {
        System.out.print("\nMasukkan Nama Anda: ");
        String namaPembeli = scanner.nextLine();
        KeranjangBelanja keranjang = new KeranjangBelanja();
        
        boolean belanja = true;
        while (belanja) {
            System.out.println(Warna.CYAN + "====================================" + Warna.RESET);
            System.out.println(Warna.CYAN + "        MENU PEMBELI - " + namaPembeli + Warna.RESET);
            System.out.println(Warna.CYAN + "====================================" + Warna.RESET);
            System.out.println(Warna.YELLOW + "1. Lihat Barang" + Warna.RESET);
            System.out.println(Warna.YELLOW + "2. Cari & Beli" + Warna.RESET);
            System.out.println(Warna.YELLOW + "3. Edit Item" + Warna.RESET);
            System.out.println(Warna.YELLOW + "4. Cek Keranjang" + Warna.RESET);
            System.out.println(Warna.YELLOW + "5. Kosongkan Keranjang" + Warna.RESET);
            System.out.println(Warna.RED + "6. Pergi ke Kasir" + Warna.RESET);
            System.out.println(Warna.RED + "7. Kembali" + Warna.RESET);
            System.out.print(Warna.BLUE + "Pilih: " + Warna.RESET);
            
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
                    System.out.print("Nama barang di keranjang: ");
                    String editNama = scanner.nextLine();
                    System.out.print("Qty baru (0 untuk hapus): ");
                    int qtyBaru = scanner.nextInt(); 
                    scanner.nextLine();
                    boolean edited = keranjang.editQty(editNama, qtyBaru);
                    if (!edited) {
                        System.out.println(Warna.RED + "Edit gagal: barang tidak ada atau stok tidak cukup." + Warna.RESET);
                    } else {
                        System.out.println(Warna.GREEN + "Qty diperbarui / item dihapus." + Warna.RESET);
                    }
                    break;
                case 4:
                    if (keranjang.isEmpty()) System.out.println("Keranjang kosong.");
                    else keranjang.hitungTotal();
                    break;
                case 5:
                    keranjang.kembalikanSemuaStok();
                    System.out.println(Warna.RED + "Keranjang berhasil dikosongkan " + Warna.RESET);
                    break;
                case 6:
                    System.out.print("Menuju antrian kasir? (y/n): ");
                    String ya = scanner.nextLine();
                    if (ya.equalsIgnoreCase("y")) {
                        kasir.tambahPelanggan(namaPembeli, keranjang);
                        System.out.println(Warna.GREEN + "Berhasil masuk antrian " + Warna.RESET);
                        belanja = false;
                    } else {
                        keranjang.kembalikanSemuaStok();
                        System.out.println(Warna.RED + "Pembelian telah dibatalkan " + Warna.RESET);
                    }
                    break;
                case 7:
                    if (!keranjang.isEmpty()) {
                        System.out.print("Keranjang belum kosong. Keluar? (y/n): ");
                        if (scanner.nextLine().equalsIgnoreCase("y")) {
                            keranjang.kembalikanSemuaStok();
                            belanja = false;
                        }
                    } else {
                        System.out.print("Keluar? (y/n): ");
                        if(scanner.nextLine().equalsIgnoreCase("y")) belanja = false;
                    }
                    break;
                default: System.out.println("Pilihan salah.");
            }
        }
    }
}
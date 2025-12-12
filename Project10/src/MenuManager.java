import java.util.Scanner;

public class MenuManager {
    public static void tampilkan(Scanner scanner, Inventaris gudang, RiwayatTransaksi history) {
        boolean back = false;
        while (!back) {
            System.out.println(Warna.CYAN + "====================================" + Warna.RESET);
            System.out.println(Warna.CYAN + "            MENU MANAGER            " + Warna.RESET);
            System.out.println(Warna.CYAN + "====================================" + Warna.RESET);
            System.out.println(Warna.YELLOW + "1. Lihat Stok (Tree A-Z)" + Warna.RESET);
            System.out.println(Warna.YELLOW + "2. Tambah Stok" + Warna.RESET);
            System.out.println(Warna.YELLOW + "3. Lihat History Penjualan" + Warna.RESET);
            System.out.println(Warna.YELLOW + "4. Urutkan History (Highest Total)" + Warna.RESET);
            System.out.println(Warna.GREEN  + "5. Lihat Barang Paling Laris" + Warna.RESET);
            System.out.println(Warna.YELLOW + "6. Lihat Barang Termurah" + Warna.RESET);
            System.out.println(Warna.YELLOW + "7. Lihat Barang Termahal" + Warna.RESET);
            System.out.println(Warna.YELLOW + "8. Top 3 Barang Laris" + Warna.RESET);
            System.out.println(Warna.YELLOW + "9. Total Penjualan Harian" + Warna.RESET);
            System.out.println(Warna.RED + "10. Kembali" + Warna.RESET);
            int p = scanner.nextInt();
            scanner.nextLine();

            switch (p) {
                case 1:
                    gudang.tampilkanSemua();
                    break;
                case 2:
                    System.out.print("Nama Barang: ");
                    String nama = scanner.nextLine();
                    System.out.print("Harga: ");
                    int harga = scanner.nextInt();
                    System.out.print("Stok: ");
                    int stok = scanner.nextInt();
                    if (harga <= 0 || stok <= 0) {
                        System.out.println(Warna.RED + "Harga/Stok harus lebih dari 0." + Warna.RESET);
                        break;
                    }
                    gudang.tambah(nama, harga, stok);
                    break;
                case 3:
                    System.out.println("\n--- DATA PENJUALAN ---");
                    history.tampilkan();
                    break;
                case 4:
                    history.urutkanHistory();
                    history.tampilkan();
                    break;
                case 5:
                    Barang laris = gudang.cariBarangPalingLaris();
                    if (laris != null) {
                        System.out.println(">> Barang paling laris: " + laris.getInfo());
                    } else {
                        System.out.println(">> Gudang kosong.");
                    }
                    break;
                case 6:
                    Barang murah = gudang.cariBarangTermurah();
                    if (murah != null) {
                        System.out.println(">> Barang termurah: " + murah.getInfo());
                    } else {
                        System.out.println(">> Gudang kosong.");
                    }
                    break;

                case 7:
                    Barang mahal = gudang.cariBarangTermahal();
                    if (mahal != null) {
                        System.out.println(">> Barang termahal: " + mahal.getInfo());
                    } else {
                        System.out.println(">> Gudang kosong.");
                    }
                    break;

                case 8:
                    System.out.println(">> Top 3 Barang Laris:");
                    gudang.top3BarangLaris();
                    break;
                case 9:
                    int totalHariIni = history.totalPenjualan();
                    System.out.println(">> Total penjualan (kumulatif): Rp " + totalHariIni);
                    break;
                case 10:
                    back = true;
                    break;
                default: System.out.println("Pilihan salah.");
            }
        }
    }
}
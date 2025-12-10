import java.util.Scanner;

public class MenuManager {
    public static void tampilkan(Scanner scanner, Inventaris gudang, RiwayatTransaksi history) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- MANAGER MENU ---");
            System.out.println("1. Lihat Stok (Tree A-Z)");
            System.out.println("2. Tambah Stok");
            System.out.println("3. Lihat History Penjualan");
            System.out.println("4. Urutkan History (Selection Sort - Highest Total)");
            System.out.println("5. Kembali");
            System.out.print("Pilih: ");
            
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
                case 5: back = true; break;
                default: System.out.println("Pilihan salah.");
            }
        }
    }
}
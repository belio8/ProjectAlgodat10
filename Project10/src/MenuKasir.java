import java.util.Scanner;

public class MenuKasir {
    public static void tampilkan(Scanner scanner, AntrianKasir kasir, RiwayatTransaksi history) {
        boolean stay = true;
        while (stay) {
            System.out.println("\n--- MENU KASIR ---");
            System.out.println("1. Lihat Daftar Antrian"); 
            System.out.println("2. Proses Transaksi (Terdepan)");
            System.out.println("3. Kembali");
            System.out.print("Pilih: ");
            
            int p = scanner.nextInt();
            scanner.nextLine();

            switch (p) {
                case 1:
                    kasir.lihatAntrian(); 
                    break;
                case 2:
                    if (kasir.isEmpty()) {
                        System.out.println(">> Antrian kosong.");
                    } else {
                        Pelanggan current = kasir.hapusPelanggan();
                        if (current != null) {
                            System.out.println("\n--- STRUK: " + current.nama + " ---");
                            int total = current.keranjang.hitungTotal();
                            System.out.println("------------------------------");
                            System.out.println("TOTAL BAYAR: Rp " + total);
                            
                            history.push(current.nama, total);
                            System.out.println(">> Transaksi selesai.");
                        }
                    }
                    break;
                case 3: stay = false; break;
                default: System.out.println("Pilihan salah.");
            }
        }
    }
}
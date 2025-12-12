import java.util.Scanner;

public class MenuKasir {
    public static void tampilkan(Scanner scanner, AntrianKasir kasir, RiwayatTransaksi history) {
        boolean stay = true;
        while (stay) {
            System.out.println(Warna.CYAN + "====================================" + Warna.RESET);
            System.out.println(Warna.CYAN + "             MENU KASIR             " + Warna.RESET);
            System.out.println(Warna.CYAN + "====================================" + Warna.RESET);
            System.out.println(Warna.YELLOW + "1. Lihat Daftar Antrian" + Warna.RESET);
            System.out.println(Warna.YELLOW + "2. Proses Transaksi (Terdepan)" + Warna.RESET);
            System.out.println(Warna.RED + "3. Kembali" + Warna.RESET);
            System.out.print(Warna.BLUE + "Pilih: " + Warna.RESET);

            int p = scanner.nextInt();
            scanner.nextLine();

            switch (p) {
                case 1:
                    kasir.lihatAntrian(); 
                    break;
                case 2:
                    if (kasir.isEmpty()) {
                        System.out.println(Warna.RED + ">> Antrian kosong." + Warna.RESET);
                    } else {
                        Pelanggan current = kasir.hapusPelanggan();
                        if (current != null) {
                            // === STRUK BELANJA dengan border & warna ===
                            System.out.println(Warna.CYAN + "====================================" + Warna.RESET);
                            System.out.println(Warna.CYAN + "             STRUK BELANJA          " + Warna.RESET);
                            System.out.println(Warna.CYAN + "====================================" + Warna.RESET);
                            System.out.println("Pelanggan: " + current.nama);

                            // tampilkan detail diskon per item
                            int total = current.keranjang.hitungTotalDenganDiskon();

                            // update jumlah terjual per barang
                            Keranjang item = current.keranjang.head;
                            while (item != null) {
                                item.barang.terjual += item.qty;
                                item = item.next;
                            }

                            System.out.println("------------------------------------");
                            System.out.println(Warna.GREEN + "TOTAL BAYAR: Rp " + total + Warna.RESET);
                            System.out.println(Warna.CYAN + "====================================" + Warna.RESET);

                            history.push(current.nama, total);
                            System.out.println(Warna.BLUE + ">> Transaksi selesai." + Warna.RESET);
                        }
                    }
                    break;
                case 3: 
                    stay = false; 
                    break;
                default: 
                    System.out.println(Warna.RED + "Pilihan salah." + Warna.RESET);
            }
        }
    }
}

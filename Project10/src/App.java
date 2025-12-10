import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    
    static Inventaris gudang = new Inventaris();
    static AntrianKasir kasir = new AntrianKasir();
    static RiwayatTransaksi history = new RiwayatTransaksi();

    public static void main(String[] args) {
    // ================== MAKANAN INSTANT ==================
    gudang.tambah("Indomie Goreng", 3500, 50);
    gudang.tambah("Indomie Ayam Bawang", 3500, 40);
    gudang.tambah("Mie Sedap Soto", 4000, 30);
    gudang.tambah("Sarimi Kari Ayam", 3000, 25);
    gudang.tambah("Pop Mie Ayam", 5000, 20);
    gudang.tambah("Supermi Soto", 3500, 35);
    gudang.tambah("Mie Gelas", 2500, 40);
    gudang.tambah("Koka Mie Pedas", 4500, 15);
    gudang.tambah("Ramen Instan", 8000, 10);
    gudang.tambah("Mie Korea Samyang", 15000, 12);

    // ================== MINUMAN ==================
    gudang.tambah("Aqua Botol 600ml", 3000, 100);
    gudang.tambah("Le Minerale 600ml", 3500, 80);
    gudang.tambah("Teh Botol Sosro", 5000, 60);
    gudang.tambah("Kopi Kapal Api Sachet", 2000, 120);
    gudang.tambah("Good Day Cappuccino", 4000, 70);
    gudang.tambah("Sprite Kaleng", 7000, 50);
    gudang.tambah("Coca Cola Kaleng", 7000, 50);
    gudang.tambah("Fanta Strawberry", 7000, 40);
    gudang.tambah("Pocari Sweat", 8000, 30);
    gudang.tambah("You C1000 Lemon", 10000, 25);

    // ================== ROTI & SNACK ==================
    gudang.tambah("Roti Tawar", 12000, 20);
    gudang.tambah("Roti Coklat", 8000, 25);
    gudang.tambah("Biskuit Roma Kelapa", 7000, 40);
    gudang.tambah("Chitato BBQ", 12000, 30);
    gudang.tambah("Taro Net", 6000, 35);
    gudang.tambah("SilverQueen Coklat", 15000, 15);
    gudang.tambah("Oreo Original", 10000, 40);
    gudang.tambah("Tango Wafer", 8000, 30);
    gudang.tambah("Kacang Garuda", 12000, 25);
    gudang.tambah("Kue Pia", 15000, 20);

    // ================== PRODUK SUSU ==================
    gudang.tambah("Susu Ultra 1L", 18000, 25);
    gudang.tambah("Susu Frisian Flag Sachet", 2000, 100);
    gudang.tambah("Yogurt Cimory", 10000, 20);
    gudang.tambah("Keju Kraft", 30000, 12);
    gudang.tambah("Susu Greenfields", 25000, 15);
    gudang.tambah("Yakult", 12000, 30);
    gudang.tambah("Susu Kental Manis Bendera", 15000, 25);
    gudang.tambah("Susu Milo Sachet", 3000, 50);
    gudang.tambah("Susu Bear Brand", 10000, 20);
    gudang.tambah("Susu Dancow Bubuk", 35000, 10);

    // ================== BAHAN POKOK ==================
    gudang.tambah("Beras 5kg", 65000, 10);
    gudang.tambah("Minyak Goreng 1L", 18000, 35);
    gudang.tambah("Gula Pasir 1kg", 15000, 25);
    gudang.tambah("Telur Ayam 1kg", 28000, 30);
    gudang.tambah("Garam Dapur 500g", 5000, 40);
    gudang.tambah("Tepung Terigu 1kg", 12000, 20);
    gudang.tambah("Kecap ABC 600ml", 18000, 15);
    gudang.tambah("Saus Sambal ABC", 15000, 20);
    gudang.tambah("Saus Tomat Del Monte", 15000, 20);
    gudang.tambah("Bumbu Masako Ayam", 2000, 50);

    // ================== PRODUK KEBERSIHAN ==================
    gudang.tambah("Sabun Lifebuoy", 5000, 80);
    gudang.tambah("Shampoo Sunsilk", 20000, 15);
    gudang.tambah("Pasta Gigi Pepsodent", 12000, 25);
    gudang.tambah("Detergen Rinso 1kg", 25000, 20);
    gudang.tambah("Pewangi Molto", 15000, 18);
    gudang.tambah("Sabun Mandi Lux", 6000, 40);
    gudang.tambah("Shampoo Pantene", 25000, 20);
    gudang.tambah("Sabun Cuci Sunlight", 12000, 30);
    gudang.tambah("Hand Sanitizer 100ml", 15000, 25);
    gudang.tambah("Tissue Basah", 10000, 30);

    // ================== PRODUK RUMAH TANGGA ==================
    gudang.tambah("Tisu Paseo", 10000, 50);
    gudang.tambah("Plastik Sampah 50L", 12000, 30);
    gudang.tambah("Lampu LED 10W", 25000, 15);
    gudang.tambah("Baterai AA Isi 2", 15000, 20);
    gudang.tambah("Sapu Ijuk", 20000, 10);
    gudang.tambah("Pel Lantai", 30000, 12);
    gudang.tambah("Ember Plastik", 25000, 15);
    gudang.tambah("Gayung Plastik", 10000, 20);
    gudang.tambah("Kain Pel", 15000, 25);
    gudang.tambah("Kipas Angin Mini", 75000, 8);

    // ================== PRODUK ALAT TULIS ==================
    gudang.tambah("Pulpen Pilot", 5000, 40);
    gudang.tambah("Buku Tulis Sidu", 3000, 60);
    gudang.tambah("Penghapus Joyko", 2000, 50);
    gudang.tambah("Pensil 2B", 2500, 70);
    gudang.tambah("Lakban Bening", 8000, 25);
    gudang.tambah("Spidol Snowman", 6000, 30);
    gudang.tambah("Penggaris 30cm", 5000, 20);
    gudang.tambah("Stabilo Highlighter", 10000, 15);
    gudang.tambah("Binder Notebook", 25000, 10);
    gudang.tambah("Kertas HVS 500 lembar", 45000, 12);

    // ================== PRODUK LAINNYA ==================
    gudang.tambah("Masker Medis 50pcs", 25000, 20);
    gudang.tambah("Obat Nyamuk Elektrik", 30000, 15);
    gudang.tambah("Obat Nyamuk Bakar", 5000, 40);
    gudang.tambah("Vitamin C Tablet", 35000, 10);
    gudang.tambah("Minyak Kayu Putih", 20000, 15);
    gudang.tambah("Plester Hansaplast", 10000, 30);
    gudang.tambah("Termometer Digital", 50000, 8);
    gudang.tambah("Korek Gas", 5000, 50);
    gudang.tambah("Lilin Putih", 8000, 25);
    gudang.tambah("Obat Batuk Komix", 7000, 20);

        boolean running = true;
        while (running) {
            System.out.println(Warna.CYAN + "===============================" + Warna.RESET);
            System.out.println(Warna.CYAN + "           S-MART JAVA         " + Warna.RESET);
            System.out.println(Warna.CYAN + "===============================" + Warna.RESET);
            System.out.println(Warna.YELLOW + "1. Login Manager" + Warna.RESET);
            System.out.println(Warna.YELLOW + "2. Login Pembeli" + Warna.RESET);
            System.out.println(Warna.YELLOW + "3. Login Kasir" + Warna.RESET);
            System.out.println(Warna.RED + "4. Keluar" + Warna.RESET);
            System.out.print(Warna.BLUE + "Pilih Menu: " + Warna.RESET);
            
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                scanner.nextLine(); 

                switch (menu) {
                    case 1: MenuManager.tampilkan(scanner, gudang, history); break;
                    case 2: MenuPembeli.tampilkan(scanner, gudang, kasir); break;
                    case 3: MenuKasir.tampilkan(scanner, kasir, history); break;
                    case 4: running = false; break;
                    default: System.out.println("Menu salah.");
                }
            } else {
                System.out.println("Input harus angka.");
                scanner.next();
            }
        }
    }
}
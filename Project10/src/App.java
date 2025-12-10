import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    
    static Inventaris gudang = new Inventaris();
    static AntrianKasir kasir = new AntrianKasir();
    static RiwayatTransaksi history = new RiwayatTransaksi();

    public static void main(String[] args) {
        gudang.tambah("Indomie", 3500, 50);
        gudang.tambah("Aqua", 3000, 100);
        gudang.tambah("Roti", 12000, 20);
        gudang.tambah("Susu", 6000, 30);

        boolean running = true;
        while (running) {
            System.out.println("\n=== SISTEM MINIMARKET JAVA ===");
            System.out.println("1. Login Manager");
            System.out.println("2. Login Pembeli");
            System.out.println("3. Login Kasir");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu: ");
            
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
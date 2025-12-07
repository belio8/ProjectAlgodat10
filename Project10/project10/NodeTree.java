//node tree buat nama pegawai dan jabatan (belum di edit)
public class NodeTree {
    String nama;
    String jabatan;
    NodeTree kiri, kanan;

    NodeTree(String nama,String jabatan) {
        this.nama = nama;
        this.jabatan = jabatan;
    }
}
import java.util.Scanner;

public class Tugas105 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hargaTiket = 50000;
        int totalTiket = 0;
        int totalPenjualan = 0;
        int jumlah;

        do {
            System.out.print("Masukkan jumlah tiket (0 untuk selesai): ");
            jumlah = sc.nextInt();

            if (jumlah < 0) {
                System.out.println("Input tidak valid. Masukkan lagi!");
                continue;
            }
            if (jumlah == 0) {
                break;
            }

            int harga = jumlah * hargaTiket;
            int diskon = 0;
            if (jumlah > 10) {
                diskon = harga * 15 / 100;
            } else if (jumlah > 4) {
                diskon = harga * 10 / 100;
            }
            int bayar = harga - diskon;

            System.out.println("Total bayar: Rp " + bayar);
            totalTiket += jumlah;
            totalPenjualan += bayar;
        } while (true);

        System.out.println("Total tiket terjual: " + totalTiket);
        System.out.println("Total penjualan: Rp " + totalPenjualan);
        sc.close();
    }
}

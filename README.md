# JOBSHEET 7 – LOOPS 1 (PERULANGAN 1)

## Identitas Mahasiswa:

* **Nama:** Cantika Putri Fauzan 
* **NIM:** 264107020237
* **Kelas / No. Presensi:** 1I / 05

## 1: TUJUAN PRAKTIKUM

The following are the objectives of this practical session:

1. Students can explain the writing format of loop programs (`for`, `while`, and `do-while`).
2. Students can implement loop flowcharts using the Java programming language.

### 2.1 Experiment 1: Student Scores in SIAKAD – FOR Loop

#### 2.1.1 Description

A lecturer wants to find the highest and lowest quiz scores of 10 students in one class. The lecturer enters the score of every student, then the program determines and displays the highest and the lowest score. The program is built from the given flowchart using a `for` loop.

#### 2.1.2 Java Program Code

The code below already includes the modification required in Question 4 (counting students who pass and fail, with the passing grade = 60).

```java
import java.util.Scanner;

public class SiakadFor05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double nilai, tertinggi = 0, terendah = 100;
        int lulus = 0, tidakLulus = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Masukkan nilai mahasiswa ke-" + i + ": ");
            nilai = sc.nextDouble();
            if (nilai > tertinggi) {
                tertinggi = nilai;
            }
            if (nilai < terendah) {
                terendah = nilai;
            }
            if (nilai >= 60) {
                lulus++;
            } else {
                tidakLulus++;
            }
        }

        System.out.println("Nilai tertinggi: " + tertinggi);
        System.out.println("Nilai terendah: " + terendah);
        System.out.println("Jumlah mahasiswa lulus: " + lulus);
        System.out.println("Jumlah mahasiswa tidak lulus: " + tidakLulus);
        sc.close();
    }
}
```

#### 2.1.3 Hasil Running / Screenshot Output

<img width="500" height="272" alt="Image" src="https://github.com/user-attachments/assets/878fae79-6aaa-4c8f-9601-f303c6ee971d" />

#### 2.1.4 Questions & Answers

**1. State and show each component of the FOR loop in the Experiment 1 program.**

```java
for (int i = 1; i <= 10; i++) {
    // loop body
}
```

| Component | Code | Function |
|-----------|------|----------|
| Initialization | `int i = 1` | Creates the counter variable and sets its starting value (runs once). |
| Condition | `i <= 10` | Checked before every iteration; the loop continues while it is `true`. |
| Update | `i++` | Increases the counter by 1 after every iteration. |
| Body | the statements inside `{ ... }` | The input and the comparison of scores that are repeated 10 times. |

**2. Why is `tertinggi` initialized to 0 and `terendah` to 100? What happens if `tertinggi` is initialized to 100 and `terendah` to 0?**

A score is in the range 0–100. Setting `tertinggi = 0` (the smallest possible score) guarantees that the first entered score is greater than or equal to it, so it can replace the initial value. Setting `terendah = 100` (the largest possible score) guarantees that any score will be smaller than it and can replace it. The initial values must be the "worst case" so the real data can always override them.

If they are swapped (`tertinggi = 100`, `terendah = 0`), the conditions `nilai > tertinggi` (greater than 100) and `nilai < terendah` (less than 0) can never be true for valid scores. The variables never change, and the program would always print the wrong result: highest = 100.0 and lowest = 0.0, regardless of the input.

**3. Explain the function and workflow of this code snippet.**

```java
if (nilai > tertinggi) {
    tertinggi = nilai;
}
if (nilai < terendah) {
    terendah = nilai;
}
```

The snippet finds the maximum and minimum values among all inputs. In each iteration:
1. The first `if` compares the new score with the highest score recorded so far. If the new score is greater, `tertinggi` is updated.
2. The second `if` compares the new score with the lowest score recorded so far. If the new score is smaller, `terendah` is updated.

The two `if` statements are separate (not `else if`), so both conditions are always checked for each score. For example, the first score entered can update both variables at once. After 10 iterations, `tertinggi` and `terendah` hold the extreme values.

**4. Modify the program to count how many students pass and fail (minimum passing score = 60).**

Two counters, `lulus` and `tidakLulus`, are declared before the loop, and the following check is placed inside the loop:

```java
if (nilai >= 60) {
    lulus++;
} else {
    tidakLulus++;
}
```

The counts are displayed after the highest and lowest score (see the full code in 2.1.2). For the sample data: 9 students pass and 1 student (55.3) fails.

---

### 2.2 Experiment 2: Student Scores in SIAKAD – WHILE Loop

#### 2.2.1 Description

The program asks the lecturer to enter the score of each student. An invalid score (negative or greater than 100) is ignored and the lecturer is asked to re-enter it. Valid scores are converted into letter grades: A (80 < score ≤ 100), B+ (73 < score ≤ 80), B (65 < score ≤ 73), C+ (60 < score ≤ 65), C (50 < score ≤ 60), D (39 < score ≤ 50), and E (score ≤ 39).

#### 2.2.2 Java Program Code

The code below already includes the modification required in Question 4 (extra message for grade A).

```java
import java.util.Scanner;

public class SiakadWhile05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nilai, jml, i = 0;

        System.out.print("Masukkan jumlah mahasiswa: ");
        jml = sc.nextInt();

        while (i < jml) {
            System.out.print("Masukkan nilai mahasiswa ke-" + (i + 1) + ": ");
            nilai = sc.nextInt();

            if (nilai < 0 || nilai > 100) {
                System.out.println("Nilai tidak valid. Masukkan lagi nilai yang valid!");
                continue;
            }

            if (nilai > 80 && nilai <= 100) {
                System.out.println("Nilai mahasiswa ke-" + (i + 1) + " adalah A");
                System.out.println("Bagus, pertahankan nilainya");
            } else if (nilai > 73 && nilai <= 80) {
                System.out.println("Nilai mahasiswa ke-" + (i + 1) + " adalah B+");
            } else if (nilai > 65 && nilai <= 73) {
                System.out.println("Nilai mahasiswa ke-" + (i + 1) + " adalah B");
            } else if (nilai > 60 && nilai <= 65) {
                System.out.println("Nilai mahasiswa ke-" + (i + 1) + " adalah C+");
            } else if (nilai > 50 && nilai <= 60) {
                System.out.println("Nilai mahasiswa ke-" + (i + 1) + " adalah C");
            } else if (nilai > 39 && nilai <= 50) {
                System.out.println("Nilai mahasiswa ke-" + (i + 1) + " adalah D");
            } else {
                System.out.println("Nilai mahasiswa ke-" + (i + 1) + " adalah E");
            }
            i++;
        }
        sc.close();
    }
}
```

#### 2.2.3 Hasil Running / Screenshot Output

<img width="548" height="206" alt="Image" src="https://github.com/user-attachments/assets/6ce8915d-b680-44e2-9b53-0f1437564688" />

#### 2.2.4 Questions & Answers

**1. Determine the meaning and purpose of the following syntax.**

**a. `nilai < 0 || nilai > 100`**

This is a compound condition using the logical OR operator (`||`). It is `true` if the score is less than 0 **or** greater than 100, that is, whenever the score is outside the valid range 0–100. It is used for input validation: if the condition is true, the input is treated as invalid.

**b. `continue`**

`continue` skips the remaining statements in the current iteration and jumps straight back to the loop condition check (`i < jml`). Here it skips the grade classification and the `i++` statement for an invalid score. Because `i` is not increased, the same student number is asked again, so the lecturer must re-enter a valid score.

**2. Why is `i++` written at the end of the WHILE loop? What happens if it is written at the beginning?**

`i` counts how many students have been processed successfully, and it starts at 0. `i++` is at the end so that it only runs after a valid score has been classified. When an invalid score occurs, `continue` jumps over `i++`, so the invalid entry is not counted.

If `i++` were written at the beginning, `i` would increase before the score is validated, so an invalid entry would still be counted and use up one of the `jml` slots. The program would then process fewer valid students than requested. Also, the displayed number `(i + 1)` would be shifted by one (the first student would be shown as "ke-2").

**3. If the number of students entered is 19, how many times does the WHILE loop run?**

The loop body completes **19 times** (for `i = 0` to `i = 18`) if all scores are valid. Every invalid score causes one extra pass through the loop (ended by `continue`) without increasing `i`, so the real number of passes is 19 plus the number of invalid inputs.

**4. Modify the program to show the additional message "Bagus, pertahankan nilainya" when a student gets an A.**

Add one more line inside the grade-A branch:

```java
if (nilai > 80 && nilai <= 100) {
    System.out.println("Nilai mahasiswa ke-" + (i + 1) + " adalah A");
    System.out.println("Bagus, pertahankan nilainya");
}

```

### 2.3 Experiment 3: Cafe Transactions – DO-WHILE Loop

#### 2.3.1 Description

A cashier processes the transactions of several customers. A customer can buy coffee (Rp 12.000), tea (Rp 7.000), and bread (Rp 20.000). The cashier keeps entering purchases for each customer until a customer name "batal" is entered, which stops the program.

#### 2.3.2 Java Program Code

```java
import java.util.Scanner;

public class KafeDoWhile05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kopi, teh, roti, totalHarga;
        String namaPelanggan;
        int hargaKopi = 12000;
        int hargaTeh = 7000;
        int hargaRoti = 20000;

        do {
            System.out.print("Masukkan nama pelanggan (ketik 'batal' untuk keluar): ");
            namaPelanggan = sc.nextLine();
            if (namaPelanggan.equalsIgnoreCase("batal")) {
                System.out.println("Transaksi dibatalkan.");
                break;
            }
            System.out.print("Jumlah kopi: ");
            kopi = sc.nextInt();
            System.out.print("Jumlah teh: ");
            teh = sc.nextInt();
            System.out.print("Jumlah roti: ");
            roti = sc.nextInt();

            totalHarga = (kopi * hargaKopi) + (teh * hargaTeh) + (roti * hargaRoti);
            System.out.println("Total yang harus dibayar: Rp " + totalHarga);
            sc.nextLine(); // clears the leftover newline from the buffer
        } while (true);

        System.out.println("Semua transaksi selesai.");
        sc.close();
    }
}
```

#### 2.3.3 Hasil Running / Screenshot Output

<img width="443" height="163" alt="Image" src="https://github.com/user-attachments/assets/5dd1a3d2-9a41-43c4-8dd1-b808ec10cc04" />
<img width="599" height="178" alt="Image" src="https://github.com/user-attachments/assets/3d35cb6f-8c2c-4f33-82f8-808f754cec4b" />

#### 2.3.4 Questions & Answers

**1. In this DO-WHILE, if the first customer name entered is "batal", how many times is the loop executed?**

**Once.** A `do-while` loop always executes its body at least one time before checking the condition. The name is read and compared in that first pass, and `break` ends the loop immediately, so no purchase is processed.

**2. State the stopping condition used in this DO-WHILE loop.**

The loop stops when the entered customer name equals "batal" (ignoring upper/lower case), i.e. `namaPelanggan.equalsIgnoreCase("batal")` is `true`. The loop is then exited with `break`. The `while (true)` condition itself never becomes false.

**3. What is the function of using the value `true` as the DO-WHILE condition?**

`true` makes the loop condition always satisfied, so the loop repeats indefinitely. This is used when the number of repetitions is unknown in advance (here, the number of customers). The loop is ended manually from inside the body with `break` when the user enters "batal".

**4. Why does this DO-WHILE keep running even though it has no initialization and update components?**

Initialization and update are only needed by a counter-controlled loop (like `for` or a `while` with `i`). This loop is controlled by an input value (a sentinel) and not by a counter. The repetition is driven by the condition `true`, and the loop is only stopped by the `break` statement when the sentinel "batal" is entered, so no counter is needed.

---

## 3. TUGAS (ASSIGNMENTS)

### Task 1: Cinema Ticket Sales (`Tugas1NoAbsen.java`)

The ticket price is Rp 50.000. A customer buying more than 4 tickets gets a 10% discount, and more than 10 tickets gets a 15% discount. A negative input is ignored and must be re-entered. *(Assumption: entering 0 ends the day's sales.)*

```java
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
```

Output:

<img width="492" height="281" alt="Image" src="https://github.com/user-attachments/assets/fe29b8b6-327b-4d36-b7a2-b61c7808a090" />

### Task 2: Parking Fee (Flowchart Implementation) (`Tugas2NoAbsen.java`)

The flowchart is implemented with a `do-while` loop: read the vehicle type (1 = car, 2 = motorcycle, 0 = exit); if the type is 1 or 2, read the duration and add `durasi * 3000` (car) or `durasi * 2000` (motorcycle) to the total; repeat while the type is not 0; finally print the total.

```java
import java.util.Scanner;

public class Tugas205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jenis, durasi, total = 0;

        do {
            System.out.print("Masukkan jenis (1 mobil, 2 motor, 0 keluar): ");
            jenis = sc.nextInt();

            if (jenis == 1 || jenis == 2) {
                System.out.print("Masukkan durasi (jam): ");
                durasi = sc.nextInt();
                if (jenis == 1) {
                    total += durasi * 3000;
                } else {
                    total += durasi * 2000;
                }
            }
        } while (jenis != 0);

        System.out.println("Total pembayaran parkir: Rp " + total);
        sc.close();
    }
}
```

Output:

```
<img width="664" height="347" alt="Image" src="https://github.com/user-attachments/assets/a59ab486-9371-4847-af3f-e7e38c222576" />
---

## Conclusion

In this practical session, I learned the three loop structures in Java and when to use each of them. The `for` loop is best when the number of repetitions is known in advance, because its initialization, condition, and update are written together in one line, as in finding the highest and lowest scores of 10 students. The `while` loop checks its condition before every iteration and is suitable when the repetition depends on a variable that is controlled inside the body, such as the student counter that only increases after a valid score. I also learned that `continue` skips the rest of the current iteration (so an invalid input can be asked again without counting it), and that the position of `i++` changes the behavior of the loop. The `do-while` loop executes its body at least once before checking the condition, and combined with `while (true)` and `break` it handles input-controlled repetition where the number of customers is unknown, as in the cafe and parking programs. Initializing the highest value to the smallest possible value and the lowest value to the largest possible value is important so that the first input can always replace them. Finally, the assignments showed that loops combined with selection statements and accumulator variables can turn a flowchart or a real-life case, such as ticket discounts and parking fees, into a short, correct Java program.

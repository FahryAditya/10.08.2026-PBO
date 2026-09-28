import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Aplikasi Pemesanan Tiket Kapal Laut (Berbasis GUI Swing)
 * Pertemuan 4 - Pemrograman Berorientasi Objek (Java)
 */
public class AplikasiPesanTiket extends JFrame {

    // --- MODEL DATA ---
    static class RuteKapal {
        private String idRute;
        private String namaKapal;
        private String pelabuhanAsal;
        private String pelabuhanTujuan;
        private double hargaDasar;
        private String jamKeberangkatan;

        public RuteKapal(String idRute, String namaKapal, String pelabuhanAsal, String pelabuhanTujuan, double hargaDasar, String jamKeberangkatan) {
            this.idRute = idRute;
            this.namaKapal = namaKapal;
            this.pelabuhanAsal = pelabuhanAsal;
            this.pelabuhanTujuan = pelabuhanTujuan;
            this.hargaDasar = hargaDasar;
            this.jamKeberangkatan = jamKeberangkatan;
        }

        public String getIdRute() { return idRute; }
        public String getNamaKapal() { return namaKapal; }
        public String getPelabuhanAsal() { return pelabuhanAsal; }
        public String getPelabuhanTujuan() { return pelabuhanTujuan; }
        public double getHargaDasar() { return hargaDasar; }
        public String getJamKeberangkatan() { return jamKeberangkatan; }

        @Override
        public String toString() {
            return String.format("[%s] %s (%s -> %s) - %s",
                    idRute, namaKapal, pelabuhanAsal, pelabuhanTujuan, AplikasiPesanTiket.formatRupiah(hargaDasar));
        }
    }

    static class TiketPesanan {
        private String kodeBooking;
        private String namaPemesan;
        private String nomorIdentitas;
        private RuteKapal rute;
        private String kelas;
        private String kategoriPenumpang;
        private int jumlahTiket;
        private double hargaPerTiket;
        private double totalHarga;
        private double diskon;
        private double biayaAsuransi;
        private double grandTotal;
        private String waktuPemesanan;

        public TiketPesanan(String kodeBooking, String namaPemesan, String nomorIdentitas, RuteKapal rute,
                             String kelas, String kategoriPenumpang, int jumlahTiket, double hargaPerTiket,
                             double totalHarga, double diskon, double biayaAsuransi, double grandTotal, String waktuPemesanan) {
            this.kodeBooking = kodeBooking;
            this.namaPemesan = namaPemesan;
            this.nomorIdentitas = nomorIdentitas;
            this.rute = rute;
            this.kelas = kelas;
            this.kategoriPenumpang = kategoriPenumpang;
            this.jumlahTiket = jumlahTiket;
            this.hargaPerTiket = hargaPerTiket;
            this.totalHarga = totalHarga;
            this.diskon = diskon;
            this.biayaAsuransi = biayaAsuransi;
            this.grandTotal = grandTotal;
            this.waktuPemesanan = waktuPemesanan;
        }

        public String getKodeBooking() { return kodeBooking; }
        public String getNamaPemesan() { return namaPemesan; }
        public String getNomorIdentitas() { return nomorIdentitas; }
        public RuteKapal getRute() { return rute; }
        public String getKelas() { return kelas; }
        public String getKategoriPenumpang() { return kategoriPenumpang; }
        public int getJumlahTiket() { return jumlahTiket; }
        public double getGrandTotal() { return grandTotal; }
        public String getWaktuPemesanan() { return waktuPemesanan; }

        public String cetakStrukText() {
            StringBuilder sb = new StringBuilder();
            sb.append("==========================================================\n");
            sb.append("                 STRUK PEMESANAN TIKET KAPAL              \n");
            sb.append("                     PELABUHAN NUSANTARA                  \n");
            sb.append("==========================================================\n");
            sb.append(String.format(" Kode Booking       : %s\n", kodeBooking));
            sb.append(String.format(" Waktu Transaksi    : %s\n", waktuPemesanan));
            sb.append("----------------------------------------------------------\n");
            sb.append(String.format(" Nama Pemesan       : %s\n", namaPemesan));
            sb.append(String.format(" No. Identitas/KTP  : %s\n", nomorIdentitas));
            sb.append(String.format(" Kategori           : %s\n", kategoriPenumpang));
            sb.append("----------------------------------------------------------\n");
            sb.append(String.format(" Nama Kapal         : %s\n", rute.getNamaKapal()));
            sb.append(String.format(" Rute Pelayaran     : %s -> %s\n", rute.getPelabuhanAsal(), rute.getPelabuhanTujuan()));
            sb.append(String.format(" Jam Keberangkatan  : %s WIB\n", rute.getJamKeberangkatan()));
            sb.append(String.format(" Kelas Layanan      : %s\n", kelas));
            sb.append(String.format(" Jumlah Tiket       : %d tiket\n", jumlahTiket));
            sb.append("----------------------------------------------------------\n");
            sb.append(String.format(" Harga per Tiket    : %s\n", AplikasiPesanTiket.formatRupiah(hargaPerTiket)));
            sb.append(String.format(" Subtotal           : %s\n", AplikasiPesanTiket.formatRupiah(totalHarga)));
            if (diskon > 0) {
                sb.append(String.format(" Diskon Potongan    : -%s\n", AplikasiPesanTiket.formatRupiah(diskon)));
            }
            sb.append(String.format(" Biaya Asuransi     : %s\n", AplikasiPesanTiket.formatRupiah(biayaAsuransi)));
            sb.append("----------------------------------------------------------\n");
            sb.append(String.format(" TOTAL PEMBAYARAN   : %s\n", AplikasiPesanTiket.formatRupiah(grandTotal)));
            sb.append("==========================================================\n");
            sb.append("    Terima kasih telah memesan tiket kapal bersama kami!   \n");
            sb.append("  * Harap tiba di pelabuhan 2 jam sebelum keberangkatan.  \n");
            sb.append("==========================================================\n");
            return sb.toString();
        }
    }

    // --- STATE SIMPAN DATA ---
    private static List<RuteKapal> daftarRute = new ArrayList<>();
    private static List<TiketPesanan> daftarRiwayat = new ArrayList<>();
    private static int counterBooking = 1;

    // --- KOMPONEN GUI ---
    private JComboBox<RuteKapal> comboRute;
    private JTextField txtNamaPemesan;
    private JTextField txtNoKtp;
    private JComboBox<String> comboKelas;
    private JComboBox<String> comboKategori;
    private JSpinner spinnerJumlahTiket;

    // Output Kalkulasi Real-time
    private JLabel lblHargaSatuan;
    private JLabel lblSubtotal;
    private JLabel lblDiskon;
    private JLabel lblAsuransi;
    private JLabel lblGrandTotal;

    // Tabel Riwayat
    private JTable tableRiwayat;
    private DefaultTableModel modelTableRiwayat;
    private TableRowSorter<DefaultTableModel> sorterRiwayat;
    private JTextField txtCariRiwayat;

    public AplikasiPesanTiket() {
        inisialisasiRute();
        setupLookAndFeel();
        initComponents();
    }

    private static void inisialisasiRute() {
        if (daftarRute.isEmpty()) {
            daftarRute.add(new RuteKapal("RUT-01", "KM Kelud", "Tanjung Priok (Jakarta)", "Tanjung Perak (Surabaya)", 350000, "08:00"));
            daftarRute.add(new RuteKapal("RUT-02", "KM Labobar", "Tanjung Perak (Surabaya)", "Soekarno-Hatta (Makassar)", 450000, "13:30"));
            daftarRute.add(new RuteKapal("RUT-03", "KM Sinabung", "Soekarno-Hatta (Makassar)", "Bitung (Manado)", 520000, "19:00"));
            daftarRute.add(new RuteKapal("RUT-04", "KM Express Bahari", "Harbor Bay (Batam)", "Tanjung Pinang", 150000, "10:15"));
            daftarRute.add(new RuteKapal("RUT-05", "KM Bukit Raya", "Tanjung Priok (Jakarta)", "Pontianak", 420000, "16:45"));
        }
    }

    private void setupLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Fallback ke sistem default jika Nimbus tidak tersedia
        }
    }

    private void initComponents() {
        setTitle("Aplikasi Pemesanan Tiket Kapal Laut - Pelabuhan Nusantara");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(980, 720);
        setLocationRelativeTo(null);

        // Panel Utama
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(248, 250, 252));

        // Header Banner
        JPanel headerPanel = createHeaderPanel();
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("SansSerif", Font.BOLD, 13));

        // Tab 1: Form Pemesanan Tiket
        JPanel panelPemesanan = createPanelPemesanan();
        tabbedPane.addTab("🎫 Form Pemesanan Tiket", panelPemesanan);

        // Tab 2: Riwayat Transaksi & Cari
        JPanel panelRiwayat = createPanelRiwayat();
        tabbedPane.addTab("📜 Riwayat & Cari Tiket", panelRiwayat);

        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        add(mainPanel);

        // Hitung estimasi awal
        updateKalkulasiRealtime();
    }

    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(30, 58, 138)); // Deep Navy Blue
        header.setBorder(new EmptyBorder(15, 20, 15, 20));

        JLabel titleLabel = new JLabel("APLIKASI PEMESANAN TIKET KAPAL LAUT");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);

        JLabel subtitleLabel = new JLabel("Sistem Informasi & Reservasi Pelabuhan Nusantara");
        subtitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        subtitleLabel.setForeground(new Color(226, 232, 240));

        JPanel textContainer = new JPanel(new GridLayout(2, 1, 0, 4));
        textContainer.setOpaque(false);
        textContainer.add(titleLabel);
        textContainer.add(subtitleLabel);

        header.add(textContainer, BorderLayout.WEST);
        return header;
    }

    private JPanel createPanelPemesanan() {
        JPanel container = new JPanel(new BorderLayout(15, 15));
        container.setBorder(new EmptyBorder(15, 15, 15, 15));
        container.setBackground(new Color(248, 250, 252));

        // --- BAGIAN ATAS: TABEL RUTE KAPAL ---
        JPanel panelRute = new JPanel(new BorderLayout());
        panelRute.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(203, 213, 225)),
                "Daftar Rute & Jadwal Kapal Tersedia",
                TitledBorder.LEFT, TitledBorder.TOP,
                new Font("SansSerif", Font.BOLD, 14), new Color(30, 58, 138)
        ));
        panelRute.setBackground(Color.WHITE);

        String[] colRute = {"Kode", "Nama Kapal", "Pelabuhan Asal", "Pelabuhan Tujuan", "Harga Ekonomi", "Jam Keberangkatan"};
        DefaultTableModel modelRute = new DefaultTableModel(colRute, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };

        for (RuteKapal r : daftarRute) {
            modelRute.addRow(new Object[]{
                    r.getIdRute(), r.getNamaKapal(), r.getPelabuhanAsal(),
                    r.getPelabuhanTujuan(), formatRupiah(r.getHargaDasar()), r.getJamKeberangkatan() + " WIB"
            });
        }

        JTable tableRute = new JTable(modelRute);
        tableRute.setRowHeight(24);
        tableRute.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tableRute.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        tableRute.getTableHeader().setBackground(new Color(241, 245, 249));

        JScrollPane scrollRute = new JScrollPane(tableRute);
        scrollRute.setPreferredSize(new Dimension(900, 140));
        panelRute.add(scrollRute, BorderLayout.CENTER);

        container.add(panelRute, BorderLayout.NORTH);

        // --- BAGIAN TENGAH: FORM INPUT (KIRI) & RINCIAN BIAYA (KANAN) ---
        JPanel centerGrid = new JPanel(new GridLayout(1, 2, 15, 0));
        centerGrid.setOpaque(false);

        // Panel Form Input
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBackground(Color.WHITE);
        panelForm.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(203, 213, 225)),
                "Form Input Pemesan",
                TitledBorder.LEFT, TitledBorder.TOP,
                new Font("SansSerif", Font.BOLD, 14), new Color(30, 58, 138)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 10, 6, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0;

        // 1. Pilih Rute
        panelForm.add(new JLabel("Pilih Rute Kapal:"), gbc);
        gbc.gridx = 1;
        comboRute = new JComboBox<>(daftarRute.toArray(new RuteKapal[0]));
        panelForm.add(comboRute, gbc);

        // 2. Nama Pemesan
        gbc.gridx = 0; gbc.gridy++;
        panelForm.add(new JLabel("Nama Pemesan:"), gbc);
        gbc.gridx = 1;
        txtNamaPemesan = new JTextField();
        panelForm.add(txtNamaPemesan, gbc);

        // 3. No KTP/Identitas
        gbc.gridx = 0; gbc.gridy++;
        panelForm.add(new JLabel("No. KTP / Identitas:"), gbc);
        gbc.gridx = 1;
        txtNoKtp = new JTextField();
        panelForm.add(txtNoKtp, gbc);

        // 4. Pilihan Kelas Layanan
        gbc.gridx = 0; gbc.gridy++;
        panelForm.add(new JLabel("Kelas Layanan:"), gbc);
        gbc.gridx = 1;
        String[] kelasOptions = {
                "Ekonomi (Harga Normal)",
                "Bisnis (Harga Normal x 1.5 - Kabin AC, Makan 3x)",
                "VIP (Harga Normal x 2.0 - Kabin Privat, TV, Wi-Fi)"
        };
        comboKelas = new JComboBox<>(kelasOptions);
        panelForm.add(comboKelas, gbc);

        // 5. Kategori Penumpang
        gbc.gridx = 0; gbc.gridy++;
        panelForm.add(new JLabel("Kategori Penumpang:"), gbc);
        gbc.gridx = 1;
        String[] kategoriOptions = {
                "Dewasa (Tarif Normal)",
                "Anak-anak (< 12 thn - Diskon 25%)",
                "Lansia (> 60 thn - Diskon 15%)"
        };
        comboKategori = new JComboBox<>(kategoriOptions);
        panelForm.add(comboKategori, gbc);

        // 6. Jumlah Tiket
        gbc.gridx = 0; gbc.gridy++;
        panelForm.add(new JLabel("Jumlah Tiket:"), gbc);
        gbc.gridx = 1;
        spinnerJumlahTiket = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        panelForm.add(spinnerJumlahTiket, gbc);

        centerGrid.add(panelForm);

        // Panel Rincian Biaya (Kanan)
        JPanel panelCost = new JPanel(new GridLayout(6, 2, 10, 12));
        panelCost.setBackground(Color.WHITE);
        panelCost.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(203, 213, 225)),
                "Rincian Perhitungan Biaya",
                TitledBorder.LEFT, TitledBorder.TOP,
                new Font("SansSerif", Font.BOLD, 14), new Color(30, 58, 138)
        ));

        Font fontLabel = new Font("SansSerif", Font.PLAIN, 13);
        Font fontValue = new Font("SansSerif", Font.BOLD, 13);

        panelCost.add(createStyledLabel("Harga per Tiket:", fontLabel));
        lblHargaSatuan = createStyledLabel("Rp 0", fontValue);
        panelCost.add(lblHargaSatuan);

        panelCost.add(createStyledLabel("Subtotal Tiket:", fontLabel));
        lblSubtotal = createStyledLabel("Rp 0", fontValue);
        panelCost.add(lblSubtotal);

        panelCost.add(createStyledLabel("Potongan Diskon:", fontLabel));
        lblDiskon = createStyledLabel("- Rp 0", fontValue);
        lblDiskon.setForeground(new Color(220, 38, 38)); // Red text
        panelCost.add(lblDiskon);

        panelCost.add(createStyledLabel("Biaya Asuransi (10rb/tkt):", fontLabel));
        lblAsuransi = createStyledLabel("Rp 0", fontValue);
        panelCost.add(lblAsuransi);

        JSeparator sep = new JSeparator();
        panelCost.add(sep);
        panelCost.add(new JSeparator());

        JLabel lblGrandTitle = new JLabel("TOTAL PEMBAYARAN:");
        lblGrandTitle.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblGrandTitle.setForeground(new Color(30, 58, 138));
        panelCost.add(lblGrandTitle);

        lblGrandTotal = new JLabel("Rp 0");
        lblGrandTotal.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblGrandTotal.setForeground(new Color(16, 185, 129)); // Green accent
        panelCost.add(lblGrandTotal);

        centerGrid.add(panelCost);
        container.add(centerGrid, BorderLayout.CENTER);

        // --- BAGIAN BAWAH: TOMBOL AKSI ---
        JPanel panelAction = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        panelAction.setOpaque(false);

        JButton btnReset = new JButton("Reset Form");
        btnReset.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnReset.setPreferredSize(new Dimension(120, 36));
        btnReset.addActionListener(e -> resetFormPemesanan());

        JButton btnSubmit = new JButton("Pesan Tiket Sekarang");
        btnSubmit.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnSubmit.setBackground(new Color(37, 99, 235));
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setPreferredSize(new Dimension(200, 38));
        btnSubmit.setFocusPainted(false);
        btnSubmit.addActionListener(e -> prosesPemesananTiketGUI());

        panelAction.add(btnReset);
        panelAction.add(btnSubmit);
        container.add(panelAction, BorderLayout.SOUTH);

        // --- EVENT LISTENERS UNTUK KALKULASI REALTIME ---
        ActionListener calcAction = e -> updateKalkulasiRealtime();
        comboRute.addActionListener(calcAction);
        comboKelas.addActionListener(calcAction);
        comboKategori.addActionListener(calcAction);
        spinnerJumlahTiket.addChangeListener(e -> updateKalkulasiRealtime());

        // Sinkronisasi seleksi tabel rute dengan combobox
        tableRute.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tableRute.getSelectedRow() != -1) {
                int row = tableRute.getSelectedRow();
                comboRute.setSelectedIndex(row);
            }
        });

        return container;
    }

    private JPanel createPanelRiwayat() {
        JPanel container = new JPanel(new BorderLayout(10, 10));
        container.setBorder(new EmptyBorder(15, 15, 15, 15));
        container.setBackground(new Color(248, 250, 252));

        // Filter / Search Bar
        JPanel panelSearch = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelSearch.setBackground(Color.WHITE);
        panelSearch.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(203, 213, 225)),
                new EmptyBorder(8, 10, 8, 10)
        ));

        panelSearch.add(new JLabel("Cari Kode Booking / Nama Pemesan:"));
        txtCariRiwayat = new JTextField(20);
        panelSearch.add(txtCariRiwayat);

        JButton btnCari = new JButton("Cari");
        btnCari.addActionListener(e -> filterRiwayatTable());
        panelSearch.add(btnCari);

        JButton btnResetSearch = new JButton("Reset Search");
        btnResetSearch.addActionListener(e -> {
            txtCariRiwayat.setText("");
            filterRiwayatTable();
        });
        panelSearch.add(btnResetSearch);

        container.add(panelSearch, BorderLayout.NORTH);

        // Tabel Riwayat
        String[] colNames = {"Kode Booking", "Waktu Transaksi", "Nama Pemesan", "No. KTP", "Nama Kapal", "Rute", "Kelas", "Kategori", "Tiket", "Total Bayar"};
        modelTableRiwayat = new DefaultTableModel(colNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };

        tableRiwayat = new JTable(modelTableRiwayat);
        tableRiwayat.setRowHeight(26);
        tableRiwayat.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tableRiwayat.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        tableRiwayat.getTableHeader().setBackground(new Color(241, 245, 249));

        sorterRiwayat = new TableRowSorter<>(modelTableRiwayat);
        tableRiwayat.setRowSorter(sorterRiwayat);

        JScrollPane scrollTable = new JScrollPane(tableRiwayat);
        container.add(scrollTable, BorderLayout.CENTER);

        // Panel Bawah (Detail Struk Button)
        JPanel panelBottom = new JPanel(new BorderLayout());
        panelBottom.setOpaque(false);

        JButton btnLihatStruk = new JButton("🔍 Lihat & Cetak Struk Tiket");
        btnLihatStruk.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnLihatStruk.setBackground(new Color(30, 58, 138));
        btnLihatStruk.setForeground(Color.WHITE);
        btnLihatStruk.setPreferredSize(new Dimension(220, 36));
        btnLihatStruk.addActionListener(e -> tampilkanStrukSelected());

        panelBottom.add(btnLihatStruk, BorderLayout.EAST);
        container.add(panelBottom, BorderLayout.SOUTH);

        return container;
    }

    private JLabel createStyledLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    private void updateKalkulasiRealtime() {
        RuteKapal selectedRute = (RuteKapal) comboRute.getSelectedItem();
        if (selectedRute == null) return;

        double pengaliKelas = 1.0;
        int kelasIdx = comboKelas.getSelectedIndex();
        if (kelasIdx == 1) pengaliKelas = 1.5;
        else if (kelasIdx == 2) pengaliKelas = 2.0;

        double persenDiskon = 0.0;
        int katIdx = comboKategori.getSelectedIndex();
        if (katIdx == 1) persenDiskon = 0.25; // Anak-anak
        else if (katIdx == 2) persenDiskon = 0.15; // Lansia

        int jumlahTiket = (Integer) spinnerJumlahTiket.getValue();

        double hargaPerTiket = selectedRute.getHargaDasar() * pengaliKelas;
        double subtotal = hargaPerTiket * jumlahTiket;
        double diskon = subtotal * persenDiskon;
        double biayaAsuransi = 10000.0 * jumlahTiket;
        double grandTotal = (subtotal - diskon) + biayaAsuransi;

        lblHargaSatuan.setText(formatRupiah(hargaPerTiket));
        lblSubtotal.setText(formatRupiah(subtotal));
        lblDiskon.setText("- " + formatRupiah(diskon));
        lblAsuransi.setText(formatRupiah(biayaAsuransi));
        lblGrandTotal.setText(formatRupiah(grandTotal));
    }

    private void prosesPemesananTiketGUI() {
        String nama = txtNamaPemesan.getText().trim();
        String ktp = txtNoKtp.getText().trim();

        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama Pemesan tidak boleh kosong!", "Peringatan Validasi", JOptionPane.WARNING_MESSAGE);
            txtNamaPemesan.requestFocus();
            return;
        }

        if (ktp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nomor KTP / Identitas tidak boleh kosong!", "Peringatan Validasi", JOptionPane.WARNING_MESSAGE);
            txtNoKtp.requestFocus();
            return;
        }

        RuteKapal ruteSelected = (RuteKapal) comboRute.getSelectedItem();
        int kelasIdx = comboKelas.getSelectedIndex();
        String namaKelas = (kelasIdx == 0) ? "Ekonomi" : (kelasIdx == 1) ? "Bisnis" : "VIP";
        double pengaliKelas = (kelasIdx == 0) ? 1.0 : (kelasIdx == 1) ? 1.5 : 2.0;

        int katIdx = comboKategori.getSelectedIndex();
        String kategori = (katIdx == 0) ? "Dewasa" : (katIdx == 1) ? "Anak-anak" : "Lansia";
        double persenDiskon = (katIdx == 0) ? 0.0 : (katIdx == 1) ? 0.25 : 0.15;

        int jumlahTiket = (Integer) spinnerJumlahTiket.getValue();

        double hargaPerTiket = ruteSelected.getHargaDasar() * pengaliKelas;
        double subtotal = hargaPerTiket * jumlahTiket;
        double diskon = subtotal * persenDiskon;
        double totalAsuransi = 10000.0 * jumlahTiket;
        double grandTotal = (subtotal - diskon) + totalAsuransi;

        String kodeBooking = String.format("TKT-%04d", counterBooking++);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String waktuSekarang = dtf.format(LocalDateTime.now());

        TiketPesanan tiketBaru = new TiketPesanan(
                kodeBooking, nama, ktp, ruteSelected, namaKelas, kategori,
                jumlahTiket, hargaPerTiket, subtotal, diskon, totalAsuransi, grandTotal, waktuSekarang
        );

        daftarRiwayat.add(tiketBaru);

        // Tambah ke tabel riwayat
        String ruteStr = ruteSelected.getPelabuhanAsal() + " -> " + ruteSelected.getPelabuhanTujuan();
        modelTableRiwayat.addRow(new Object[]{
                tiketBaru.getKodeBooking(), tiketBaru.getWaktuPemesanan(), tiketBaru.getNamaPemesan(),
                tiketBaru.getNomorIdentitas(), ruteSelected.getNamaKapal(), ruteStr,
                tiketBaru.getKelas(), tiketBaru.getKategoriPenumpang(), tiketBaru.getJumlahTiket(),
                formatRupiah(tiketBaru.getGrandTotal())
        });

        // Tampilkan dialog Struk Pemesanan
        tampilkanDialogStruk(tiketBaru.cetakStrukText());
        resetFormPemesanan();
    }

    private void resetFormPemesanan() {
        txtNamaPemesan.setText("");
        txtNoKtp.setText("");
        comboRute.setSelectedIndex(0);
        comboKelas.setSelectedIndex(0);
        comboKategori.setSelectedIndex(0);
        spinnerJumlahTiket.setValue(1);
        updateKalkulasiRealtime();
    }

    private void filterRiwayatTable() {
        String keyword = txtCariRiwayat.getText().trim();
        if (keyword.isEmpty()) {
            sorterRiwayat.setRowFilter(null);
        } else {
            sorterRiwayat.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
        }
    }

    private void tampilkanStrukSelected() {
        int selectedRow = tableRiwayat.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Silakan pilih salah satu baris transaksi pada tabel riwayat terlebih dahulu.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int modelRow = tableRiwayat.convertRowIndexToModel(selectedRow);
        String kodeBooking = (String) modelTableRiwayat.getValueAt(modelRow, 0);

        for (TiketPesanan t : daftarRiwayat) {
            if (t.getKodeBooking().equalsIgnoreCase(kodeBooking)) {
                tampilkanDialogStruk(t.cetakStrukText());
                return;
            }
        }
    }

    private void tampilkanDialogStruk(String strukText) {
        JDialog dialog = new JDialog(this, "Struk Pemesanan Tiket Kapal", true);
        dialog.setSize(480, 560);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout(10, 10));

        JTextArea txtArea = new JTextArea(strukText);
        txtArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtArea.setEditable(false);
        txtArea.setBackground(new Color(254, 254, 235)); // Soft light yellow receipt background
        txtArea.setMargin(new Insets(15, 15, 15, 15));

        JScrollPane scroll = new JScrollPane(txtArea);
        dialog.add(scroll, BorderLayout.CENTER);

        JButton btnClose = new JButton("Tutup");
        btnClose.addActionListener(e -> dialog.dispose());
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(btnClose);
        dialog.add(btnPanel, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }

    public static String formatRupiah(double nominal) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setMonetaryDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("#,##0", symbols);
        return "Rp " + df.format(nominal);
    }

    // --- MAIN METHOD UNTUK MENJALANKAN GUI ---
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AplikasiPesanTiket app = new AplikasiPesanTiket();
            app.setVisible(true);
        });
    }
}

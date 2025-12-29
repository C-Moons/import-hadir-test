Feature: Test Case Import Struktur User

  Scenario Outline: Import Struktur User dengan berbagai value
    Given Saya buka browser dan mengakses halaman login web.
    When input username "admin@hadir.com" dan password "MagangSQA_JC@123" login.
    And Masuk di dashboard dan akses import di sidebar.
    And Pilih Import Struktur User.
    And Pilih Download Template Struktur User.
    And Upload file "<upload_file>" ke kolom Struktur User.
    And Tekan tombol import untuk upload file ke Struktur User.
    Then Keluar pesan dengan isi "<message>" jika status "<status>".

    Examples:
      | upload_file                         | message               | status |
      | DATA_STRUKTUR_USER.xlsx             | Berhasil import excel | sukses |
      | DATA_STRUKTUR_USER_Tanpa_Nama.xlsx  | Berhasil import excel | sukses |
      | DATA_STRUKTUR_USER_Blank.xlsx       | Gagal import excel    | gagal  |
      | DATA_STRUKTUR_USER_Tanpa_NIK.xlsx   | Gagal import excel    | gagal  |
      | Testing.txt| *File harus berupa file Excel (.xls atau .xlsx)| gagal  |


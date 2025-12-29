Feature: Test Case Import Cuti

  Scenario Outline: Import Import Cuti dengan berbagai value
    Given Saya membuka browser dan mengakses halaman login web.
    When menginput username "admin@hadir.com" dan password "MagangSQA_JC@123" login.
    And Masuk di dashboard dan mengakses import di sidebar.
    And Pilih Import Cuti.
    And Pilih Download Template Import Cuti.
    And Upload file "<upload_file>" ke kolom Import Cuti.
    And Tekan tombol import untuk upload file ke Import Cuti.
    Then Keluar alert dengan isi "<message>" jika status "<status>".

    Examples:
      | upload_file                         | message               | status |
      | Template_Cuti_Hadir.xlsx            | Berhasil import excel | sukses |
      | Template_Cuti_Hadir_Tanpa_Nama.xlsx | Berhasil import excel | sukses |
      | Template_Cuti_Hadir_Tanpa_NIK.xlsx  | Gagal import excel    | gagal  |
      | Template_Cuti_Hadir_Tanpa_Tanggal.xlsx |Gagal import excel  | gagal  |
      | Template_Cuti_Hadir.pdf | *File harus berupa file Excel (.xls atau .xlsx)| gagal  |



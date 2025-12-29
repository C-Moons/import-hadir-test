Feature: Test Case Import Status Aktif

  Scenario Outline: Import Status Aktif dengan berbagai value
    Given Saya buka browser dan mengakses halaman login.
    When memasukkan username "admin@hadir.com" dan password "MagangSQA_JC@123" login.
    And Masuk menu dashboard dan akses import di sidebar.
    And Pilih Import Status Aktif.
    And Pilih Download Template Status Aktif.
    And Upload file "<upload_file>" ke kolom Status Aktif .
    And Tekan tombol import untuk upload file ke Status Aktif.
    Then Keluar pesan status aktif dengan "<message>" jika status "<status>".

    Examples:
      | upload_file                       | message                   | status |
      | DATA_STATUS_USER.xlsx             | Berhasil import excel     | sukses |
      | DATA_STATUS_USER_Tanpa_Nama.xlsx  | Berhasil import excel     | sukses |
      | DATA_STATUS_USER_Blank.xlsx       | Gagal import excel        | gagal  |
      | DATA_STATUS_USER_Tanpa_NIK.xlsx   | Gagal import excel        | gagal  |
      | DATA_STATUS_USER_Tanpa_Status.xltx| *File harus berupa file Excel (.xls atau .xlsx)| gagal |
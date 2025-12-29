Feature: Test Case Import Absen 
    Scenario Outline: Import absen dengan berbagai value 
    
    Given Saya membuka browser dan mengakses halaman login.
    When Saya memasukkan username "admin@hadir.com" dan password "MagangSQA_JC@123" login. 
    And Masuk dashboard dan akses import di sidebar.
    And Pilih Import Absen.
    And Pilih Download Template.
    And Upload file "<upload_file>" .
    And Tekan tombol import.
    Then Keluar pesan dengan "<message>" jika status "<status>".

    Examples:
    | upload_file                 | message                           | status |
    | DATA_ABSEN_HADIR.xlsx       | Berhasil import excel             | sukses |
    | DATA_ABSEN_HADIR_Tanpa_Nama.xlsx | Berhasil import excel        | sukses |
    | DATA_ABSEN_HADIR_Tanpa_Header_Kolom.xlsx | Berhasil import excel| sukses |
    | DATA_ABSEN_HADIR_Tanpa_NIK.xlsx | Gagal import excel            | gagal  |
    | DATA_ABSEN_HADIR_blank.xlsx | Gagal import excel                | gagal  |

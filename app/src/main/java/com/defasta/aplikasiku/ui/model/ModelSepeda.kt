package com.defasta.aplikasiku.ui.model

class ModelSepeda(nama: String?, jenis: String?, tahun: String? ) {
    private var nama: String
    private var jenis: String
    private var tahun: String
    init {
        this.nama = nama!!
        this.jenis = jenis!!
        this.tahun = tahun!!
    }

     fun getNama(): String? {
         return nama
     }

    fun setNama(nama: String?){
        this.nama = nama!!
    }

    fun getTahun(): String? {
        return tahun
    }

    fun setTahun(tahun: String?){
        this.tahun = tahun!!
    }

    fun getJenis(): String? {
        return jenis
    }

    fun setJenis(jenis: String?){
        this.jenis = jenis!!
    }

}
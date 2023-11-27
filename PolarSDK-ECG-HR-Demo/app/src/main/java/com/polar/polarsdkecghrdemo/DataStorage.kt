package com.polar.polarsdkecghrdemo

class DataStorage {
    companion object {
        private val ecgDataList = mutableListOf<Float>() // Menyimpan data ECG dalam list
        private val hrDataList = mutableListOf<Int>()   // Menyimpan data HR dalam list

        fun saveECGData(data: Float) {
            ecgDataList.add(data)
        }

        fun saveHRData(data: Int) {
            hrDataList.add(data)
        }

        fun getECGData(): List<Float> {
            return ecgDataList.toList() // Mengembalikan data ECG yang disimpan
        }

        fun getHRData(): List<Int> {
            return hrDataList.toList() // Mengembalikan data HR yang disimpan
        }

    }
}

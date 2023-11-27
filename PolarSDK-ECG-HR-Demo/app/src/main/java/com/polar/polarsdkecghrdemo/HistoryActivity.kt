package com.polar.polarsdkecghrdemo

import android.os.Bundle
import android.widget.TextView
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        val textHistory: TextView = findViewById(R.id.textHistory)

        // Ambil data ECG dan HR dari penyimpanan
        val ecgData = DataStorage.getECGData()
        val hrData = DataStorage.getHRData()

        if (ecgData.isEmpty()) {
            textHistory.visibility = View.VISIBLE // Tampilkan TextView jika tidak ada data
        } else {
            textHistory.visibility = View.GONE // Sembunyikan TextView jika ada data
        }
        if (hrData.isEmpty()) {
            textHistory.visibility = View.VISIBLE // Tampilkan TextView jika tidak ada data
        } else {
            textHistory.visibility = View.GONE // Sembunyikan TextView jika ada data
        }
    }
}

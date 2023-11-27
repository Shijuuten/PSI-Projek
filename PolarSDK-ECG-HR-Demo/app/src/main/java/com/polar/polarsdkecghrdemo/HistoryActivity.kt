package com.polar.polarsdkecghrdemo

import android.os.Bundle
import android.widget.TextView
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class HistoryActivity : AppCompatActivity() {
    private lateinit var historyManager: HistoryManager
    private lateinit var historyList: MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        val textHistory: TextView = findViewById(R.id.textHistory)
        val textHistory2: TextView = findViewById(R.id.textHistory2)

        historyManager = HistoryManager(this)
        historyList = historyManager.loadHistory().toMutableList()

        // Ambil data ECG dan HR dari penyimpanan
        val ecgData = DataStorage.getECGData()
        val hrData = DataStorage.getHRData()

        if (ecgData.isEmpty()) {
            textHistory.visibility = View.VISIBLE // Tampilkan TextView jika tidak ada data
        } else {
            textHistory.visibility = View.GONE // Sembunyikan TextView jika ada data
        }
        if (hrData.isEmpty()) {
            textHistory2.visibility = View.VISIBLE // Tampilkan TextView jika tidak ada data
        } else {
            textHistory2.visibility = View.GONE // Sembunyikan TextView jika ada data
        }
    }
    private fun addToHistory(item: String) {
        historyList.add(item)
        historyManager.saveHistory(historyList)
    }
}

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var yearSpinner: Spinner
    private lateinit var durationHourSpinner: Spinner
    private lateinit var durationMinuteSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi spinner-spinner
        yearSpinner = findViewById(R.id.yearSpinner)
        durationHourSpinner = findViewById(R.id.durationHourSpinner)
        durationMinuteSpinner = findViewById(R.id.durationMinuteSpinner)

        // Populate data untuk spinner-spinner
        populateYearSpinner()
        populateDurationHourSpinner()
        populateDurationMinuteSpinner()

        val okButton: Button = findViewById(R.id.okButton)
        okButton.setOnClickListener {
            // Mendapatkan data yang dipilih dari spinner-spinner
            val selectedYear = yearSpinner.selectedItem.toString()
            val selectedDurationHour = durationHourSpinner.selectedItem.toString()
            val selectedDurationMinute = durationMinuteSpinner.selectedItem.toString()

            // Membuat intent untuk memulai ResultActivity
            val intent = Intent(this, ResultActivity::class.java).apply {
                // Mengirim data yang dipilih ke ResultActivity
                putExtra("YEAR", selectedYear)
                putExtra("DURATION_HOUR", selectedDurationHour)
                putExtra("DURATION_MINUTE", selectedDurationMinute)
            }

            // Memulai ResultActivity dengan intent
            startActivity(intent)
        }
    }

    private fun populateYearSpinner() {
        val years = mutableListOf<String>()
        for (year in 2015..2024) {
            years.add(year.toString())
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, years)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        yearSpinner.adapter = adapter
    }

    private fun populateDurationHourSpinner() {
        val hours = mutableListOf<String>()
        for (hour in 1..5) {
            hours.add(hour.toString())
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, hours)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        durationHourSpinner.adapter = adapter
    }

    private fun populateDurationMinuteSpinner() {
        val minutes = listOf("10", "20", "30", "40", "50")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, minutes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        durationMinuteSpinner.adapter = adapter
    }
}

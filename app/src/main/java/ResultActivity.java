// ResultActivity.java

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Mendapatkan data yang dikirim dari MainActivity
        String year = getIntent().getStringExtra("YEAR");
        String durationHour = getIntent().getStringExtra("DURATION_HOUR");
        String durationMinute = getIntent().getStringExtra("DURATION_MINUTE");

        // Menampilkan data yang diterima di TextView
        TextView resultTextView = findViewById(R.id.resultTextView);
        String resultText = "Year: " + year + "\nDuration: " + durationHour + " Hour(s) " + durationMinute + " Minute(s)";
        resultTextView.setText(resultText);
    }
}

package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	private EditText guessNumber;
	private Button guessButton, resetButton;
	private int randomNumber;
	private int max = 100;
	private int min = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initRandomNumber();
		guessNumber = findViewById(R.id.number_input);
		guessButton = findViewById(R.id.guess_button);
		resetButton = findViewById(R.id.reset_button);
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		randomNumber = new Random().nextInt((max - min) + 1) + min;
	}

	public void handleGuess(View view) {
		if (guessNumber.getText().toString().isEmpty()) {
			Toast.makeText(this, "Oops!.. Harap isikan sebuah angka!", Toast.LENGTH_SHORT).show();
		} else {
			int convertNumber = Integer.parseInt(guessNumber.getText().toString());
			if (convertNumber > randomNumber) {
				Toast.makeText(this, "Oops!.. Tebakan anda terlalu Besar!", Toast.LENGTH_SHORT).show();
			} else if (convertNumber < randomNumber) {
				Toast.makeText(this, "Oops!.. Tebakan anda terlalu Kecil!", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "Wow!.. Tebakan anda Benar!", Toast.LENGTH_SHORT).show();
				guessButton.setEnabled(false);
			}
		}
	}

	public void handleReset(View view) {
		initRandomNumber();
		guessNumber.setText("");
		guessButton.setEnabled(true);
	}
}
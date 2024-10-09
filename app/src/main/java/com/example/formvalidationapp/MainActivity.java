package com.example.formvalidationapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText pierwszeimie, nazwisko, email, nrtelefonu, hasło, potwierdzhasło;
    private Button guzik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pierwszeimie = findViewById(R.id.Name);
        nazwisko = findViewById(R.id.Surname);
        email = findViewById(R.id.Email);
        nrtelefonu = findViewById(R.id.Phone);
        hasło = findViewById(R.id.Password);
        potwierdzhasło = findViewById(R.id.ConfirmPassword);
        guzik = findViewById(R.id.SubmitButton);


        guzik.setOnClickListener(new View.OnClickListener() {



            public void onClick(View v) {
                String firstNameInput = pierwszeimie.getText().toString().trim();
                String lastNameInput = nazwisko.getText().toString().trim();
                String emailInput = email.getText().toString().trim();
                String phoneInput = nrtelefonu.getText().toString().trim();
                String passwordInput = hasło.getText().toString().trim();
                String confirmPasswordInput = potwierdzhasło.getText().toString().trim();

                if (TextUtils.isEmpty(firstNameInput)) {
                    pierwszeimie.setError("Podaj imię");
                    return;
                }

                if (TextUtils.isEmpty(lastNameInput)) {
                    nazwisko.setError("Podaj nazwisko");
                    return;
                }

                if (TextUtils.isEmpty(emailInput) || !android.util.Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                    email.setError("Podaj poprawny adres e-mail");
                    return;
                }

                if (TextUtils.isEmpty(phoneInput) || phoneInput.length() < 9) {
                    nrtelefonu.setError("Podaj poprawny numer telefonu");
                    return;
                }

                if (TextUtils.isEmpty(passwordInput) || passwordInput.length() < 6) {
                    hasło.setError("Hasło musi zawierać co najmniej 6 znaków");
                    return;
                }

                if (!passwordInput.equals(confirmPasswordInput)) {
                    potwierdzhasło.setError("Hasła się nie zgadzają");
                    return;
                }


                Toast.makeText(MainActivity.this, "Formularz został poprawnie wypełniony!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
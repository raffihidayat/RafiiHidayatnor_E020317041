package id.ac.poliban.mi.rafii.rafiihidayatnor_e020317041;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rg = (RadioGroup)findViewById(R.id.rg);
        Button btSubmit = findViewById(R.id.btSubmit);
        Button btClear = findViewById(R.id.btClear);
        EditText etNim = findViewById(R.id.etNim);
        EditText etNama = findViewById(R.id.etNama);
        EditText etAlamat = findViewById(R.id.etAlamat);
        EditText etTelp = findViewById(R.id.etTelp);
        RadioButton rbLaki = findViewById(R.id.rbLaki);
        RadioButton rbPr = findViewById(R.id.rbPr);
        Switch sw = findViewById(R.id.sw);

        sw.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if(sw.isChecked()){
                etAlamat.setEnabled(true);
                etNama.setEnabled(true);
                etNim.setEnabled(true);
                etTelp.setEnabled(true);
                rg.setEnabled(true);
            }
            else {
                etAlamat.setEnabled(false);
                etNama.setEnabled(false);
                etNim.setEnabled(false);
                etTelp.setEnabled(false);
                rg.setEnabled(false);
            }
        }));
        btSubmit.setOnClickListener(v -> {
            String gender = "";
            if (rbLaki.isChecked()){
                gender+= "Laki-laki";
            }
            if (rbPr.isChecked()){
                gender+= "Perempuan";
            }
            new AlertDialog.Builder(this)
                    .setTitle("Info")
                    .setMessage("NIM : "+etNim.getText().toString()+"\n"+
                            "Nama : "+etNama.getText().toString()+"\n"+
                            "Gender : "+gender.toString()+"\n"+
                            "Alamat : "+etAlamat.getText().toString()+"\n"+
                            "Telp : "+etTelp.getText().toString()
                    )
                    .setPositiveButton("Ok", null)
                    .setNegativeButton("Cancel", null).show();
        });

        btClear.setOnClickListener(v -> {
            etAlamat.setText("");
            etNama.setText("");
            etNim.setText("");
            etTelp.setText("");
            rg.clearCheck();
        });
    }
}
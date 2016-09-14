package id.sch.smktelkom_mlg.tugas01.xirpl6025.formulir;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Nama;
    Button bOk;
    TextView nHasil, kHasil, hHasil;
    RadioButton rbVE, rbD, rbGD, rbN;
    CheckBox cbNF, cbNG, cbMG, cbIN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nama = (EditText) findViewById(R.id.editText);
        bOk = (Button) findViewById(R.id.buttonOK);
        nHasil = (TextView) findViewById(R.id.textView4);
        kHasil = (TextView) findViewById(R.id.textView5);
        hHasil = (TextView) findViewById(R.id.textView6);

        rbVE = (RadioButton) findViewById(R.id.radioButtonVE);
        rbD = (RadioButton) findViewById(R.id.radioButtonD);
        rbGD = (RadioButton) findViewById(R.id.radioButtonGD);
        rbN = (RadioButton) findViewById(R.id.radioButtonN);

        cbNF = (CheckBox) findViewById(R.id.checkBoxNF);
        cbNG = (CheckBox) findViewById(R.id.checkBoxNG);
        cbMG = (CheckBox) findViewById(R.id.checkBoxMG);
        cbIN = (CheckBox) findViewById(R.id.checkBoxIN);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
                doClick();
            }
        });

    }


    private void doClick() {
        String klshasil = null;

        if (rbVE.isChecked()) {
            klshasil = rbVE.getText().toString();
        } else if (rbD.isChecked()) {
            klshasil = rbD.getText().toString();
        } else if (rbGD.isChecked()) {
            klshasil = rbGD.getText().toString();
        } else if (rbN.isChecked()) {
            klshasil = rbN.getText().toString();
        }
        if (klshasil == null) {
            kHasil.setText("Anda belum memilih Kelas");
        } else {
            kHasil.setText("Kelas : " + klshasil);
        }

        String hohasil = "Hobby : \n";
        int startlen = hohasil.length();
        if (cbNF.isChecked()) hohasil += cbNF.getText() + "\n";
        if (cbNG.isChecked()) hohasil += cbNG.getText() + "\n";
        if (cbMG.isChecked()) hohasil += cbMG.getText() + "\n";
        if (cbIN.isChecked()) hohasil += cbIN.getText() + "\n";

        if (hohasil.length() == startlen) hohasil += "Tidak ada pada Pilihan";

        hHasil.setText(hohasil);
    }

    private void doProcess() {
        if (isValid()) {
            String nama = Nama.getText().toString();
            nHasil.setText("Nama : " + nama);
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = Nama.getText().toString();

        if (nama.isEmpty()) {
            Nama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            Nama.setError("nama minimal 3 karakter");
            valid = false;
        } else {
            Nama.setError(null);
        }

        return valid;
    }

}
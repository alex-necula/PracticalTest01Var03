package lab03.eim.systems.cs.pub.ro.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03);
    }

    // Sa se asocieze un ascultator pentru cele 2 butoane, astfel incat la apasarea oricaruia in campul text needitabil sa se afiseze operatia care se doreste a fi realizata, impreuna cu rezultatul sau. In situatia in care oricare dintre cele 2 campuri tex editabile nu contine o valoare de tip intreg, se va afisa un mesaj de eroare in cadrul unei ferestre de tip toast.
    // Fortati sistemul de operare Android sa nu salveze/restaureze starea campurilor text in cazul in care aceasta este distrusa. Implementati un mecanism de salvare/restaurare a starii activitatii in cazul in care aceasta este distrusa. Sa se afiseze aceste valori la pornirea activitatii in cadrul unei ferestre toast.
}
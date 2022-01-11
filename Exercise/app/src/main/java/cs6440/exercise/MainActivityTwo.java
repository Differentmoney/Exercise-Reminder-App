package cs6440.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cs6440.backend.FhirClient;
import cs6440.backend.DatabaseHelper;

public class MainActivityTwo extends AppCompatActivity {
    private EditText eName;
    private EditText ePassword;
    private Button elogin;
    DatabaseHelper patientDB;
    DatabaseHelperProvider db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eName = findViewById(R.id.username);
        ePassword = findViewById(R.id.password);
        elogin = findViewById(R.id.btnlogin);
        db = new DatabaseHelperProvider(this);
        patientDB = new DatabaseHelper(this);


        elogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // enter user name and password
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                //Enable Twilio to send SMS
                if (android.os.Build.VERSION.SDK_INT > 9) {
                    StrictMode.setThreadPolicy( new StrictMode.ThreadPolicy.Builder().permitAll().build() );
                }
                //Test Twilio
                //Twilio2 ob = new Twilio2();
                //ob.sendMsg("Hello World");


                Boolean isExit=db.checkUserExist(inputName, inputPassword);
                if (isExit){
                    Intent intent = new Intent(MainActivityTwo.this, DoctorHomePageTwo.class);
                    intent.putExtra("username", inputName);
                    startActivity(intent);

                    String pracID = "e443ac58-8ece-4385-8d55-775c1b8f3a37";

                    //Initialize Fhir Client/Retrieve patient resources
                    FhirClient c = new FhirClient(pracID);
                    patientDB.makeDB();

                    //Make SQLite DB




                }else{

                    ePassword.setText(null);
                    Toast.makeText(MainActivityTwo.this, "Login failed. Invalid Username or Password.", Toast.LENGTH_SHORT).show();
                }




            }
        });

    }

}
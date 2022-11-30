package com.example.exercise_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView infoTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        infoTV = findViewById(R.id.infoTV);

//        String userName = getIntent().getStringExtra("UserName");
//        String password = getIntent().getStringExtra( "Password");
//        String firstName = getIntent().getStringExtra("FirstName");
//        String lastName = getIntent().getStringExtra("LastName");
//        String email = getIntent().getStringExtra("Email");
//        infoTV.setText("User Name : "+userName + "\nPassword : " + password + "\nFirst Name : " + firstName + "\nLast Name : " + lastName + "\nEmail : " +  email );

        Student student = (Student) getIntent().getSerializableExtra("data");
        infoTV.setText("User Name : "+student.getUserName() + "\nPassword : " + student.getPassword() + "\nFirst Name : " + student.getFirstName() + "\nLast Name : " + student.getLastName() + "\nEmail : " +  student.getEmail() );
    }
}


package com.example.exercise_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    ViewGroup root;
    private boolean loginEnable;
    private EditText userName;
    private EditText password;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private Button loginButton;
    private RadioButton login;
    private RadioButton register;

    private ArrayList<Student> studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        root = findViewById(R.id.root);
        userName = findViewById(R.id.userNameET);
        password = findViewById(R.id.passwordET);
        firstName = findViewById(R.id.firstNameET);
        lastName = findViewById(R.id.lastNameET);
        email = findViewById(R.id.emailET);
        loginButton = findViewById(R.id.login_button);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        RadioGroup rg = findViewById(R.id.radioGroup);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
        studentList = new ArrayList<Student>();
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked();
            }
        });
    }

    @Override
    public void onClick(View v) {
        String text;
        switch (v.getId()) {
            case R.id.login:
                loginEnable = true;
                viewEnable();
                break;
            case R.id.register:
                loginEnable = false;
                viewEnable();
                break;
            default:
                break;
        }
    }

    private void viewEnable(){
        if(loginEnable){
            userName.setVisibility(View.VISIBLE);
            password.setVisibility(View.VISIBLE);
            firstName.setVisibility(View.GONE);
            lastName.setVisibility(View.GONE);
            email.setVisibility(View.GONE);

            loginButton.setText("Login");
        }else{
            userName.setVisibility(View.VISIBLE);
            password.setVisibility(View.VISIBLE);
            firstName.setVisibility(View.VISIBLE);
            lastName.setVisibility(View.VISIBLE);
            email.setVisibility(View.VISIBLE);
            loginButton.setText("Register");
        }
    }

    private void buttonClicked(){
        if(loginEnable){
            if(validUser()) {

                navigateToHome();
            }else{
                Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();

            }
        }else{
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.logo)
                    .setPositiveButton("Yes", (dialog, which) -> userRegistered())
                    .setTitle("Are you sure?")
                    .setNegativeButton("No", null)
                    .create()
                    .show();
        }
    }

    private void clearFields() {
        userName.setText("");
        password.setText("");
        firstName.setText("");
        lastName.setText("");
        email.setText("");
    }

    private void userRegistered(){
        if(userExist()){
            Toast.makeText(MainActivity.this, "This username has been taken.", Toast.LENGTH_SHORT).show();
            userName.setText("");
        }else {
            String uName =  userName.getText().toString();
            String pass =  password.getText().toString();
            String fName =  firstName.getText().toString();
            String lName =  lastName.getText().toString();
            String userEmail =  email.getText().toString();
            Student student = new Student(uName,pass,fName,lName,userEmail);
            studentList.add(student);

            Toast.makeText(MainActivity.this, "You have been successfully registered.", Toast.LENGTH_SHORT).show();
            clearFields();
            login.setChecked(true);
            loginEnable = true;
            viewEnable();

        }
    }

    private void navigateToHome(){
        Intent intent = new Intent(getBaseContext(), HomeActivity.class);
        intent.putExtra("User", "User Name");
        startActivity(intent);
    }

    private boolean validUser(){
        return true;
    }

    private boolean userExist(){
        
        return true;
    }
}
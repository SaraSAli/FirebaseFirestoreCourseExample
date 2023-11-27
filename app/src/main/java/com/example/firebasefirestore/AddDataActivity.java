package com.example.firebasefirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firebasefirestore.model.Courses;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.units.qual.C;

public class AddDataActivity extends AppCompatActivity {

    private EditText courseNameEdtTxt, courseCodeEdtTxt, courseDescriptionEdtTxt;

    private Button submitCourseBtn;
    FirebaseFirestore db;

    private String courseName, courseCode, courseDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        courseNameEdtTxt = findViewById(R.id.edit_text_name);
        courseCodeEdtTxt = findViewById(R.id.edit_text_code);
        courseDescriptionEdtTxt = findViewById(R.id.edit_text_desc);

        submitCourseBtn = findViewById(R.id.save_button);

        db = FirebaseFirestore.getInstance();

        submitCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting data from edittext fields.
                courseName = courseNameEdtTxt.getText().toString();
                courseDescription = courseCodeEdtTxt.getText().toString();
                courseCode = courseDescriptionEdtTxt.getText().toString();

                addDataToFirestore(courseName, courseDescription, courseCode);
            }
        });
    }

    private void addDataToFirestore(String courseName, String courseDescription, String courseCode) {
        CollectionReference dbCourses = db.collection("Courses");

        Courses course = new Courses(courseName, courseDescription, courseCode);
        dbCourses.add(course).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(AddDataActivity.this, "Your Course has been added to Firebase Firestore", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AddDataActivity.this, "Fail to add course \n" + e, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
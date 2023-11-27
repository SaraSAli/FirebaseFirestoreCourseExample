package com.example.firebasefirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ProgressBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.firebasefirestore.model.Courses;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView courseRecyclerView;
    private ArrayList<Courses> coursesArrayList;
    private CourseAdapter courseAdapter;
    FloatingActionButton floatingActionButton;

    ProgressBar loadingPB;

    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseRecyclerView = findViewById(R.id.idRVCourses);
        loadingPB = findViewById(R.id.idProgressBar);

        floatingActionButton = findViewById(R.id.floating_action_button);

        firestore = FirebaseFirestore.getInstance();

        coursesArrayList = new ArrayList<>();
        courseRecyclerView.setHasFixedSize(true);
        courseRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        courseAdapter = new CourseAdapter(coursesArrayList);
        courseRecyclerView.setAdapter(courseAdapter);

        firestore.collection("Courses").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            loadingPB.setVisibility(View.GONE);
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {

                                Courses c = d.toObject(Courses.class);
                                coursesArrayList.add(c);
                            }
                            courseAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(MainActivity.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
                    }
                });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddDataActivity.class));
            }
        });
    }
}
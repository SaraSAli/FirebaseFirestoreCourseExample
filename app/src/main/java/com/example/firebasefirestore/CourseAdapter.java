package com.example.firebasefirestore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebasefirestore.model.Courses;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private ArrayList<Courses> coursesArrayList;

    public CourseAdapter(ArrayList<Courses> coursesArrayList) {
        this.coursesArrayList = coursesArrayList;
    }

    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {
        Courses courses = coursesArrayList.get(position);
        holder.courseNameTV.setText(courses.getCourseName());
        holder.courseCodeTV.setText(courses.getCourseCode());
        holder.courseDescriptionTV.setText(courses.getCourseDescription());
    }

    @Override
    public int getItemCount() {
        return coursesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView courseNameTV, courseCodeTV, courseDescriptionTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseCodeTV = itemView.findViewById(R.id.idTVCourseCode);
            courseDescriptionTV = itemView.findViewById(R.id.idTVCourseDescription);
        }
    }
}

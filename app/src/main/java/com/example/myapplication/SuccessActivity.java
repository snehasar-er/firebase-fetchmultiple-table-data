package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class SuccessActivity extends AppCompatActivity {

	ListView listView;
	DatabaseReference databaseReference;
	List<Success> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_success);

		listView = findViewById(R.id.listviewViewData);

		list = new ArrayList<>();
		databaseReference = FirebaseDatabase.getInstance().getReference("success");

		databaseReference.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
				list.clear();

				for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
					Success success = dataSnapshot1.getValue(Success.class);
					list.add(success);
				}

				MyAdapter adapter = new MyAdapter(SuccessActivity.this, list );
				listView.setAdapter(adapter);
			}

			@Override
			public void onCancelled(@NonNull DatabaseError databaseError) {

			}
		});
	}
}
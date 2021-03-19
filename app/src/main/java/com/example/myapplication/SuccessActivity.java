package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SuccessActivity extends AppCompatActivity implements View.OnClickListener {
	Button btn_insert;
	EditText btn_edit;
	DatabaseReference databaseReference;
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_success);
		btn_insert= findViewById(R.id.button);
		btn_edit=findViewById(R.id.editText1);
		databaseReference = FirebaseDatabase.getInstance().getReference("success");
		btn_insert.setOnClickListener(this);

	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.button:
				String Text = btn_edit.getText().toString().trim();

				if (Text.isEmpty()) {
					btn_edit.setError("Name is required");
					btn_edit.requestFocus();
					return;
				}
				String ID = databaseReference.push().getKey();
				Success success = new Success(ID, Text);
				databaseReference.child(ID).setValue(success).addOnCompleteListener(new OnCompleteListener<Void>() {
					@Override
					public void onComplete(@NonNull Task<Void> task) {
						if (task.isSuccessful()) {
							Toast.makeText(getApplicationContext(), "quotes added successfully", Toast.LENGTH_LONG).show();
						}
					}
				})
						.addOnFailureListener(new OnFailureListener() {
							@Override
							public void onFailure(@NonNull Exception e) {
								Toast.makeText(SuccessActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
							}
						});
		}



		}
	}


package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btn_success, btn_motivate, btn_inspire;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_success=findViewById(R.id.btn_success);
		btn_motivate=findViewById(R.id.btn_motivate);
		btn_inspire=findViewById(R.id.btn_inspire);
		btn_success.setOnClickListener(this);
		btn_motivate.setOnClickListener(this);
		btn_inspire.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
			case R.id.btn_success:
            Intent intent1 = new Intent(MainActivity.this,SuccessActivity.class);
            startActivity(intent1);
				break;
			case R.id.btn_motivate:
				Intent intent2 = new Intent(MainActivity.this,MotivateActivity.class);
				startActivity(intent2);
				break;
			case R.id.btn_inspire:
				Intent intent3 = new Intent(MainActivity.this,InspireActivity.class);
				startActivity(intent3);
				break;
		}
	}
}
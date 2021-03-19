package com.example.myapplication;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class  MyAdapter extends ArrayAdapter<Success> {

	Activity activity;
	List<Success> list;

	public MyAdapter(Activity activity, List<Success> list) {
		super(activity, R.layout.view_success_data, list);
		this.activity = activity;
		this.list = list;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

		LayoutInflater layoutInflater = activity.getLayoutInflater();
		convertView = layoutInflater.inflate(R.layout.view_success_data, null, true);

		TextView ID = convertView.findViewById(R.id.fetch_ID);
		TextView NAME = convertView.findViewById(R.id.fetch_name);


		Success success = list.get(position);

		ID.setText(success.getId());
		NAME.setText(success.getText());


		return convertView;
	}
}

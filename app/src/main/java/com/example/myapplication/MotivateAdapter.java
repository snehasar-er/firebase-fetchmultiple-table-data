package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MotivateAdapter  extends ArrayAdapter<Motivate> {
	Activity activity;
	List<Motivate> list;

	public MotivateAdapter(Activity activity, List<Motivate> list) {
		super(activity, R.layout.view_data_motivate, list);
		this.activity = activity;
		this.list = list;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

		LayoutInflater layoutInflater = activity.getLayoutInflater();
		convertView = layoutInflater.inflate(R.layout.view_data_motivate, null, true);

		TextView ID = convertView.findViewById(R.id.fetch_ID);
		TextView NAME = convertView.findViewById(R.id.fetch_name);


		Motivate motivate = list.get(position);

		ID.setText(motivate.getId());
		NAME.setText(motivate.getText());


		return convertView;
	}
}


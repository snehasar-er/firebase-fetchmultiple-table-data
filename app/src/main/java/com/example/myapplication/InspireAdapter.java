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

public class InspireAdapter  extends ArrayAdapter<Inspire> {
	Activity activity;
	List<Inspire> list;

	public InspireAdapter(Activity activity, List<Inspire> list) {
		super(activity, R.layout.view_data_inspire, list);
		this.activity = activity;
		this.list = list;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

		LayoutInflater layoutInflater = activity.getLayoutInflater();
		convertView = layoutInflater.inflate(R.layout.view_data_inspire, null, true);

		TextView ID = convertView.findViewById(R.id.fetch_ID);
		TextView NAME = convertView.findViewById(R.id.fetch_name);


		Inspire inspire = list.get(position);

		ID.setText(inspire.getId());
		NAME.setText(inspire.getText());


		return convertView;
	}
}



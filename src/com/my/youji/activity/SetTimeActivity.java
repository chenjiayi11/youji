package com.my.youji.activity;
import java.util.Calendar;

import com.my.youji.R;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TextView;


public class SetTimeActivity extends Activity implements OnClickListener {

	private View startDate,endDate;
	private TextView startYear,endYear;
	private TextView startDay,endDay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_time);
		initActivity();
	}
	
	private void initActivity(){
		startDate = findViewById(R.id.setting_time_start_date);
		endDate = findViewById(R.id.setting_time_end_date);
		startYear = (TextView) findViewById(R.id.setting_time_start_year);
		endYear = (TextView) findViewById(R.id.setting_time_end_year);
		startDay = (TextView) findViewById(R.id.setting_time_start_day);
		endDay = (TextView) findViewById(R.id.setting_time_end_day);
		
		startDate.setOnClickListener(this);
		endDate.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View view) {
		DatePickerDialog dialog = null;
		Calendar calendar = Calendar.getInstance();
		switch (view.getId()) {
		case R.id.setting_time_start_date:
			dialog = new DatePickerDialog(this, dateListener1,
					calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
					calendar.get(Calendar.DAY_OF_MONTH));
			dialog.show();
			break;

		case R.id.setting_time_end_date:
			dialog = new DatePickerDialog(this, dateListener2,
					calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
					calendar.get(Calendar.DAY_OF_MONTH));
			dialog.show();
			break;
		}
	}

	private OnDateSetListener dateListener1 = new OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			String yearString = getString(R.string.time_for_year);
			startYear.setText(String.format(yearString, String.valueOf(year)));
			String dayString = getString(R.string.time_for_month_and_day);
			startDay.setText(String.format(dayString, String.valueOf(monthOfYear+1), String.valueOf(dayOfMonth)));
		}
	};
	
	private OnDateSetListener dateListener2 = new OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			String yearString = getString(R.string.time_for_year);
			endYear.setText(String.format(yearString, String.valueOf(year)));
			String dayString = getString(R.string.time_for_month_and_day);
			endDay.setText(String.format(dayString, String.valueOf(monthOfYear+1), String.valueOf(dayOfMonth)));
		}
	};
}

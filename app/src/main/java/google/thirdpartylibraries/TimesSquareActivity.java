package google.thirdpartylibraries;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.squareup.timessquare.CalendarPickerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.BindView;


public class TimesSquareActivity extends AppCompatActivity {

    @BindView(R.id.calendarPickerView)
    CalendarPickerView calendarPickerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times_square);

        ButterKnife.bind(this);

        Calendar nextYear = Calendar.getInstance(); // 2018
        nextYear.add(Calendar.YEAR, 1);      // 2019

        Date today = new Date();

        calendarPickerView.init(today, nextYear.getTime()).withSelectedDate(today);


        calendarPickerView.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                Toast.makeText(TimesSquareActivity.this, formatDate(date), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });
    }

    private String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }
}

package com.unho.unhomeals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.unho.unhomeals.adapter.MainAdapter;
import com.unho.unhomeals.data.Meal;
import com.unho.unhomeals.data.SharedPf;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;

public class ApplyActivity extends AppCompatActivity {

    String UID;
    String monday, friday;

    MainAdapter adapter;

    Button btn_apply;
    CheckBox cb_apply;
    boolean apply_always;

    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy. M. d.");
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);
        findViewById(R.id.exit_apply).setOnClickListener(view -> finish());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 7);

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        friday = dateFormat1.format(calendar.getTime());

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        monday = dateFormat1.format(calendar.getTime());

        TextView tv_weekday = findViewById(R.id.tv_weekday);
        tv_weekday.setText(
            String.format(
                getString(R.string.date_rng),
                monday,
                friday
            )
        );

        // ViewPager2 Adapter
        Meal meal1 = new Meal("??????(???)", "");
        Meal meal2 = new Meal("??????(???)", "");
        Meal meal3 = new Meal("??????(???)", "");
        Meal meal4 = new Meal("??????(???)", "");
        Meal meal5 = new Meal("??????(???)", "");

        ArrayList<Meal> meals = new ArrayList<>(Arrays.asList(meal1, meal2, meal3, meal4, meal5));
        adapter = new MainAdapter(meals);

        String[] contents = new String[5];
        for (int i = 0; i < 5; i++) {
            contents[i] = IntroActivity.dietInfo.get(dateFormat2.format(calendar.getTime())+"??????");
            if (contents[i] == null) contents[i] = "?????? ????????? ????????????.";
            adapter.getItemAt(i).setContent(contents[i]);
            adapter.notifyItemChanged(i);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        // ViewPager2
        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer((page, position) -> page.setScaleY(0.8f+(1-Math.abs(position))*0.2f));

        ViewPager2 vp_meals = findViewById(R.id.vp_meals_apply);
        vp_meals.setAdapter(adapter);
        vp_meals.setOffscreenPageLimit(3);
        vp_meals.setPageTransformer(transformer);

        // Apply Always Checkbox
        cb_apply = findViewById(R.id.cb_apply);
        apply_always = SharedPf.getBoolean(this, "APPLY_ALWAYS");
        if (apply_always) cb_apply.setChecked(true);

        // Apply Button
        btn_apply = findViewById(R.id.btn_apply);

        UID = SharedPf.getString(this, "UID");
        ArrayList<String> applicants = new ArrayList<>(); // TODO SERVER : Get applicants from server

        Calendar today = Calendar.getInstance();
        today.add(Calendar.DAY_OF_WEEK, 2);
        int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);

        if (UID.equals("0")) {
            cb_apply.setVisibility(View.INVISIBLE);
            btn_apply.setBackground(ContextCompat.getDrawable(this, R.color.light));
            btn_apply.setText(getText(R.string.export_applicants));
            if (dayOfWeek == 1 || dayOfWeek > 5) {
                btn_apply.setBackground(ContextCompat.getDrawable(this, R.color.unho));
            }

            btn_apply.setOnClickListener(view -> {
                if (2 <= dayOfWeek && dayOfWeek <= 5) {
                    String message = "?????? ????????? ?????? ????????????.";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    return;
                }

                btn_apply.setBackground(ContextCompat.getDrawable(this, R.color.light));
                btn_apply.setEnabled(false);

                for (int i = 0; i < applicants.size(); i++) {
                    applicants.set(i, IntroActivity.userInfo.get(applicants.get(i))); // TODO SERVER : CONVERT UID TO USER INFO
                }
                download(applicants);

                btn_apply.setBackground(ContextCompat.getDrawable(this, R.color.unho));
                btn_apply.setEnabled(true);
            });
        } else {
            if (applicants.contains(UID)) {
                btn_apply.setBackground(ContextCompat.getDrawable(this, R.color.light));
                btn_apply.setText("????????????");
            }

            btn_apply.setOnClickListener(view -> {
                String text = btn_apply.getText().toString();
                if (text.equals("????????????")) {
                    btn_apply.setBackground(ContextCompat.getDrawable(this, R.color.light));
                    btn_apply.setText("????????????");
                } else {
                    btn_apply.setBackground(ContextCompat.getDrawable(this, R.color.unho));
                    btn_apply.setText("????????????");
                }
            });
        }
    }

    private void download(ArrayList<String> applicants) {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row;
        Cell cell;

        row = sheet.createRow(0);

        cell = row.createCell(0);
        cell.setCellValue("??????");
        cell = row.createCell(1);
        cell.setCellValue("??????");

        for (int i = 0; i < applicants.size(); i++) {
            String[] applicant = applicants.get(i).split(" ");
            row = sheet.createRow(i+1);

            cell = row.createCell(0);
            cell.setCellValue(applicant[0]);
            cell = row.createCell(1);
            cell.setCellValue(applicant[1]);
        }

        try {
            String date = dateFormat2.format(Objects.requireNonNull(dateFormat1.parse(monday)));

            File parent = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(parent, date+"??????????????????.xls");

            FileOutputStream os = new FileOutputStream(file);
            workbook.write(os);

            String message = "???????????? ????????? ?????????????????????.";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        } catch (IOException | ParseException ignored) {
            String message = "????????? ??? ????????????.";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPf.put(this, "APPLY_ALWAYS", cb_apply.isChecked());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String text = btn_apply.getText().toString();
        if (text.equals("????????????") || apply_always) {
            // TODO SERVER : Send "UID" to server
        }
    }
}
package com.example.homelogpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class bargraph extends AppCompatActivity {

    private DatabaseReference node;
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList<BarEntry> barEntries;
    ArrayList<String> xlabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bargraph);

        barChart = findViewById(R.id.barchart);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        node = FirebaseDatabase.getInstance().getReference().child("marks").child(key).child("Maths marks");
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String quest1 = snapshot.child("addquest1").getValue().toString();
                String quest2 = snapshot.child("addquest2").getValue().toString();
                String quest3 = snapshot.child("addquest3").getValue().toString();
                String squest1 = snapshot.child("subquest1").getValue().toString();
                String squest2 = snapshot.child("subquest2").getValue().toString();
                String squest3 = snapshot.child("subquest3").getValue().toString();
                String cquest1 = snapshot.child("compquest1").getValue().toString();
                String cquest2 = snapshot.child("compquest2").getValue().toString();
                String cquest3 = snapshot.child("compquest3").getValue().toString();
                int ay1 = Integer.parseInt(quest1);
                int ay2 = Integer.parseInt(quest2);
                int ay3 = Integer.parseInt(quest3);
                int sy1 = Integer.parseInt(squest1);
                int sy2 = Integer.parseInt(squest2);
                int sy3 = Integer.parseInt(squest3);
                int cy1 = Integer.parseInt(cquest1);
                int cy2 = Integer.parseInt(cquest2);
                int cy3 = Integer.parseInt(cquest3);
                int a = ay1+ay2+ay3;
                int s = sy1+sy2+sy3;
                int c = cy1+cy2+cy3;
                barEntries = new ArrayList<>();
                barEntries.add(new BarEntry(1, a));
                barEntries.add(new BarEntry(2,s));
                barEntries.add(new BarEntry(3,c));
                barDataSet = new BarDataSet(barEntries,"Data Set");
                barData = new BarData(barDataSet);
                barChart.setData(barData);
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);
                barChart.setFitBars(true);
                barChart.getDescription().setText("Bar Chart Example");
                barChart.animateY(2000);

                xlabel = new ArrayList<>();
                xlabel.add("");
                xlabel.add("Addition");
                xlabel.add("Subtraction");
                xlabel.add("Comparison");
                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(xlabel));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        node.addValueEventListener(postListener);
    }
}
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
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class threegraphs extends AppCompatActivity {

    private DatabaseReference node;
    BarChart barChart1,barChart2,barChart3;
    BarData barData,barData2,barData3;
    BarDataSet barDataSet;
    ArrayList<BarEntry> barEntries;
    ArrayList<BarEntry> barEntries2;
    ArrayList<BarEntry> barEntries3;
    ArrayList<String> xlabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threegraphs);

        barChart1 = findViewById(R.id.barchart1);
        barChart2 = findViewById(R.id.barchart2);
        barChart3 = findViewById(R.id.barchart3);
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

                xlabel = new ArrayList<>();
                xlabel.add("");
                xlabel.add("Addition");
                xlabel.add("Subtraction");
                xlabel.add("Comparison");
                XAxis xAxis = barChart1.getXAxis();
                xAxis.setGranularity(1f);
                xAxis.setValueFormatter(new IndexAxisValueFormatter(xlabel));

                barDataSet = new BarDataSet(barEntries,"marks");
                barData = new BarData(barDataSet);
                barChart1.setData(barData);
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);
                barChart1.setFitBars(true);
                barChart1.getDescription().setText("");
                barChart1.animateY(2000);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        node.addValueEventListener(postListener);




        node = FirebaseDatabase.getInstance().getReference().child("marks").child(key).child("EVS marks");
        ValueEventListener postListener2 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String aquest1 = snapshot.child("aniquest1").getValue().toString();
                String aquest2 = snapshot.child("aniquest2").getValue().toString();
                String aquest3 = snapshot.child("aniquest3").getValue().toString();
                String fquest1 = snapshot.child("fquestion1").getValue().toString();
                String fquest2 = snapshot.child("fquestion2").getValue().toString();
                String fquest3 = snapshot.child("fquest3").getValue().toString();
                String hquest1 = snapshot.child("hquest1").getValue().toString();
                String hquest2 = snapshot.child("hquest2").getValue().toString();
                String hquest3 = snapshot.child("hquest3").getValue().toString();
                int any1 = Integer.parseInt(aquest1);
                int any2 = Integer.parseInt(aquest2);
                int any3 = Integer.parseInt(aquest3);
                int fy1 = Integer.parseInt(fquest1);
                int fy2 = Integer.parseInt(fquest2);
                int fy3 = Integer.parseInt(fquest3);
                int hy1 = Integer.parseInt(hquest1);
                int hy2 = Integer.parseInt(hquest2);
                int hy3 = Integer.parseInt(hquest3);
                int an = any1+any2+any3;
                int f = fy1+fy2+fy3;
                int h = hy1+hy2+hy3;
                barEntries2 = new ArrayList<>();
                barEntries2.add(new BarEntry(1, an));
                barEntries2.add(new BarEntry(2,f));
                barEntries2.add(new BarEntry(3,h));
                barDataSet = new BarDataSet(barEntries2,"marks");
                barData2 = new BarData(barDataSet);
                barChart2.setData(barData2);
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);
                barChart2.setFitBars(true);
                barChart2.getDescription().setText("");
                barChart2.animateY(2000);

                xlabel = new ArrayList<>();
                xlabel.add("");
                xlabel.add("Animals");
                xlabel.add("Festivals");
                xlabel.add("Humanbody");
                XAxis xAxis = barChart2.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(xlabel));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        node.addValueEventListener(postListener2);




        node = FirebaseDatabase.getInstance().getReference().child("marks").child(key).child("English marks");
        ValueEventListener postListener3 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String alquest1 = snapshot.child("alphabetquest1").getValue().toString();
                String alquest2 = snapshot.child("alphabetquest2").getValue().toString();
                String alquest3 = snapshot.child("alphabetquest3").getValue().toString();
                String rquest1 = snapshot.child("rquest1").getValue().toString();
                String rquest2 = snapshot.child("rquest2").getValue().toString();
                String rquest3 = snapshot.child("rquest3").getValue().toString();
                String sentquest1 = snapshot.child("squest1").getValue().toString();
                String sentquest2 = snapshot.child("squest2").getValue().toString();
                String sentquest3 = snapshot.child("squest3").getValue().toString();
                int aly1 = Integer.parseInt(alquest1);
                int aly2 = Integer.parseInt(alquest2);
                int aly3 = Integer.parseInt(alquest3);
                int ry1 = Integer.parseInt(rquest1);
                int ry2 = Integer.parseInt(rquest2);
                int ry3 = Integer.parseInt(rquest3);
                int scy1 = Integer.parseInt(sentquest1);
                int scy2 = Integer.parseInt(sentquest2);
                int scy3 = Integer.parseInt(sentquest3);
                int al = aly1+aly2+aly3;
                int r = ry1+ry2+ry3;
                int sc = scy1+scy2+scy3;
                barEntries3 = new ArrayList<>();
                barEntries3.add(new BarEntry(1, al));
                barEntries3.add(new BarEntry(2,r));
                barEntries3.add(new BarEntry(3,sc));
                barDataSet = new BarDataSet(barEntries3,"marks");
                barData3 = new BarData(barDataSet);
                barChart3.setData(barData3);
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);
                barChart3.setFitBars(true);
                barChart3.getDescription().setText("");
                barChart3.animateY(2000);

                xlabel = new ArrayList<>();
                xlabel.add("");
                xlabel.add("Alphabet");
                xlabel.add("Rhyming");
                xlabel.add("Sentance");
                XAxis xAxis = barChart3.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(xlabel));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        node.addValueEventListener(postListener3);

    }
}
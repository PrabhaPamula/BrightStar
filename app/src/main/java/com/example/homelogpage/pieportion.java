package com.example.homelogpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.collection.LLRBNode;

import java.util.ArrayList;
import java.util.Collections;

public class pieportion extends AppCompatActivity {

    PieChart pieChart;
    private DatabaseReference node;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pieportion);

        pieChart = (PieChart) findViewById(R.id.piechart);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");

        node = FirebaseDatabase.getInstance().getReference().child("pievalue").child(key);
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
                int a1 = Integer.parseInt(quest1);
                int a2 = Integer.parseInt(quest2);
                int a3 = Integer.parseInt(quest3);
                int s1 = Integer.parseInt(squest1);
                int s2 = Integer.parseInt(squest2);
                int s3 = Integer.parseInt(squest3);
                int c1 = Integer.parseInt(cquest1);
                int c2 = Integer.parseInt(cquest2);
                int c3 = Integer.parseInt(cquest3);

                String alquest1 = snapshot.child("alphabetquest1").getValue().toString();
                String alquest2 = snapshot.child("alphabetquest2").getValue().toString();
                String alquest3 = snapshot.child("alphabetquest3").getValue().toString();
                String rquest1 = snapshot.child("rquest1").getValue().toString();
                String rquest2 = snapshot.child("rquest2").getValue().toString();
                String rquest3 = snapshot.child("rquest3").getValue().toString();
                String sentquest1 = snapshot.child("squest1").getValue().toString();
                String sentquest2 = snapshot.child("squest2").getValue().toString();
                String sentquest3 = snapshot.child("squest3").getValue().toString();
                int e1 = Integer.parseInt(alquest1);
                int e2 = Integer.parseInt(alquest2);
                int e3 = Integer.parseInt(alquest3);
                int r1 = Integer.parseInt(rquest1);
                int r2 = Integer.parseInt(rquest2);
                int r3 = Integer.parseInt(rquest3);
                int sc1 = Integer.parseInt(sentquest1);
                int sc2 = Integer.parseInt(sentquest2);
                int sc3 = Integer.parseInt(sentquest3);

                String aquest1 = snapshot.child("aniquest1").getValue().toString();
                String aquest2 = snapshot.child("aniquest2").getValue().toString();
                String aquest3 = snapshot.child("aniquest3").getValue().toString();
                String fquest1 = snapshot.child("fquestion1").getValue().toString();
                String fquest2 = snapshot.child("fquestion2").getValue().toString();
                String fquest3 = snapshot.child("fquest3").getValue().toString();
                String hquest1 = snapshot.child("hquest1").getValue().toString();
                String hquest2 = snapshot.child("hquest2").getValue().toString();
                String hquest3 = snapshot.child("hquest3").getValue().toString();
                int an1 = Integer.parseInt(aquest1);
                int an2 = Integer.parseInt(aquest2);
                int an3 = Integer.parseInt(aquest3);
                int f1 = Integer.parseInt(fquest1);
                int f2 = Integer.parseInt(fquest2);
                int f3 = Integer.parseInt(fquest3);
                int h1 = Integer.parseInt(hquest1);
                int h2 = Integer.parseInt(hquest2);
                int h3 = Integer.parseInt(hquest3);

                int complete = a1+a2+a3+s1+s2+s3+c1+c2+c3+e1+e2+e3+r1+r2+r3+sc1+sc2+sc3+an1+an2+an3+f1+f2+f3+h1+h2+h3;
                int incomplete = 27-complete;

                ArrayList<PieEntry> records=new ArrayList<>();
                records.add(new PieEntry(complete, "Done"));
                records.add(new PieEntry(incomplete, "Remaining"));

                PieDataSet dataSet = new PieDataSet(records,"Pie Chart Report");
                dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                dataSet.setValueTextColor(Color.BLACK);
                dataSet.setValueTextSize(22f);

                PieData pieData = new PieData(dataSet);

                pieChart.setData(pieData);
                pieChart.getDescription().setEnabled(false);
                pieChart.setCenterText("Portion");
                pieChart.animate();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        node.addValueEventListener(postListener);

       /* ArrayList<PieEntry> records=new ArrayList<>();
        records.add(new PieEntry(32, "Quater1"));
        records.add(new PieEntry(14, "Quater2"));
        records.add(new PieEntry(34, "Quater3"));
        records.add(new PieEntry(38, "Quater4"));

        PieDataSet dataSet = new PieDataSet(records,"Pie Chart Report");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(22f);

        PieData pieData = new PieData(dataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(true);
        pieChart.setCenterText("Portion Chart");
        pieChart.animate();*/
    }
}
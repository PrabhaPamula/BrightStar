package com.example.homelogpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineChart extends AppCompatActivity {
    com.github.mikephil.charting.charts.LineChart lineChart;
    private DatabaseReference node;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        lineChart=findViewById(R.id.linechart);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        node = FirebaseDatabase.getInstance().getReference().child("marks").child(key);
        ValueEventListener postListener = new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String quest1 = snapshot.child("Maths marks").child("addquest1").getValue().toString();
                String quest2 = snapshot.child("Maths marks").child("addquest2").getValue().toString();
                String quest3 = snapshot.child("Maths marks").child("addquest3").getValue().toString();
                String squest1 = snapshot.child("Maths marks").child("subquest1").getValue().toString();
                String squest2 = snapshot.child("Maths marks").child("subquest2").getValue().toString();
                String squest3 = snapshot.child("Maths marks").child("subquest3").getValue().toString();
                String cquest1 = snapshot.child("Maths marks").child("compquest1").getValue().toString();
                String cquest2 = snapshot.child("Maths marks").child("compquest2").getValue().toString();
                String cquest3 = snapshot.child("Maths marks").child("compquest3").getValue().toString();
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
                int f=a+s+c;

                String aquest1 = snapshot.child("EVS marks").child("aniquest1").getValue().toString();
                String aquest2 = snapshot.child("EVS marks").child("aniquest2").getValue().toString();
                String aquest3 = snapshot.child("EVS marks").child("aniquest3").getValue().toString();
                String fquest1 = snapshot.child("EVS marks").child("fquestion1").getValue().toString();
                String fquest2 = snapshot.child("EVS marks").child("fquestion2").getValue().toString();
                String fquest3 = snapshot.child("EVS marks").child("fquest3").getValue().toString();
                String hquest1 = snapshot.child("EVS marks").child("hquest1").getValue().toString();
                String hquest2 = snapshot.child("EVS marks").child("hquest2").getValue().toString();
                String hquest3 = snapshot.child("EVS marks").child("hquest3").getValue().toString();
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
                int fy = fy1+fy2+fy3;
                int h = hy1+hy2+hy3;
                int evs=an+fy+h;

                String alquest1 = snapshot.child("English marks").child("alphabetquest1").getValue().toString();
                String alquest2 = snapshot.child("English marks").child("alphabetquest2").getValue().toString();
                String alquest3 = snapshot.child("English marks").child("alphabetquest3").getValue().toString();
                String rquest1 = snapshot.child("English marks").child("rquest1").getValue().toString();
                String rquest2 = snapshot.child("English marks").child("rquest2").getValue().toString();
                String rquest3 = snapshot.child("English marks").child("rquest3").getValue().toString();
                String sentquest1 = snapshot.child("English marks").child("squest1").getValue().toString();
                String sentquest2 = snapshot.child("English marks").child("squest2").getValue().toString();
                String sentquest3 = snapshot.child("English marks").child("squest3").getValue().toString();
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
                int eng=al+r+sc;


                ArrayList<Entry> information= new ArrayList<>();
                information.add(new Entry(1,f));
                information.add(new Entry(2,evs));
                information.add(new Entry(3,eng));


                LineDataSet lineDataSet=new LineDataSet(information,"Marks");
                lineChart.getDescription().setText("");
                lineDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                lineDataSet.setValueTextColor(Color.BLACK);
                lineDataSet.setCircleRadius(10);
                lineDataSet.setValueTextSize(20f);

                LineData lineData=new LineData(lineDataSet);

                lineChart.setData(lineData);
                lineChart.animateY(2000);

                XAxis xAxis = lineChart.getXAxis();
                xAxis.setDrawAxisLine(false);
                //xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);


                String[] xAxisVals = new String[]{"","Maths", "EVS", "English"};
                xAxis.setGranularity(1f);
                xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisVals));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        node.addValueEventListener(postListener);
    }
}
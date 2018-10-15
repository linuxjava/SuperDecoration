package com.example.myapplication;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import xiao.free.decoration.HorizontalDividerItemDecoration;
import xiao.free.superadapter.recycview.CommonAdapter;
import xiao.free.superadapter.recycview.base.ViewHolder;

public class VerticalActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private CommonAdapter mCommonAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical);

        mRecyclerView = findViewById(R.id.recyclerview);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCommonAdapter = new CommonAdapter<String>(this, R.layout.item_vertical_text) {
            @Override
            protected void convert(ViewHolder holder, String o, int position) {
                holder.setText(R.id.text_content, o);
            }
        };

        //使用color绘制
//        mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
//                .size(1).margin(20, 20)
//                .colorResId(R.color.colorAccent)
//                .build());
        //使用drawable绘制
//        mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
//                .drawable(R.drawable.shape_divider)
//                .build());

        //使用paint绘制
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            //需要开启LAYER_TYPE_SOFTWARE，否则setPathEffect无效果
            mRecyclerView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        Paint paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setPathEffect(new DashPathEffect(new float[]{25.0f, 25.0f}, 0));
        mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
                .paint(paint)
                .showLastDivider()
                .build());

        mRecyclerView.setAdapter(mCommonAdapter);

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            data.add("position " + i);
        }

        mCommonAdapter.setDatas(data);
    }
}

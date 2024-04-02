package com.project.guido_yourtrekmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

public class DetailActivity extends AppCompatActivity {
    ImageButton imageButton;
    TextView detailTitle,detailDesc, detailRat, detailLoc, detailDist, detailTime, detailMonth;
    ImageView imageView;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tabLayout =findViewById(R.id.tl_detail);
        viewPager =findViewById(R.id.vp_detail);
        imageButton =findViewById(R.id.iv_back);
        imageView =findViewById(R.id.iv_trek);
        detailTitle = findViewById(R.id.tv_title);
        detailDesc=findViewById(R.id.tv_desc);
        detailLoc=findViewById(R.id.tv_Loc);
        detailRat=findViewById(R.id.tv_Rat);
        detailDist=findViewById(R.id.tv_distance);
        detailTime=findViewById(R.id.tv_time);
        detailMonth=findViewById(R.id.tv_month);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            detailTitle.setText(bundle.getString("Title"));
            detailDesc.setText(bundle.getString("Desc"));
            detailLoc.setText(bundle.getString("Loc"));
            detailRat.setText(bundle.getString("Rat"));
            detailDist.setText(bundle.getString("Dist"));
            detailTime.setText(bundle.getString("Time"));
            detailMonth.setText(bundle.getString("Month"));
            Glide.with(this).load(bundle.getString("Image")).into(imageView);
        }

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });



        tabLayout.setupWithViewPager(viewPager);
        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new Review(),"Review");
        vpAdapter.addFragment(new Weather(),"Weather");
        viewPager.setAdapter(vpAdapter);
    }
}
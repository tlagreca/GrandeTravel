package com.thomasjamesdev.thomas.grandetravel;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnViewAll;
    Button btnSearch;
    EditText editTextSearchField;
    TextView textViewTitle;
    TextView textViewSubTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnViewAll = (Button) findViewById(R.id.btn_view_all);
        btnSearch = (Button) findViewById(R.id.btn_search);
        editTextSearchField = (EditText) findViewById(R.id.et_search_field);
        editTextSearchField.setVisibility(View.GONE);
        textViewTitle = (TextView)findViewById(R.id.tv_title);
        textViewSubTitle = (TextView)findViewById(R.id.tv_sub_title);


    }


    public void clickSearch(View view) {

        btnViewAll.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_out_right));
        editTextSearchField.setVisibility(View.VISIBLE);
        btnViewAll.setVisibility(View.GONE);
        textViewSubTitle.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_out_right));
        textViewSubTitle.setVisibility(View.GONE);
        editTextSearchField.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left));
    }

    public void clickViewAll(View view){
        Intent searchResultsIntent = new Intent(MainActivity.this, SearchResultsActivity.class);
        getWindow().setExitTransition(new Slide());
        startActivity(searchResultsIntent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
    }

}

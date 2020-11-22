package com.example.myspinninglib;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class SuperSpinner extends LinearLayout {

    private SpinningLayer spinningLayer;
    private Context context;
    private List<String> quotesList;
    private ProgressBar progressBar;
    private TextView textView;
    private boolean showQuotes = false;
    private String loadingText = "";

    public SuperSpinner(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public SuperSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public SuperSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    public SuperSpinner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        init();
    }

    private void init(){
        this.setOrientation(VERTICAL);
        this.setVisibility(GONE);
        spinningLayer = new SpinningLayer().invoke();
        quotesList = new ArrayList<>();
        createProgressBar();
        createTextView();

        this.addView(progressBar);
        this.addView(textView);
    }

    private void createTextView() {
        textView = new TextView(context);
    }

    private void createProgressBar(){
        progressBar = new ProgressBar(context,null, android.R.attr.progressBarStyle);
        progressBar.setIndeterminateDrawable(spinningLayer.getLayerDrawable());
        progressBar.setPadding(0,10,0,25);
    }

    public void setIcon(Drawable icon) {
        spinningLayer.getSpinningLogo().setDrawable(icon);
        progressBar.setIndeterminateDrawable(spinningLayer.getLayerDrawable());
    }
    public void setIcon(int icon) {
        spinningLayer.getSpinningLogo().setDrawable(ContextCompat.getDrawable(context, icon));
        progressBar.setIndeterminateDrawable(spinningLayer.getLayerDrawable());
    }

    public void setSpinDegree(int degree){
        spinningLayer.getSpinningLogo().setToDegrees(degree);
        progressBar.setIndeterminateDrawable(spinningLayer.getLayerDrawable());
    }

    public void setLoadingText(String text){
        this.showQuotes = false;
        this.loadingText = text;
        textView.setText(text);
    }

    public void setLoadingQuotes(List<String> quotesList){
        this.showQuotes = true;
        this.quotesList = quotesList;
    }

    public void showSpin(){
        this.setVisibility(VISIBLE);
        if(showQuotes && quotesList != null && !quotesList.isEmpty()){
            int num = generateQuoteNumber(0, quotesList.size());
            Log.i("LOADING", "setLoadingQuotes: " + num);
            textView.setText(quotesList.get(num));
        } else if(!loadingText.isEmpty() && !loadingText.equals("")){
            textView.setText(loadingText);
        }
    }

    private int generateQuoteNumber(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public void setShowQuotes(boolean show){
        this.showQuotes = show;
    }
    public void stopSpin(){
        this.setVisibility(GONE);
    }


    private class SpinningLayer {
        private LayerDrawable layerDrawable;
        private RotateDrawable spinningLogo;

        public LayerDrawable getLayerDrawable() {
            return layerDrawable;
        }

        public RotateDrawable getSpinningLogo() {
            return spinningLogo;
        }

        public SpinningLayer invoke() {
            layerDrawable = (LayerDrawable) ContextCompat.getDrawable(context, R.drawable.progress_icon);
            spinningLogo = (RotateDrawable) Objects.requireNonNull(layerDrawable)
                    .findDrawableByLayerId(R.id.spinning_logo);
            return this;
        }
    }
}

package com.example.myspinninglib;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class SuperSpinner extends LinearLayout {

    /**
     * The context which the superSpinner attached to.
     */
    private Context context;

    /**
     * The layer which holds the spinning logo and the rotation
     */
    private SpinningLayer spinningLayer;

    /**
     * List of quotes to display under the super spinner
     */
    private List<String> quotesList;

    /**
     * Progress bar which will be customized as our spinner
     */
    private ProgressBar progressBar;

    /**
     * Text to be shown under the spinner logo
     */
    private String loadingText = "";

    /**
     * TextView under the logo
     */
    private TextView textView;

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

    /**
     * Initialize all views and their default values
     */
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

    /**
     * Initialize TextView
     */
    private void createTextView() {
        textView = new TextView(context);
        textView.setTextAlignment(TEXT_ALIGNMENT_CENTER);
    }

    /**
     * Initialize our progress bar
     */
    private void createProgressBar(){
        progressBar = new ProgressBar(context,null, android.R.attr.progressBarStyle);
        progressBar.setIndeterminateDrawable(spinningLayer.getLayerDrawable());
        progressBar.setPadding(0,10,0,25);
    }

    /**
     * This method allows to change the spinner logo
     *
     * @param icon a drawable of the spinning logo
     */
    public void setIcon(Drawable icon) {
        spinningLayer.getSpinningLogo().setDrawable(icon);
        progressBar.setIndeterminateDrawable(spinningLayer.getLayerDrawable());
    }
    /**
     * This method allows to change the spinner logo
     *
     * @param icon an int of the resource id for the spinning logo
     */
    public void setIcon(int icon) {
        spinningLayer.getSpinningLogo().setDrawable(ContextCompat.getDrawable(context, icon));
        progressBar.setIndeterminateDrawable(spinningLayer.getLayerDrawable());
    }

    /**
     * This method let you change the amount of degrees the logo spins
     *
     * @param degree a drawable of the spinning logo
     */
    public void setSpinDegree(int degree){
        spinningLayer.getSpinningLogo().setToDegrees(degree);
        progressBar.setIndeterminateDrawable(spinningLayer.getLayerDrawable());
    }

    /**
     * This method let you add text underneath the spinning logo
     *
     * @param text a drawable of the spinning logo
     */
    public void setLoadingText(String text){
        this.loadingText = text;
        textView.setText(text);
    }

    /**
     * This method let you add list of quotes to show underneath the logo
     *
     * @param quotesList a drawable of the spinning logo
     */
    public void setLoadingQuotes(List<String> quotesList){
        this.quotesList = quotesList;
    }

    /**
     * This method shows & start the loading spinner
     */
    public void showSpin(){
        this.setVisibility(VISIBLE);
        if(quotesList != null && !quotesList.isEmpty()){
            int num = generateQuoteNumber(0, quotesList.size());
            Log.i("LOADING", "setLoadingQuotes: " + num);
            textView.setText(quotesList.get(num));
        } else if(!loadingText.isEmpty() && !loadingText.equals("")){
            textView.setText(loadingText);
        }
    }

    /**
     * This method generate a quote number to be chosen
     */
    private int generateQuoteNumber(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    /**
     * This method hides the spinning logo
     */
    public void stopSpin(){
        this.setVisibility(GONE);
    }


    /**
     * Layerlist for our spinning logo
     */
    private class SpinningLayer {
        private LayerDrawable layerDrawable;
        private RotateDrawable spinningLogo;

        public LayerDrawable getLayerDrawable() {
            return layerDrawable;
        }

        public RotateDrawable getSpinningLogo() {
            return spinningLogo;
        }

        /**
         * Initialize using progress_icon.xml for rotate functionality
         */
        public SpinningLayer invoke() {
            layerDrawable = (LayerDrawable) ContextCompat.getDrawable(context, R.drawable.progress_icon);
            spinningLogo = (RotateDrawable) Objects.requireNonNull(layerDrawable)
                    .findDrawableByLayerId(R.id.spinning_logo);
            return this;
        }
    }
}

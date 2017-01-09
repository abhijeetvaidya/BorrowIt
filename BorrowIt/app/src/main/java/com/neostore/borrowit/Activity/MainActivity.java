package com.neostore.borrowit.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neostore.borrowit.Fragment.AboutUsFragment;
import com.neostore.borrowit.Fragment.CalculatorFragment;
import com.neostore.borrowit.Fragment.ContactUsFragment;
import com.neostore.borrowit.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageCal, imageAbout, imageContact, imageReload, imageLoanCal;
    TextView txtCal, txtAbout, txtContact;
    LinearLayout linCalulator, linAbout, linContact;
    private CalculatorFragment calculatorFragment;
    private ContactUsFragment contactusFragment;
    private AboutUsFragment aboutUsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageCal = (ImageView) findViewById(R.id.imgcal);
        imageAbout = (ImageView) findViewById(R.id.imgabout);
        imageContact = (ImageView) findViewById(R.id.imgcontact);
        imageReload = (ImageView) findViewById(R.id.imgReload);
        //imageLoanCal = (ImageView) findViewById(R.id.imgLoanCal);
        txtCal = (TextView) findViewById(R.id.txtCalculator);
        txtAbout = (TextView) findViewById(R.id.txtAbout);
        txtContact = (TextView) findViewById(R.id.txtConatactUs);
        linCalulator = (LinearLayout) findViewById(R.id.linCalculator);
        linAbout = (LinearLayout) findViewById(R.id.linAbout);
        linContact = (LinearLayout) findViewById(R.id.linContactUs);
        linCalulator.setOnClickListener(this);
        linAbout.setOnClickListener(this);
        linContact.setOnClickListener(this);
        imageReload.setOnClickListener(this);
        LoadCalculatorFragment();
        LinCalClick();
    }

    public void LinCalClick() {
        imageReload.setVisibility(View.VISIBLE);
        txtCal.setTextColor(Color.parseColor("#4171FE"));
        imageCal.setImageResource(R.drawable.calculator_selected);
        imageAbout.setImageResource(R.drawable.about_unselected);
        imageContact.setImageResource(R.drawable.contact_unselected);
        txtAbout.setTextColor(Color.parseColor("#000000"));
        txtContact.setTextColor(Color.parseColor("#000000"));
    }

    public void LinAboutClick() {
        imageReload.setVisibility(View.INVISIBLE);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 100);
        params.gravity= Gravity.RIGHT;
        //imageLoanCal.setLayoutParams(params);
        imageAbout.setImageResource(R.drawable.about_selected);
        imageCal.setImageResource(R.drawable.calculator_unselected);
        imageContact.setImageResource(R.drawable.contact_unselected);
        txtCal.setTextColor(Color.parseColor("#000000"));
        txtAbout.setTextColor(Color.parseColor("#4171FE"));
        txtContact.setTextColor(Color.parseColor("#000000"));
    }

    public void LinkContactUs() {
        imageReload.setVisibility(View.INVISIBLE);
        imageContact.setImageResource(R.drawable.contact_selected);
        imageCal.setImageResource(R.drawable.calculator_unselected);
        imageAbout.setImageResource(R.drawable.about_unselected);
        txtContact.setTextColor(Color.parseColor("#4171FE"));
        txtCal.setTextColor(Color.parseColor("#000000"));
        txtAbout.setTextColor(Color.parseColor("#000000"));
    }

    public void LoadCalculatorFragment() {
        calculatorFragment = new CalculatorFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.framContainer, calculatorFragment).commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.imgReload:
                LinCalClick();
                calculatorFragment = new CalculatorFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.framContainer, calculatorFragment).commit();
                break;
            case R.id.linCalculator:
                LinCalClick();
                calculatorFragment = new CalculatorFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.framContainer, calculatorFragment).commit();
                break;
            case R.id.linAbout:
                LinAboutClick();
                aboutUsFragment = new AboutUsFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.framContainer, aboutUsFragment).commit();
                break;
            case R.id.linContactUs:
                LinkContactUs();
                contactusFragment = new ContactUsFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.framContainer, contactusFragment).commit();
                break;
        }
    }
}

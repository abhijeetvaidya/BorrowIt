package com.neostore.borrowit.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.neostore.borrowit.Activity.EnquiryActivity;
import com.neostore.borrowit.R;

public class ContactUsFragment extends Fragment implements View.OnClickListener {

    Button btnCall, btnEnq;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCall = (Button) view.findViewById(R.id.btnCall);
        btnEnq = (Button) view.findViewById(R.id.btnEnquiry);
        btnCall.setOnClickListener(this);
        btnEnq.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnCall:
                super.onResume();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:131497"));
                startActivity(callIntent);
                break;
            case R.id.btnEnquiry:
                Intent intentEnquiry = new Intent(getActivity(), EnquiryActivity.class);
                startActivity(intentEnquiry);
                break;
        }
    }
}

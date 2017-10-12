package com.ikidi.pehdesign.ikidi_android;

import android.annotation.TargetApi;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.Manifest.permission.READ_CONTACTS;

public class AddNewPostActivity extends AppCompatActivity {

    private EditText mTitleView;
    private EditText mDescriptionView;
    private EditText mDataExpired;

    Button okButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_post);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        mTitleView = (EditText) findViewById(R.id.addTitle);
        mDataExpired = (EditText) findViewById(R.id.addDataExpired);
        mDescriptionView = (EditText) findViewById(R.id.addDescription);
        okButton = (Button) findViewById(R.id.okButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        mTitleView.setError(null);
        mDataExpired.setError(null);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Store values at the time of the login attempt.
                String title = mTitleView.getText().toString();
                String dataExpired = mDataExpired.getText().toString();

                boolean cancel = false;
                View focusView = null;

                // Check for a valid password, if the user entered one.
                if (TextUtils.isEmpty(title)) {
                    mTitleView.setError(getString(R.string.error_field_required));
                    focusView = mTitleView;
                    cancel = true;
                }

                // Check for a valid email address.
                if (TextUtils.isEmpty(dataExpired)) {
                    mDataExpired.setError(getString(R.string.error_field_required));
                    focusView = mDataExpired;
                    cancel = true;
                }

                if (cancel) {
                    // There was an error; don't attempt login and focus the first
                    // form field with an error.
                    focusView.requestFocus();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                setResult(RESULT_CANCELED, returnIntent);
                finish();
            }
        });
    }

}

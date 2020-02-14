package com.gridev.validateform;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;



/**
 * A simple {@link Fragment} subclass.
 */
public class FormValidationFragment extends Fragment {

    private AwesomeValidation validation;

    // Views ...
    private EditText name;
    private EditText date;
    private EditText email;
    private EditText password;
    private Button submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_form_validation, container, false);

        // Initialize Views
        initializeViews(view);


        // Step 1 : Create Awesome Validation Object
        validation = new AwesomeValidation(ValidationStyle.BASIC);

        // Step 2 : Add Validation to views
        validation.addValidation(name, "^[A-Z]{4,}$", getString(R.string.err_name));
        validation.addValidation(date, "^(19|20)[0-9][0-9][-/](0[1-9]|1[012])[-/](0[1-9]|[12][0-9]|3[01])$", getString(R.string.err_date));
        validation.addValidation(email, "^[a-z]*@tdi.com$", getString(R.string.err_email) );
        validation.addValidation(password, "^[A-Z][a-zA-Z]{2,4}[0-9]{2}[A-Za-z]", getString(R.string.err_pass));

        return view;
    }

    // step 3 ctrl + o to generate onActivityCreated
    // In Fragment you cant validate AwesomeValidation Object in onCreateView lifecycle
    // So you need to do it onActivityCreated Lifecycle

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // step 4 : Validate
                validation.validate();
            }
        });
    }

    private void initializeViews(View view) {
        name = view.findViewById(R.id.name);
        date = view.findViewById(R.id.date);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);
        submit = view.findViewById(R.id.submit);
    }
}




package com.droidev.util.expensetracker.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.droidev.util.expensetracker.R;
import com.droidev.util.expensetracker.model.GenericResponse;
import com.droidev.util.expensetracker.model.RestError;
import com.droidev.util.expensetracker.model.UserLoginDetails;
import com.droidev.util.expensetracker.network.NetworkAdapter;
import com.droidev.util.expensetracker.network.ResponseCallback;
import com.droidev.util.expensetracker.utils.GeneralUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int MINIMUM_PASSWORD_LENGTH = 6;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initClickListeners();
    }

    private void initClickListeners() {
        findViewById(R.id.not_registered_text_view).setOnClickListener(this);
        findViewById(R.id.sign_in_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.not_registered_text_view):
                navigateToSignUpScreen();
                break;
            case (R.id.sign_in_button):
                fetchEmailAndPassword();
                break;
        }

    }

    private void fetchEmailAndPassword() {
        mEmailEditText = (EditText) findViewById(R.id.account_id_edit_text);
        String email = mEmailEditText.getText().toString();
        mPasswordEditText = (EditText) findViewById(R.id.password_edit_text);
        String password = mPasswordEditText.getText().toString();
        validateEmailAndPassword(email, password);
    }

    private void validateEmailAndPassword(String email, String password) {
        String emailAddress = email.trim();
        if (TextUtils.isEmpty(emailAddress)) {
            showEditTextErrorMessage(getApplicationContext().getString(R.string
                    .empty_email_error_message), mEmailEditText);
        } else if (!GeneralUtils.isEmailValid(emailAddress)) {
            showEditTextErrorMessage(getApplicationContext().getString(R.string
                    .invalid_email_error_message), mEmailEditText);
        } else if (TextUtils.isEmpty(password)) {
            showEditTextErrorMessage(getApplicationContext().getString(R.string
                    .empty_password_error_message), mPasswordEditText);
        } else if (password.trim().length() < MINIMUM_PASSWORD_LENGTH) {
            showEditTextErrorMessage(getApplicationContext().getString(R.string
                    .short_password_error_message), mPasswordEditText);
        } else {
            sendLoginDetailsToServer(password, emailAddress);
        }
    }

    private void sendLoginDetailsToServer(String password, String emailAddress) {
        UserLoginDetails userLoginDetails = new UserLoginDetails();
        userLoginDetails.setPassword(GeneralUtils.getSecurePassword(password));
        userLoginDetails.setUserId(emailAddress);
        userLoginDetails.setDeviceId(GeneralUtils.getDeviceId(getApplicationContext()));
        NetworkAdapter.get(getApplicationContext()).initLogin(userLoginDetails, new
                ResponseCallback<GenericResponse>() {

                    @Override
                    public void onSuccess(GenericResponse genericResponse) {

                    }

                    @Override
                    public void onFailure(RestError error) {
                        showEditTextErrorMessage(getApplicationContext().getString(R.string
                                .unregistered_user_error_message), mEmailEditText);
                    }
                });
    }

    private void showEditTextErrorMessage(String errorMesssage, EditText editTextView) {
        editTextView.setError(errorMesssage);
    }


    private void navigateToSignUpScreen() {

    }

}

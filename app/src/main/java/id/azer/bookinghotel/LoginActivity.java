package id.azer.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import chanphenghor.com.library.EditTextIconLeft;
import mehdi.sakout.fancybuttons.FancyButton;

public class LoginActivity extends AppCompatActivity {

    EditTextIconLeft edtEmail;
    EditTextIconLeft edtPass;
    FancyButton btnLoginFB;
    FancyButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        btnLoginFB = findViewById(R.id.btnLoginFB);
        btnLogin = findViewById(R.id.btnLogin);

        EdtLogin();
        btnLoginFB();
        btnLogin();

    }

    private void EdtLogin(){
        edtEmail.setBorderFocus(
                R.drawable.border_edittext,
                R.drawable.focus_border,
                R.drawable.user_empty,
                R.drawable.user_empty_focus);
        edtEmail.editText().requestFocus();
        edtEmail.iconLeft().setVisibility(View.VISIBLE);

        edtPass.setBorderFocus(
                R.drawable.border_edittext,
                R.drawable.focus_border,
                R.drawable.user_empty,
                R.drawable.user_empty_focus);
        edtPass.editText().requestFocus();
        edtPass.iconLeft().setVisibility(View.VISIBLE);
    }

    private void btnLoginFB(){
        btnLoginFB.setText("Login with Facebook");
        btnLoginFB.setBackgroundColor(Color.parseColor("#3b5998"));
        btnLoginFB.setFocusBackgroundColor(Color.parseColor("#5474b8"));
        btnLoginFB.setTextSize(17);
        btnLoginFB.setRadius(5);
        btnLoginFB.setIconResource("\uf082");
        btnLoginFB.setIconPosition(FancyButton.POSITION_LEFT);
        btnLoginFB.setFontIconSize(30);
    }

    private void btnLogin(){
        btnLogin.setText("Login");
        btnLogin.setBackgroundColor(Color.parseColor("#000000"));
        btnLogin.setFocusBackgroundColor(Color.parseColor("#5474b8"));
        btnLogin.setTextSize(17);
        btnLogin.setRadius(5);
        btnLogin.setIconResource("");
        btnLogin.setIconPosition(FancyButton.POSITION_LEFT);
        btnLogin.setFontIconSize(30);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
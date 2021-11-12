package com.example.mobilebanking;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void btnRegister(View view) {
        String Fullname = ((EditText) findViewById(R.id.frmHoTen)).getText().toString();
        String Passport_num = ((EditText) findViewById(R.id.frmCMND)).getText().toString();
        String Email = ((EditText) findViewById(R.id.frmEmail)).getText().toString();
        String Password = ((EditText) findViewById(R.id.frmMK)).getText().toString();

        if (Fullname.isEmpty()) {
            ((EditText) findViewById(R.id.frmHoTen)).setError("Tên không được để trống!");
        } else if (Passport_num.isEmpty()) {
            ((EditText) findViewById(R.id.frmCMND)).setError("Không được để trống!");
        } else if (Email.isEmpty()) {
            ((EditText) findViewById(R.id.frmEmail)).setError("Email không được để trống!");
        } else if (Password.isEmpty()) {
            ((EditText) findViewById(R.id.frmMK)).setError("Mật khẩu không được để trống!");
        } else if (Password.length() < 6) {
            ((EditText) findViewById(R.id.frmMK)).setError("Mật khẩu quá ngắn! phải trên 6 kí tự");
        } else {
            Account account = new Account(Fullname, Passport_num, Email, Password);
            IAccountDAO dao = new ImplAccountDAO(this);
            boolean isOk = dao.insert(account);
            if (isOk) {
                AlertDialog.Builder check = new AlertDialog.Builder(SignUpActivity.this);
                check.setTitle("BKAP Bank");
                check.setMessage("Đăng kí thông tin thành công vui lòng kiểm tra thư điện tử!");
                check.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
                AlertDialog alert = check.create();
                alert.show();
            }
        }
    }

}
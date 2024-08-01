package com.example.myform;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    EditText et_name ,et_phone,et_password;
    RadioButton rb_male, rb_female;
    CheckBox cb_java, cb_python,cb_c;
    Spinner sp_cities;
    LinearLayout linear;
    ImageView image;
    TextView text1, text2, text3, text4, text5, text6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void AllClick(View view)
    {
        LayoutInflater lf = getLayoutInflater();
        View vie = lf.inflate(R.layout.activity_custon_toast_form, (ViewGroup) findViewById(R.id.custom_toast));

        //------------------TextView defined---------->
        image = vie.findViewById(R.id.image_profile);
        text1 = vie.findViewById(R.id.text1);
        text2 = vie.findViewById(R.id.text2);
        text3 = vie.findViewById(R.id.text3);
        text4 = vie.findViewById(R.id.text4);
        text5 = vie.findViewById(R.id.text5);
        text6 = vie.findViewById(R.id.text6);


        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        et_password = findViewById(R.id.et_password);
        String name = et_name.getText().toString();
        String phone = et_phone.getText().toString();
        String password = et_password.getText().toString();
        //----------------------Radio Button ------------>
        rb_male = findViewById(R.id.rb_male);
        rb_female = findViewById(R.id.rb_female);
        String male =" ";
       if(rb_male.isChecked())
       {
           male = rb_male.getText().toString();
       }
        if(rb_female.isChecked())
        {
            male = rb_female.getText().toString();
        }
        //----------------Check box------------------->
        cb_java =findViewById(R.id.cb_java);
        cb_python =findViewById(R.id.cb_python);
        cb_c =findViewById(R.id.cb_c);
        String java = " ";
        if(cb_java.isChecked()) {
            java += cb_java.getText().toString()+"\n";
        }
        if(cb_python.isChecked())
        {
        java += cb_python.getText().toString()+"\n";
        }
        if(cb_c.isChecked())
        {
        java += cb_c.getText().toString()+"\n";
        }
        //-----------------Spinners uses------------>
        sp_cities = findViewById(R.id.sp_cities);
        String city= sp_cities.getSelectedItem().toString();

        //---------------Toast defined by Button---------------->
        text1.setText(name);
        text2.setText(phone);
        text3.setText(password);
        text4.setText(male);
        text5.setText(java);
        text6.setText(city);

        //Toast.makeText(this, res ,Toast.LENGTH_LONG).show();
        Toast t = new Toast(getApplicationContext());
        t.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        t.setDuration(Toast.LENGTH_LONG);
        t.setView(vie);
        t.show();

    }
}
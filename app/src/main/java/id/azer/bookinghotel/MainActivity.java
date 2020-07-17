package id.azer.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView, textView2, textView3;
    String text,text2,text3;
    int image;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.images);
        textView = findViewById(R.id.desc);
        textView2 = findViewById(R.id.desc2);
        textView3 = findViewById(R.id.detail);

        text = getIntent().getStringExtra("tvTitle");
        text2 = getIntent().getStringExtra("tvTitle2");
        image = getIntent().getIntExtra("ivPhoto",0);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            //text3 = bundle.getString("detail");
            text3 = Objects.requireNonNull(getIntent().getExtras()).getString("detail");
            textView3.setText(text3);
        }
        
        textView.setText(text);
        textView2.setText(text2);
        textView3.setText("Detail "+text3);
        imageView.setImageResource(image);


    }
}
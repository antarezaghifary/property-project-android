package id.azer.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView, textView2;
    String text,text2;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.images);
        textView = findViewById(R.id.desc);
        textView2 = findViewById(R.id.desc2);


        text = getIntent().getStringExtra("tvTitle");
        text2 = getIntent().getStringExtra("tvTitle2");
        image = getIntent().getIntExtra("ivPhoto",0);

        textView.setText(text);
        textView2.setText(text2);
        imageView.setImageResource(image);


    }
}
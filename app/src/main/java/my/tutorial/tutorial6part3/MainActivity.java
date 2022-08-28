package my.tutorial.tutorial6part3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating Views for the two images
        Button Button1=findViewById(R.id.button1);
        Button Button2=findViewById(R.id.button2);

        // Creating Animations using ObjectAnimators
        ObjectAnimator AnimateButton1 = ObjectAnimator.ofFloat(Button1,"translationY",1300f);
        AnimateButton1.setDuration(4000);

        ObjectAnimator AnimateButton2 = ObjectAnimator.ofFloat(Button2,"translationY",1300f);
        AnimateButton2.setDuration(4000);


        // Adding onClick Listeners to check the correct side
        Button1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                    // Wrong Side
                    // Change the image to Broken Glass
                    Button1.setText("Button Clicked.");
                    // Stop the Animation
                    AnimateButton1.pause();
                    AnimateButton2.pause();
                    AnimateButton1.removeAllListeners();
                    Toast.makeText(MainActivity.this, "Don't Touch The Button!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                // Wrong Side
                // Change the image to Broken Glass
                Button2.setText("Button Clicked.");
                // Stop the Animation
                AnimateButton1.pause();
                AnimateButton2.pause();
                AnimateButton1.removeAllListeners();
                Toast.makeText(MainActivity.this, "Don't Touch The Button!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        // Adding Animation End Listener
        AnimateButton1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                // Check any of the glasses are selected
                    // Stop the Animation
                    AnimateButton1.cancel();
                    AnimateButton2.cancel();
                    Toast.makeText(MainActivity.this, "Good work you didn't touch the button.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        // Starting the Animations for the First Time
        AnimateButton1.start();
        AnimateButton2.start();
    }
}
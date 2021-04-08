package ro.pub.cs.systems.eim.lab01.myfirstandroidapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // setare timp de FADE
    final private static long TRANSPARENCY_EFFECT_DURATION = 5000;

    // buton pe care putem apasa si face o actiune
    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            // Spatiul unde trecem numele persoanei
            EditText userNameEditText = (EditText)findViewById(R.id.user_name_edit_text);

            // Mesajul care va aparea dupa ce apasam butonul de SUBMIT
            TextView greetingTextView = (TextView)findViewById(R.id.greeting_text_view);
            greetingTextView.setAlpha(1);

            // TODO: exercise 9a: mesajul afisat include numele utilizatorului cum apare in widget-ul EditBox
            greetingTextView.setText(greetingTextView.getText().toString().replace("xxx", "\n"+userNameEditText.getText()));

            // TODO: exercise 9b: efect de FADE al textului in decurs de TRANSPARENCY_EFFECT_DURATION ms
            AlphaAnimation fadeEffect = new AlphaAnimation(1.0f, 0.0f);
            fadeEffect.setDuration(TRANSPARENCY_EFFECT_DURATION);
            fadeEffect.setFillAfter(true);
            greetingTextView.setAnimation(fadeEffect);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ce face butonul de SUBMIT
        Button submitButton = (Button)findViewById(R.id.submit_button);
        submitButton.setOnClickListener(buttonClickListener);
    }
}

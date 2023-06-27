package sg.edu.np.mad.practical4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    final String TAG = "Main Activity";
    private boolean following = false;
    private Button followButton;
    private Button msgButton;

    TextView Username;
    TextView Description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "On Create!");

        followButton = findViewById(R.id.followed);
        Username = findViewById(R.id.userName);
        msgButton = findViewById(R.id.message);
        Description = findViewById(R.id.Desc);

        Intent i = getIntent();
        String UserName = i.getStringExtra("username");
        String Desc = i.getStringExtra("description");
        Username.setText(UserName);
        Description.setText(Desc);

        followButton.setOnClickListener(view -> {
            if(following != false){ //checking if boolean is false or not, if it's true, button will change text
                followButton.setText("Unfollow");
                Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_LONG).show(); //Pop up message triggered when button has been clicked
            }
            else { //if boolean is false, button will change text
                followButton.setText("Follow");
                Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_LONG).show();
            }
            following = !following; //boolean following will change to the opp (true --> false vice versa)
        });


    }
}
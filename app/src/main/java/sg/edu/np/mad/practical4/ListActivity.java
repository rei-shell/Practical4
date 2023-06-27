package sg.edu.np.mad.practical4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    final String TAG = "List Activity";
    ArrayList<User> User_list = new ArrayList<>();
    ImageView profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listactivity);

        for (int i = 0; i < 20; i++) {
            User obj = new User();

            Random randomNum = new Random();
            int ranNum = randomNum.nextInt(999999999);

            Random randomDesc = new Random();
            int ranDesc = randomDesc.nextInt(999999999);

            String Name = "Name" + ranNum;
            String Description = "Description: " + ranDesc;

            obj.setMyUser(Name);
            obj.setMyDescription(Description);

            User_list.add(obj);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserAdapter(User_list, this));
    }
}
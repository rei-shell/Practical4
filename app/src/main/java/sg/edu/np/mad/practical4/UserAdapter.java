package sg.edu.np.mad.practical4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Random;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.myViewHolder>{
    private ArrayList<User> User_list;
    private Context context;

    public UserAdapter(ArrayList<User> User_list, Context context){
        this.User_list = User_list;
        this.context = context;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private ImageView profile;
        private TextView userName;
        private TextView description;
        private ImageView BigImg;

        public myViewHolder(View view) {
            super(view);
            profile = view.findViewById(R.id.ProfileImg);
            BigImg = view.findViewById(R.id.BigImg);
            userName = view.findViewById(R.id.ProfileName);
            description = view.findViewById(R.id.Description);

            profile.setOnClickListener(parentView -> {
                AlertDialog.Builder builder = new AlertDialog.Builder(parentView.getContext());
                builder.setTitle("Profile");
                builder.setMessage(userName.getText());
                builder.setPositiveButton("View", (dialog, id) -> {
                    // Need to implement the moving to new activity
                    Intent i = new Intent(context, MainActivity.class);
                    i.putExtra("username", userName.getText());
                    i.putExtra("description", description.getText());
                    context.startActivity(i);
                });
                builder.setNegativeButton("Close", (dialog, id) -> dialog.dismiss());
                AlertDialog alert = builder.create();
                alert.show();
            });
        }

        public TextView getUserName() {
            return userName;
        }

        public TextView getDescription() {
            return description;
        }

        public ImageView getBigImage() {
            return BigImg;
        }
    }

    @Override
    public int getItemViewType(int position) {

        String username = User_list.get(position).getMyUser();
        String description = User_list.get(position).getMyDescription();

        if (username.charAt(username.length() - 1) != '7') {
            return 0;
        }
        return 1;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        if (viewType == 0) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.secondrecycler, viewGroup, false);
            return new myViewHolder(view);
        }
        if (viewType == 1) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.firstrecycer, viewGroup, false);
            return new myViewHolder(view);
        }
        return null;
    }

    public void onBindViewHolder(myViewHolder myViewHolder, final int position) {
        String username = User_list.get(position).getMyUser();
        String description = User_list.get(position).getMyDescription();

        myViewHolder.getUserName().setText(username);
        myViewHolder.getDescription().setText(description);
    }

    @Override
    public int getItemCount() {
        return User_list.size();
    }

}
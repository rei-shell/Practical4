package sg.edu.np.mad.practical4;

import android.widget.ImageView;

public class User {
    private String myUser;
    private String myDescription;

    public User(String myUser, String myDescription){
        this.myUser = myUser;
        this.myDescription = myDescription;
    }

    public User(){

    }

    public String getMyUser() {
        return myUser;
    }

    public void setMyUser(String myUser) {
        this.myUser = myUser;
    }

    public String getMyDescription() {
        return myDescription;
    }

    public void setMyDescription(String myDescription) {
        this.myDescription = myDescription;
    }

}

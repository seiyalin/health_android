package callback;

/**
 * Created by misssea on 2016/4/15.
 */
public class User {

    public String tag ;
    public boolean error  ;

    public User() {
        // TODO Auto-generated constructor stub
    }

    public User(String tag, boolean error) {
        this.tag = tag;
        this.error =error;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "tag='" + tag + '\'' +
                ", error='" + error + '\'' +
                '}';
    }


    public boolean getboolean()
    {
       return error;
    }
}

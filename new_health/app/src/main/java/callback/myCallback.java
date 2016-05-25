package callback;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;

import okhttp3.Response;


/**
 * Created by misssea on 2016/4/15.
 */
public abstract class myCallback extends Callback<User>
{
    //非UI线程，支持任何耗时操作
    @Override
    public User parseNetworkResponse(Response response) throws IOException
    {
        String string = response.body().string();
        User user = new Gson().fromJson(string, User.class);
        return user;
    }
}

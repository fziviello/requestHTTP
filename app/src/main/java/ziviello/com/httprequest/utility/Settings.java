package ziviello.com.httprequest.utility;

import ziviello.com.httprequest.MyApplication;
import ziviello.com.httprequest.R;

/**
 * Created by fziviello on 12/01/18.
 */

public class Settings {

    public static final boolean DEBUG = true;
    public static final String BASE_PATH = MyApplication.getGlobalContext().getString(R.string.BaseHost);
    public static final String LOGIN_PATH = "login";

}

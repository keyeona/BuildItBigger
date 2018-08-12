import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

@RunWith(AndroidJUnit4.class)
public class asyncTest {
    public static final String TEST_THIS = "";

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkButtonResponse() {
        onView(withId(R.id.jokeButton)).perform(click());
        //Is it really testing? This should FAILE if this test is performed and this line is
        //commented out
        //onView(withId(R.id.android_lib_textview)).check(matches(withText("FAKE_STRING")));
        onView(withId(R.id.android_lib_textview)).check(matches(not(withText(TEST_THIS))));
    }

    @Test
    public  void checkViewEnabled(){
        onView(withId(R.id.jokeButton)).perform(click());
        onView(withId(R.id.android_lib_textview)).check(matches(isEnabled()));
    }
}

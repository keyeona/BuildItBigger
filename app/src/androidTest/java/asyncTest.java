import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.util.Pair;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.not;

@RunWith(AndroidJUnit4.class)
public class asyncTest{
    public static final String TEST_THIS = "";


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void checkButtonResponse() {
        onView(withId(R.id.jokeButton)).perform(click());
        //Is it really testing? This should FAIL if this test is performed and this line is
        //commented out
        //onView(withId(R.id.android_lib_textview)).check(matches(withText("FAKE_STRING")));
        onView(withId(R.id.android_lib_textview)).check(matches(not(withText(TEST_THIS))));
    }

    @Test
    public  void checkViewEnabled(){
        onView(withId(R.id.jokeButton)).perform(click());
        onView(withId(R.id.android_lib_textview)).check(matches(isEnabled()));
    }

    @Test
    public void endpointTest(){
        final CountDownLatch signal = new CountDownLatch(1);
        try {
            Random rand = new Random();
            String position = String.valueOf(rand.nextInt(24) - 1);
            EndpointsAsyncTask endpointAsync = (EndpointsAsyncTask) new EndpointsAsyncTask();
            endpointAsync.setJokeListener(new EndpointsAsyncTask.JokeListener() {
                @Override
                public void onResult(String joke) {
                    Log.i("results", joke);
                    assertTrue(joke.length() > 0);
                    signal.countDown();
                }
                @Override
                public void onError(String error) {
                    assertFalse(error.length() > 0);
                    signal.countDown();
                }
            });
            endpointAsync.execute(new Pair<Context, String>(InstrumentationRegistry.getContext(), position));
            signal.await();
        }
        catch (InterruptedException e) {

        }
    }
}

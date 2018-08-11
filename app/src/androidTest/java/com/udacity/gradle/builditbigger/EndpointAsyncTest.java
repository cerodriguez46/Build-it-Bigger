package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertFalse;

@RunWith(AndroidJUnit4.class)
public class EndpointAsyncTest {

    private String mJokeTest;

    @Test
    public void aTest() throws InterruptedException {
        // CountDownLatch is a synchronisation aid that allows one or more threads to wait until a
        // set of operations being performed in other threads completes
        //new CountDownLatch(1) is passed int number. It is the number of times countDown() must be
        // invoked before threads can pass through await(). If it is negative, it gives IllegalArgumentException
        final CountDownLatch signal = new CountDownLatch(1);
        EndpointAsync task = new EndpointAsync();
        task.setListener(new EndpointAsync.GetTaskListener() {
            @Override
            public void onComplete(String jokeTest, Exception mError) {
                mJokeTest = jokeTest;
                //countDown()	Decrements the count of the latch, releasing all waiting threads
                // if the count reaches zero.
                signal.countDown();
            }
        }).execute();
        //
        //await()	Causes the current thread to wait until the latch has counted down to zero,
        // unless the thread is interrupted.
        //signal.await() waits before signal.countDown() is called
        signal.await();
        assertFalse(TextUtils.isEmpty(mJokeTest));
    }
}

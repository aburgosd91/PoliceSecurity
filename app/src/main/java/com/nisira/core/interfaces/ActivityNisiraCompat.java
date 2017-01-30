package com.nisira.core.interfaces;

import android.support.v7.app.AppCompatActivity;
import com.nisira.core.service.ConsumerService;

/**
 * Created by vzavala on 14/11/2016.
 */

public class ActivityNisiraCompat extends AppCompatActivity implements AsyncTaskService {
    @Override
    public void onPostExecuteWebService(ConsumerService cws, String result) {

    }
}

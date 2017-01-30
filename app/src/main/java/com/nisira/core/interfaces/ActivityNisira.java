package com.nisira.core.interfaces;

import android.app.Activity;

import com.nisira.core.service.ConsumerService;

/**
 * Created by vzavala on 14/11/2016.
 */

public class ActivityNisira extends Activity implements AsyncTaskService {
    @Override
    public  void onPostExecuteWebService(ConsumerService cws, String result) {

    }
}

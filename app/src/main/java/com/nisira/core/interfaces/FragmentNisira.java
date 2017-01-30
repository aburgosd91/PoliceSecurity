package com.nisira.core.interfaces;

import android.support.v4.app.Fragment;

import com.nisira.core.service.ConsumerService;

/**
 * Created by aburgos on 09/01/2017.
 */

public class FragmentNisira extends Fragment implements AsyncTaskService {
    @Override
    public void onPostExecuteWebService(ConsumerService cws, String result) {}
}

package com.nisira.core.interfaces;


import com.nisira.core.service.ConsumerService;

/**
 * Created by vzavala on 14/11/2016.
 */

public interface AsyncTaskService {

    public void onPostExecuteWebService(ConsumerService cws, String result) ;
}

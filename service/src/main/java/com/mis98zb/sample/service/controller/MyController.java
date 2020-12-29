package com.mis98zb.sample.service.controller;

import com.mis98zb.sample.api.IMyService;
import com.mis98zb.sample.model.MyModel;
import org.springframework.stereotype.Controller;

@Controller
public class MyController implements IMyService {

    @Override
    public MyModel test(String name) {
        var ret = new MyModel();
        ret.setAge(1000);
        ret.setName(name);
        return ret;
    }
}

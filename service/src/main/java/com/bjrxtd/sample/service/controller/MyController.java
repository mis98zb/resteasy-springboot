package com.bjrxtd.sample.service.controller;

import com.bjrxtd.sample.api.IMyService;
import com.bjrxtd.sample.model.MyModel;
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

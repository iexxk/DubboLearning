package exxk.dubbo.provider.impl;

import exxk.dubbo.commonimpl.DemoService;

public class DemoServiceImpl implements DemoService{
    @Override
    public String sayHello(String name) {
        return "hello"+ name;
    }
}

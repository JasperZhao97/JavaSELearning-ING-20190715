package com.demo.practise.practise2;


import com.demo.practise.practise2.impl.PersonServiceImpl;

/**
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月12日 15:17:05
 */
public class TestAutoWried {

    @AutoWried
    private PersonServiceImpl personService;

    public void service() {
        personService.method();
    }

}

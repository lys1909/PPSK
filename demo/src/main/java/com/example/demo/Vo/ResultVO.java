package com.example.demo.Vo;

public class ResultVO<T> {


    public static ResultVO<Void> getSuccess(String success) {
        System.out.println(success);
        return ResultVO.getSuccess(success);
    }


}

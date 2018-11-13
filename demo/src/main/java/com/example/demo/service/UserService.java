package com.example.demo.service;

import com.example.demo.Vo.ResultVO;
import com.example.demo.Vo.UserVO;

import javax.servlet.http.HttpServletResponse;

public interface UserService {


    /**
     * 导出用户EXCEL
     *
     * @param userVO
     * @return VOID
     * @throws Exception
     */
    ResultVO<Void> export() throws Exception;


}

package com.example.demo.util;

import org.apache.poi.xssf.streaming.SXSSFSheet;

public interface WriteExcelDataDelegated {
    /**
     *
     * @param eachSheet 指定SHEET
     * @param startRowCount 开始行
     * @param endRowCount 结束行
     * @param currentPage 分批查询开始页
     * @param pageSize 分批查询数据量
     * @throws Exception
     */
    public abstract void writeExcelData(SXSSFSheet eachSheet, Integer startRowCount, Integer endRowCount, Integer currentPage, Integer pageSize) throws Exception;

}

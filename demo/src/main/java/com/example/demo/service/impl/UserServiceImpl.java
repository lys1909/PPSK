package com.example.demo.service.impl;

import com.example.demo.Vo.ResultVO;
import com.example.demo.Vo.UserVO;

import com.example.demo.service.UserService;
import com.example.demo.util.PoiUtil;
import com.example.demo.util.WriteExcelDataDelegated;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



    @Service
    public class UserServiceImpl implements UserService {

        public List<UserVO> selectUserVOList() throws Exception {
            List<UserVO> list = new ArrayList<>();
            for(int i=0;i<1000000;i++){
                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                UserVO userVO = new UserVO("suiwanling", date, "insert", "172.27.24.52");
                list.add(userVO);
            }
            return list;
        }

        public Integer selectUserVOCount() throws Exception {

            return 1000000;
        }

        @Override
        public ResultVO<Void> export() throws Exception {

            // 总记录数
            Integer totalRowCount = selectUserVOCount();

            // 导出EXCEL文件名称
            String filaName = "用户EXCEL";

            // 标题
            String[] titles = {"账号", "日期", "描述", "IP"};

            List<UserVO> userVOList = selectUserVOList();

            //导出到本地
            PoiUtil.exportExcelToLocalPath(totalRowCount, titles, "C:\\Users\\lys1909\\IdeaProjects\\demo\\src\\demo.xlsx", new WriteExcelDataDelegated() {

                @Override
                public void writeExcelData(SXSSFSheet eachSheet, Integer startRowCount, Integer endRowCount, Integer currentPage, Integer pageSize) throws Exception {


                    if (!CollectionUtils.isEmpty(userVOList)) {

                        // --------------   这一块变量照着抄就行  强迫症 后期也封装起来     ----------------------
                        for (int i = startRowCount; i <= endRowCount; i++) {
                            SXSSFRow eachDataRow = eachSheet.createRow(i);
                            if ((i - startRowCount) < userVOList.size()) {

                                UserVO eachUserVO = userVOList.get(i - startRowCount);
                                // ---------   这一块变量照着抄就行  强迫症 后期也封装起来     -----------------------

                                eachDataRow.createCell(0).setCellValue(eachUserVO.getUserName() == null ? "" : eachUserVO.getUserName());
                                eachDataRow.createCell(1).setCellValue(eachUserVO.getDate() == null ? "" : eachUserVO.getDate());

                                eachDataRow.createCell(2).setCellValue(eachUserVO.getDescreption() == null ? "" : eachUserVO.getDescreption());
                                eachDataRow.createCell(3).setCellValue(eachUserVO.getIP() == null ? "" : eachUserVO.getIP());

                            }
                        }
                    }
                }
            });
            // 开始导入
            /*PoiUtil.exportExcelToWebsite(response, totalRowCount, filaName, titles, new WriteExcelDataDelegated() {
                @Override
                public void writeExcelData(SXSSFSheet eachSheet, Integer startRowCount, Integer endRowCount, Integer currentPage, Integer pageSize) throws Exception {

 //                   PageHelper.startPage(currentPage, pageSize);
                    List<UserVO> userVOList = userMapper.selectUserVOList();

                    if (!CollectionUtils.isEmpty(userVOList)) {

                        // --------------   这一块变量照着抄就行  强迫症 后期也封装起来     ----------------------
                        for (int i = startRowCount; i <= endRowCount; i++) {
                            SXSSFRow eachDataRow = eachSheet.createRow(i);
                            if ((i - startRowCount) < userVOList.size()) {

                                UserVO eachUserVO = userVOList.get(i - startRowCount);
                                // ---------   这一块变量照着抄就行  强迫症 后期也封装起来     -----------------------

                                eachDataRow.createCell(0).setCellValue(eachUserVO.getUserName() == null ? "" : eachUserVO.getUserName());
                                eachDataRow.createCell(1).setCellValue(eachUserVO.getDate() == null ? "" : eachUserVO.getDate());

                                eachDataRow.createCell(2).setCellValue(eachUserVO.getDescreption() == null ? "" : eachUserVO.getDescreption());
                                eachDataRow.createCell(3).setCellValue(eachUserVO.getIP() == null ? "" : eachUserVO.getIP());

                            }
                        }
                    }

                }
            });*/
            return ResultVO.getSuccess("导出用户EXCEL成功");
        }


    }


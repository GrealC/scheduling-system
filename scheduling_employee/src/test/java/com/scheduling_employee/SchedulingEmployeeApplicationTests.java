package com.scheduling_employee;

import com.scheduling_employee.mapper.BusinessHistoryMapper;
import com.scheduling_employee.pojo.BusinessHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class SchedulingEmployeeApplicationTests {


    @Autowired
    private BusinessHistoryMapper businessHistoryMapper;
    @Test
    public void predictCustomer() {

        String storeId = "1";

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = ft.parse("2023-05-01");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        List<BusinessHistory> businessHistoriesM = businessHistoryMapper.selectBusiness(storeId+"-1");
        List<BusinessHistory> businessHistoriesA = businessHistoryMapper.selectBusiness(storeId+"-2");
        List<BusinessHistory> businessHistoriesE = businessHistoryMapper.selectBusiness(storeId+"-3");

        List<Integer> historicalDataM = new ArrayList<>();
        List<Integer> historicalDataA = new ArrayList<>();
        List<Integer> historicalDataE = new ArrayList<>();

        for(BusinessHistory b: businessHistoriesM){
            historicalDataM.add(b.getBusiness());
        }

        for(BusinessHistory b: businessHistoriesA){
            historicalDataA.add(b.getBusiness());
        }

        for(BusinessHistory b: businessHistoriesE){
            historicalDataE.add(b.getBusiness());
        }

        int[] predictionsM = predict(historicalDataM);
        int[] predictionsA = predict(historicalDataA);
        int[] predictionsE = predict(historicalDataE);

        String[][] predictions = new String[4][7];

        // 获取当前时间

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        // 把日期往后增加一天,整数  往后推,负数往前移动

        for(int i = 0; i < 7; i++){
            calendar.add(Calendar.DATE, 1);
            // 这个时间就是日期往后推一天的结果
            date = calendar.getTime();
            predictions[0][i] = date.toString();
        }
        for(int i = 0; i < 7; i++){
            predictions[1][i] = predictionsM[i]+"";
        }
        for(int i = 0; i < 7; i++){
            predictions[2][i] = predictionsA[i]+"";
        }
        for(int i = 0; i < 7; i++){
            predictions[3][i] = predictionsE[i]+"";
        }

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 7; j++){
                System.out.print(predictions[i][j]+" ");
            }
            System.out.println(" ");
        }
    }

    public int[] predict(List<Integer> historicalData) {

        int[] predictions = predictNext7Days(historicalData);

        return predictions;
    }

    // 使用移动平均方法进行预测
    public int[] predictNext7Days(List<Integer> historicalData) {
        int windowSize = 3; // 移动平均窗口大小
        int[] predictions = new int[7];

        for (int i = 0; i < 7; i++) {
            int startIndex = historicalData.size() - windowSize - 7 + i;
            if (startIndex < 0) {
                startIndex = 0;
            }

            double sum = 0;
            for (int j = startIndex; j < startIndex + windowSize; j++) {
                sum += historicalData.get(j);
            }
            double average = sum / windowSize;
            predictions[i] = (int)average;
        }

        return predictions;
    }
}

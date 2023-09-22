package com.scheduling_employee.service.impl;

import com.scheduling_employee.mapper.BusinessForecastsMapper;
import com.scheduling_employee.mapper.BusinessHistoryMapper;
import com.scheduling_employee.pojo.BusinessForecasts;
import com.scheduling_employee.pojo.BusinessHistory;
import com.scheduling_employee.service.PredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PredictServiceImpl implements PredictService {

    @Autowired
    private BusinessHistoryMapper businessHistoryMapper;

    @Autowired
    private BusinessForecastsMapper businessForecastsMapper;
    @Override
    public String[][] predictCustomer(String storeId, Date date) {

        String mor = storeId+"-1";
        String after = storeId+"-2";
        String even = storeId+"-3";

        List<BusinessHistory> businessHistoriesM = businessHistoryMapper.selectBusiness(mor);
        List<BusinessHistory> businessHistoriesA = businessHistoryMapper.selectBusiness(after);
        List<BusinessHistory> businessHistoriesE = businessHistoryMapper.selectBusiness(even);


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

        System.out.println(historicalDataA);
        int[] predictionsM = predict(historicalDataM);
        int[] predictionsA = predict(historicalDataA);
        int[] predictionsE = predict(historicalDataE);

        String[][] predictions = new String[4][7];

        // 获取当前时间

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        // 把日期往后增加一天,整数  往后推,负数往前移动
        List<Date> weekDate = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            calendar.add(Calendar.DATE, 1);
            // 这个时间就是日期往后推一天的结果
            date = calendar.getTime();
            weekDate.add(date);
            predictions[0][i] = date.toString();
        }


        for(int i = 0; i < 7; i++){
            storagePredict(mor, weekDate.get(i), predictionsM[i]);
            predictions[1][i] = predictionsM[i]+"";
        }
        for(int i = 0; i < 7; i++){
            storagePredict(after, weekDate.get(i), predictionsA[i]);
            predictions[2][i] = predictionsA[i]+"";
        }
        for(int i = 0; i < 7; i++){
            storagePredict(even, weekDate.get(i), predictionsE[i]);
            predictions[3][i] = predictionsE[i]+"";
        }

        return predictions;
    }

    @Override
    public void storagePredict(String storeId, Date date, int customers) {
        businessForecastsMapper.storagePredictCustomers(storeId,date,customers);
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

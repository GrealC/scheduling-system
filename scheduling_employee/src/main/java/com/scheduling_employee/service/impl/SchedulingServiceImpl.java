package com.scheduling_employee.service.impl;

import com.scheduling_employee.mapper.*;
import com.scheduling_employee.pojo.*;
import com.scheduling_employee.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SchedulingServiceImpl implements SchedulingService {

    @Autowired
    private BusinessForecastsMapper businessForecastsMapper;
    @Autowired
    private ScheduleRulesMapper scheduleRulesMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private EmployeeWorkPeriodsMapper employeeWorkPeriodsMapper;
    @Autowired
    private LeaveMapper leaveMapper;
    @Autowired
    private OvertimeMapper overtimeMapper;

    /*
    *  自动排班
    * */
    @Override
    public List<EmployeeWorkPeriods> setSchedule(String storeId, String date) {

        /*
         * 读取排班规则
         * */
         int workTimes = 3; //默认工作次数
        List<ScheduleRules> scheduleRules = getScheduleRules(storeId); //工作时段：3个，List中默认3个元素

        /*
        *读取预测信息, businessForecasts中存储date当天工作日3个时段分别对应的客流量
        * */
        List<BusinessForecasts> businessForecasts = new ArrayList<>();

        for (int j = 1; j <= workTimes; j++){
            businessForecasts.add(getBusinessForecasts(storeId,date, "-"+j));
        }

        /*
        * 获取员工信息、休假信息、加班信息、已排班信息
        * */
        List<Users> users = getUsersInfo();
        List<Leave> leaves = getEmployeeLeave();
        List<Overtime> overtimes = getEmployeeOverTime();
        List<EmployeeWorkPeriods> employeeWorkPeriods = getWorkPeriodsInfo();

        /*
        * 信息处理：去除已排班、超工时、已请假的员工信息-->适应值计算、排序
        * */

        //时段一
        List<String> u1 = resolveEmployee(storeId,"1",users,leaves,overtimes,employeeWorkPeriods,date);
        //时段二
        List<String> u2 = resolveEmployee(storeId,"2",users,leaves,overtimes,employeeWorkPeriods,date);
        //时段三
        List<String> u3 = resolveEmployee(storeId,"3",users,leaves,overtimes,employeeWorkPeriods,date);

        /*
        *  排班分配
        * */
        List<EmployeeWorkPeriods> e1 = new ArrayList<>();
        List<EmployeeWorkPeriods> e2 = new ArrayList<>();
        List<EmployeeWorkPeriods> e3 = new ArrayList<>();

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = null;
        try {
            startTime = ft.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < businessForecasts.get(0).getFoot_traffic()/5; i++) {

            if(u1.get(i)==null){
                break;
            }
            EmployeeWorkPeriods e = new EmployeeWorkPeriods();
            e.setWorkPeriod_id(i);
            e.setUser_id(u1.get(i)+"-1");
            e.setStart_time(startTime);
            e.setEnd_time(startTime);
            e1.add(e);
            employeeWorkPeriodsMapper.insertScheduleInfo(e.getUser_id(),e.getStart_time(),e.getEnd_time());
        }

        for (int i = 0; i < businessForecasts.get(1).getFoot_traffic()/5; i++) {

            if(u2.get(i)==null){
                break;
            }
            EmployeeWorkPeriods e = new EmployeeWorkPeriods();
            e.setWorkPeriod_id(i);
            e.setUser_id(u1.get(i)+"-2");
            e.setStart_time(startTime);
            e.setEnd_time(startTime);
            e2.add(e);
            employeeWorkPeriodsMapper.insertScheduleInfo(e.getUser_id(),e.getStart_time(),e.getEnd_time());
        }

        for (int i = 0; i < businessForecasts.get(2).getFoot_traffic()/5; i++) {

            if(u3.get(i)==null){
                break;
            }
            EmployeeWorkPeriods e = new EmployeeWorkPeriods();
            e.setWorkPeriod_id(i);
            e.setUser_id(u1.get(i)+"-3");
            e.setStart_time(startTime);
            e.setEnd_time(startTime);
            e3.add(e);
            employeeWorkPeriodsMapper.insertScheduleInfo(e.getUser_id(),e.getStart_time(),e.getEnd_time());
        }

        List<EmployeeWorkPeriods> employeeWorkPeriodsList = new ArrayList<>();

        for (int i = 0; i < e1.size(); i++) {
            employeeWorkPeriodsList.add(e1.get(i));
        }

        for (int i = 0; i < e2.size(); i++) {
            employeeWorkPeriodsList.add(e2.get(i));
        }

        for (int i = 0; i < e3.size(); i++) {
            employeeWorkPeriodsList.add(e3.get(i));
        }


        return employeeWorkPeriodsList;
    }

    /*
    * 处理员工信息
    * */
    @Override
    public List<String> resolveEmployee(String storeId, String period, List<Users> users, List<Leave> leave, List<Overtime> overtime, List<EmployeeWorkPeriods> employeeWorkPeriods, String date) {

        List<Users> usersList = users;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date nowDate = null;
        try {
            nowDate = ft.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        /*
        *  去除已排班员工
        * */
        for (int i = 0; i < users.size(); i++) {
            for (EmployeeWorkPeriods e : employeeWorkPeriods) {
                if(nowDate.compareTo(e.getStart_time())>=0&&nowDate.compareTo(e.getEnd_time())<=0) {
                    if(e.getUser_id().equals(usersList.get(i).getUser_id()+period)) {
                        usersList.remove(i);
                    }
                }
            }
        }

        /*
        *  去除已请假员工
        * */
        for (int i = 0; i < users.size(); i++) {
            for (Leave l : leave) {
                if(nowDate.compareTo(l.getStart_time())>=0&&nowDate.compareTo(l.getEnd_time())<=0) {
                    if(l.getUser_id().equals(usersList.get(i).getUser_id()+period)) {
                        usersList.remove(i);
                    }
                }
            }
        }

        //计算工作时长
        Map<String, Integer> workTime_1 = new HashMap<>();
        Map<String, Integer> workTime_2 = new HashMap<>();
        Map<String, Integer> workTime_3 = new HashMap<>();

        for (int i = 0; i < usersList.size(); i++) {
            int time1 = 0;
            int time2 = 0;
            int time3 = 0;

            for (EmployeeWorkPeriods e : employeeWorkPeriods) {
                if(e.getUser_id().equals(usersList.get(i).getUser_id()+"-1")) {
                    time1++;
                }
            }

            for (EmployeeWorkPeriods e : employeeWorkPeriods) {
                if(e.getUser_id().equals(usersList.get(i).getUser_id()+"-2")) {
                    time2++;
                }
            }

            for (EmployeeWorkPeriods e : employeeWorkPeriods) {
                if(e.getUser_id().equals(usersList.get(i).getUser_id()+"-3")) {
                    time3++;
                }
            }

            workTime_1.put(usersList.get(i).getUser_id(), time1);
            workTime_2.put(usersList.get(i).getUser_id(), time2);
            workTime_3.put(usersList.get(i).getUser_id(), time3);
        }
        //去除工时已满员工：获取排班规则、计算工时
        List<ScheduleRules> rules = getScheduleRules(storeId);
        Map<String, Integer> sumTime = new HashMap<>();

        for (int i = 0; i < usersList.size(); i++){
            int time = workTime_1.get(usersList.get(i).getUser_id())*rules.get(0).getWork_hours_per_day();
            time += workTime_2.get(usersList.get(i).getUser_id())*rules.get(1).getWork_hours_per_day();
            time += workTime_3.get(usersList.get(i).getUser_id())*rules.get(2).getWork_hours_per_day();

            sumTime.put(usersList.get(i).getUser_id(), time);
        }

        int ruleTime = rules.get(2).getWork_hours_per_day()+rules.get(1).getWork_hours_per_day()+rules.get(0).getWork_hours_per_day();
        int length = usersList.size();
        for (int i = 0 ; i < length; i++) {
            if(sumTime.get(usersList.get(i).getUser_id())>ruleTime||sumTime.get(usersList.get(i).getUser_id())>ruleTime*rules.get(0).getWork_days_per_week()) {
                sumTime.remove(usersList.get(i).getUser_id());
            }
        }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(sumTime.entrySet());
        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // 提取排序后的uid保存在List<String>中
        List<String> sortedUids = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : sortedList) {
            sortedUids.add(entry.getKey());
        }

        return sortedUids;
    }


    /*
    * 获取预测信息, 通过店铺id-时段,预测日期获得对应信息
    * */
    @Override
    public BusinessForecasts getBusinessForecasts(String storeId, String time, String periods) {

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = ft.parse(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        BusinessForecasts business = businessForecastsMapper.selectPredictCustomers(storeId+periods, date);

        return business;
    }

    /*
    * 获取排班规则信息
    * */
    @Override
    public List<ScheduleRules> getScheduleRules(String storeID) {

        List<ScheduleRules> scheduleRules = scheduleRulesMapper.getScheduleRules(storeID);

        return scheduleRules;
    }

    /*
     * 获取员工信息
     * */
    @Override
    public List<Users> getUsersInfo() {

        List<Users> users = usersMapper.getUsers();

        return users;
    }

    /*
    * 获取工作时段信息
    * */
    @Override
    public List<EmployeeWorkPeriods> getWorkPeriodsInfo() {

        List<EmployeeWorkPeriods> employeeWorkPeriods = employeeWorkPeriodsMapper.getWorkPeriods();
        return employeeWorkPeriods;
    }

    /*
    *  获取员工休假时间
    * */
    @Override
    public List<Leave> getEmployeeLeave() {

        return leaveMapper.getLeaveInfo();
    }

    //获取员工加班信息
    @Override
    public List<Overtime> getEmployeeOverTime() {
        return overtimeMapper.getOverTime();
    }



}

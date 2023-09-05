package com.scheduling_employee;

import com.scheduling_employee.mapper.*;
import com.scheduling_employee.pojo.*;
import com.scheduling_employee.service.DailyScheduleService;
import com.scheduling_employee.service.EmployeeWorkHoursService;
import com.scheduling_employee.service.TotalWorkService;
import com.scheduling_employee.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class SchedulingEmployeeApplicationTests {


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
    @Autowired
    DailyScheduleService dailyScheduleService;
    @Autowired
    EmployeeWorkHoursService employeeWorkHoursService;
    @Autowired
    TotalWorkService totalWorkService;
    @Test
    public void selectSalary(){
        List<TotalWork> totalWork=totalWorkService.selectAll();
        System.out.println(getSalary(totalWork));
    }
    public List<TotalWork> getSalary(List<TotalWork> list){
        BigDecimal a = new BigDecimal(15);
        BigDecimal b=new BigDecimal(20);
        for (TotalWork i : list) {
            if(i.getRole().equals("后勤") || i.getRole().equals("服务员")) i.setSalary(i.getTotalTime().multiply(a));
            if(i.getRole().equals("店长"))  i.setSalary(i.getTotalTime().multiply(b));
            totalWorkService.setSalary(i);
        }
        return  list;
    }
    @Test
    public void workTime(){
//        String jwt=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("token");
//        String userId= (String) JwtUtils.parseJWT(jwt).get("userId");
        String userId = "1";
        List<EmployeeWorkHours> ewh=employeeWorkHoursService.selectWorkTime(userId);
        System.out.println(ewh.toString());
    }
    @Test
    public void tt1(){
//        String jwt=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("token");
//        String userId= (String) JwtUtils.parseJWT(jwt).get("userId");
        String userId = "1";
        List<DailySchedule> ds=dailyScheduleService.selectSchedule(userId);
        System.out.println(ds);
    }



    /*
     * 获取预测信息, 通过店铺id-时段,预测日期获得对应信息
     * */

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

    public List<ScheduleRules> getScheduleRules(String storeID) {

        List<ScheduleRules> scheduleRules = scheduleRulesMapper.getScheduleRules(storeID);

        return scheduleRules;
    }

    /*
     * 获取员工信息
     * */

    public List<Users> getUsersInfo() {

        List<Users> users = usersMapper.getUsers();

        return users;
    }

    /*
     * 获取工作时段信息
     * */

    public List<EmployeeWorkPeriods> getWorkPeriodsInfo() {

        List<EmployeeWorkPeriods> employeeWorkPeriods = employeeWorkPeriodsMapper.getWorkPeriods();
        return employeeWorkPeriods;
    }

    /*
     *  获取员工休假时间
     * */

    public List<Leave> getEmployeeLeave() {

        return leaveMapper.getLeaveInfo();
    }

    //获取员工加班信息

    public List<Overtime> getEmployeeOverTime() {
        return overtimeMapper.getOverTime();
    }
}

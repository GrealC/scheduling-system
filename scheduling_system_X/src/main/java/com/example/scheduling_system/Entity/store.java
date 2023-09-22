package com.example.scheduling_system.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class store {
    /**
     * 店铺Id
     */
    private String storeId;
    /**
     * 店铺名称
     */
    private String storeName;
    /**
     * 管理者Id
     */
    private String manageId;
    /**
     * 最大排班数
     */
    private int maxSchedules;


}

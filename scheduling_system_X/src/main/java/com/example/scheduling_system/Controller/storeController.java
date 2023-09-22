package com.example.scheduling_system.Controller;


import com.example.scheduling_system.Entity.ResBean;
import com.example.scheduling_system.Entity.store;
import com.example.scheduling_system.Service.storeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
@Api("店铺操作")
public class storeController {

    @Autowired
    private storeService storeService;

    @ApiOperation("增加店铺")
    @PostMapping("/addStore")
    public ResBean addStore(@RequestBody store store){
        ResBean resBean = storeService.addStore(store);
        return resBean;
    }

    @ApiOperation("查看所有店铺")
    @GetMapping("/storeAll")
    public ResBean selectStore(){
        ResBean resBean = storeService.selectAll();
        return resBean;
    }

    @ApiOperation("删除店铺")
    @DeleteMapping("/storeById")
    public ResBean delectByIdStore(int id){
        ResBean resBean = storeService.delectById(id);
        return resBean;
    }
}

package com.example.scheduling_system.Service;

import com.example.scheduling_system.Entity.ResBean;
import com.example.scheduling_system.Entity.users;

public interface userService {
    ResBean insertUser(users user);

    ResBean delectUser(int id);

    ResBean selectUsers();

}

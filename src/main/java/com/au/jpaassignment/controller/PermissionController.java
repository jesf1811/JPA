package com.au.jpaassignment.controller;

import com.au.jpaassignment.model.Login;
import com.au.jpaassignment.model.Permission;
import com.au.jpaassignment.service.PermissionDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PermissionController {
    @Autowired
    private PermissionDBService permissionDBService;

    @GetMapping("/permissions")
    public List<Permission> getAllPermissions(){
        return permissionDBService.getAllPermissions();
    }

    @GetMapping("/permissions/{permissionId}")
    public Permission getPermissionById(@PathVariable int permissionId){
        return permissionDBService.getPermissionById(permissionId);
    }

    @PostMapping("/permissions")
    public Permission createPermission(@RequestBody Permission permission){
        return permissionDBService.createPermission(permission);
    }

    @DeleteMapping("/permissions/{permissionId}")
    public String deletePermission(@PathVariable int permissionId){
        return permissionDBService.deletePermissionById(permissionId);
    }

    @PutMapping("/permissions")
    public Permission updatePermission(@RequestBody Permission permission){
        return permissionDBService.updatePermission(permission);
    }

//    @GetMapping("/query/permissions")
//    public List<Permission> getPermissionsQuery(){
//        return permissionDBService.getPermissionQuery();
//    }
//
//    @PostMapping("/query/createPermission")
//    public Permission createPermissionQuery(@RequestBody Permission permission){
//        return permissionDBService.createPermissionQuery(permission);
//    }
//
//    @DeleteMapping("/query/permissions/{permissionId}")
//    public String deletePermissionQuery(@PathVariable int permissionId){
//        return permissionDBService.deletePermissionQuery(permissionId);
//    }
}

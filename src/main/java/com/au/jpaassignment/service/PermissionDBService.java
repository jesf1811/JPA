package com.au.jpaassignment.service;

import com.au.jpaassignment.model.Permission;
import com.au.jpaassignment.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionDBService {
    @Autowired
    private PermissionRepository permissionRepository;

    public List<Permission> getAllPermissions(){
        return (List<Permission>) permissionRepository.findAll();
    }

    public Permission getPermissionById(int permissionId){
        return permissionRepository.findById(permissionId).orElseThrow();
    }

    public Permission createPermission(Permission permission){
        return permissionRepository.save(permission);
    }

    public String deletePermissionById(int permissionId){
        permissionRepository.deleteById(permissionId);
        return "Permission successfully deleted";
    }

    public Permission updatePermission(Permission permission){
        Permission oldPermission;
        Optional<Permission> optionalPermission = permissionRepository.findById(permission.getId());
        if (optionalPermission.isPresent()){
            oldPermission = optionalPermission.get();
            oldPermission.setPermissionLevel(permission.getPermissionLevel());
            oldPermission.setId(permission.getId());
//            oldPermission.setUser(permission.getUser());
            permissionRepository.save(oldPermission);
        } else {
            return new Permission();
        }
        return oldPermission;
    }

    public List<Permission> getPermissionQuery(){
        return permissionRepository.getPermissionQuery();
    }

    public Permission createPermissionQuery(Permission permission){
        return permissionRepository.createPermissionQuery(permission.getId(),permission.getPermissionLevel(),permission.getUser());
    }

    public String deletePermissionQuery(int permissionId){
        permissionRepository.deletePermissionQuery(permissionId);
        return "Permission successfully deleted";
    }
}

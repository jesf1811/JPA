package com.au.jpaassignment.model;

import jakarta.persistence.*;

@Entity
@Table(name="permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;

    @Column(name = "permission_level")
    private int permissionLevel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }


}

package com.example.rdbmsPractice.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId ;
    private String RoleName;
    public Role(String roleName) {
        RoleName = roleName;
    }
    @OneToMany(mappedBy = "role")
    private Set<Teacher> teachers;

    public Role() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }




}

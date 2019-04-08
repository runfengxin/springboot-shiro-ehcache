package com.demo.shiroehcache.pojo;

import javax.persistence.*;

@Table(name = "t_permission")
public class Permission {
    @Id
    private Integer id;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_code")
    private String menuCode;

    @Column(name = "permission_name")
    private String permissionName;

    @Column(name = "permission_code")
    private String permissionCode;

    private Integer required;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return menu_name
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * @return menu_code
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * @param menuCode
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
    }

    /**
     * @return permission_name
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * @param permissionName
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    /**
     * @return permission_code
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     * @param permissionCode
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    /**
     * @return required
     */
    public Integer getRequired() {
        return required;
    }

    /**
     * @param required
     */
    public void setRequired(Integer required) {
        this.required = required;
    }
}
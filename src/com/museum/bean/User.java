package com.museum.bean;

/**
 * User - 用户实体类
 */
public class User {
    private Integer id;                     //用户id
    private String username;                //用户名
    private String  avatar;
    private String password;                //用户密码
    private String name;                    //用户姓名
    private String email;                   //用户邮箱
    private String phone;                   //用户电话
    private String address;                 //用户地址
    private Boolean isAdmin = false;        //是否为管理员
    private Boolean isValidate = false;     //账户是否有效

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String username, String avatar, String password, String name, String email, String phone, String address, Boolean isAdmin, Boolean isValidate) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.isAdmin = isAdmin;
        this.isValidate = isValidate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getIsValidate() {
        return isValidate;
    }

    public void setIsValidate(Boolean validate) {
        isValidate = validate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", isAdmin=" + isAdmin +
                ", isValidate=" + isValidate +
                '}';
    }
}

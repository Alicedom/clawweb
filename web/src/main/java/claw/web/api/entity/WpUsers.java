//package claw.web.api.entity;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//import java.util.Objects;
//
//@Entity
//@Table(name = "wp_users", schema = "wordpress", catalog = "")
//public class WpUsers {
//    private Long id;
//    private String userLogin;
//    private String userPass;
//    private String userNicename;
//    private String userEmail;
//    private String userUrl;
//    private Timestamp userRegistered;
//    private String userActivationKey;
//    private Integer userStatus;
//    private String displayName;
//
//    @Id
//    @Column(name = "ID")
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "user_login")
//    public String getUserLogin() {
//        return userLogin;
//    }
//
//    public void setUserLogin(String userLogin) {
//        this.userLogin = userLogin;
//    }
//
//    @Basic
//    @Column(name = "user_pass")
//    public String getUserPass() {
//        return userPass;
//    }
//
//    public void setUserPass(String userPass) {
//        this.userPass = userPass;
//    }
//
//    @Basic
//    @Column(name = "user_nicename")
//    public String getUserNicename() {
//        return userNicename;
//    }
//
//    public void setUserNicename(String userNicename) {
//        this.userNicename = userNicename;
//    }
//
//    @Basic
//    @Column(name = "user_email")
//    public String getUserEmail() {
//        return userEmail;
//    }
//
//    public void setUserEmail(String userEmail) {
//        this.userEmail = userEmail;
//    }
//
//    @Basic
//    @Column(name = "user_url")
//    public String getUserUrl() {
//        return userUrl;
//    }
//
//    public void setUserUrl(String userUrl) {
//        this.userUrl = userUrl;
//    }
//
//    @Basic
//    @Column(name = "user_registered")
//    public Timestamp getUserRegistered() {
//        return userRegistered;
//    }
//
//    public void setUserRegistered(Timestamp userRegistered) {
//        this.userRegistered = userRegistered;
//    }
//
//    @Basic
//    @Column(name = "user_activation_key")
//    public String getUserActivationKey() {
//        return userActivationKey;
//    }
//
//    public void setUserActivationKey(String userActivationKey) {
//        this.userActivationKey = userActivationKey;
//    }
//
//    @Basic
//    @Column(name = "user_status")
//    public Integer getUserStatus() {
//        return userStatus;
//    }
//
//    public void setUserStatus(Integer userStatus) {
//        this.userStatus = userStatus;
//    }
//
//    @Basic
//    @Column(name = "display_name")
//    public String getDisplayName() {
//        return displayName;
//    }
//
//    public void setDisplayName(String displayName) {
//        this.displayName = displayName;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        WpUsers wpUsers = (WpUsers) o;
//        return Objects.equals(id, wpUsers.id) &&
//                Objects.equals(userLogin, wpUsers.userLogin) &&
//                Objects.equals(userPass, wpUsers.userPass) &&
//                Objects.equals(userNicename, wpUsers.userNicename) &&
//                Objects.equals(userEmail, wpUsers.userEmail) &&
//                Objects.equals(userUrl, wpUsers.userUrl) &&
//                Objects.equals(userRegistered, wpUsers.userRegistered) &&
//                Objects.equals(userActivationKey, wpUsers.userActivationKey) &&
//                Objects.equals(userStatus, wpUsers.userStatus) &&
//                Objects.equals(displayName, wpUsers.displayName);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, userLogin, userPass, userNicename, userEmail, userUrl, userRegistered, userActivationKey, userStatus, displayName);
//    }
//}

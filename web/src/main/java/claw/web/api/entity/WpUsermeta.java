//package claw.web.api.entity;
//
//import javax.persistence.*;
//import java.util.Objects;
//
////@Entity
//@Table(name = "wp_usermeta", schema = "wordpress", catalog = "")
//public class WpUsermeta {
//    private Long umetaId;
//    private Long userId;
//    private String metaKey;
//    private String metaValue;
//
//    @Id
//    @Column(name = "umeta_id")
//    public Long getUmetaId() {
//        return umetaId;
//    }
//
//    public void setUmetaId(Long umetaId) {
//        this.umetaId = umetaId;
//    }
//
//    @Basic
//    @Column(name = "user_id")
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    @Basic
//    @Column(name = "meta_key")
//    public String getMetaKey() {
//        return metaKey;
//    }
//
//    public void setMetaKey(String metaKey) {
//        this.metaKey = metaKey;
//    }
//
//    @Basic
//    @Column(name = "meta_value")
//    public String getMetaValue() {
//        return metaValue;
//    }
//
//    public void setMetaValue(String metaValue) {
//        this.metaValue = metaValue;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        WpUsermeta that = (WpUsermeta) o;
//        return Objects.equals(umetaId, that.umetaId) &&
//                Objects.equals(userId, that.userId) &&
//                Objects.equals(metaKey, that.metaKey) &&
//                Objects.equals(metaValue, that.metaValue);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(umetaId, userId, metaKey, metaValue);
//    }
//}

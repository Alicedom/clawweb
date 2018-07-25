//package claw.web.api.entity;
//
//import javax.persistence.*;
//import java.util.Objects;
//
////@Entity
//@Table(name = "wp_options", schema = "wordpress", catalog = "")
//public class WpOptions {
//    private Long optionId;
//    private String optionName;
//    private String optionValue;
//    private String autoload;
//
//    @Id
//    @Column(name = "option_id")
//    public Long getOptionId() {
//        return optionId;
//    }
//
//    public void setOptionId(Long optionId) {
//        this.optionId = optionId;
//    }
//
//    @Basic
//    @Column(name = "option_name")
//    public String getOptionName() {
//        return optionName;
//    }
//
//    public void setOptionName(String optionName) {
//        this.optionName = optionName;
//    }
//
//    @Basic
//    @Column(name = "option_value")
//    public String getOptionValue() {
//        return optionValue;
//    }
//
//    public void setOptionValue(String optionValue) {
//        this.optionValue = optionValue;
//    }
//
//    @Basic
//    @Column(name = "autoload")
//    public String getAutoload() {
//        return autoload;
//    }
//
//    public void setAutoload(String autoload) {
//        this.autoload = autoload;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        WpOptions wpOptions = (WpOptions) o;
//        return Objects.equals(optionId, wpOptions.optionId) &&
//                Objects.equals(optionName, wpOptions.optionName) &&
//                Objects.equals(optionValue, wpOptions.optionValue) &&
//                Objects.equals(autoload, wpOptions.autoload);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(optionId, optionName, optionValue, autoload);
//    }
//}

//package claw.web.api.entity;
//
//import javax.persistence.*;
//import java.util.Objects;
//
////@Entity
//@Table(name = "wp_terms", schema = "wordpress", catalog = "")
//public class WpTerms {
//    private Long termId;
//    private String name;
//    private String slug;
//    private Long termGroup;
//
//    @Id
//    @Column(name = "term_id")
//    public Long getTermId() {
//        return termId;
//    }
//
//    public void setTermId(Long termId) {
//        this.termId = termId;
//    }
//
//    @Basic
//    @Column(name = "name")
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Basic
//    @Column(name = "slug")
//    public String getSlug() {
//        return slug;
//    }
//
//    public void setSlug(String slug) {
//        this.slug = slug;
//    }
//
//    @Basic
//    @Column(name = "term_group")
//    public Long getTermGroup() {
//        return termGroup;
//    }
//
//    public void setTermGroup(Long termGroup) {
//        this.termGroup = termGroup;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        WpTerms wpTerms = (WpTerms) o;
//        return Objects.equals(termId, wpTerms.termId) &&
//                Objects.equals(name, wpTerms.name) &&
//                Objects.equals(slug, wpTerms.slug) &&
//                Objects.equals(termGroup, wpTerms.termGroup);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(termId, name, slug, termGroup);
//    }
//}

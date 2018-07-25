//package claw.web.api.entity;
//
//import javax.persistence.*;
//import java.util.Objects;
//
////@Entity
//@Table(name = "wp_term_taxonomy", schema = "wordpress", catalog = "")
//public class WpTermTaxonomy {
//    private Long termTaxonomyId;
//    private Long termId;
//    private String taxonomy;
//    private String description;
//    private Long parent;
//    private Long count;
//
//    @Id
//    @Column(name = "term_taxonomy_id")
//    public Long getTermTaxonomyId() {
//        return termTaxonomyId;
//    }
//
//    public void setTermTaxonomyId(Long termTaxonomyId) {
//        this.termTaxonomyId = termTaxonomyId;
//    }
//
//    @Basic
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
//    @Column(name = "taxonomy")
//    public String getTaxonomy() {
//        return taxonomy;
//    }
//
//    public void setTaxonomy(String taxonomy) {
//        this.taxonomy = taxonomy;
//    }
//
//    @Basic
//    @Column(name = "description")
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @Basic
//    @Column(name = "parent")
//    public Long getParent() {
//        return parent;
//    }
//
//    public void setParent(Long parent) {
//        this.parent = parent;
//    }
//
//    @Basic
//    @Column(name = "count")
//    public Long getCount() {
//        return count;
//    }
//
//    public void setCount(Long count) {
//        this.count = count;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        WpTermTaxonomy that = (WpTermTaxonomy) o;
//        return Objects.equals(termTaxonomyId, that.termTaxonomyId) &&
//                Objects.equals(termId, that.termId) &&
//                Objects.equals(taxonomy, that.taxonomy) &&
//                Objects.equals(description, that.description) &&
//                Objects.equals(parent, that.parent) &&
//                Objects.equals(count, that.count);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(termTaxonomyId, termId, taxonomy, description, parent, count);
//    }
//}

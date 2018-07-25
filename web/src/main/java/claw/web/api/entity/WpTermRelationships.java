//package claw.web.api.entity;
//
//import javax.persistence.*;
//import java.util.Objects;
//
////@Entity
//@Table(name = "wp_term_relationships", schema = "wordpress", catalog = "")
//public class WpTermRelationships {
//    private Long objectId;
//    private Long termTaxonomyId;
//    private Integer termOrder;
//
//    @Id
//    @Column(name = "object_id")
//    public Long getObjectId() {
//        return objectId;
//    }
//
//    public void setObjectId(Long objectId) {
//        this.objectId = objectId;
//    }
//
//    @Basic
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
//    @Column(name = "term_order")
//    public Integer getTermOrder() {
//        return termOrder;
//    }
//
//    public void setTermOrder(Integer termOrder) {
//        this.termOrder = termOrder;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        WpTermRelationships that = (WpTermRelationships) o;
//        return Objects.equals(objectId, that.objectId) &&
//                Objects.equals(termTaxonomyId, that.termTaxonomyId) &&
//                Objects.equals(termOrder, that.termOrder);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(objectId, termTaxonomyId, termOrder);
//    }
//}

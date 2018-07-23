package claw.web.api.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "wp_termmeta", schema = "wordpress", catalog = "")
public class WpTermmeta {
    private Long metaId;
    private Long termId;
    private String metaKey;
    private String metaValue;

    @Id
    @Column(name = "meta_id")
    public Long getMetaId() {
        return metaId;
    }

    public void setMetaId(Long metaId) {
        this.metaId = metaId;
    }

    @Basic
    @Column(name = "term_id")
    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    @Basic
    @Column(name = "meta_key")
    public String getMetaKey() {
        return metaKey;
    }

    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }

    @Basic
    @Column(name = "meta_value")
    public String getMetaValue() {
        return metaValue;
    }

    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WpTermmeta that = (WpTermmeta) o;
        return Objects.equals(metaId, that.metaId) &&
                Objects.equals(termId, that.termId) &&
                Objects.equals(metaKey, that.metaKey) &&
                Objects.equals(metaValue, that.metaValue);
    }

    @Override
    public int hashCode() {

        return Objects.hash(metaId, termId, metaKey, metaValue);
    }
}

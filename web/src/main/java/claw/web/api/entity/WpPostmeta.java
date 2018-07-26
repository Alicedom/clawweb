package claw.web.api.entity;

import javax.persistence.*;
import java.util.Objects;

//@Entity
@Table(name = "wp_postmeta", schema = "wordpress", catalog = "")
public class WpPostmeta {
    private Long metaId;
    private Long postId;
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
    @Column(name = "post_id")
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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
        WpPostmeta that = (WpPostmeta) o;
        return Objects.equals(metaId, that.metaId) &&
                Objects.equals(postId, that.postId) &&
                Objects.equals(metaKey, that.metaKey) &&
                Objects.equals(metaValue, that.metaValue);
    }

    @Override
    public int hashCode() {

        return Objects.hash(metaId, postId, metaKey, metaValue);
    }
}

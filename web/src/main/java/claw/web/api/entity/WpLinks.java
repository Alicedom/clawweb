//package claw.web.api.entity;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//import java.util.Objects;
//
////@Entity
//@Table(name = "wp_links", schema = "wordpress", catalog = "")
//public class WpLinks {
//    private Long linkId;
//    private String linkUrl;
//    private String linkName;
//    private String linkImage;
//    private String linkTarget;
//    private String linkDescription;
//    private String linkVisible;
//    private Long linkOwner;
//    private Integer linkRating;
//    private Timestamp linkUpdated;
//    private String linkRel;
//    private String linkNotes;
//    private String linkRss;
//
//    @Id
//    @Column(name = "link_id")
//    public Long getLinkId() {
//        return linkId;
//    }
//
//    public void setLinkId(Long linkId) {
//        this.linkId = linkId;
//    }
//
//    @Basic
//    @Column(name = "link_url")
//    public String getLinkUrl() {
//        return linkUrl;
//    }
//
//    public void setLinkUrl(String linkUrl) {
//        this.linkUrl = linkUrl;
//    }
//
//    @Basic
//    @Column(name = "link_name")
//    public String getLinkName() {
//        return linkName;
//    }
//
//    public void setLinkName(String linkName) {
//        this.linkName = linkName;
//    }
//
//    @Basic
//    @Column(name = "link_image")
//    public String getLinkImage() {
//        return linkImage;
//    }
//
//    public void setLinkImage(String linkImage) {
//        this.linkImage = linkImage;
//    }
//
//    @Basic
//    @Column(name = "link_target")
//    public String getLinkTarget() {
//        return linkTarget;
//    }
//
//    public void setLinkTarget(String linkTarget) {
//        this.linkTarget = linkTarget;
//    }
//
//    @Basic
//    @Column(name = "link_description")
//    public String getLinkDescription() {
//        return linkDescription;
//    }
//
//    public void setLinkDescription(String linkDescription) {
//        this.linkDescription = linkDescription;
//    }
//
//    @Basic
//    @Column(name = "link_visible")
//    public String getLinkVisible() {
//        return linkVisible;
//    }
//
//    public void setLinkVisible(String linkVisible) {
//        this.linkVisible = linkVisible;
//    }
//
//    @Basic
//    @Column(name = "link_owner")
//    public Long getLinkOwner() {
//        return linkOwner;
//    }
//
//    public void setLinkOwner(Long linkOwner) {
//        this.linkOwner = linkOwner;
//    }
//
//    @Basic
//    @Column(name = "link_rating")
//    public Integer getLinkRating() {
//        return linkRating;
//    }
//
//    public void setLinkRating(Integer linkRating) {
//        this.linkRating = linkRating;
//    }
//
//    @Basic
//    @Column(name = "link_updated")
//    public Timestamp getLinkUpdated() {
//        return linkUpdated;
//    }
//
//    public void setLinkUpdated(Timestamp linkUpdated) {
//        this.linkUpdated = linkUpdated;
//    }
//
//    @Basic
//    @Column(name = "link_rel")
//    public String getLinkRel() {
//        return linkRel;
//    }
//
//    public void setLinkRel(String linkRel) {
//        this.linkRel = linkRel;
//    }
//
//    @Basic
//    @Column(name = "link_notes")
//    public String getLinkNotes() {
//        return linkNotes;
//    }
//
//    public void setLinkNotes(String linkNotes) {
//        this.linkNotes = linkNotes;
//    }
//
//    @Basic
//    @Column(name = "link_rss")
//    public String getLinkRss() {
//        return linkRss;
//    }
//
//    public void setLinkRss(String linkRss) {
//        this.linkRss = linkRss;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        WpLinks wpLinks = (WpLinks) o;
//        return Objects.equals(linkId, wpLinks.linkId) &&
//                Objects.equals(linkUrl, wpLinks.linkUrl) &&
//                Objects.equals(linkName, wpLinks.linkName) &&
//                Objects.equals(linkImage, wpLinks.linkImage) &&
//                Objects.equals(linkTarget, wpLinks.linkTarget) &&
//                Objects.equals(linkDescription, wpLinks.linkDescription) &&
//                Objects.equals(linkVisible, wpLinks.linkVisible) &&
//                Objects.equals(linkOwner, wpLinks.linkOwner) &&
//                Objects.equals(linkRating, wpLinks.linkRating) &&
//                Objects.equals(linkUpdated, wpLinks.linkUpdated) &&
//                Objects.equals(linkRel, wpLinks.linkRel) &&
//                Objects.equals(linkNotes, wpLinks.linkNotes) &&
//                Objects.equals(linkRss, wpLinks.linkRss);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(linkId, linkUrl, linkName, linkImage, linkTarget, linkDescription, linkVisible, linkOwner, linkRating, linkUpdated, linkRel, linkNotes, linkRss);
//    }
//}

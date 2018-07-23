package claw.web.api.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "wp_posts", schema = "wordpress", catalog = "")
public class WpPosts {
    private Long id;
    private Long postAuthor;
    private Timestamp postDate;
    private Timestamp postDateGmt;
    private String postContent;
    private String postTitle;
    private String postExcerpt;
    private String postStatus;
    private String commentStatus;
    private String pingStatus;
    private String postPassword;
    private String postName;
    private String toPing;
    private String pinged;
    private Timestamp postModified;
    private Timestamp postModifiedGmt;
    private String postContentFiltered;
    private Long postParent;
    private String guid;
    private Integer menuOrder;
    private String postType;
    private String postMimeType;
    private Long commentCount;

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "post_author")
    public Long getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(Long postAuthor) {
        this.postAuthor = postAuthor;
    }

    @Basic
    @Column(name = "post_date")
    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    @Basic
    @Column(name = "post_date_gmt")
    public Timestamp getPostDateGmt() {
        return postDateGmt;
    }

    public void setPostDateGmt(Timestamp postDateGmt) {
        this.postDateGmt = postDateGmt;
    }

    @Basic
    @Column(name = "post_content")
    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    @Basic
    @Column(name = "post_title")
    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    @Basic
    @Column(name = "post_excerpt")
    public String getPostExcerpt() {
        return postExcerpt;
    }

    public void setPostExcerpt(String postExcerpt) {
        this.postExcerpt = postExcerpt;
    }

    @Basic
    @Column(name = "post_status")
    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    @Basic
    @Column(name = "comment_status")
    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    @Basic
    @Column(name = "ping_status")
    public String getPingStatus() {
        return pingStatus;
    }

    public void setPingStatus(String pingStatus) {
        this.pingStatus = pingStatus;
    }

    @Basic
    @Column(name = "post_password")
    public String getPostPassword() {
        return postPassword;
    }

    public void setPostPassword(String postPassword) {
        this.postPassword = postPassword;
    }

    @Basic
    @Column(name = "post_name")
    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @Basic
    @Column(name = "to_ping")
    public String getToPing() {
        return toPing;
    }

    public void setToPing(String toPing) {
        this.toPing = toPing;
    }

    @Basic
    @Column(name = "pinged")
    public String getPinged() {
        return pinged;
    }

    public void setPinged(String pinged) {
        this.pinged = pinged;
    }

    @Basic
    @Column(name = "post_modified")
    public Timestamp getPostModified() {
        return postModified;
    }

    public void setPostModified(Timestamp postModified) {
        this.postModified = postModified;
    }

    @Basic
    @Column(name = "post_modified_gmt")
    public Timestamp getPostModifiedGmt() {
        return postModifiedGmt;
    }

    public void setPostModifiedGmt(Timestamp postModifiedGmt) {
        this.postModifiedGmt = postModifiedGmt;
    }

    @Basic
    @Column(name = "post_content_filtered")
    public String getPostContentFiltered() {
        return postContentFiltered;
    }

    public void setPostContentFiltered(String postContentFiltered) {
        this.postContentFiltered = postContentFiltered;
    }

    @Basic
    @Column(name = "post_parent")
    public Long getPostParent() {
        return postParent;
    }

    public void setPostParent(Long postParent) {
        this.postParent = postParent;
    }

    @Basic
    @Column(name = "guid")
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Basic
    @Column(name = "menu_order")
    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    @Basic
    @Column(name = "post_type")
    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    @Basic
    @Column(name = "post_mime_type")
    public String getPostMimeType() {
        return postMimeType;
    }

    public void setPostMimeType(String postMimeType) {
        this.postMimeType = postMimeType;
    }

    @Basic
    @Column(name = "comment_count")
    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WpPosts wpPosts = (WpPosts) o;
        return Objects.equals(id, wpPosts.id) &&
                Objects.equals(postAuthor, wpPosts.postAuthor) &&
                Objects.equals(postDate, wpPosts.postDate) &&
                Objects.equals(postDateGmt, wpPosts.postDateGmt) &&
                Objects.equals(postContent, wpPosts.postContent) &&
                Objects.equals(postTitle, wpPosts.postTitle) &&
                Objects.equals(postExcerpt, wpPosts.postExcerpt) &&
                Objects.equals(postStatus, wpPosts.postStatus) &&
                Objects.equals(commentStatus, wpPosts.commentStatus) &&
                Objects.equals(pingStatus, wpPosts.pingStatus) &&
                Objects.equals(postPassword, wpPosts.postPassword) &&
                Objects.equals(postName, wpPosts.postName) &&
                Objects.equals(toPing, wpPosts.toPing) &&
                Objects.equals(pinged, wpPosts.pinged) &&
                Objects.equals(postModified, wpPosts.postModified) &&
                Objects.equals(postModifiedGmt, wpPosts.postModifiedGmt) &&
                Objects.equals(postContentFiltered, wpPosts.postContentFiltered) &&
                Objects.equals(postParent, wpPosts.postParent) &&
                Objects.equals(guid, wpPosts.guid) &&
                Objects.equals(menuOrder, wpPosts.menuOrder) &&
                Objects.equals(postType, wpPosts.postType) &&
                Objects.equals(postMimeType, wpPosts.postMimeType) &&
                Objects.equals(commentCount, wpPosts.commentCount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, postAuthor, postDate, postDateGmt, postContent, postTitle, postExcerpt, postStatus, commentStatus, pingStatus, postPassword, postName, toPing, pinged, postModified, postModifiedGmt, postContentFiltered, postParent, guid, menuOrder, postType, postMimeType, commentCount);
    }
}

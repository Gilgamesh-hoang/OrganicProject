package com.laptrinhweb.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "blog")
@EntityListeners(AuditingEntityListener.class) // de su dung createdBy..., duoc cau hinh trong jpaAuditingConfig
public class BlogEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int blogId;

	@Column(name = "title")
	private String title;

	@Column(name = "image")
	private String image;

	@Column(name = "content", columnDefinition = "TEXT")
	private String content;

	@Column(name = "short_description")
	private String shortDescription;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryBlogEntity category;

	@OneToMany(mappedBy = "blog")
	private List<CommentBlogEntity> listComment;

	@Column(name = "created_by")
	@CreatedBy
	private String createdBy;

	@Column(name = "modified_by")
	@LastModifiedBy
	private String modifiedBy;

	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date createdDate;

	@Column(name = "modified_date")
	@Temporal(TemporalType.DATE)
	@LastModifiedDate
	private Date modifiedDate;

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public List<CommentBlogEntity> getListComment() {
		return listComment;
	}

	public void setListComment(List<CommentBlogEntity> listComment) {
		this.listComment = listComment;
	}

	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public CategoryBlogEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryBlogEntity category) {
		this.category = category;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}

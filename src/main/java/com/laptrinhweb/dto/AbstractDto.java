package com.laptrinhweb.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractDto<T> {
	private int id;
	private String createdBy;
	private String modifiedBy;
	private Date createdDate;
	private Date modifiedDate;
	private List<T> listObject;
	private Integer page;
	private Integer totalPage;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

}

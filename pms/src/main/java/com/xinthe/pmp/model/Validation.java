package com.xinthe.pmp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Validation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String validationName;
	private Date createdDate;
	private Date updatedDate;
	private String createdBy;
	private String updatedBy;
}



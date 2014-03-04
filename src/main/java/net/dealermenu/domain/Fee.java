package net.dealermenu.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Fee implements Serializable {

	/**
     */
	@NotBlank(message = "Fee name may not be empty")
	private String feeName;

	/**
     */
	private String displayName;

	/**
     */
	private double defaultValue;

	/**
     */
	private Boolean isActive;

	/**
     */
	private Boolean isTaxable;

	/**
     */
	@ManyToOne
	private Dealer dealer;

	@ManyToMany(mappedBy = "fees")
	private List<DealTemplate> dealTemplates;

}

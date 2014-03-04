package net.dealermenu.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Provider implements Serializable {

	/**
     */
	@NotBlank(message = "Provider name may not be empty")
	private String providerName;

	/**
     */
	@ManyToOne
	private Dealer dealer;

	/**
     */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "provider")
	private List<Product> products;
}

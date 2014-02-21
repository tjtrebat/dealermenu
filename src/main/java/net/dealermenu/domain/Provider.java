package net.dealermenu.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Provider implements Serializable {

	/**
     */
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

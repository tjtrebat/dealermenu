package net.dealermenu.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class DealTemplate implements Serializable {

	@Column(name = "vCreatedBy")
	private String createdBy;

	@Column(name = "vTemplateName")
	private String templateName;

	@Column(name = "vType")
	private DealType type;

	@ManyToOne
	private Dealer dealer;

	@ElementCollection
	@CollectionTable(name = "PROD_PACKAGETYPES")
	@MapKeyJoinColumn(name = "PROD_ID")
	private Map<Product, PackageEntry> packageTypes;

	@ManyToMany
	@JoinTable(name = "DEALTPL_FEE", joinColumns = { @JoinColumn(name = "DEALTPL_ID") }, inverseJoinColumns = { @JoinColumn(name = "FEE_ID") })
	private List<Fee> fees;

}

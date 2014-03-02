package net.dealermenu.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@NamedQueries({
		@javax.persistence.NamedQuery(name = "Dealer.getDealerByLoginId", query = "SELECT dealer FROM Dealer dealer WHERE dealer.loginId=:loginId"),
		@javax.persistence.NamedQuery(name = "Dealer.getDeals", query = "SELECT deal FROM Dealer dealer JOIN dealer.dealTemplates dealTemplate JOIN dealTemplate.deals deal WHERE dealer.loginId=:loginId"),
		@javax.persistence.NamedQuery(name = "Dealer.getDealByPrimaryKey", query = "SELECT deal FROM Dealer dealer JOIN dealer.dealTemplates dealTemplate JOIN dealTemplate.deals deal WHERE dealer.loginId=:loginId AND deal.id=:primaryKey"),
		@javax.persistence.NamedQuery(name = "Dealer.getDealTemplates", query = "SELECT dealTemplate FROM Dealer dealer JOIN dealer.dealTemplates dealTemplate WHERE dealer.loginId=:loginId"),
		@javax.persistence.NamedQuery(name = "Dealer.getDealTemplateByPrimaryKey", query = "SELECT dealTemplate FROM Dealer dealer JOIN dealer.dealTemplates dealTemplate WHERE dealer.loginId=:loginId AND dealTemplate.id=:primaryKey"),
		@javax.persistence.NamedQuery(name = "Dealer.getProducts", query = "SELECT product FROM Dealer dealer JOIN dealer.providers provider JOIN provider.products product WHERE dealer.loginId=:loginId"),
		@javax.persistence.NamedQuery(name = "Dealer.getProductByPrimaryKey", query = "SELECT product FROM Dealer dealer JOIN dealer.providers provider JOIN provider.products product WHERE dealer.loginId=:loginId AND product.id=:primaryKey"),
		@javax.persistence.NamedQuery(name = "Dealer.getFeeByPrimaryKey", query = "SELECT fee FROM Dealer dealer JOIN dealer.fees fee WHERE dealer.loginId=:loginId AND fee.id=:primaryKey"),
		@javax.persistence.NamedQuery(name = "Dealer.getTaxByPrimaryKey", query = "SELECT tax FROM Dealer dealer JOIN dealer.taxes tax WHERE dealer.loginId=:loginId AND tax.id=:primaryKey"),
		@javax.persistence.NamedQuery(name = "Dealer.getProductCategoryByPrimaryKey", query = "SELECT productCategory FROM Dealer dealer JOIN dealer.productCategories productCategory WHERE dealer.loginId=:loginId AND productCategory.id=:primaryKey"),
		@javax.persistence.NamedQuery(name = "Dealer.getProviderByPrimaryKey", query = "SELECT provider FROM Dealer dealer JOIN dealer.providers provider WHERE dealer.loginId=:loginId AND provider.id=:primaryKey") })
public class Dealer implements Serializable {

	@Column(name = "vDealerName")
	@Size(min = 3, max = 50, message = "Your full name must be between 3 and 50 characters long.")
	private String dealerName;

	@Column(name = "vMailId")
	@Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "Invalid email address.")
	private String mailId;

	@Column(name = "vMobile")
	private String mobile;

	@Column(name = "vLoginId")
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long.")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces")
	private String loginId;

	@Column(name = "vPassword")
	@Size(min = 6, message = "The password must be at least 6 characters long.")
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "vUserType")
	private UserRoles userType;

	@Column(name = "vStreetAddress")
	private String streetAddress;

	@Column(name = "vCity")
	private String city;

	@Column(name = "vState")
	private String state;

	@Column(name = "vZip")
	private String zip;

	@Column(name = "vStatus")
	private DealerStatus status;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dealer")
	private List<DealTemplate> dealTemplates;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dealer")
	private List<ProductCategory> productCategories;

	/**
     */
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "dealer")
	private Packages packages;

	/**
     */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dealer")
	private List<Provider> providers;

	/**
     */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dealer")
	private List<Tax> taxes;

	/**
     */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dealer")
	private List<Fee> fees;

}

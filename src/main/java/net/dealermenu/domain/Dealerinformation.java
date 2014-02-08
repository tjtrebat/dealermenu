package net.dealermenu.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@NamedQueries({
		@javax.persistence.NamedQuery(name = "Dealerinformation.getDealerByLoginId", query = "SELECT dealerInformation FROM Dealerinformation dealerInformation WHERE dealerInformation.loginId=:loginId"),
		@javax.persistence.NamedQuery(name = "Dealerinformation.getProducts", query = "SELECT product FROM Dealerinformation dealerInformation JOIN dealerInformation.providers provider JOIN provider.products product WHERE dealerInformation.loginId=:loginId"),
		@javax.persistence.NamedQuery(name = "Dealerinformation.getProductByPrimaryKey", query = "SELECT product FROM Dealerinformation dealerInformation JOIN dealerInformation.providers provider JOIN provider.products product WHERE dealerInformation.loginId=:loginId AND product.id=:primaryKey"),
		@javax.persistence.NamedQuery(name = "Dealerinformation.getFeeByPrimaryKey", query = "SELECT fee FROM Dealerinformation dealerInformation JOIN dealerInformation.fees fee WHERE dealerInformation.loginId=:loginId AND fee.id=:primaryKey"),
		@javax.persistence.NamedQuery(name = "Dealerinformation.getTaxByPrimaryKey", query = "SELECT tax FROM Dealerinformation dealerInformation JOIN dealerInformation.taxes tax WHERE dealerInformation.loginId=:loginId AND tax.id=:primaryKey"),
		@javax.persistence.NamedQuery(name = "Dealerinformation.getProductCategoryByPrimaryKey", query = "SELECT productCategory FROM Dealerinformation dealerInformation JOIN dealerInformation.productCategories productCategory WHERE dealerInformation.loginId=:loginId AND productCategory.id=:primaryKey"),
		@javax.persistence.NamedQuery(name = "Dealerinformation.getProviderByPrimaryKey", query = "SELECT provider FROM Dealerinformation dealerInformation JOIN dealerInformation.providers provider WHERE dealerInformation.loginId=:loginId AND provider.id=:primaryKey") })
public class Dealerinformation {

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
	@Size(min = 6, max = 20, message = "The password must be at least 6 characters long.")
	private String password;

	@Column(name = "vUserType")
	private String userType;

	@Column(name = "vStreetAddress")
	private String streetAddress;

	@Column(name = "vCity")
	private String city;

	@Column(name = "vState")
	private String state;

	@Column(name = "vZip")
	private String zip;

	@Column(name = "vStatus")
	@Pattern(regexp = "ActiveDealers|AwaitingDealers|DeniedDealers", flags = Flag.CASE_INSENSITIVE)
	private String status;

	@OneToMany(mappedBy = "dealer")
	private List<Template> templates;

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

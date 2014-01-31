package net.dealermenu.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.sql.Template;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@NamedQuery(name = "Dealerinformation.getDealerByLoginId", query = "SELECT dealerInformation FROM Dealerinformation dealerInformation WHERE dealerInformation.loginId=:loginId")
public class Dealerinformation {
	
	@Column(name = "vDealerName")
	@Size(min = 3, max = 50, message = "Your full name must be between 3 and 50 characters long.")
	private String dealerName;

	@Column(name = "vStatus")
	@Pattern(regexp = "ActiveDealers|AwaitingDealers|DeniedDealers", flags = Pattern.Flag.CASE_INSENSITIVE)
	private String status;

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

	@OneToMany(mappedBy = "dealer")
	private List<Template> templates;

	@OneToMany(mappedBy = "dealer")
	private List<ProductCategory> productCategories;

}

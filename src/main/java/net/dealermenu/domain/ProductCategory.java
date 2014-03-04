package net.dealermenu.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class ProductCategory implements Serializable {

	@Column(name = "vProductCategory")
	@NotBlank(message = "Product category name may not be empty")
	private String productCategoryName;

	@ManyToOne
	private Dealer dealer;

	@OneToMany(mappedBy = "productCategory")
	private List<Product> products;

}

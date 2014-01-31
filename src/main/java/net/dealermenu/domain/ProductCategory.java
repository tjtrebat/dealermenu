package net.dealermenu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class ProductCategory {

	@Column(name = "vProductCategory")
	private String productCategory;

	@ManyToOne
	private Dealerinformation dealer;

	@OneToMany(mappedBy = "productCategory")
	private List<Product> products;

}

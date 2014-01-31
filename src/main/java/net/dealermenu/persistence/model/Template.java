package net.dealermenu.persistence.model;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Template {
	
	@Column(name = "vCreatedBy")
	private String createdBy;

	@Column(name = "vTemplateName")
	private String templateName;

	@Column(name = "vType")
	private String type;

	@ManyToOne
	private Dealerinformation dealer;

}

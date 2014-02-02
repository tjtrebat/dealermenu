package net.dealermenu.service;

import net.dealermenu.domain.Template;

public interface TemplateService {

	public void removeTemplate(Template template);

	public Template getTemplateByPrimaryKey(Long id);
}

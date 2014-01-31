package net.dealermenu.web;
import net.dealermenu.domain.Template;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/templates")
@Controller
@RooWebScaffold(path = "templates", formBackingObject = Template.class)
public class TemplateController {
}

package net.dealermenu.web;
import net.dealermenu.domain.Dealerinformation;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dealerinformations")
@Controller
@RooWebScaffold(path = "dealerinformations", formBackingObject = Dealerinformation.class)
public class DealerinformationController {
}

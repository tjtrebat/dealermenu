package net.dealermenu.web;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.binding.mapping.MappingResult;
import org.springframework.webflow.engine.FlowAttributeMappingException;
import org.springframework.webflow.execution.ActionExecutionException;
import org.springframework.webflow.execution.FlowExecutionException;
import org.springframework.webflow.execution.FlowExecutionListenerAdapter;
import org.springframework.webflow.execution.RequestContext;

public class LoggingFlowExecutionListener extends FlowExecutionListenerAdapter {

	private final Log logger = LogFactory.getLog(getClass());

	@Override
	@SuppressWarnings("unchecked")
	public void exceptionThrown(RequestContext context,
			FlowExecutionException exception) {
		if (exception instanceof FlowAttributeMappingException) {
			List<MappingResult> errors = ((FlowAttributeMappingException) exception)
					.getMappingResults().getErrorResults();
			for (MappingResult error : errors) {
				if (error.getErrorCause() != null) {
					logger.warn(
							"FlowAttributeMappingException thown containing error : "
									+ error.getErrorCause(),
							error.getErrorCause());
				}
			}
		} else if (exception instanceof ActionExecutionException)
			((ActionExecutionException) exception).printStackTrace();
	}

}

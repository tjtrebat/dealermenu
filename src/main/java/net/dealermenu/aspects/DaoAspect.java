package net.dealermenu.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class DaoAspect {

	public Object catchEmptyResultDataAccessException(ProceedingJoinPoint pjp) {
		Object result = null;
		try {
			result = pjp.proceed();
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Found empty result set in "
					+ pjp.getSignature());
			e.printStackTrace();
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		return result;
	}
}

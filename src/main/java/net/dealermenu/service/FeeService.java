package net.dealermenu.service;

import net.dealermenu.domain.Fee;

public interface FeeService {

	public void removeFee(Long primaryKey);
	
	public Fee updateFee(Fee fee);
	
}

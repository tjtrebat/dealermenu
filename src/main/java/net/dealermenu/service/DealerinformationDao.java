package net.dealermenu.service;

import java.util.List;

import net.dealermenu.domain.Dealerinformation;

public interface DealerinformationDao {

	public List<Dealerinformation> getDealerinformations();
	
	public List<Dealerinformation> getDealersByStatus(String status);

	public Dealerinformation getDealerByLoginId(String loginId);
	
	public Dealerinformation getDealerByPrimaryKey(Long primaryKey);
	
	public void saveDealer(Dealerinformation dealer);
	
	public Dealerinformation updateDealer(Dealerinformation dealer);

	public void removeDealer(Dealerinformation dealerInformation);
	
}

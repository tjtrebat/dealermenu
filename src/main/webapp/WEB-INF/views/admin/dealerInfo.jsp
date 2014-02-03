<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<div class="grid_6 prefix_3 suffix_3 alpha omega">
	<div class="grid_2 alpha">
		<p>
			<strong>Dealer Name</strong>
		</p>
	</div>
	<div class="grid_4 omega">
		<p>${dealer.dealerName}</p>
	</div>
	<div class="clear"></div>
	<div class="grid_2 alpha">
		<p>
			<strong>Street Address</strong>
		</p>
	</div>
	<div class="grid_4 omega">
		<p>${dealer.streetAddress}</p>
	</div>
	<div class="clear"></div>
	<div class="grid_2 alpha">
		<p>
			<strong>City</strong>
		</p>
	</div>
	<div class="grid_4 omega">
		<p>${dealer.city}</p>
	</div>
	<div class="clear"></div>
	<div class="grid_2 alpha">
		<p>
			<strong>State</strong>
		</p>
	</div>
	<div class="grid_4 omega">
		<p>${dealer.state}</p>
	</div>
	<div class="clear"></div>
	<div class="grid_2 alpha">
		<p>
			<strong>Zip</strong>
		</p>
	</div>
	<div class="grid_4 omega">
		<p>${dealer.zip}</p>
	</div>
	<div class="clear"></div>
	<div class="grid_2 alpha">
		<p>
			<strong>Email</strong>
		</p>
	</div>
	<div class="grid_4 omega">
		<p>${dealer.mailId}</p>
	</div>
	<div class="clear"></div>
	<div class="grid_2 alpha">
		<p>
			<strong>Mobile no.</strong>
		</p>
	</div>
	<div class="grid_4 omega">
		<p>${dealer.mobile}</p>
	</div>
</div>
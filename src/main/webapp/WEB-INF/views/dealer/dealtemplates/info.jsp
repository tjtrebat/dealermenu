<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ page session="false"%>
<div class="grid_8 suffix_2 prefix_2 alpha omega">
	<div class="grid_8">
		<h6>Product Details</h6>
	</div>
	<div id="tblContents" class="grid_8">
		<div id="tblHeader" class="grid_8 alpha omega">
			<div class="grid_2 alpha">
				<p>
					<strong>Products</strong>
				</p>
			</div>
			<div class="grid_2">
				<p>
					<strong>Provider</strong>
				</p>
			</div>
			<div class="grid_1">
				<p class="alignCenter">
					<strong>Preferred</strong>
				</p>
			</div>
			<div class="grid_1">
				<p class="alignCenter">
					<strong>Premium</strong>
				</p>
			</div>
			<div class="grid_1">
				<p class="alignCenter">
					<strong>Value</strong>
				</p>
			</div>
			<div class="grid_1 alpha omega">
				<p class="alignCenter">
					<strong>Economy</strong>
				</p>
			</div>
		</div>
		<div class="clear"></div>
		<div id="tblBody" class="grid_8 alpha omega">
			<c:forEach var="packageType" items="${packageTypes}">
				<div class="grid_8 alpha omega tblRow">
					<div class="grid_2 alpha">
						<p>${packageType.key.productName}</p>
					</div>
					<div class="grid_2">
						<p>${packageType.key.provider.providerName}</p>
					</div>
					<div class="grid_1">
						<p class="alignCenter">
							<tags:yesorno value="${packageType.value.isPreferred}" />
						</p>
					</div>
					<div class="grid_1">
						<p class="alignCenter">
							<tags:yesorno value="${packageType.value.isPremium}" />
						</p>
					</div>
					<div class="grid_1">
						<p class="alignCenter">
							<tags:yesorno value="${packageType.value.isValue}" />
						</p>
					</div>
					<div class="grid_1 omega">
						<p class="alignCenter">
							<tags:yesorno value="${packageType.value.isEconomy}" />
						</p>
					</div>
				</div>
				<div class="clear"></div>
			</c:forEach>
		</div>
	</div>
	<div class="grid_8">
		<h6>Fees Details</h6>
	</div>
	<div id="tblContents" class="grid_8">
		<div id="tblHeader" class="grid_8 alpha omega">
			<div class="grid_2 alpha">
				<p>
					<strong>Fee Name</strong>
				</p>
			</div>
			<div class="grid_2">
				<p>
					<strong>Display Name</strong>
				</p>
			</div>
			<div class="grid_2">
				<p>
					<strong>Default Value</strong>
				</p>
			</div>
			<div class="grid_2 omega">
				<p class="alignCenter">
					<strong>Included</strong>
				</p>
			</div>
		</div>
		<div class="clear"></div>
		<div id="tblBody" class="grid_8 alpha omega">
			<c:forEach var="fee" items="${fees}">
				<c:if test="${fee.isActive}">
					<div class="grid_8 alpha omega tblRow">
						<div class="grid_2 alpha">
							<p>${fee.feeName}</p>
						</div>
						<div class="grid_2">
							<p>${fee.displayName}</p>
						</div>
						<div class="grid_2">
							<p>${fee.defaultValue}</p>
						</div>
						<div class="grid_2 omega">
							<p class="alignCenter">yes</p>
						</div>
					</div>
					<div class="clear"></div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</div>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ page session="false"%>
<div class="grid_12 alpha omega">
	<div class="grid_12">
		<h6>
			<tags:ucfirst value="${deal.dealTemplate.type}" />
			Deal
		</h6>
	</div>
	<c:url var="updateUrl" value="/dealer/deals/update" />
	<form:form action="${updateUrl}" modelAttribute="deal" method="post">
		<div class="grid_12">
			<jsp:include page="../../../_notification.jsp">
				<jsp:param value="deal" name="commandName" />
			</jsp:include>
		</div>
		<form:hidden path="id" />
		<input type="hidden" name="dealTemplate"
			value="${deal.dealTemplate.id}" />
		<div class="grid_4 alpha">
			<div class="grid_2 alpha">
				<p class="alignRight">
					<form:label path="buyerName">
						<s:message code="deal.buyerName" />
					</form:label>
				</p>
			</div>
			<div class="grid_2 omega">
				<p>
					<form:input path="buyerName" size="17" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 alpha">
				<p class="alignRight">
					<form:label path="stock">
						<s:message code="deal.stock" />
					</form:label>
				</p>
			</div>
			<div class="grid_2 omega">
				<p>
					<form:input path="stock" size="17" />
				</p>
			</div>
		</div>
		<div class="grid_4">
			<div class="grid_2 alpha">
				<p class="alignRight">
					<form:label path="vehicleType">
						<s:message code="deal.vehicleType" />
					</form:label>
				</p>
			</div>
			<div class="grid_2 omega">
				<p>
					<form:input path="vehicleType" size="17" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 alpha">
				<p class="alignRight">
					<form:label path="vin">
						<s:message code="deal.vin" />
					</form:label>
				</p>
			</div>
			<div class="grid_2 omega">
				<p>
					<form:input path="vin" size="17" />
				</p>
			</div>
		</div>
		<div class="grid_4 omega">
			<div class="grid_2 alpha">
				<p class="alignRight">
					<form:label path="mileage">
						<s:message code="deal.mileage" />
					</form:label>
				</p>
			</div>
			<div class="grid_2 omega">
				<p>
					<form:input path="mileage" size="17" />
				</p>
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
		<div id="tblContents" class="grid_12 alpha omega">
			<div id="tblHeader" class="grid_12 alpha omega">
				<div class="grid_4 alpha">
					<p class="alignCenter">
						<strong>Deal Information</strong>
					</p>
				</div>
				<div class="grid_4">
					<p class="alignCenter">
						<strong>Payment Information</strong>
					</p>
				</div>
				<div class="grid_4 omega">
					<p class="alignCenter">
						<strong>Product Information</strong>
					</p>
				</div>
			</div>
			<div class="clear"></div>
			<div id="tblBody" class="grid_12 alpha omega">
				<div class="grid_4 alpha">
					<div class="grid_2 alpha">
						<p class="alignRight">
							<form:label path="sellingPrice">
								<s:message code="deal.sellingPrice" />
							</form:label>
						</p>
					</div>
					<div class="grid_2 omega">
						<p>
							<form:input path="sellingPrice" size="6" />
						</p>
					</div>
					<div class="clear"></div>
					<div class="grid_2 alpha">
						<p class="alignRight">
							<form:label path="trade">
								<s:message code="deal.trade" />
							</form:label>
						</p>
					</div>
					<div class="grid_2 omega">
						<p>
							<form:input path="trade" size="6" />
						</p>
					</div>
					<div class="clear"></div>
					<div class="grid_2 alpha">
						<p class="alignRight">
							<form:label path="payoff">
								<s:message code="deal.payoff" />
							</form:label>
						</p>
					</div>
					<div class="grid_2 omega">
						<p>
							<form:input path="payoff" size="6" />
						</p>
					</div>
					<div class="clear"></div>
					<div class="grid_2 alpha">
						<p class="alignRight">
							<form:label path="customerCash">
								<s:message code="deal.customerCash" />
							</form:label>
						</p>
					</div>
					<div class="grid_2 omega">
						<p>
							<form:input path="customerCash" size="6" />
						</p>
					</div>
					<div class="clear"></div>
					<div class="grid_2 alpha">
						<p class="alignRight">
							<form:label path="rebate">
								<s:message code="deal.rebate" />
							</form:label>
						</p>
					</div>
					<div class="grid_2 omega">
						<p>
							<form:input path="rebate" size="6" />
						</p>
					</div>
					<div class="clear"></div>
					<div class="grid_2 alpha">
						<p class="alignRight">
							<form:label path="fees">
								<s:message code="deal.fees" />
							</form:label>
						</p>
					</div>
					<div class="grid_2 omega">
						<p>
							<form:input path="fees" size="6" />
						</p>
					</div>
					<div class="clear"></div>
					<div class="grid_2 alpha">
						<p class="alignRight">
							<form:label path="tax">
								<s:message code="deal.tax" />
							</form:label>
						</p>
					</div>
					<div class="grid_2 omega">
						<p>
							<form:select path="tax">
								<c:forEach var="tax" varStatus="status" items="${taxes}">
									<option value="${tax.id}"
										<c:if test="${deal.tax.id eq tax.id}"> selected="selected"</c:if>>${tax.profileName}
									</option>
								</c:forEach>
							</form:select>
							<c:forEach var="tax" items="${taxes}">
								<input type="hidden" class="taxRate" value="${tax.rate}" />
							</c:forEach>
						</p>
					</div>
					<div class="clear"></div>
				</div>
				<div class="grid_4">
					<div class="grid_2 alpha">
						<p class="alignRight">Deal Template</p>
					</div>
					<div class="grid_2 omega">
						<p>${deal.dealTemplate.templateName}</p>
					</div>
					<div class="clear"></div>
					<div class="grid_2 alpha">
						<p class="alignRight">Print</p>
					</div>
					<div class="grid_2 omega">
						<c:url var="reportUrl" value="/dealer/deals/report">
							<c:param name="pk">${deal.id}</c:param>
						</c:url>
						<p>
							<a href="${reportUrl}">Print</a>
						</p>
					</div>
					<div class="clear"></div>
					<div class="grid_2 alpha">
						<p class="alignRight">Menu Payment</p>
					</div>
					<div class="grid_2 omega">
						<p>
							<input type="text" id="menu_payment" size="6" disabled="disabled" />
						</p>
					</div>
					<div class="clear"></div>
					<div class="grid_2 alpha">
						<p class="alignRight">Unpaid Balance</p>
					</div>
					<div class="grid_2 omega">
						<p>
							<input type="text" id="unpaid_balance" size="6"
								disabled="disabled" />
						</p>
					</div>
					<div class="clear"></div>
					<div class="grid_2 alpha">
						<p class="alignRight">Taxes</p>
					</div>
					<div class="grid_2 omega">
						<p>
							<input type="text" id="taxes" size="6" disabled="disabled" />
						</p>
					</div>
					<div class="clear"></div>
					<div class="grid_2 alpha">
						<p class="alignRight">
							<form:label path="baseAmtFinanced">
								<s:message code="deal.baseAmtFinanced" />
							</form:label>
						</p>
					</div>
					<div class="grid_2 omega">
						<p>
							<form:input path="baseAmtFinanced" size="6" disabled="disabled" />
						</p>
					</div>
					<div class="clear"></div>
				</div>
				<div class="grid_4 omega">
					<div class="grid_2 alpha">
						<p class="alignRight">
							<form:label path="packageType">
								<s:message code="deal.packageType" />
							</form:label>
						</p>
					</div>
					<div class="grid_2 omega">
						<p>
							<form:select id="id_packageType" path="packageType">
								<c:forEach var="type" items="${packageTypes}">
									<option value="${type}"
										<c:if test="${deal.packageType eq type}"> selected="selected"</c:if>><tags:ucfirst
											value="${type}" /></option>
								</c:forEach>
							</form:select>
						</p>
					</div>
					<div class="clear"></div>
					<div class="grid_2 alpha">
						<p>
							<strong>Product</strong>
						</p>
					</div>
					<div class="grid_1">
						<p>
							<strong>Price</strong>
						</p>
					</div>
					<div class="grid_1 omega">
						<p class="alignCenter">
							<strong>Select</strong>
						</p>
					</div>
					<div class="clear"></div>
					<div id="dealProducts" class="grid_4 alpha omega">
						<c:forEach var="product" items="${products}">
							<div class="grid_2 alpha">
								<p>${product.productName}</p>
							</div>
							<div class="grid_1">
								<p>
									<form:input path="productValuesKeyedById[${product.id}]"
										size="6" />
								</p>
							</div>
							<div class="grid_1 omega">
								<p class="alignCenter">
									<form:checkbox path="selectedProducts[${product.id}]" />
								</p>
							</div>
							<div class="clear"></div>
						</c:forEach>
					</div>
					<div class="clear"></div>
					<div class="grid_2 alpha">
						<p class="alignRight">Total of Products</p>
					</div>
					<div class="grid_2 omega">
						<p>
							<input type="text" id="totalOfProducts" size="6"
								disabled="disabled" />
						</p>
					</div>
				</div>
				<div class="clear"></div>
				<div class="grid_2 push_10 alpha omega">
					<p class="alignCenter">
						<input type="button" id="menu_calculate" value="Menu Calculate" />
					</p>
				</div>
			</div>
		</div>
		<div class="grid_12 alpha omega">
			<div class="grid_2 prefix_5 suffix_5 alpha omega">
				<div class="grid_1 alpha">
					<form:button name="isSigned" value="1">Sign</form:button>
				</div>
				<div class="grid_1 omega">
					<s:message var="saveTxt" code="button_save" />
					<input type="submit" value="${saveTxt}" />
				</div>
			</div>
		</div>
	</form:form>
</div>
<script type="text/javascript">
	$(function() {
		$("#id_packageType").change(function() {
			$.post("<c:url value="/dealer/deals/getProductList" />", {
				"dealTemplateId" : <c:out value="${deal.dealTemplate.id}" />,
				"index" : $("#id_packageType").prop("selectedIndex"),
				"deal" : <c:out value="${deal.id}" />
			}, function(data) {
				$("#dealProducts").html(data);
			});
		});

		$("#menu_calculate").click(
				function() {
					var totalOfProducts = 0.0;
					$("#dealProducts").find("input[type='checkbox']").each(
							function(index, element) {
								if ($(element).attr("checked") == "checked")
									totalOfProducts += parseFloat($(
											"#dealProducts").find(
											"input[type='text']:eq(" + index
													+ ")").val());
							});
					$("#totalOfProducts").val(totalOfProducts.toFixed(2));
					$("#apr2").val($("#apr").val());
					$("#term2").val($("#term").val());
					var taxValue = parseFloat($(
							".taxRate:eq(" + $("#tax option:selected").index()
									+ ")").val());
					var sellingPrice = parseFloat($("#sellingPrice").val());
					var trade = parseFloat($("#trade").val());
					var payoff = parseFloat($("#payoff").val());
					var customerCash = parseFloat($("#customerCash").val());
					var rebate = parseFloat($("#rebate").val());
					var fees = parseFloat($("#fees").val());
					var apr = parseFloat($("#apr").val());
					var term = parseInt($("#term").val());
					// calculate taxes
					var tax = (taxValue / 100)
							* (sellingPrice - (rebate + trade));
					tax = roundDecimals(tax, 2);
					$("#taxes").val(tax);
					// calculate unpaid balance
					var unpaidBalance = sellingPrice - customerCash - rebate
							- trade + payoff + tax;
					unpaidBalance = roundDecimals(unpaidBalance, 2);
					$("#unpaid_balance").val(unpaidBalance);
					// calculate base amount financed
					var baseAmtFinanced = unpaidBalance + fees;
					baseAmtFinanced = roundDecimals(baseAmtFinanced, 2);
					$("#baseAmtFinanced").val(baseAmtFinanced);
					// calculate monthly payment
					var presentValue = baseAmtFinanced + totalOfProducts;
					var interestRate = apr / 100;
					var monthlyPayment = calculatePayment(presentValue,
							interestRate / 12, term);
					$("#menu_payment").val(monthlyPayment);
					return false;
				});

		function calculatePayment(pv, ir, np) {
			var pmt = (pv * ir) / (1 - Math.pow(1 + ir, -np));
			return roundDecimals(pmt, 2);
		}

		function roundDecimals(originalNumber, decimals) {
			var result = originalNumber * Math.pow(10, decimals);
			result = Math.round(result);
			result /= Math.pow(10, decimals);
			return result;
		}

		$("#menu_calculate").trigger("click");
	});

	
</script>
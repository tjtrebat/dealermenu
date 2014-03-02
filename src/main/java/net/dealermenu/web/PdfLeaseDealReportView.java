package net.dealermenu.web;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dealermenu.domain.Deal;
import net.dealermenu.domain.Dealer;
import net.dealermenu.domain.PackageType;
import net.dealermenu.domain.Packages;
import net.dealermenu.domain.Product;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfLeaseDealReportView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Deal deal = (Deal) model.get("deal");
		Dealer dealer = (Dealer) model.get("dealer");
		Paragraph pDealerName = new Paragraph(dealer.getDealerName(),
				FontFactory.getFont(FontFactory.TIMES_ROMAN, 22, Font.BOLD,
						new Color(0, 0, 0)));
		pDealerName.setSpacingAfter(9f);

		document.add(pDealerName);

		PdfPTable DealDetailTable = new PdfPTable(6);
		float[] widths = { 20f, 13f, 20f, 13f, 20f, 14f };
		DealDetailTable.setWidths(widths);
		DealDetailTable.setWidthPercentage(100f);

		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_LEFT);
		DealDetailTable.addCell("MSRP");
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_RIGHT);
		DealDetailTable.addCell("$" + deal.getMsrp());
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_LEFT);
		DealDetailTable.addCell("   L.E.V(%)");
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_RIGHT);
		DealDetailTable.addCell("" + deal.getLev());
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_RIGHT);
		DealDetailTable.getDefaultCell().setColspan(2);
		DealDetailTable.addCell("Finance Options- "
				+ String.valueOf(deal.getTerm()) + " months for");

		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setColspan(1);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_LEFT);
		DealDetailTable.addCell("Selling Price");
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_RIGHT);
		DealDetailTable.addCell("$" + deal.getSellingPrice());
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_LEFT);
		DealDetailTable.addCell("   Trade Allowance");
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_RIGHT);
		DealDetailTable.addCell("$" + deal.getTrade());
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setColspan(2);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_RIGHT);
		DealDetailTable.addCell(deal.getBuyerName());

		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setColspan(1);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_LEFT);
		DealDetailTable.addCell("Cash Down");
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_RIGHT);
		DealDetailTable.addCell("$" + deal.getCustomerCash());
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_LEFT);
		DealDetailTable.addCell("   Payoff Amount");
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_RIGHT);
		DealDetailTable.addCell("$" + deal.getPayoff());
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_RIGHT);
		DealDetailTable.getDefaultCell().setColspan(2);
		DealDetailTable.addCell("");

		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setColspan(1);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_LEFT);
		DealDetailTable.addCell("Rebate");
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_RIGHT);
		DealDetailTable.addCell("$" + deal.getRebate());
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_LEFT);
		DealDetailTable.addCell("   Vehicle Type");
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_RIGHT);
		DealDetailTable.addCell(deal.getVehicleType());
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_LEFT);
		DealDetailTable.addCell("                           Mileage");
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_RIGHT);
		DealDetailTable.addCell("" + deal.getMileage());

		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_LEFT);
		DealDetailTable.addCell("");
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.addCell("");
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_LEFT);
		DealDetailTable.addCell("   Stock");
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_RIGHT);
		DealDetailTable.addCell(deal.getStock());
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_LEFT);
		DealDetailTable.addCell("                           VIN");
		DealDetailTable.getDefaultCell().setBorder(0);
		DealDetailTable.getDefaultCell().setHorizontalAlignment(
				Element.ALIGN_RIGHT);
		DealDetailTable.addCell(deal.getVin());
		DealDetailTable.setSpacingAfter(7f);
		document.add(DealDetailTable);

		Packages packages = dealer.getPackages();
		if (packages == null)
			packages = new Packages();

		PdfPTable PreferredTable = new PdfPTable(1);
		PdfPCell PreferredCell = new PdfPCell(new Paragraph(
				(packages.getPreferredPackageName() != null) ? packages
						.getPreferredPackageName() : "Preferred"));
		PreferredCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		PreferredTable.addCell(PreferredCell);
		double dPreferredTotal = 0.0;
		if (deal.getPackageType() == PackageType.PREFERRED) {
			for (Product product : deal.getProductValues().keySet()) {
				PreferredTable.getDefaultCell().setGrayFill(0.8f);
				PreferredTable.getDefaultCell().setHorizontalAlignment(
						Element.ALIGN_CENTER);
				PreferredTable.addCell(product.getProductName());
				PreferredTable.getDefaultCell().setBackgroundColor(Color.WHITE);
				Paragraph p1 = new Paragraph(product.getDescription(),
						FontFactory.getFont(FontFactory.defaultEncoding, 10,
								Font.NORMAL));
				PreferredTable.addCell(p1);
				dPreferredTotal += deal.getProductValues().get(product);
			}
		}

		PdfPTable PremiumTable = new PdfPTable(1);
		PdfPCell PremiumCell = new PdfPCell(new Paragraph(
				(packages.getPremiumPackageName() != null) ? packages
						.getPremiumPackageName() : "Premium"));
		PremiumCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		PremiumTable.addCell(PremiumCell);
		double dPremiumTotal = 0.0;
		if (deal.getPackageType() == PackageType.PREMIUM) {
			for (Product product : deal.getProductValues().keySet()) {
				PremiumTable.getDefaultCell().setGrayFill(0.8f);
				PremiumTable.getDefaultCell().setHorizontalAlignment(
						Element.ALIGN_CENTER);
				PremiumTable.addCell(product.getProductName());
				PremiumTable.getDefaultCell().setBackgroundColor(Color.WHITE);
				Paragraph p1 = new Paragraph(product.getDescription(),
						FontFactory.getFont(FontFactory.defaultEncoding, 10,
								Font.NORMAL));
				PremiumTable.addCell(p1);
				dPremiumTotal += deal.getProductValues().get(product);
			}
		}
		PdfPTable ValueTable = new PdfPTable(1);
		PdfPCell ValueCell = new PdfPCell(new Paragraph(
				(packages.getValuePackageName() != null) ? packages
						.getValuePackageName() : "Value"));
		ValueCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		ValueTable.addCell(ValueCell);
		double dValueTotal = 0.0;
		if (deal.getPackageType() == PackageType.PREMIUM) {
			for (Product product : deal.getProductValues().keySet()) {
				ValueTable.getDefaultCell().setGrayFill(0.8f);
				ValueTable.getDefaultCell().setHorizontalAlignment(
						Element.ALIGN_CENTER);
				ValueTable.addCell(product.getProductName());
				ValueTable.getDefaultCell().setBackgroundColor(Color.WHITE);
				Paragraph p1 = new Paragraph(product.getDescription(),
						FontFactory.getFont(FontFactory.defaultEncoding, 10,
								Font.NORMAL));
				ValueTable.addCell(p1);
				dValueTotal += deal.getProductValues().get(product);
			}
		}
		PdfPTable EconomyTable = new PdfPTable(1);
		PdfPCell EconomyCell = new PdfPCell(new Paragraph(
				(packages.getEconomyPackageName() != null) ? packages
						.getEconomyPackageName() : "Economy"));
		EconomyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		EconomyTable.addCell(EconomyCell);
		double dEconomyTotal = 0.0;
		if (deal.getPackageType() == PackageType.PREMIUM) {
			for (Product product : deal.getProductValues().keySet()) {
				EconomyTable.getDefaultCell().setGrayFill(0.8f);
				EconomyTable.getDefaultCell().setHorizontalAlignment(
						Element.ALIGN_CENTER);
				EconomyTable.addCell(product.getProductName());
				EconomyTable.getDefaultCell().setBackgroundColor(Color.WHITE);
				Paragraph p1 = new Paragraph(product.getDescription(),
						FontFactory.getFont(FontFactory.defaultEncoding, 10,
								Font.NORMAL));
				EconomyTable.addCell(p1);
				dEconomyTotal += deal.getProductValues().get(product);
			}
		}

		PdfPTable tablenew = new PdfPTable(4);
		tablenew.setWidthPercentage(100f);
		tablenew.getDefaultCell().setBorderColor(new Color(255, 255, 255));
		tablenew.addCell(PreferredTable);
		tablenew.addCell(PremiumTable);
		tablenew.addCell(ValueTable);
		tablenew.addCell(EconomyTable);
		tablenew.setSpacingAfter(10f);
		document.add(tablenew);

		double dMSRP = deal.getMsrp();
		double dLEV = deal.getLev();
		double dBaseAmountFinanced = deal.getBaseAmtFinanced();
		double dAPR = deal.getApr();
		int iTerm = deal.getTerm();
		double dTax = deal.getTax().getRate();

		double dLeaseEndValue = dMSRP * (dLEV / 100);

		double dPreferredLease = getLeaseValue(dBaseAmountFinanced,
				dLeaseEndValue, dAPR, dPreferredTotal, iTerm, dTax);
		double dPremiumLease = getLeaseValue(dBaseAmountFinanced,
				dLeaseEndValue, dAPR, dPremiumTotal, iTerm, dTax);
		double dValueLease = getLeaseValue(dBaseAmountFinanced, dLeaseEndValue,
				dAPR, dValueTotal, iTerm, dTax);
		double dEconomyLease = getLeaseValue(dBaseAmountFinanced,
				dLeaseEndValue, dAPR, dEconomyTotal, iTerm, dTax);

		double dAPR2 = deal.getApr1();
		int iTerm2 = deal.getTerm1();

		double dPreferredLease2 = getLeaseValue(dBaseAmountFinanced,
				dLeaseEndValue, dAPR2, dPreferredTotal, iTerm2, dTax);
		double dPremiumLease2 = getLeaseValue(dBaseAmountFinanced,
				dLeaseEndValue, dAPR2, dPremiumTotal, iTerm2, dTax);
		double dValueLease2 = getLeaseValue(dBaseAmountFinanced,
				dLeaseEndValue, dAPR2, dValueTotal, iTerm2, dTax);
		double dEconomyLease2 = getLeaseValue(dBaseAmountFinanced,
				dLeaseEndValue, dAPR2, dEconomyTotal, iTerm2, dTax);

		if ((!String.valueOf(dPreferredLease).equalsIgnoreCase("Infinity"))
				|| (!String.valueOf(dPremiumLease).equalsIgnoreCase("Infinity"))
				|| (!String.valueOf(dValueLease).equalsIgnoreCase("Infinity"))
				|| (!String.valueOf(dEconomyLease).equalsIgnoreCase("Infinity"))) {
			PdfPTable tableLease = new PdfPTable(4);
			tableLease.setWidthPercentage(100f);
			tableLease.getDefaultCell()
					.setBorderColor(new Color(255, 255, 255));
			tableLease.getDefaultCell().setHorizontalAlignment(
					Element.ALIGN_CENTER);
			tableLease.addCell(String.valueOf(iTerm) + " months X $"
					+ String.valueOf(dPreferredLease) + " @ "
					+ String.valueOf(dAPR) + "%____");
			tableLease.addCell(String.valueOf(iTerm) + " months X $"
					+ String.valueOf(dPremiumLease) + " @ "
					+ String.valueOf(dAPR) + "%____");
			tableLease.addCell(String.valueOf(iTerm) + " months X $"
					+ String.valueOf(dValueLease) + " @ "
					+ String.valueOf(dAPR) + "%____");
			tableLease.addCell(String.valueOf(iTerm) + " months X $"
					+ String.valueOf(dEconomyLease) + " @ "
					+ String.valueOf(dAPR) + "%____");
			tableLease.setSpacingAfter(10f);
			document.add(tableLease);
		}

		if ((!String.valueOf(dPreferredLease2).equalsIgnoreCase("Infinity"))
				|| (!String.valueOf(dPremiumLease2)
						.equalsIgnoreCase("Infinity"))
				|| (!String.valueOf(dValueLease2).equalsIgnoreCase("Infinity"))
				|| (!String.valueOf(dEconomyLease2)
						.equalsIgnoreCase("Infinity"))) {
			PdfPTable tableLease2 = new PdfPTable(4);
			tableLease2.setWidthPercentage(100f);
			tableLease2.getDefaultCell().setBorderColor(
					new Color(255, 255, 255));
			tableLease2.getDefaultCell().setHorizontalAlignment(
					Element.ALIGN_CENTER);
			tableLease2.addCell(String.valueOf(iTerm2) + " months X $"
					+ String.valueOf(dPreferredLease2) + " @ "
					+ String.valueOf(dAPR2) + "%____");
			tableLease2.addCell(String.valueOf(iTerm2) + " months X $"
					+ String.valueOf(dPremiumLease2) + " @ "
					+ String.valueOf(dAPR2) + "%____");
			tableLease2.addCell(String.valueOf(iTerm2) + " months X $"
					+ String.valueOf(dValueLease2) + " @ "
					+ String.valueOf(dAPR2) + "%____");
			tableLease2.addCell(String.valueOf(iTerm2) + " months X $"
					+ String.valueOf(dEconomyLease2) + " @ "
					+ String.valueOf(dAPR2) + "%____");
			tableLease2.setSpacingAfter(10f);
			document.add(tableLease2);
		}

		String sDisclosure = "This is not a contract, nor an offer to purchase. Payments are based on an A.P.R. of "
				+ String.valueOf(dAPR)
				+ " %, for a term of "
				+ String.valueOf(iTerm)
				+ " months. All products are optional. You do not have to purchase any of these products to secure financing. Finance charges, total of payments, total of payments including down payment, and amount financed will be clearly disclosed on your actual contract. The dealer makes no warranties, whether expressed or implied. All payments are estimates. You must qualify to secure financing, as these payments may vary depending on credit. By initialing a payment you acknowledge that all products were offered and explained to you.";
		Paragraph pDisclosure = new Paragraph(sDisclosure, FontFactory.getFont(
				FontFactory.TIMES_ROMAN, 8, Font.NORMAL, new Color(0, 0, 0)));
		pDisclosure.setSpacingAfter(11f);
		document.add(pDisclosure);

		PdfPTable tableFooter = new PdfPTable(3);
		tableFooter.setWidthPercentage(100f);
		float[] width = { 20f, 50f, 30f };
		tableFooter.setWidths(width);
		tableFooter.getDefaultCell().setBorderColor(new Color(255, 255, 255));
		tableFooter.addCell("Customer Signature");
		tableFooter.addCell("______________________________________");
		tableFooter.getDefaultCell()
				.setHorizontalAlignment(Element.ALIGN_RIGHT);
		tableFooter.addCell(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
				.format(new Date()));
		tableFooter.addCell("");
		tableFooter.getDefaultCell().setColspan(2);
		tableFooter
				.addCell("Frederick M. Small Insurance Services 2008. All Rights Reserved");
		document.add(tableFooter);
	}

	public double getLeaseValue(double dBaseAmountFinanced,
			double dLeaseEndValue, double dAPR, Double dTotalOfProducts,
			int iTerm, double dTax) {
		double dLeaseValue = 0.0;
		double dMoneyFactor = dAPR / 2400;
		double dAverageMonthlyDepreciation = (dBaseAmountFinanced
				+ dTotalOfProducts - dLeaseEndValue)
				/ iTerm;
		double dMonthlyMoneyFee = (dBaseAmountFinanced + dTotalOfProducts + dLeaseEndValue)
				* dMoneyFactor;
		double dBaseMonthlyPayment = dAverageMonthlyDepreciation
				+ dMonthlyMoneyFee;
		dLeaseValue = dBaseMonthlyPayment * (1 + (dTax / 100));
		try {
			DecimalFormat df = new DecimalFormat("#.##");
			dLeaseValue = Double.parseDouble(df.format(dLeaseValue));
			return dLeaseValue;
		} catch (Exception e) {
			return dLeaseValue;
		}
	}

}

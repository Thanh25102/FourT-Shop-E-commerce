package com.buimanhthanh.exporter;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.buimanhthanh.dto.OrderDTO;
import com.buimanhthanh.dto.RevenueDTO;

public class RevenueExporter implements IExporter<RevenueDTO> {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	private List<RevenueDTO> revenues;
	private List<OrderDTO> orders;

	public RevenueExporter(List<RevenueDTO> revenues, List<OrderDTO> orders) {
		this.orders = orders;
		this.revenues = revenues;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Revenues");
	}

	public void writeHeaderRow() {
		Row row0 = sheet.createRow(0);
		Row row1 = sheet.createRow(1);

		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 13));
		for (int i = 0; i <= 13; i++) {
			Cell cellz1 = row0.createCell(i);
			Cell cellz2 = row1.createCell(i);

			CellUtil.setCellStyleProperty(cellz1, CellUtil.BORDER_LEFT, BorderStyle.THIN);
			CellUtil.setCellStyleProperty(cellz1, CellUtil.BORDER_RIGHT, BorderStyle.THIN);
			CellUtil.setCellStyleProperty(cellz1, CellUtil.BORDER_TOP, BorderStyle.THIN);
			CellUtil.setCellStyleProperty(cellz1, CellUtil.BORDER_BOTTOM, BorderStyle.THIN);

			CellUtil.setCellStyleProperty(cellz2, CellUtil.BORDER_LEFT, BorderStyle.THIN);
			CellUtil.setCellStyleProperty(cellz2, CellUtil.BORDER_RIGHT, BorderStyle.THIN);
			CellUtil.setCellStyleProperty(cellz2, CellUtil.BORDER_TOP, BorderStyle.THIN);
			CellUtil.setCellStyleProperty(cellz2, CellUtil.BORDER_BOTTOM, BorderStyle.THIN);
		}

		Cell cell = row0.createCell(0);
		cell.setCellValue("Revenue & Bill");
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		CellUtil.setCellStyleProperty(cell, CellUtil.BORDER_LEFT, BorderStyle.THIN);
		CellUtil.setCellStyleProperty(cell, CellUtil.BORDER_RIGHT, BorderStyle.THIN);
		CellUtil.setCellStyleProperty(cell, CellUtil.BORDER_TOP, BorderStyle.THIN);
		CellUtil.setCellStyleProperty(cell, CellUtil.BORDER_BOTTOM, BorderStyle.THIN);
		cell.setCellStyle(cellStyle);
	}

	public void writeDataRows() {
		writeDataBill();
		writeDataRevenue();
	}

	public void writeDataBill() {
		int rowNum = 3;
		// write header for Bill
		Row row = sheet.createRow(rowNum);
		Cell cell1 = row.createCell(2);
		cell1.setCellValue("ID");
		Cell cell2 = row.createCell(3);
		cell2.setCellValue("Username");
		Cell cell3 = row.createCell(4);
		cell3.setCellValue("Status");
		Cell cell4 = row.createCell(5);
		cell4.setCellValue("Ammount");
		Cell cell5 = row.createCell(6);
		cell5.setCellValue("Payment Method");
		Cell cell6 = row.createCell(7);
		cell6.setCellValue("Create Time");
		Cell cell7 = row.createCell(8);
		cell7.setCellValue("Phone");
		Cell cell8 = row.createCell(9);
		cell8.setCellValue("Shipping Address");
		Cell cell9 = row.createCell(10);
		cell9.setCellValue("City");
		Cell cell10 = row.createCell(11);
		cell10.setCellValue("Discount Code");
		rowNum++;

		// write data bill
		for (OrderDTO order : orders) {
			Row rowData = sheet.createRow(rowNum);
			Cell cellData1 = rowData.createCell(2);
			cellData1.setCellValue(order.getId());
			Cell cellData2 = rowData.createCell(3);
			cellData2.setCellValue(order.getUsername());
			Cell cellData3 = rowData.createCell(4);
			cellData3.setCellValue(order.getOrderStatus());
			Cell cellData4 = rowData.createCell(5);
			cellData4.setCellValue(order.getAmmount());
			Cell cellData5 = rowData.createCell(6);
			cellData5.setCellValue(order.getPaymentMethod());
			Cell cellData6 = rowData.createCell(7);
			cellData6.setCellValue(order.getCreateTime());
			Cell cellData7 = rowData.createCell(8);
			cellData7.setCellValue(order.getPhone());
			Cell cellData8 = rowData.createCell(9);
			cellData8.setCellValue(order.getShipingAddress());
			Cell cellData9 = rowData.createCell(10);
			cellData9.setCellValue(order.getCity());
			Cell cellData10 = rowData.createCell(11);
			cellData10.setCellValue(order.getDiscountCode());
			rowNum++;
		}
	}

	public void writeDataRevenue() {
		int rowNum = 5 + orders.size();
		// write header
		Row row1 = sheet.createRow(rowNum);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("Month");

		Row row2 = sheet.createRow(rowNum + 1);
		Cell cell2 = row2.createCell(0);
		cell2.setCellValue("Revenue");

		Double sumMoney = 0D;
		// write data
		for (int i = 1; i <= 12; i++) {
			Cell cellMonth = row1.createCell(i);
			cellMonth.setCellValue(i);
			Cell cellRevenue = row2.createCell(i);
			cellRevenue.setCellValue("0");
			for (RevenueDTO revenue : revenues) {
				if (revenue.getMonth() == i) {
					cellRevenue.setCellValue(revenue.getRevenue());
					sumMoney += revenue.getRevenue();
				}
			}
		}

		Cell cellSumMoneyKey = row1.createCell(13);
		cellSumMoneyKey.setCellValue("Sum Money");

		Cell cellSumMoneyValue = row2.createCell(13);
		cellSumMoneyValue.setCellValue(sumMoney);

	}

	public void alginRows() {
		for (int i = 3; i <= (3 + orders.size()); i++) {
			Row rowTemp = sheet.getRow(i);
			for (int j = 2; j < 12; j++) {
				CellUtil.setCellStyleProperty(rowTemp.getCell(j), CellUtil.BORDER_LEFT, BorderStyle.THIN);
				CellUtil.setCellStyleProperty(rowTemp.getCell(j), CellUtil.BORDER_RIGHT, BorderStyle.THIN);
				CellUtil.setCellStyleProperty(rowTemp.getCell(j), CellUtil.BORDER_TOP, BorderStyle.THIN);
				CellUtil.setCellStyleProperty(rowTemp.getCell(j), CellUtil.BORDER_BOTTOM, BorderStyle.THIN);
				CellUtil.setAlignment(rowTemp.getCell(j), HorizontalAlignment.CENTER);

			}
		}

		for (int i = 0; i < 14; i++) {
			sheet.setColumnWidth(i, 3500);
		}

		int rownum = 5 + orders.size();
		for (int i = rownum; i <= rownum + 1; i++) {
			Row rowTemp = sheet.getRow(i);
			for (int j = 0; j < 14; j++) {
				CellUtil.setCellStyleProperty(rowTemp.getCell(j), CellUtil.BORDER_LEFT, BorderStyle.THIN);
				CellUtil.setCellStyleProperty(rowTemp.getCell(j), CellUtil.BORDER_RIGHT, BorderStyle.THIN);
				CellUtil.setCellStyleProperty(rowTemp.getCell(j), CellUtil.BORDER_TOP, BorderStyle.THIN);
				CellUtil.setCellStyleProperty(rowTemp.getCell(j), CellUtil.BORDER_BOTTOM, BorderStyle.THIN);
				CellUtil.setAlignment(rowTemp.getCell(j), HorizontalAlignment.CENTER);

			}
		}
	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderRow();
		writeDataRows();
		alginRows();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}
}

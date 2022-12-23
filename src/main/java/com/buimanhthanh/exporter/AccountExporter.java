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

import com.buimanhthanh.dto.AccountDTO;

public class AccountExporter implements IExporter<AccountDTO> {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	private List<AccountDTO> accounts;

	public AccountExporter(List<AccountDTO> accounts) {
		this.accounts = accounts;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Accounts");
	}

	public void writeHeaderRow() {
		Row row0 = sheet.createRow(0);
		Row row1 = sheet.createRow(1);

		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 9));
		for (int i = 0; i <= 9; i++) {
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
		cell.setCellValue("Account");
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
	}

	public void writeDataBill() {
		int rowNum = 2;
		// write header for Bill
		Row row = sheet.createRow(rowNum);
		Cell cell1 = row.createCell(0);
		cell1.setCellValue("Username");
		sheet.setColumnWidth(0, 5000);
		Cell cell2 = row.createCell(1);
		cell2.setCellValue("Password");
		sheet.setColumnWidth(1, 8000);
		Cell cell3 = row.createCell(2);
		cell3.setCellValue("Enabled");
		sheet.setColumnWidth(2, 2000);
		Cell cell4 = row.createCell(3);
		cell4.setCellValue("Email");
		sheet.setColumnWidth(3, 7000);
		Cell cell5 = row.createCell(4);
		cell5.setCellValue("Phone");
		sheet.setColumnWidth(4, 3000);
		Cell cell6 = row.createCell(5);
		cell6.setCellValue("Full Name");
		sheet.setColumnWidth(5, 5500);
		Cell cell7 = row.createCell(6);
		cell7.setCellValue("Address");
		sheet.setColumnWidth(6, 5000);
		Cell cell8 = row.createCell(7);
		cell8.setCellValue("Rank Account");
		sheet.setColumnWidth(7, 4000);
		Cell cell9 = row.createCell(8);
		cell9.setCellValue("Avatar");
		sheet.setColumnWidth(8, 6000);
		Cell cell10 = row.createCell(9);
		cell10.setCellValue("Role Id");
		sheet.setColumnWidth(9, 2000);
		
		rowNum++;

		// write data bill
		for (AccountDTO account : accounts) {
			Row rowData = sheet.createRow(rowNum);
			Cell cellData1 = rowData.createCell(0);
			cellData1.setCellValue(account.getUsername());
			Cell cellData2 = rowData.createCell(1);
			cellData2.setCellValue(account.getPassword());
			Cell cellData3 = rowData.createCell(2);
			cellData3.setCellValue(account.getEnabled());
			Cell cellData4 = rowData.createCell(3);
			cellData4.setCellValue(account.getEmail());
			Cell cellData5 = rowData.createCell(4);
			cellData5.setCellValue(account.getPhone());
			Cell cellData6 = rowData.createCell(5);
			cellData6.setCellValue(account.getFullName());
			Cell cellData7 = rowData.createCell(6);
			cellData7.setCellValue(account.getAddress());
			Cell cellData8 = rowData.createCell(7);
			cellData8.setCellValue(account.getRankAccount());
			Cell cellData9 = rowData.createCell(8);
			cellData9.setCellValue(account.getAvatar());
			Cell cellData10 = rowData.createCell(9);
			cellData10.setCellValue(account.getRoleId());
			rowNum++;
		}
	}

	public void alginRows() {
		for (int i = 2; i <= (2 + accounts.size()); i++) {
			Row rowTemp = sheet.getRow(i);
			for (int j = 0; j < 10; j++) {
				CellUtil.setCellStyleProperty(rowTemp.getCell(j), CellUtil.BORDER_LEFT, BorderStyle.THIN);
				CellUtil.setCellStyleProperty(rowTemp.getCell(j), CellUtil.BORDER_RIGHT, BorderStyle.THIN);
				CellUtil.setCellStyleProperty(rowTemp.getCell(j), CellUtil.BORDER_TOP, BorderStyle.THIN);
				CellUtil.setCellStyleProperty(rowTemp.getCell(j), CellUtil.BORDER_BOTTOM, BorderStyle.THIN);
				CellUtil.setAlignment(rowTemp.getCell(j), HorizontalAlignment.CENTER);
			}
		}

//		for (int i = 0; i < 10; i++) {
//			sheet.setColumnWidth(i, 4500);
//		}
	}

	@Override
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

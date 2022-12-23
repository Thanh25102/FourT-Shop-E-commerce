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
import com.buimanhthanh.dto.ProductDTO;

public class ProductExporter implements IExporter<AccountDTO> {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	private List<ProductDTO> products;

	public ProductExporter(List<ProductDTO> products) {
		this.products = products;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Products");
	}

	public void writeHeaderRow() {
		Row row0 = sheet.createRow(0);
		Row row1 = sheet.createRow(1);

		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 7));
		for (int i = 0; i <= 7; i++) {
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
		cell.setCellValue("PRODUCT");
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
		cell1.setCellValue("Id");
		sheet.setColumnWidth(0, 1000);
		Cell cell2 = row.createCell(1);
		cell2.setCellValue("Name");
		sheet.setColumnWidth(1, 8000);
		Cell cell3 = row.createCell(2);
		cell3.setCellValue("Price");
		sheet.setColumnWidth(2, 3000);
		Cell cell4 = row.createCell(3);
		cell4.setCellValue("Category Id");
		sheet.setColumnWidth(3, 3000);
		Cell cell5 = row.createCell(4);
		cell5.setCellValue("Description");
		sheet.setColumnWidth(4, 10000);
		Cell cell6 = row.createCell(5);
		cell6.setCellValue("Thumbnail");
		sheet.setColumnWidth(5, 5500);
		Cell cell7 = row.createCell(6);
		cell7.setCellValue("Represent");
		sheet.setColumnWidth(6, 12000);
		Cell cell8 = row.createCell(7);
		cell8.setCellValue("Discount Id");
		sheet.setColumnWidth(7, 3000);

		rowNum++;

		// write data bill
		for (ProductDTO product : products) {
			Row rowData = sheet.createRow(rowNum);
			Cell cellData1 = rowData.createCell(0);
			cellData1.setCellValue(product.getId());
			Cell cellData2 = rowData.createCell(1);
			cellData2.setCellValue(product.getName());
			Cell cellData3 = rowData.createCell(2);
			cellData3.setCellValue(product.getPrice());
			Cell cellData4 = rowData.createCell(3);
			cellData4.setCellValue(product.getCategoryId());
			Cell cellData5 = rowData.createCell(4);
			cellData5.setCellValue(product.getDescription());
			Cell cellData6 = rowData.createCell(5);
			cellData6.setCellValue(product.getThumbnail());
			Cell cellData7 = rowData.createCell(6);
			cellData7.setCellValue(product.getRepresent());
			Cell cellData8 = rowData.createCell(7);
			cellData8.setCellValue(product.getDiscountId() != null ? product.getDiscountId().toString() : "");
			rowNum++;
		}
	}

	public void alginRows() {
		for (int i = 2; i <= (2 + products.size()); i++) {
			Row rowTemp = sheet.getRow(i);
			for (int j = 0; j < 8; j++) {
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

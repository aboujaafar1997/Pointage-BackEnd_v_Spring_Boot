package com.pnp.api.PermisDeConfiance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.text.Position;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pnp.api.Chauffeur.Chauffeur;
import com.pnp.api.Chauffeur.ChauffeurDAOImp;

public class Imprission {
public Imprission(String id,int permis) throws DocumentException, MalformedURLException, IOException {
	Chauffeur chauffeur= new ChauffeurDAOImp().getChauffeurid(id);	
	System.err.println("******"+chauffeur.getCin());
	String v = "C:\\Users\\abouj\\Documents\\workspace2\\pnp\\target\\classes\\pdf\\"+id+".pdf";
	Document document = new Document();
	PdfWriter.getInstance(document, new FileOutputStream(new File(v)));
	BaseFont TahomaBase = BaseFont.createFont("c:/windows/fonts/tahoma.ttf", BaseFont.IDENTITY_H, true);
	Font TahomaFont = new Font(TahomaBase, 8);
	BaseFont ArialBase = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.IDENTITY_H, true); 
	Font ArialFont = new Font(ArialBase, 16);
	document.open();
	Image watermark_image = Image.getInstance(chauffeur.getImage().toString());
	watermark_image.scaleToFit(0, 0);
	watermark_image.scaleAbsolute(90, 100);
	PdfWriter.getInstance(document, new FileOutputStream(v));
	Rectangle one = new Rectangle(400, 200);
	document.setPageSize(one);
	document.setMargins(0,5,5,5);
	document.open();
	PdfPTable table = new PdfPTable(2);
table.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
	PdfPCell cell = new PdfPCell();
	PdfPCell cell1 = new PdfPCell();

	PdfPCell cell2 = new PdfPCell();
	PdfPCell cell3 = new PdfPCell();
	Paragraph p0 = new Paragraph("رخصة الثقة", ArialFont);
	p0.setAlignment(Paragraph.ALIGN_CENTER);;
	cell2.addElement(p0);
	cell3.addElement(watermark_image);
	//cell3.setFixedHeight(80);
	cell3.setBorder(Rectangle.NO_BORDER);
	cell2.setBorder(Rectangle.NO_BORDER);
	cell1.setBorder(Rectangle.NO_BORDER);
	PdfPCell cell0 = new PdfPCell();
	cell0.setBorder(Rectangle.NO_BORDER);
    Paragraph p10 = new Paragraph("الاسم", TahomaFont);
    Paragraph p20 = new Paragraph("النسب ", TahomaFont);
    Paragraph p30 = new Paragraph("حامل البطاقة الوطنية رقم ", TahomaFont);
    Paragraph p40 = new Paragraph("رقم  رخصة السياقة ", TahomaFont);
    Paragraph p50 = new Paragraph("رقم  رخصة الثقة "  , TahomaFont);
   // p.setAlignment(PdfPCell.ALIGN_LEFT); 

Paragraph p11 = new Paragraph(":" + chauffeur.getNom(), TahomaFont);
Paragraph p22 = new Paragraph(":"+ chauffeur.getPrenom(), TahomaFont);
Paragraph p33 = new Paragraph(":"+ chauffeur.getCin(), TahomaFont);
Paragraph p44 = new Paragraph(":"+ chauffeur.getPermisconduit(), TahomaFont);
Paragraph p55 = new Paragraph(":" + permis, TahomaFont);
    table.setWidthPercentage(100);

    cell0.addElement(p10);
    cell0.addElement(p20);
    cell0.addElement(p30);
    cell0.addElement(p40);
    cell0.addElement(p50);
    cell1.addElement(p11);
    cell1.addElement(p22);
    cell1.addElement(p33);
    cell1.addElement(p44);
    cell1.addElement(p55);
    cell1.setPaddingRight(20);
    cell.setPaddingRight(20);
    table.addCell(cell2);
    table.addCell(cell3);
    table.addCell(cell0);
    table.addCell(cell1);
    document.add(table); 
	document.close();


}
}

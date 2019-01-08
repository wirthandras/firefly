package hu.wirthandras.firefly.service.pdf;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

@Service
public class ServicePDFGenerator {
	
	public static void main(String[] args) throws IOException {
		generatePDF();
	}

	public static void generatePDF() throws IOException {
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		contentStream.beginText();
		contentStream.setFont(PDType1Font.TIMES_ROMAN, 20);
		contentStream.newLineAtOffset(25, 700);
		contentStream.showText("aaa");
		contentStream.endText();
		contentStream.close();
		document.save("lala.pdf");
		document.close();
	}
}

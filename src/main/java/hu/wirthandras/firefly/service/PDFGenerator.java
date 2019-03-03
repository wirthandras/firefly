package hu.wirthandras.firefly.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import hu.wirthandras.firefly.controller.Input;

@Service
public class PDFGenerator implements IGeneratorService {

	private static final String EXTENSION = ".pdf";

	private static final String PREFIX = "contract_";

	private static final int LINE_OFFSET = -30;

	private Input input;

	@Override
	public File generate() throws IOException {

		Path path = Files.createTempFile(PREFIX, EXTENSION);

		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		contentStream.beginText();
		contentStream.setFont(PDType1Font.TIMES_ROMAN, 20);

		drawTexts(contentStream);

		contentStream.endText();
		contentStream.close();
		document.save(path.toFile());
		document.close();
		return path.toFile();
	}

	private void drawTexts(PDPageContentStream contentStream) throws IOException {
		contentStream.newLineAtOffset(25, 700);
		contentStream.showText(input.getAuthorizingPersonName());

		contentStream.newLineAtOffset(0, LINE_OFFSET);
		contentStream.showText(input.getProxyPersonName());

		contentStream.newLineAtOffset(0, LINE_OFFSET);
		contentStream.showText(input.getValid());

		contentStream.newLineAtOffset(0, LINE_OFFSET);
		contentStream.showText(input.getApplicable());

		contentStream.newLineAtOffset(0, LINE_OFFSET);
		contentStream.showText(input.getCondition());

		contentStream.newLineAtOffset(0, LINE_OFFSET);
		contentStream.showText(input.getWitness1Name());

		contentStream.newLineAtOffset(0, LINE_OFFSET);
		contentStream.showText(input.getWitness1Address());

		contentStream.newLineAtOffset(0, LINE_OFFSET);
		contentStream.showText(input.getWitness2Name());

		contentStream.newLineAtOffset(0, LINE_OFFSET);
		contentStream.showText(input.getWitness2Address());
	}

	@Override
	public void addData(Input input) {
		this.input = input;
	}

}

package hu.wirthandras.firefly.domain.authorization;

import java.awt.Color;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import hu.wirthandras.firefly.domain.person.Client;
import hu.wirthandras.firefly.domain.person.Person;
import hu.wirthandras.firefly.domain.person.Witness;

public abstract class Authorization {

	protected final Color colorBlack = Color.BLACK;
	protected final PDFont font = PDType1Font.HELVETICA_BOLD;
	protected final int fontSize = 12;
	protected final PDRectangle pdRectangle = PDRectangle.A4;

	protected Client meghatalmazo;
	protected Client meghatalmazott;
	protected Witness witness1;
	protected Witness witness2;

	protected PDDocument document;

	protected PDPage page;

	protected String title;

	public Authorization(Client meghatalmazo, Client meghatalmazott, Witness witness1, Witness witness2) {
		super();
		this.meghatalmazo = meghatalmazo;
		this.meghatalmazott = meghatalmazott;
		this.witness1 = witness1;
		this.witness2 = witness2;
	}

	public void draw() throws IOException {
		drawTitle();
		drawPerson1();
		drawPerson2();
		drawWitness1();
		drawWitness2();
	}

	public void make(String path) throws IOException {
		document = new PDDocument();
		page = new PDPage(pdRectangle);
		document.addPage(page);
		draw();
		document.save(path);
		document.close();
	}

	protected void drawPerson(Person person, int x, int y) throws IOException {
		PDPageContentStream content = new PDPageContentStream(document, page, AppendMode.APPEND, true);
		content.setNonStrokingColor(colorBlack);
		content.setLeading(10);
		content.beginText();
		content.setFont(font, fontSize);
		person.draw(content, x, y);
		content.endText();
		content.close();
	}

	protected void drawTitle() throws IOException {
		PDPageContentStream content = new PDPageContentStream(document, page, AppendMode.APPEND, true);
		content.setNonStrokingColor(colorBlack);
		content.setLeading(10);
		content.beginText();
		content.setFont(font, fontSize);
		content.newLineAtOffset(300, 800);
		content.showText(title);
		content.endText();
		content.close();
	}

	protected void drawWitness2() throws IOException {
		drawPerson(witness2, 300, 0 + fontSize);
	}

	protected void drawWitness1() throws IOException {
		drawPerson(witness1, 0, 0 + fontSize);
	}

	protected void drawPerson1() throws IOException {
		drawPerson(meghatalmazo, 0, 600 + fontSize);
	}

	protected void drawPerson2() throws IOException {
		drawPerson(meghatalmazo, 300, 600 + fontSize);
	}

}

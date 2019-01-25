package hu.wirthandras.firefly.domain.person;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

public interface Person {

	public void draw(PDPageContentStream content, int posX, int posY) throws IOException;

}

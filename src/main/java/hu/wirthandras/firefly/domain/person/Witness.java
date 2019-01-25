package hu.wirthandras.firefly.domain.person;

import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

@Entity
public class Witness implements Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;

	public Witness() {

	}

	public Witness(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public void draw(PDPageContentStream content, int posX, int posY) throws IOException {
		content.newLineAtOffset(posX, posY);
		content.showText(getName());
		content.newLine();
		content.showText(getAddress());
	}

}

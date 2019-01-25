package hu.wirthandras.firefly.domain.person;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

@Entity
public class Client implements Person {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	private String birthName;
	private String actualName;
	private String bornPlace;
	private LocalDate bornDate;
	private String motherName;
	private String address;

	public Client() {

	}

	public Client(String birthName, String actualName, String bornPlace, LocalDate bornDate, String motherName,
			String address) {
		super();
		this.birthName = birthName;
		this.actualName = actualName;
		this.bornPlace = bornPlace;
		this.bornDate = bornDate;
		this.motherName = motherName;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBirthName() {
		return birthName;
	}

	public void setBirthName(String birthName) {
		this.birthName = birthName;
	}

	public String getActualName() {
		return actualName;
	}

	public void setActualName(String actualName) {
		this.actualName = actualName;
	}

	public String getBornPlace() {
		return bornPlace;
	}

	public void setBornPlace(String bornPlace) {
		this.bornPlace = bornPlace;
	}

	public LocalDate getBornDate() {
		return bornDate;
	}

	public void setBornDate(LocalDate bornDate) {
		this.bornDate = bornDate;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
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
		content.showText("Név: " + getActualName());
		content.newLine();
		content.showText("Születési név: " + getBirthName());
		content.newLine();
		content.showText("Cím: " + getAddress());
		content.newLine();
		content.showText("Született: " + getBornDate() + ", " + getBornPlace());
		content.newLine();
		content.showText("Anyja neve: " + getMotherName());
	}

}

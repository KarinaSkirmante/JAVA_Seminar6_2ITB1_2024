package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//personas tabula ir tukša, visi dati Studentā vai Profesorā
//@Inheritance(strategy = InheritanceType.JOINED)//Personas dati ir personas tabulā, bet individuālo Students un Professors tabulā
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) -> gan Studenti, gan Profesori Personas tabulā
@Table
@Entity
public class Person {

	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idpe")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idpe;
	
	
	@NotNull
	@Size(min = 2, max = 20)
	@Pattern(regexp = "[A-Z]{1}[a-z]+") //TODO nokopēt no iepriekšējiem semināriem arī ar mīkstinājumu/garumu zīmēm
	@Column(name = "Name")
	private String name;
	
	@NotNull
	@Size(min = 2, max = 40)
	@Pattern(regexp = "[A-Z]{1}[a-z]+") //TODO nokopēt no iepriekšējiem semināriem arī ar mīkstinājumu/garumu zīmēm
	@Column(name = "Surname")
	private String surname;
	
	public Person(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
	
}

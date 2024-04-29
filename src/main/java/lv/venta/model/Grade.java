package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "GradeTable")
@Entity
public class Grade {
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idg")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idg;
	
	@Column(name = "Grvalue")
	private int grvalue;
	
	@ManyToOne
	@JoinColumn(name = "Idc")//saite uz kolonnu (@Column) no Course klases
	private Course course;
	
	
	
}

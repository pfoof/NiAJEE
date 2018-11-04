package pl.gda.pg.eti.kask.javaee.jsf.business.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {

	private Integer id;
	private List<Keypart> keyparts = new ArrayList<>();
	private String name;
	private String email;
	
}

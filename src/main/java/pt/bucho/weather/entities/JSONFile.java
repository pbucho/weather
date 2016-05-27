package pt.bucho.weather.entities;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "json_file")
public class JSONFile {

	@Id
	@Column(unique = true)
	private String path;
	
	private JSONFile() {
	}
	
	public JSONFile(File file) {
		this();
		this.path = file.getAbsolutePath();
	}
	
	public String getPath() {
		return path;
	}
	
}

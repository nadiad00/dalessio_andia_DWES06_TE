package birt.dwes.apirest.dto;

public class EquipoDTO {

	private String nombreP1;
    private String nombreP2;
    private String nombreP3;
    private String nombreP4;
    private String nombreP5;
    private String nombreP6;
	
    public EquipoDTO(String nombreP1, String nombreP2, String nombreP3, String nombreP4, String nombreP5,
			String nombreP6) {
    	
		this.nombreP1 = nombreP1;
		this.nombreP2 = nombreP2;
		this.nombreP3 = nombreP3;
		this.nombreP4 = nombreP4;
		this.nombreP5 = nombreP5;
		this.nombreP6 = nombreP6;
	}

	public String getNombreP1() {
		return nombreP1;
	}

	public void setNombreP1(String nombreP1) {
		this.nombreP1 = nombreP1;
	}

	public String getNombreP2() {
		return nombreP2;
	}

	public void setNombreP2(String nombreP2) {
		this.nombreP2 = nombreP2;
	}

	public String getNombreP3() {
		return nombreP3;
	}

	public void setNombreP3(String nombreP3) {
		this.nombreP3 = nombreP3;
	}

	public String getNombreP4() {
		return nombreP4;
	}

	public void setNombreP4(String nombreP4) {
		this.nombreP4 = nombreP4;
	}

	public String getNombreP5() {
		return nombreP5;
	}

	public void setNombreP5(String nombreP5) {
		this.nombreP5 = nombreP5;
	}

	public String getNombreP6() {
		return nombreP6;
	}

	public void setNombreP6(String nombreP6) {
		this.nombreP6 = nombreP6;
	}
}

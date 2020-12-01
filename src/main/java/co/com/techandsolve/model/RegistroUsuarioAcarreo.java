package co.com.techandsolve.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "registro_usuario_acarreo")
public class RegistroUsuarioAcarreo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
	protected static final String PK = "id";

	@Id
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(generator = "native_generator")
	@Column(unique = true, nullable = false, precision = 10)
	private int id;
	@Column(name = "cedula", nullable = false, length = 255)
	private int cedula;
	@Column(name = "fecha_registro", nullable = false, length = 255)
	private LocalDateTime fechaRegistro;
	@Column(name = "numero_viajes", nullable = false, length = 255)
	private String numeroViajes;

	/** Default constructor. */
	public RegistroUsuarioAcarreo() {
		super();
	}

	/**
	 * Access method for id.
	 *
	 * @return the current value of id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter method for id.
	 *
	 * @param aId the new value for id
	 */
	public void setId(int aId) {
		id = aId;
	}

	/**
	 * Access method for cedula.
	 *
	 * @return the current value of id
	 */
	public int getCedula() {
		return cedula;
	}

	/**
	 * Setter method for cedula.
	 *
	 * @param aId the new value for id
	 */
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	/**
	 * Access method for fechaRegistro.
	 *
	 * @return the current value of id
	 */
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * Setter method for fechaRegistro.
	 *
	 * @param aId the new value for id
	 */
	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * Access method for numeroViajes.
	 *
	 * @return the current value of id
	 */
	public String getNumeroViajes() {
		return numeroViajes;
	}

	/**
	 * Setter method for numeroViajes.
	 *
	 * @param aId the new value for id
	 */
	public void setNumeroViajes(String numeroViajes) {
		this.numeroViajes = numeroViajes;
	}

	/**
	 * Compares this instance with another City.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof RegistroUsuarioAcarreo))
			return false;
		return this.equals(other) && ((RegistroUsuarioAcarreo) other).equals(this);
	}

	/**
	 * Returns a hash code for this instance.
	 *
	 * @return Hash code
	 */
	@Override
	public int hashCode() {
		int i;
		int result = 17;
		i = getId();
		result = 37 * result + i;
		return result;
	}

	/**
	 * Returns a debug-friendly String representation of this instance.
	 *
	 * @return String representation of this instance
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[RegistroUsuarioAcarreo |");
		sb.append(" id=").append(getId());
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Return all elements of the primary key.
	 *
	 * @return Map of key names to values
	 */
	public Map<String, Object> getPrimaryKey() {
		Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
		ret.put("id", Integer.valueOf(getId()));
		return ret;
	}
}

package by.senla.zartem.foodpricemonitoring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "measurementsystem")
public class MeasurementSystem {

	@Id
	@Column(name = "measurement_system_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer measurementSystemId;

	@Column(name = "measurement_system_name")
	private String name;

	public MeasurementSystem() {
	}

	public MeasurementSystem(Integer id, String name) {
		this.measurementSystemId = id;
		this.name = name;
	}

	public Integer getMeasurementSystemId() {
		return measurementSystemId;
	}

	public void setMeasurementSystemId(Integer id) {
		this.measurementSystemId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "MeasurementSystem [id=" + measurementSystemId + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((measurementSystemId == null) ? 0 : measurementSystemId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeasurementSystem other = (MeasurementSystem) obj;
		if (measurementSystemId == null) {
			if (other.measurementSystemId != null)
				return false;
		} else if (!measurementSystemId.equals(other.measurementSystemId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

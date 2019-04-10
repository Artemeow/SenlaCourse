package by.azhulpa.task4.autoservice.model;

import by.azhulpa.task4.autoservice.model.enums.Status;

public class Mechanic implements Identifying{
	
	private String name;
	private Integer age;
	private String address;
	private final Long id;
	private Status status;
	
	public Mechanic(Long id, String name, Integer age, String address, Status status) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.id = id;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Long getId() {
		return id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String toString() {
		return "\nMechanic [id=" + getId() + ", status=" + getStatus() + ", name=" + getName() + ", age=" + getAge()
				+ ", adress=" + getAddress() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Mechanic other = (Mechanic) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

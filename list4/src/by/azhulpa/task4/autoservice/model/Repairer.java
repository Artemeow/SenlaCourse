package by.azhulpa.task4.autoservice.model;

import by.azhulpa.task4.autoservice.model.enums.Status;

public class Repairer extends Man implements Identifying{
	
	private final Long id;
	private Status status;
	
	public Repairer(Long id, String name, Integer age, String address, Status status) {
		super(name, age, address);
		this.id = id;
		this.status = status;
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
		return "Repairer [id=" + id + ", status=" + status + ", name=" + getName() + ", age=" + getAge()
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
		Repairer other = (Repairer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

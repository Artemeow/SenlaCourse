package by.azhulpa.task4.autoservice.model;

import by.azhulpa.task4.autoservice.model.enums.Status;

public class ServicePlace implements Identifying {

	private Long id;
	private Status status;
	
	public ServicePlace(Long id, Status status) {
		this.id = id;
		this.status = status;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}

	public String toString() {
		return "\nServicePlace [id=" + id + ", status=" + status + "]";
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
		ServicePlace other = (ServicePlace) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

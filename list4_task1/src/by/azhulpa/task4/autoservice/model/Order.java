package by.azhulpa.task4.autoservice.model;

import java.util.Date;

import by.azhulpa.task4.autoservice.model.enums.OrderStatus;

public class Order implements Identifying{

	private Long id;
	private Date adoption;
	private Date start;
	private Date ending;
	private Double cost;
	private Mechanic mechanic;
	private ServicePlace place;
	private OrderStatus status;
	
	public Order() {
	}

	public Order(Long id, Date adoption, Date start, Date ending, Double cost, Mechanic mechanic,
			ServicePlace place, OrderStatus status) {
		this.id = id;
		this.adoption = adoption;
		this.start = start;
		this.ending = ending;
		this.cost = cost;
		this.mechanic = mechanic;
		this.place = place;
		this.status = status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public Date getAdoption() {
		return adoption;
	}

	public void setAdoption(Date adoption) {
		this.adoption = adoption;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnding() {
		return ending;
	}

	public void setEnding(Date ending) {
		this.ending = ending;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Mechanic getMechanic() {
		return mechanic;
	}

	public void setMechanic(Mechanic mechanic) {
		this.mechanic = mechanic;
	}
	
	public ServicePlace getPlace() {
		return place;
	}

	public void setPlace(ServicePlace place) {
		this.place = place;
	}
	
	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "\nOrder [id=" + id + ", adoption=" + adoption + ", start=" + start + ", ending=" + ending
				+ ", cost=" + cost + ", mechanic=" + mechanic + ", place=" + place + ", status=" + status + "]\n";
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
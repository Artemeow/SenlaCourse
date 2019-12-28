package by.senla.zartem.foodpricemonitoring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productId;

	@OneToOne
	@JoinColumn(name = "category")
	private Category category;

	@Column(name = "kind")
	private String kind;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user")
	private User user;

	@Column(name = "quantity")
	private Integer quantity;

	@OneToOne
	@JoinColumn(name = "measurement_system")
	private MeasurementSystem measurementSystem;

	@OneToOne
	@JoinColumn(name = "current_price")
	private Price price;

	@OneToOne
	@JoinColumn(name = "vendor")
	private Vendor vendor;

	@Column(name = "product_name")
	private String name;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public MeasurementSystem getMeasurementSystem() {
		return measurementSystem;
	}

	public void setMeasurementSystem(MeasurementSystem measurementSystem) {
		this.measurementSystem = measurementSystem;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", category=" + category + ", kind=" + kind + ", user=" + user
				+ ", quantity=" + quantity + ", measurementSystem=" + measurementSystem + ", price=" + price
				+ ", vendor=" + vendor + ", name=" + name + "]";
	}

}

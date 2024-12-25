package entity;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	@SerializedName	("productID")
	private String id;
	@SerializedName	("productName")
	private String name;
	private double unitPrice;
	private String quantityPerUnit;
	
	public Product(String id, String name, double unitPrice, String quantityPerUnit) {
		super();
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantityPerUnit = quantityPerUnit;
	}

	@ToString.Exclude
	private Category category;

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", quantityPerUnit="
				+ quantityPerUnit + ", category=" + category + "]";
	}
	

}

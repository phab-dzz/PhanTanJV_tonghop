package models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;



import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "product")

@JsonIgnoreProperties({"productImageList", "orderDetails", "productPrices"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", columnDefinition = "BIGINT(20)")
    private long product_id;
    @Column(columnDefinition = "VARCHAR(150)", nullable = false)
    private String name;
    @Column(name = "manufacturer_name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String manufacturer;
    @Column(columnDefinition = "VARCHAR(250)", nullable = false)
    private String description;
    @Column(columnDefinition = "VARCHAR(25)", nullable = false)
    private String unit;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)

    private String status;


	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductImage> productImageList;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductPrice> productPrices;

    public Product() {
    }

    public Product(long product_id) {
        this.product_id = product_id;
    }

   

    public Product(long product_id, String name, String manufacturer, String description, String unit, String status,
			List<ProductImage> productImageList, List<OrderDetail> orderDetails, List<ProductPrice> productPrices) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.unit = unit;
		this.status = status;
		this.productImageList = productImageList;
		this.orderDetails = orderDetails;
		this.productPrices = productPrices;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return product_id == product.product_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id);
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }



    public List<ProductImage> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(List<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", status=" + status +
                '}';
    }
}
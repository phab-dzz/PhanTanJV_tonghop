package models;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product_image")
@NamedQuery(name = "ProductImage.findAll", query="SELECT pi from ProductImage pi")
@NamedQuery(name = "ProductImage.getImageByProductIdAndPagination", query="SELECT pi from ProductImage pi where pi.product.id = :productId")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(20)")
    private long image_id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(columnDefinition = "VARCHAR(250)", nullable = false)
    private String path;
    @Column(columnDefinition = "VARCHAR(250)")
    private String alternative;

    public ProductImage() {
    }

    public ProductImage(String path, String alternative) {
        this.path = path;
        this.alternative = alternative;
    }

    public ProductImage(Product product, String path, String alternative) {
        this.product = product;
        this.path = path;
        this.alternative = alternative;
    }

    public ProductImage(long image_id, Product product, String path, String alternative) {
        this.image_id = image_id;
        this.product = product;
        this.path = path;
        this.alternative = alternative;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductImage that = (ProductImage) o;
        return image_id == that.image_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(image_id);
    }

    public long getImage_id() {
        return image_id;
    }

    public void setImage_id(long image_id) {
        this.image_id = image_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "image_id=" + image_id +
                ", product=" + product +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                '}';
    }
}

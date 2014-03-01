package com.ny6design.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.collect.Lists;

public class Product{
	
	private String orderColumnName="date_added";
	private String orderBy="DESC";
	
    private Integer productId;

    @NotEmpty
    private String model;

    private String sku;

    private String location;

    private Integer quantity;

    private Integer stockStatusId;

    private String image;

    private Integer manufacturerId;

    private Integer shipping;

    private BigDecimal price;

    private Integer taxClassId;

    private Date dateAvailable;

    private BigDecimal weight;

    private Integer weightClassId;

    private BigDecimal length;

    private BigDecimal width;

    private BigDecimal height;

    private Integer lengthClassId;

    private Integer status;

    private Date dateAdded;

    private Date dateModified;

    private Integer viewed;

    private Integer sortOrder;

    private Integer subtract;

    private Integer minimum;

    private BigDecimal cost;
    
	private ProductDescription productDesc;
	private Long categoryId;
	private List<ProductImage> productImageList = Lists.newArrayList();
	private List<ProductPrice> productPriceList = Lists.newArrayList();

	
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStockStatusId() {
        return stockStatusId;
    }

    public void setStockStatusId(Integer stockStatusId) {
        this.stockStatusId = stockStatusId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Integer getShipping() {
        return shipping;
    }

    public void setShipping(Integer shipping) {
        this.shipping = shipping;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getTaxClassId() {
        return taxClassId;
    }

    public void setTaxClassId(Integer taxClassId) {
        this.taxClassId = taxClassId;
    }

    public Date getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(Date dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getWeightClassId() {
        return weightClassId;
    }

    public void setWeightClassId(Integer weightClassId) {
        this.weightClassId = weightClassId;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public Integer getLengthClassId() {
        return lengthClassId;
    }

    public void setLengthClassId(Integer lengthClassId) {
        this.lengthClassId = lengthClassId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Integer getViewed() {
        return viewed;
    }

    public void setViewed(Integer viewed) {
        this.viewed = viewed;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getSubtract() {
        return subtract;
    }

    public void setSubtract(Integer subtract) {
        this.subtract = subtract;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

	public ProductDescription getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(ProductDescription productDesc) {
		this.productDesc = productDesc;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public List<ProductImage> getProductImageList() {
		return productImageList;
	}

	public void setProductImageList(List<ProductImage> productImageList) {
		this.productImageList = productImageList;
	}

	public List<ProductPrice> getProductPriceList() {
		return productPriceList;
	}

	public void setProductPriceList(List<ProductPrice> productPriceList) {
		this.productPriceList = productPriceList;
	}

	public String getOrderColumnName() {
		return orderColumnName;
	}

	public void setOrderColumnName(String orderColumnName) {
		this.orderColumnName = orderColumnName;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", orderColumnName=" + orderColumnName
				+", orderBy=" + orderBy +", model=" + model
				+ ", sku=" + sku + ", location=" + location + ", quantity="
				+ quantity + ", stockStatusId=" + stockStatusId + ", image="
				+ image + ", manufacturerId=" + manufacturerId + ", shipping="
				+ shipping + ", price=" + price + ", taxClassId=" + taxClassId
				+ ", dateAvailable=" + dateAvailable + ", weight=" + weight
				+ ", weightClassId=" + weightClassId + ", length=" + length
				+ ", width=" + width + ", height=" + height
				+ ", lengthClassId=" + lengthClassId + ", status=" + status
				+ ", dateAdded=" + dateAdded + ", dateModified=" + dateModified
				+ ", viewed=" + viewed + ", sortOrder=" + sortOrder
				+ ", subtract=" + subtract + ", minimum=" + minimum + ", cost="
				+ cost + ", productDesc=" + productDesc + ", categoryId="
				+ categoryId + ", productImageList=" + productImageList
				+ ", productPriceList=" + productPriceList + "]";
	}
    
}
package com.ny6design.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

import com.google.common.collect.Lists;

public class Product{
	
    private Integer productId;

    @NotEmpty
    private String model;

    private String sku = "1";

    private String location = "USA";

    private Integer quantity;

    private Integer stockStatusId=1;

    private String image;

    private Integer manufacturerId=1;

    private Integer shipping=1;

    private BigDecimal price;

    private Integer taxClassId=1;

    //set at front end
    private Date dateAvailable = DateTime.now().toDate();

    private BigDecimal weight = BigDecimal.ZERO;

    private Integer weightClassId = 0;

    private BigDecimal length = new BigDecimal(0.00);

    private BigDecimal width = new BigDecimal(0.00);

    private BigDecimal height = new BigDecimal(0.00);

    private Integer lengthClassId = 0;

    private Integer status = 0;

    private Date dateAdded = DateTime.now().toDate();

    private Date dateModified  = DateTime.now().toDate();

    private Integer viewed = 0;

    private Integer sortOrder = 0;

    private Integer subtract = 1;

    private Integer minimum = 1;
    
    private Integer index;

    private BigDecimal cost = new BigDecimal(0.0000);
    
	private ProductDescription productDesc;
	private List<ProductImage> productImageList = Lists.newArrayList();
	private List<ProductPrice> productPriceList = Lists.newArrayList();
	private List<Product2CategoryKey> productCategoryList = Lists.newArrayList();

	
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

	public List<Product2CategoryKey> getProductCategoryList() {
		return productCategoryList;
	}

	public void setProductCategoryList(List<Product2CategoryKey> productCategoryList) {
		this.productCategoryList = productCategoryList;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", model=" + model + ", index=" + index
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
				+ cost + ", productDesc=" + productDesc  + ", productImageList=" + productImageList
				+ ", productPriceList=" + productPriceList
				+ ", productCategoryList=" + productCategoryList + "]";
	}

    
}
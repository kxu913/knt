package com.ny6design.model;

import org.hibernate.validator.constraints.NotEmpty;

public class ProductDescription extends ProductDescriptionKey {
	@NotEmpty
    private String name;

    private String metaKeywords;

    private String metaDescription;

    @NotEmpty
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords == null ? null : metaKeywords.trim();
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription == null ? null : metaDescription.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	@Override
	public String toString() {
		return "ProductDescription [name=" + name + ", metaKeywords="
				+ metaKeywords + ", metaDescription=" + metaDescription
				+ ", description=" + description + "]";
	}
    
}
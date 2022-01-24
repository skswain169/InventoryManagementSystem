package com.accenture.lkm.business.bean;

public class VendorBean {
	private String vendorId;
	private String vendorName;
	private String vendorAddress;
	private String contactPerson;
	private String contactNumber;

	public VendorBean() {
		super();
	}
	

	public VendorBean(String vendorId, String vendorName, String vendorAddress, String contactPerson,
			String contactNumber) {
		
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.contactPerson = contactPerson;
		this.contactNumber = contactNumber;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public String getVendorId() {
		return vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
}

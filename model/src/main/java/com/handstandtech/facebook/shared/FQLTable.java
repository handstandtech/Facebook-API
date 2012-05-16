//package com.handstandtech.facebook.shared;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.handstandtech.facebook.shared.model.FacebookPermission;
//
//public class FQLTable implements Serializable {
//
//	/**
//	 * Default UID
//	 */
//	private static final long serialVersionUID = 1L;
//	private String name;
//	private List<FQLColumn> columns = new ArrayList<FQLColumn>();
//	private String description;
//	private List<FacebookPermission> requiredPermissions = new ArrayList<FacebookPermission>();
//
//	public FQLTable(String name) {
//		setName(name);
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setColumns(List<FQLColumn> columns) {
//		this.columns = columns;
//	}
//
//	public List<FQLColumn> getColumns() {
//		return columns;
//	}
//
//	public void addColumn(FQLColumn column) {
//		columns.add(column);
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public void requiresPermissions(FacebookPermission permission) {
//		requiredPermissions.add(permission);
//	}
//}

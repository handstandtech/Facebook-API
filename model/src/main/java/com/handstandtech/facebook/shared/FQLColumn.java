//package com.handstandtech.facebook.shared;
//
//import java.io.Serializable;
//
//
//public class FQLColumn implements Serializable {
//		/**
//		 * Default UID
//		 */
//		private static final long serialVersionUID = 1L;
//
//		public FQLColumn(String name, ParamType type, boolean indexable) {
//			this.setName(name);
//			this.setType(type);
//			this.setIndexable(indexable);
//		}
//
//		public void setDescription(String description) {
//			this.description = description;
//		}
//		public String getDescription() {
//			return description;
//		}
//
//		public void setType(ParamType type) {
//			this.type = type;
//		}
//
//		public ParamType getType() {
//			return type;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public void setIndexable(boolean indexable) {
//			this.indexable = indexable;
//		}
//
//		public boolean isIndexable() {
//			return indexable;
//		}
//
//		private boolean indexable;
//		private String name;
//		private ParamType type;
//		private String description;
//	}
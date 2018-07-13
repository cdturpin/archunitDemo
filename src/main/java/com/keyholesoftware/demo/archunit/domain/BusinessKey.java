//package com.keyholesoftware.demo.archunit.domain;
//
//import org.apache.commons.lang3.ObjectUtils;
//import org.apache.commons.lang3.StringUtils;
//
//public class BusinessKey { 
//	private String key;
//	private String value;
//
//	public BusinessKey( String key, String value ) {
//		super();
//
//		this.key = key;
//		this.value = value;
//	}
//
//	public String getKey() {
//		return key;
//	}
//
//	public String getValue() {
//		return value;
//	}
//
//	@Override
//	public boolean equals( Object obj ) {
//		if ( ! ( obj instanceof BusinessKey ) ) {
//			return false;
//		}
//
//		BusinessKey that = ( BusinessKey ) obj;
//
//		return StringUtils.equals(this.key, that.key);
//	}
//
//	@Override
//	public int hashCode() {
//		return ObjectUtils.hashCode( key );
//	}
//}

package com.netflux.adp.data;


public abstract class BaseDB {

	public abstract String getDatabaseName();
	public abstract int getDatabaseVersion();
	public abstract String[] getCreateStatements();
	public abstract String[] getUpdateStatements();
	public abstract String[] getDowngradeStatements();

}

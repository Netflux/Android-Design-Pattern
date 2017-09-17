package com.netflux.adp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BaseDBOpenHelper extends SQLiteOpenHelper {

	private BaseDB mDatabase;

	public BaseDBOpenHelper(Context context, BaseDB database) {
		super(context, database.getDatabaseName(), null, database.getDatabaseVersion());
		mDatabase = database;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		runStatements(db, mDatabase.getCreateStatements());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		runStatements(db, mDatabase.getUpdateStatements());
	}

	@Override
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		runStatements(db, mDatabase.getDowngradeStatements());
	}

	private void runStatements(SQLiteDatabase db, String[] statements) {
		for (String statement : statements) {
			db.execSQL(statement);
		}
	}

	/**
	 * Get the default {@link BaseDB Database} for the {@link BaseDBOpenHelper DB Open Helper}.
	 * @return The {@link BaseDB Database}.
	 */
	protected BaseDB getDatabase() {
		return mDatabase;
	}

}

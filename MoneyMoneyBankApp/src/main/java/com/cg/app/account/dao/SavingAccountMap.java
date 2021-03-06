package com.cg.app.account.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cg.app.account.SavingsAccount;

public class SavingAccountMap implements RowMapper<SavingsAccount> {

	public SavingsAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
		SavingsAccount account = new SavingsAccount(rs.getInt("account_number"),rs.getString("account_hn"),
				rs.getDouble("account_bal"),rs.getBoolean("salary"));
		return account;
	}

}

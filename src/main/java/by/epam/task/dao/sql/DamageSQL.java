package by.epam.task.dao.sql;

public class DamageSQL {
	private DamageSQL() {}
	
	public static final int INDEX_DAMAGE_COST = 1;
	public static final int INDEX_DAMAGE_DESCRIPTION = 2;
	public static final int INDEX_DAMAGE_DEAL_ID = 3;
	 
	public static final String INSERT_DAMAGE = "INSERT INTO damages(dmg_cost, dmg_description, dmg_deal_id)" 
			+ " VALUES(?, ?, ?)";
	public static final String DELETE_DAMAGE = "SELECT * FROM damages WHERE dmg_id = ?";
	public static final String UPDATE_DAMAGE = "UPDATE damages "
			+ " SET dmg_cost = ?, dmg_description = ?"
			+ " WHERE dmg_id = ?";
	
}

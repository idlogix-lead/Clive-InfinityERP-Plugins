package com.clive.model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.adempiere.exceptions.DBException;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;

public class MStitching extends X_ER_Stitching {

	public MStitching(Properties ctx, int ER_Stitching_ID, String trxName) {
		super(ctx, ER_Stitching_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MStitching(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected boolean beforeSave(boolean newRecord)
	{
		int MPID = getM_Production_ID();
		
		BigDecimal BottomQty = Env.ZERO;
		BigDecimal totalStichedQty = Env.ZERO;

		StringBuilder sb = new StringBuilder("SELECT \n");

		sb.append("coalesce(sum(qty), 0) as totalstichedqty,\n" + 
				"        (SELECT coalesce(sum(qty), 0) from er_bottom where m_production_id = " + MPID + ") as totalbottomqty\n" + 
				"from er_stitching where er_stitching_id <> " + get_ID() + " AND m_production_id=" + MPID);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement (sb.toString(), get_TrxName());
			
			rs = pstmt.executeQuery ();
			if (rs.next ())
			{
				BottomQty = rs.getBigDecimal("totalbottomqty");
				totalStichedQty = rs.getBigDecimal("totalstichedqty");

			}
		}
		catch (SQLException e)
		{
			throw new DBException(e, sb.toString());
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null; pstmt = null;
		}
		if (BottomQty.compareTo(totalStichedQty.add(getQty())) == -1)
		{
			log.saveError("Error", Msg.getMsg(getCtx(), "Qty Overflow"));
			return false;
		}
		return super.beforeSave(newRecord);
	}
}

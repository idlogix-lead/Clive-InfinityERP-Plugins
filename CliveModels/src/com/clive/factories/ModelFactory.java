package com.clive.factories;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.MProductionLine;
import org.compiere.model.PO;
import org.compiere.util.Env;

import com.clive.model.MBottom;
import com.clive.model.MCoupon;
import com.clive.model.MCutting;
import com.clive.model.MDailyProduction;
import com.clive.model.MLaborActivity;
import com.clive.model.MLaborActivityLine;
import com.clive.model.MLasting;
import com.clive.model.MMasterProduction;
import com.clive.model.MMasterProductionLine;
import com.clive.model.MMovement;
import com.clive.model.MOperation;
import com.clive.model.MPacking;
import com.clive.model.MProduct;
import com.clive.model.MProductBOM;
import com.clive.model.MProduction;
import com.clive.model.MStitching;
import com.clive.model.MStrobel;

public class ModelFactory implements IModelFactory {

	@Override
	public Class<?> getClass(String tableName) {
		
		if (tableName.equals(MMasterProduction.Table_Name)) { return MMasterProduction.class; }
		if (tableName.equals(MMasterProductionLine.Table_Name)) { return MMasterProductionLine.class; }
		if (tableName.equals(MProduction.Table_Name)) { return MProduction.class; }
		if (tableName.equals(MProductionLine.Table_Name)) { return MProductionLine.class; }
		if (tableName.equals(MCutting.Table_Name)) { return MCutting.class; }
		if (tableName.equals(MBottom.Table_Name)) { return MBottom.class; }
		if (tableName.equals(MStitching.Table_Name)) { return MStitching.class; }
		if (tableName.equals(MStrobel.Table_Name)) { return MStrobel.class; }
		if (tableName.equals(MPacking.Table_Name)) { return MPacking.class; }
		if (tableName.equals(MDailyProduction.Table_Name)) { return MDailyProduction.class; }
		if (tableName.equals(MProduct.Table_Name)) { return MProduct.class; }
		if (tableName.equals(MProductBOM.Table_Name)) { return MProductBOM.class; }
		if (tableName.equals(MLasting.Table_Name)) { return MLasting.class; }
		if (tableName.equals(MCoupon.Table_Name)) { return MCoupon.class; }
		if (tableName.equals(MOperation.Table_Name)) { return MOperation.class; }
		if (tableName.equals(MLaborActivityLine.Table_Name)) { return MLaborActivityLine.class; }
		if (tableName.equals(MLaborActivity.Table_Name)) { return MLaborActivity.class; }
		if (tableName.equals(MMovement.Table_Name)) { return MMovement.class; }
		
		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {

		if (tableName.equals(MMasterProduction.Table_Name)) { return new MMasterProduction(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MMasterProductionLine.Table_Name)) { return new MMasterProductionLine(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MProduction.Table_Name)) { return new MProduction(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MProductionLine.Table_Name)) { return new MProductionLine(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MCutting.Table_Name)) { return new MCutting(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MBottom.Table_Name)) { return new MBottom(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MStitching.Table_Name)) { return new MStitching(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MStrobel.Table_Name)) { return new MStrobel(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MPacking.Table_Name)) { return new MPacking(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MDailyProduction.Table_Name)) { return new MDailyProduction(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MProduct.Table_Name)) { return new MProduct(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MProductBOM.Table_Name)) { return new MProductBOM(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MLasting.Table_Name)) { return new MLasting(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MCoupon.Table_Name)) { return new MCoupon(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MOperation.Table_Name)) { return new MOperation(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MLaborActivityLine.Table_Name)) { return new MLaborActivityLine(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MLaborActivity.Table_Name)) { return new MLaborActivity(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MMovement.Table_Name)) { return new MMovement(Env.getCtx(), Record_ID, trxName); }
		
		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		
		if (tableName.equals(MMasterProduction.Table_Name)) { return new MMasterProduction(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MMasterProductionLine.Table_Name)) { return new MMasterProductionLine(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MProduction.Table_Name)) { return new MProduction(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MProductionLine.Table_Name)) { return new MProductionLine(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MCutting.Table_Name)) { return new MCutting(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MBottom.Table_Name)) { return new MBottom(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MStitching.Table_Name)) { return new MStitching(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MStrobel.Table_Name)) { return new MStrobel(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MPacking.Table_Name)) { return new MPacking(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MDailyProduction.Table_Name)) { return new MDailyProduction(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MProduct.Table_Name)) { return new MProduct(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MProductBOM.Table_Name)) { return new MProductBOM(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MLasting.Table_Name)) { return new MLasting(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MCoupon.Table_Name)) { return new MCoupon(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MOperation.Table_Name)) { return new MOperation(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MLaborActivityLine.Table_Name)) { return new MLaborActivityLine(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MLaborActivity.Table_Name)) { return new MLaborActivity(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MMovement.Table_Name)) { return new MMovement(Env.getCtx(), rs, trxName); }

		return null;
	}

}

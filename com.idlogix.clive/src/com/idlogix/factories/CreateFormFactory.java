package com.idlogix.factories;

import org.compiere.grid.ICreateFrom;
import org.compiere.grid.ICreateFromFactory;
import org.compiere.model.GridTab;
import com.clive.model.X_ER_LaborActivity;
import org.compiere.model.MInOut;



import com.idlogix.forms.CreateFromArticleUI;
import com.idlogix.forms.CreateFromLaborWageUI;

public class CreateFormFactory implements ICreateFromFactory {

	@Override
	public ICreateFrom create(GridTab mTab) {
		// TODO Auto-generated method stub
		String tableName = mTab.getTableName();
		if (tableName.equals(MInOut.Table_Name))
			return null;
		return null;
	}

}

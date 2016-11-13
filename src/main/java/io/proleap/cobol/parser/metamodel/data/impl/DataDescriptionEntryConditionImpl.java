/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.data.impl;

import io.proleap.cobol.Cobol85Parser.DataDescriptionEntryFormat3Context;
import io.proleap.cobol.parser.metamodel.CobolDivision;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.data.DataDescriptionEntryCondition;

//FIXME: add clauses
public class DataDescriptionEntryConditionImpl extends DataDescriptionEntryImpl
		implements DataDescriptionEntryCondition {

	protected final DataDescriptionEntryFormat3Context ctx;

	public DataDescriptionEntryConditionImpl(final String name, final ProgramUnit programUnit,
			final CobolDivision scope, final DataDescriptionEntryFormat3Context ctx) {
		super(name, programUnit, scope, ctx);

		this.ctx = ctx;
	}

	@Override
	public Type getType() {
		return Type.Condition;
	}

}
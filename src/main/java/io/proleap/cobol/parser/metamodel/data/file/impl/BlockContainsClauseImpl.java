/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.data.file.impl;

import io.proleap.cobol.Cobol85Parser.BlockContainsClauseContext;
import io.proleap.cobol.parser.metamodel.IntegerLiteral;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.data.file.BlockContainsClause;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;

public class BlockContainsClauseImpl extends CobolDivisionElementImpl implements BlockContainsClause {

	protected final BlockContainsClauseContext ctx;

	protected IntegerLiteral from;

	protected IntegerLiteral to;

	protected Unit unit;

	public BlockContainsClauseImpl(final ProgramUnit programUnit, final BlockContainsClauseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public IntegerLiteral getFrom() {
		return from;
	}

	@Override
	public IntegerLiteral getTo() {
		return to;
	}

	@Override
	public Unit getUnit() {
		return unit;
	}

	@Override
	public void setFrom(final IntegerLiteral from) {
		this.from = from;
	}

	@Override
	public void setTo(final IntegerLiteral to) {
		this.to = to;
	}

	@Override
	public void setUnit(final Unit unit) {
		this.unit = unit;
	}
}
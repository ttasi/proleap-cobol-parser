/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.impl;

import io.proleap.cobol.Cobol85Parser.StopStatementContext;
import io.proleap.cobol.parser.metamodel.CobolScope;
import io.proleap.cobol.parser.metamodel.CopyBook;
import io.proleap.cobol.parser.metamodel.impl.CobolScopedElementImpl;
import io.proleap.cobol.parser.metamodel.procedure.StopStatement;

public class StopStatementImpl extends CobolScopedElementImpl implements StopStatement {

	protected final StopStatementContext ctx;

	public StopStatementImpl(final CopyBook copyBook, final CobolScope superScope, final StopStatementContext ctx) {
		super(copyBook, superScope, ctx);

		this.ctx = ctx;
	}

}
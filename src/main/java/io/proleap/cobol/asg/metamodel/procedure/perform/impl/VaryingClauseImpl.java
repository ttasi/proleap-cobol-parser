/*
 * Copyright (C) 2017, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.procedure.perform.impl;

import java.util.List;

import io.proleap.cobol.Cobol85Parser.PerformAfterContext;
import io.proleap.cobol.Cobol85Parser.PerformVaryingClauseContext;
import io.proleap.cobol.Cobol85Parser.PerformVaryingPhraseContext;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.asg.metamodel.procedure.perform.After;
import io.proleap.cobol.asg.metamodel.procedure.perform.VaryingClause;
import io.proleap.cobol.asg.metamodel.procedure.perform.VaryingPhrase;
import io.proleap.cobol.asg.metamodel.valuestmt.ValueStmt;

public class VaryingClauseImpl extends CobolDivisionElementImpl implements VaryingClause {

	protected List<After> afters;

	protected final PerformVaryingClauseContext ctx;

	protected VaryingPhrase varyingPhrase;

	public VaryingClauseImpl(final ProgramUnit programUnit, final PerformVaryingClauseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public After addAfter(final PerformAfterContext ctx) {
		After result = (After) getASGElement(ctx);

		if (result == null) {
			result = new AfterImpl(programUnit, ctx);

			result.addVaryingPhrase(ctx.performVaryingPhrase());

			afters.add(result);
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public VaryingPhrase addVaryingPhrase(final PerformVaryingPhraseContext ctx) {
		VaryingPhrase result = (VaryingPhrase) getASGElement(ctx);

		if (result == null) {
			result = new VaryingPhraseImpl(programUnit, ctx);

			// varying
			final ValueStmt varyingValueStmt = createValueStmt(ctx.identifier(), ctx.literal());
			result.setVaryingValueStmt(varyingValueStmt);

			// from
			result.addFrom(ctx.performFrom());

			// by
			result.addBy(ctx.performBy());

			// until
			result.addUntil(ctx.performUntil());

			varyingPhrase = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public List<After> getAfters() {
		return afters;
	}

	@Override
	public VaryingPhrase getVaryingPhrase() {
		return varyingPhrase;
	}

}
package org.xacml4j.v30.pdp;

/*
 * #%L
 * Xacml4J Core Engine Implementation
 * %%
 * Copyright (C) 2009 - 2014 Xacml4J.org
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import org.xacml4j.v30.RequestContext;
import org.xacml4j.v30.Result;
import org.xacml4j.v30.spi.pdp.RequestContextHandler;


/**
 * An interface to the {@link org.xacml4j.v30.PolicyDecisionPoint} used
 * by {@link RequestContextHandler} to request decision
 * for particular request
 *
 * @author Giedrius Trumpickas
 */
public interface PolicyDecisionCallback
{
	/**
	 * Requests a decision for a given request
	 * from a policy decision point
	 *
	 * @param request a decision request
	 * @return {@link Result} a decision result
	 */
	Result requestDecision(PolicyDecisionPointContext context,
			RequestContext request);
}

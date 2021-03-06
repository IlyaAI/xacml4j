package org.xacml4j.util;

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

import java.lang.reflect.Method;

import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

public final class CglibInvocationFactory implements InvocationFactory
{
	@Override
	public <T> Invocation<T> create(final Object instance, final Method m) {
		return new Invocation<T>()
		{
			private FastClass fastClass;
			private FastMethod fastMethod;

			{
				this.fastClass = FastClass.create(m.getDeclaringClass());
				this.fastMethod = fastClass.getMethod(m);
			}

			@SuppressWarnings("unchecked")
			@Override
			public T invoke(Object... params) throws Exception {
				return (T)fastMethod.invoke(instance, params);
			}
		};
	}

}

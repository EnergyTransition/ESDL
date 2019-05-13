/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package nl.tno.esdl;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicMonitor;

/**
 * Generates log INFIO messages for each sub task.
 */
public class LoggerMonitor extends BasicMonitor
{
	protected final Logger log;
	
	public LoggerMonitor(Logger log) {
		this.log = log;
	}

	@Override
	public void subTask(String name) {
		log.info(/*"subTask " +*/ name);
	}
}
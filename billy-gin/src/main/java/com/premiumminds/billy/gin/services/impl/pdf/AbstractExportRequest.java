/**
 * Copyright (C) 2013 Premium Minds.
 * 
 * This file is part of billy GIN.
 * 
 * billy GIN is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * billy GIN is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with billy GIN. If not, see <http://www.gnu.org/licenses/>.
 */
package com.premiumminds.billy.gin.services.impl.pdf;

import com.premiumminds.billy.core.services.UID;
import com.premiumminds.billy.gin.services.ExportServiceRequest;
import com.premiumminds.billy.gin.services.export.IBillyTemplateBundle;

public class AbstractExportRequest implements ExportServiceRequest {

	protected UID uid;
	private IBillyTemplateBundle bundle;

	public AbstractExportRequest(UID uid, IBillyTemplateBundle bundle) {
		this.uid = uid;
		this.bundle = bundle;
	}

	public UID getDocumentUID() {
		return this.uid;
	}

	public IBillyTemplateBundle getBundle() {
		return this.bundle;
	}

}

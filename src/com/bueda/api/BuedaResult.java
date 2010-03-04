/*
 * Copyright (C) 2008 Bueda Inc.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package com.bueda.api;

import java.util.Collection;



public class BuedaResult {

	/** The Clean Tags **/
    private Collection<String> query; 
                  
	private Collection<String> split_tags;
	
	private Collection<String> cleanup;
	
	private Collection<BuedaSemanticTag> semantic;
	
	
	//private Collection<BuedaCategory> categories;


	private String status;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BuedaResult() {

	}

	public Collection<String> getQuery() {
		return query;
	}

	public void setQuery(Collection<String> query) {
		this.query = query;
	}

	public Collection<String> getSplit_tags() {
		return split_tags;
	}

	public void setSplit_tags(Collection<String> splitTags) {
		split_tags = splitTags;
	}

	public Collection<String> getCleanup() {
		return cleanup;
	}

	public void setCleanup(Collection<String> cleanup) {
		this.cleanup = cleanup;
	}

	public Collection<BuedaSemanticTag> getSemantic() {
		return semantic;
	}

	public void setSemantic(Collection<BuedaSemanticTag> semantic) {
		this.semantic = semantic;
	}


}

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


/**
 * This class holds the semantic tag object
 * @author vasco
 *
 */
public class BuedaSemanticTag {

	/** The canonical name of the semantic tag **/
	public String name;
	
	/** The original tags that resulted in this semantic tag **/
	public Collection<String> qtoken;
	
	/** The Semantic categories for this semantic Tag**/	
	public Collection<String> categories;
	
	/** The pointer to the common tag for this semantic tag **/
	public String concept_id;
	

	public BuedaSemanticTag(){
		
	}


	@Override
	public String toString() {
		return "{ name:" + name + ", orignal tags:" + qtoken + "categories:" + categories + ", concept_id:"
				+ concept_id + "}";
	}
	
	
}

/*
 * Copyright (C) 2010 Bueda Inc.
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

package com.bueda.test;

import java.io.IOException;

import com.bueda.api.Bueda;
import com.bueda.api.BuedaResult;

public class BuedaAPiTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		 if (args.length != 2)
		      usageAndExit();
		    
		 String apiKey = args[0];
		 String tags = args[1];

		
		 Bueda bue = new Bueda(apiKey);
		 BuedaResult bueResult = bue.enhance(tags);
		 if (bueResult.getStatus()=="true"){
			 System.out.println("Query: " + bueResult.getQuery());
			 System.out.println("Split Tags: " + bueResult.getSplit_tags());
			 System.out.println("Clean Tags: " + bueResult.getCleanup());
			 System.out.println("Semantic Tags: " + bueResult.getSemantic());
			 //System.out.println("Categories: " + bueResult.getCategories());
		 }
		 else{
			 System.out.println("Error: " + bueResult.getMessage());
		 }
	}
	
	
	
	 private static void usageAndExit() {
		    System.out.println("Usage: ");
		    System.out.println("  java -jar buedaapi-java-test.jar <api_key> <text>");
		    System.exit(-1);
		  }

}

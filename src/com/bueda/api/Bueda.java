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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.google.gson.Gson;


/**
 * The <code>Bueda</code> class represents a java implementation of <a
 * href="http://www.bueda.com">Bueda Inc.</a> API. Bueda is a tag enhancement
 * engine that works with a set of tags. Read more in the link given above or in
 * <a href="http://www.bueda.com/company/api/">API</a> pages.
 * 
 * @author Vasco Calais Pedro
 */

public class Bueda {

	/** API host url */
	private static final String API_HOST = "api.bueda.com";

	/** Gateway for API calls */
	private static final String GATEWAY = "/enriched";

	/** Currently used API key for API calls */
	private String apiKey;

	/** Currently used gateway for API calls */
	private String apiGateway;

	/**
	 * Main constructor that initializes all data required for API calls
	 * 
	 * @param apiKey
	 *            API key for server authentication. Developers can register for
	 *            it at <a
	 *            href="http://www.bueda.com/accounts/registration/register/"
	 *            >API</a> page of Zemanta.
	 */
	public Bueda(String apiKey) {
		this.apiKey = apiKey;
		this.apiGateway = new StringBuilder().append(API_HOST).append(GATEWAY)
				.toString();

	}

	/**
	 * Takes a string with comma delimited tags and gets a json object with the
	 * results
	 * 
	 * @param tags
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public BuedaResult enhance(String tags) {
		String response = "";
		APIResult result = new APIResult();
		
		BuedaResult bResult;
		
		try {
			response = getResponse(tags);
			Gson gson = new Gson();
			result = gson.fromJson(response, APIResult.class);
			
			// if we got a response then we return the result
			// and we add the original query 
			if (result.getSucess()=="true"){
				bResult = result.getResult();
				bResult.setStatus(result.getSucess());
				bResult.setQuery(result.getQuery());	
				bResult.setMessage(result.getMessage());
				
			}
			
			// if we got a bad result then we return a empty result with the query and 
			// message
			else{
				bResult = new BuedaResult();
				bResult.setStatus(result.getSucess());
				bResult.setMessage(result.getMessage());
				bResult.setQuery(result.getQuery());
				
			}
		} catch (IOException e) {
			bResult = new BuedaResult();
			bResult.setStatus("error");
			bResult.setMessage(e.getMessage());
			bResult.setQuery(null);
			e.printStackTrace();
		}
		return bResult;

	}

	/**
	 * Takes a string with the tags and executes the actual request
	 * 
	 * @param tags
	 * @return the response json object in string form
	 * @throws IOException 
	 * @throws IOException
	 */
	private String getResponse(String tags) throws IOException{
		tags = URLEncoder.encode(tags, "UTF-8");
		String queryURL = new StringBuilder().append("http://").append(
				apiGateway).append("?apikey=").append(apiKey).append("&tags=")
				.append(tags).toString();

		URL buedaapi;
		buedaapi = new URL(queryURL);
		URLConnection bd = buedaapi.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(bd
				.getInputStream()));
		String inputLine;

		StringBuilder jsonResponse = new StringBuilder();

		while ((inputLine = in.readLine()) != null)
			jsonResponse.append(inputLine);
		in.close();

		String response = jsonResponse.toString();

		
		return response;
	}
}

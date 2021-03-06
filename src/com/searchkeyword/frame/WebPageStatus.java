package com.searchkeyword.frame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WebPageStatus {

	public static String getPageContent(String pageurl) {
		String pagecontant = "";
		//System.out.println("Page URL " + pageurl);
		try {
			URL url = new URL(pageurl);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					url.openStream()));
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					"data.html"));
			String line;

			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				// writer.write(line);
				// writer.newLine();
				pagecontant = pagecontant + line;
			}

			//System.out.println(pagecontant);
			List pageUrl = Test.getLink(pagecontant);
			// String pagetitle=Test.getPageTitle(pagecontant);
			// System.out.println("Title "+pagetitle);
			reader.close();
			writer.close();
		} catch (MalformedURLException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		}

		return pagecontant;

	}

	public static List getLink(String str) {

		String str1[] = str.split("<a");

		List urlLink = new ArrayList();

		for (int i = 1; i < str1.length; i++) {
			String strlink1 = str1[i];
			// System.out.println("Link1 "+strlink1);
			String str2[] = strlink1.split("</a>");

			for (int j = 0; j < str2.length - 1; j++) {
				String strlink2 = str2[j];
				// System.out.println("Link2 "+strlink2);
				String str3[] = strlink2.split(">");

				for (int k = 0; k < str3.length; k++) {
					String strlink3 = str3[k];
					// System.out.println("Link3 "+strlink3);

					String str4[] = strlink3.split("href=");
					for (int l = 0; l < str4.length; l++) {
						String strlink4 = str4[l];
						// System.out.println("Link4 "+strlink4);

						String str5[] = strlink4.split("href=");
						for (int m = 0; m < str5.length; m++) {
							String strlink5 = str5[m];
							// System.out.println("Link5 "+strlink5);

							String str6[] = strlink5.split(" ");
							for (int n = 0; n < str6.length; n++) {
								String strlink6 = str6[n];
								/*if (n % 2 == 0
										&& !strlink6.equals("")
										&& (strlink6.indexOf(".html") != -1
												|| strlink6.indexOf(".php") != -1
												|| strlink6.indexOf("&") != -1
												|| strlink6.indexOf(".jsp") != -1 || strlink6
												.indexOf(".aspx") != -1)) {
									// System.out.println("Link6 "+strlink6);
									urlLink.add(strlink6);

								}*/
								
								if (n % 2 == 0
										&& !strlink6.equals("")
										&& (strlink6.indexOf(".html") != -1
												|| strlink6.indexOf(".php") != -1		
												|| strlink6.indexOf("&") != -1												
												|| strlink6.indexOf(".jsp") != -1 || strlink6
												.indexOf(".aspx") != -1) && (strlink6.indexOf("&nbsp;") < 0) && ( (strlink6.indexOf("class") < 0) || (strlink6.indexOf("CLASS") < 0))) {
									// System.out.println("Link6 "+strlink6+"   "+strlink6.indexOf("&nbsp;"));
									
									strlink6=strlink6.substring(1, strlink6.length()-1);
									urlLink.add(strlink6);

								}
								
							}

						}

					}
				}
			}

		}

		HashSet pageUrl = new HashSet(urlLink);

		ArrayList arrayUrl = new ArrayList(pageUrl);

		ArrayList arrayTitle = new ArrayList();

		// Ensure correct order, since HashSet doesn't
		// Collections.sort(arrayList2);

		/*
		 * for (int x=0;x<arrayUrl.size();x++) { String
		 * pagelink=String.valueOf(arrayUrl.get(x)); String
		 * pagetitle=getPageTitle(str); System.out.println(pagelink);
		 * System.out.println(pagetitle);
		 *  }
		 */

		return arrayUrl;

	}

	public static String getPageTitle(String pagetext) {
		// System.out.println("P Text: "+pagetext);
		String pagetitle = "";
		if (pagetext != null && !pagetext.equals("")) {
			String str1[] = pagetext.split("<title>");
			if (str1.length > 1) {
				// System.out.println(str1.length);;
				String titlestr = str1[1];
				String str2[] = titlestr.split("</title>");
				// System.out.println("Title "+str2[0]);
				if (str2.length > 0) {
					pagetitle = str2[0];
				}
			}
		}
		return pagetitle;
	}

}

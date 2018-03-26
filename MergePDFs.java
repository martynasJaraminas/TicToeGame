
package test1;
//Created by MAJA

//Martynas.jaraminas@gmail.com

/*  >>>>Dependencies<<<<
 *  >>>>PDFBOX-2.0.8<<<< 
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class MergePDFs {

	private List<String> listukas = new ArrayList<String>();
	private String filename;

	public static void main(String[] args) throws IOException {
		// Instantiating PDFMergerUtility class
		MergePDFs obj = new MergePDFs(); // susikuriam objekta
		System.out.println(
				"Please enter the directory of files\nTxt file must be in the same directory as PDF`s\nTxt file must be named as \"list.txt\"");
		Scanner sx = new Scanner(System.in);
		obj.filename = sx.next();
		obj.filename = obj.filename + "\\";
		// Sukuriu nauja folderi sujungtiems PDF`ams
		new File(obj.filename + "Merged_PDFs").mkdirs();
		obj.fileScaning(obj.filename); // nusiskainuojam duota faila
		try {
			System.out.println("Merge done ! Thanks for using !");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("!!!*** Thread Sleep ERROR ***!!!");
			e.printStackTrace();
		}
	}

	void fileScaning(String failoVardas) throws IOException {
		MergePDFs objv = new MergePDFs();
		String pdfName = null, finalName;
		String[] arr = null;
		Scanner sc;
		// Nusiskanuojam faila
		try {
			sc = new Scanner(new File(failoVardas + "list.txt"));
			List<String> lines = new ArrayList<String>();
			while (sc.hasNextLine()) {
				lines.add(sc.nextLine());

			}
			arr = lines.toArray(new String[0]);
		} catch (FileNotFoundException e) {
			System.out.println("!!! *** ERROR READING A FILE *** !!!");
			e.printStackTrace();
		}
		// Jungiam pdf`us
		for (int i = 0; i < arr.length; i++) {
			pdfName = arr[i];
			if (!pdfName.equals("end")) {
				listukas.add(pdfName);
			} else {
				i++;
				finalName = arr[i];
				objv.sujunk(listukas, finalName, failoVardas);
				listukas.clear();
			}
		}
	}

	@SuppressWarnings("deprecation")
	// PDFU jungimo funkcija
	void sujunk(List<String> naujas, String pavadinimas, String kelias) {
		PDFMergerUtility PDFmerger = new PDFMergerUtility();
		String pdfName;
		String[] suktukas;
		suktukas = naujas.toArray(new String[0]);
		for (int i = 0; i < suktukas.length; i++) {
			pdfName = suktukas[i];
			// Nuskaitom failu adresus kuruos jungsiu is txt
			try {
				PDFmerger.addSource(kelias + pdfName + ".pdf");
			} catch (FileNotFoundException e) {
				System.out.println("!!!*** Error adding file to source ***!!!");
				e.printStackTrace();
			}
		}
		// Nuskaitom failo norima pavadinima is txt
		PDFmerger.setDestinationFileName(kelias + "Merged_PDFs\\" + pavadinimas + ".pdf");
		try {
			PDFmerger.mergeDocuments();
		} catch (IOException e) {
			System.out.println("!!!*** Failed to merge a PDF ***!!!");
			e.printStackTrace();
		}
	}
}
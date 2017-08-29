package net.util;

import java.io.File;
import java.util.Date;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class JacobUtil {
	public static final int WORD_HTML = 8;
	public static final int WORD_TXT = 7;
	public static final int EXCEL_HTML = 44;

	public static void deleteExistHtml(String htmlfile) {
		if (htmlfile != null) {
			File f = new File(htmlfile);
			if (f.exists()) {
				f.delete();
			}

			String attachments = htmlfile.substring(0,
					htmlfile.lastIndexOf("."))
					+ ".files";
			f = new File(attachments);
			deleteDirectory(f);
		}
	}
	
	private static void deleteDirectory(File file){
		if(file != null && file.exists()){
			if(file.isDirectory()){
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					deleteDirectory(files[i]);
				}
			}
			
			file.delete();
		}
	}

	/**
	 * WORD转HTML
	 * 
	 * @param docfile
	 *            WORD文件全路径
	 * @param htmlfile
	 *            转换后HTML存放路径
	 */

	public static void wordToHtml(String docfile, String htmlfile) {

		// 启动word
		ActiveXComponent app = new ActiveXComponent("Word.Application");
		try { // 设置word不可见
			app.setProperty("Visible", new Variant(false));
			Dispatch docs = app.getProperty("Documents").toDispatch();
			// 打开word文件
			Dispatch doc = Dispatch.invoke(
					docs,
					"Open",
					Dispatch.Method,
					new Object[] { docfile, new Variant(false),
							new Variant(true) }, new int[1]).toDispatch();

			deleteExistHtml(htmlfile);

			// 作为html格式保存到临时文件
			Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {
					htmlfile, new Variant(WORD_HTML) }, new int[1]);
			Variant f = new Variant(false);
			Dispatch.call(doc, "Close", f);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			app.invoke("Quit", new Variant[] {});
			ComThread.Release();
			app = null;
		}
	}

	/**
	 * EXCEL转HTML
	 * 
	 * @param xlsfile
	 *            EXCEL文件全路径
	 * @param htmlfile
	 *            转换后HTML存放路径
	 */
	public static void excelToHtml(String xlsfile, String htmlfile) {
		// 启动excel
		ActiveXComponent app = new ActiveXComponent("Excel.Application");
		try {
			// 设置excel不可见
			app.setProperty("Visible", new Variant(false));
			Dispatch excels = app.getProperty("Workbooks").toDispatch();
			// 打开excel文件
			Dispatch excel = Dispatch.invoke(
					excels,
					"Open",
					Dispatch.Method,
					new Object[] { xlsfile, new Variant(false),
							new Variant(true) }, new int[1]).toDispatch();

			deleteExistHtml(htmlfile);

			// 作为html格式保存到临时文件
			Dispatch.invoke(excel, "SaveAs", Dispatch.Method, new Object[] {
					htmlfile, new Variant(EXCEL_HTML) }, new int[1]);
			Variant f = new Variant(false);
			Dispatch.call(excel, "Close", f);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			app.invoke("Quit", new Variant[] {});
			ComThread.Release();
			app = null;
		}
	}

	static ActiveXComponent wordApp;

	public static void wordToHtmlt(String docfile, String htmlfile) {

		System.out.println("启动word --> " + new Date().toLocaleString());
		// 启动word
		if (wordApp == null) {
			wordApp = new ActiveXComponent("Word.Application");
		}
		System.out.println("启动word 2--> " + new Date().toLocaleString());
		try { // 设置word不可见
			wordApp.setProperty("Visible", new Variant(false));
			Dispatch docs = wordApp.getProperty("Documents").toDispatch();
			// 打开word文件
			Dispatch doc = Dispatch.invoke(
					docs,
					"Open",
					Dispatch.Method,
					new Object[] { docfile, new Variant(false),
							new Variant(true) }, new int[1]).toDispatch();
			System.out.println("打开文件 --> " + new Date().toLocaleString());

			// 作为html格式保存到临时文件
			Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {
					htmlfile, new Variant(WORD_HTML) }, new int[1]);
			Variant f = new Variant(false);
			System.out.println("关闭文件 --> " + new Date().toLocaleString());
			Dispatch.call(doc, "Close", f);
			System.out.println("关闭文件 2--> " + new Date().toLocaleString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			wordApp.invoke("Quit", new Variant[] {});
			ComThread.Release();
			wordApp = null;
			System.out.println("关闭word --> " + new Date().toLocaleString());
		}
	}

	public static void main(String[] args) {
		/*// String docfile = "e://test.docx";
		String xlsfile = "e://u.doc";
		String htmlfile = "e://t.html";
		// wordToHtml(docfile, htmlfile);

		System.out.println(" start --> " + new Date().toLocaleString());
		// for (int i = 0; i < 10; i++) {

		wordToHtmlt(xlsfile, htmlfile);
		// }
		System.out.println(" end --> " + new Date().toLocaleString());*/
		
		String htmlfile = "D:\\Workspaces\\eclipse_EE_ysh\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ckt\\upload\\doc\\01b9efea-83ed-4ac5-b9ff-09df644640e2.html";
		deleteExistHtml(htmlfile);
	}
}
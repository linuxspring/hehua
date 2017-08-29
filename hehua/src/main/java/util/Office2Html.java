package util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class Office2Html {
	public static final int WORD_HTML = 8;
	public static final int WORD_TXT = 7;
	public static final int EXCEL_HTML = 44;

	/**
	 * EXCEL转HTML
	 * 
	 * @param xlsfile
	 *            EXCEL文件全路径
	 * @param htmlfile
	 *            转换后HTML存放路径
	 */
	public static String excelToHtml(String xlsfile, String htmlfile) {
		// 启动excel
		ActiveXComponent app = new ActiveXComponent("Excel.Application");
		String result = "N";
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
			// 作为html格式保存到临时文件
			Dispatch.invoke(excel, "SaveAs", Dispatch.Method, new Object[] {
					htmlfile, new Variant(EXCEL_HTML) }, new int[1]);
			app.setProperty("DisplayAlerts", new Variant(false));
			Dispatch.call(excel, "Close", new Variant(false));
			excel = null;
			excels = null;
			app.invoke("Quit", new Variant[] {});
			ComThread.Release();// 真正退出Excel進程
			app = null;

			result = "Y";
		} catch (Exception e) {
			result = "N";
			e.printStackTrace();
		} finally {
			if (app != null)
				app.invoke("Quit", new Variant[] {});
		}
		return result;
	}

	/**
	 * WORD转HTML
	 * 
	 * @param docfile
	 *            WORD文件全路径
	 * @param htmlfile
	 *            转换后HTML存放路径
	 */
	public static String wordToHtml(String docfile, String htmlfile) {
		// 启动word
		ActiveXComponent app = new ActiveXComponent("Word.Application");
		String result = "N";
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
			// 作为html格式保存到临时文件
			Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {
					htmlfile, new Variant(WORD_HTML) }, new int[1]);
			Variant f = new Variant(false);
			Dispatch.call(doc, "Close", f);
			result = "Y";
		} catch (Exception e) {
			result = "N";
			e.printStackTrace();
		} finally {
			app.invoke("Quit", new Variant[] {});
			ComThread.Release();
			app = null;
		}
		return result;
	}
	
	public static void main(String[] args) {
		String docfile = "E:\\t.doc";
		//String xlsfile = "e:\\b.xlsx";
		String htmlfile = "e:\\t.html";
		wordToHtml(docfile, htmlfile);
		//excelToHtml(xlsfile, htmlfile);
	}
}
